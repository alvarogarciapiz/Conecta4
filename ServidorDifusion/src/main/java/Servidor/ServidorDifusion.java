package Servidor;

import Ficheros.FicherosPartidas;
import java.io.*;
import java.net.*;
import java.util.*;
import Partidas.*;
import Servidor.ClienteDifusion;

public class ServidorDifusion implements Runnable {

    private ServerSocket servidor;
    public static ArrayList<ClienteDifusion> listaUsuarios = new ArrayList<>();
    public static ArrayList<Partida> listaPartidas = new ArrayList<>();
    private Thread t;
    public static int cont = 0;

    public ServidorDifusion() throws Exception {
        servidor = new ServerSocket(5666);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            startListeningUsers();
        } catch (Exception e) {

        }
    }

    public void startListeningUsers() throws Exception {
        while (true) {
            System.out.println("Esperando clientes...");
            Socket sck = servidor.accept();
            

            //--> Aquí tengo el usuario conectado
            System.out.println(listaUsuarios.size() + 1 + " clientes conectados...");

            ClienteDifusion unCliente = new ClienteDifusion(sck);
            listaUsuarios.add(unCliente); //El número en listausuarios = nº usuarios conectados
        }
    }

    
    
    public static void difusionMensaje(byte[] mensaje) {

        try {

            String msg = new String(mensaje);
            String[] partesmensaje = msg.split("#");
            String respuesta;
            Boolean error = false;

            if (partesmensaje[1].equals("START")) {
                listaUsuarios.get(cont).setNick(partesmensaje[0]);
                cont++;

                int posicionCliente = buscarCliente(partesmensaje[0]);
                ClienteDifusion user = listaUsuarios.get(posicionCliente);

                respuesta = "#START#OK#";
                user.sendMessage(respuesta.getBytes());
            } else {
                int posicionCliente = buscarCliente(partesmensaje[0]);
                ClienteDifusion user = listaUsuarios.get(posicionCliente);

                // VALIDADOR
                switch (partesmensaje[1]) {

                    case "REGISTRO": // #NICK#REGISTRO#EMAIL#NICK#PASSWORD# ----------------------------------    
                        if (partesmensaje.length != 5) {
                            respuesta = "#REGISTRO#NOK#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (Ficheros.Ficheros.comprobarEmailRepetido(partesmensaje[2]) == true) {
                            respuesta = "#REGISTRO#NOK#EMAIL#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (Ficheros.Ficheros.comprobarUsernameRepetido(partesmensaje[3]) == true) {
                            respuesta = "#REGISTRO#NOK#NICK#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (RegistroyLogin.Registro.comprobarPassword(partesmensaje[4]) == true) {
                            respuesta = "#REGISTRO#NOK#PASSWORD#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (error == false) {
                            respuesta = "#REGISTRO#OK#";
                            RegistroyLogin.Registro.registrarNuevoUsuario(partesmensaje[2], partesmensaje[3], partesmensaje[4]);
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                    case "LOGIN": // #NICK#LOGIN#EMAIL#PASSWORD# -----------------------------------------------   
                        if (partesmensaje.length != 4) {
                            respuesta = "#LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (RegistroyLogin.login.loginUsuario(partesmensaje[2], partesmensaje[3]) == true) {
                            //Aquí como el login es correcto deberé iniciar las variables del objeto con lo que tengo almacenado en el fichero
                            hacerLogin(partesmensaje[0], partesmensaje[2], partesmensaje[3]); //Se hace login el clienteDifusion
                            String nick = Ficheros.Ficheros.buscarNickPorEmail(partesmensaje[2]);
                            respuesta = "LOGIN#OK#" + nick + "#";

                            int posNueva = buscarCliente(nick);
                            user = listaUsuarios.get(posNueva);

                            user.sendMessage(respuesta.getBytes());

                        } else {
                            respuesta = "#LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        // --> Al hacer login activo los campos en clienteDifusion

                        break;

                    case "REDIFUSION": // Ejemplo de redifusión (ENVIAR A TODOS)

                        for (ClienteDifusion unCliente : listaUsuarios) {
                            String julio = "MENSAJE";
                            mensaje = julio.getBytes();
                            unCliente.sendMessage(mensaje);
                        }

                        break;

                    case "DISPONIBLES": //Se devuelven todos los usuarios disponibles
                        respuesta = "";
                        for (int i = 0; i < listaUsuarios.size(); i++) {
                            if (!partesmensaje[0].equals(listaUsuarios.get(i).nick)) {
                                respuesta = respuesta + listaUsuarios.get(i).nick + "#";
                            }
                        }
                        user.sendMessage(respuesta.getBytes());
                        break;

                    case "RETAR": // nickOrigen#RETAR#nickDestino#
                        String nickOrigen = partesmensaje[0];
                        String nickDestino = partesmensaje[2];

                        int posicionNickDestino = buscarCliente(nickDestino);
                        user = listaUsuarios.get(posicionNickDestino);

                        respuesta = "TERETAN#" + nickOrigen + "#";
                        user.sendMessage(respuesta.getBytes());

                        break;

                    case "RESPUESTARETO": //nickOrigen#RESPUESTARETO#SI/NO#nickDestino#
                        int posicionDest = buscarCliente(partesmensaje[3]);
                        user = listaUsuarios.get(posicionDest);

                        if (partesmensaje[2].equals("NO")) { //No se comienza la partida
                            respuesta = "PARTIDA#NO#" + partesmensaje[3] + "#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (partesmensaje[2].equals("SI")) { //Se comienza la partida
                            respuesta = "PARTIDA#SI#" + partesmensaje[3] + "#";
                            user.sendMessage(respuesta.getBytes());

                            registrarPartida(partesmensaje[0], partesmensaje[3]);
                        }

                        break;

                    case "FICHA": //nickOrigen#FICHA#IDpartida#posiciónCOL#
                        posicionDest = buscarCliente(partesmensaje[0]);
                        user = listaUsuarios.get(posicionDest);
                        Partida p = buscarPartida(partesmensaje[2]);
                        
                        if (p.turno.equals("null")){
                            respuesta = "ERROR#FINPARTIDA#";
                            user.sendMessage(respuesta.getBytes());
                        } else if (comprobarTurno(p, partesmensaje[0]) == false) {
                            //Error: no es su turno
                            respuesta = "ERROR#NOTURNO#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if (comprobarColumnaLlena(p,partesmensaje[3]) == false){
                            //Error: columna ya llena
                            respuesta = "ERROR#COLUMNA#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else {
                            colocarFicha(partesmensaje[2], partesmensaje[3], partesmensaje[0]);
                            respuesta = "FICHA#EXITO#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                    case "RANKING":
                        respuesta = Partidas.Ranking.obtenerRanking();
                        user.sendMessage(respuesta.getBytes());
                        break;
                        
                    default:
                        respuesta = "ERROR";
                        user.sendMessage(respuesta.getBytes());
                }
            }

        } catch (Exception e) {
            System.out.println("Error de difusion: " + e.toString());
        }
    }

    public static int buscarCliente(String nick) {
        ClienteDifusion user = null;
        int i = 0;

        for (i = 0; i < listaUsuarios.size(); i++) {
            if (nick.equals(listaUsuarios.get(i).nick)) {
                user = listaUsuarios.get(i);
                return i;
            }
        }

        return i;
    }

    public static void hacerLogin(String nick, String email, String password) {

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (nick.equals(listaUsuarios.get(i).nick)) {
                String nickNuevo = Ficheros.Ficheros.buscarNickPorEmail(email);
                listaUsuarios.get(i).setEmail(email);
                listaUsuarios.get(i).setPassword(password);
                listaUsuarios.get(i).setNick(nickNuevo);
                listaUsuarios.get(i).setPartidasJugadas(Ficheros.Ficheros.obtenerPartidasJugadas(nickNuevo));
                listaUsuarios.get(i).setPartidasGanadas(Ficheros.Ficheros.obtenerPartidasGanadas(nickNuevo));
                listaUsuarios.get(i).setPartidasPerdidas(Ficheros.Ficheros.obtenerPartidasPerdidas(nickNuevo));
            }
        }
    }

    public static void registrarPartida(String usuario1, String usuario2) {
        Partida p1 = new Partida();
        p1.setID(Partida.solicitarIDPartida());
        p1.usuario1 = usuario1;
        p1.usuario2 = usuario2;
        p1.setTurno(usuario1);
        p1.tablero = new Tablero();

        // ¿? FicherosPartidas.nuevaPartida(usuario1, usuario2, "null", p1.getID());
        listaPartidas.add(p1);
    }


    public static void imprimirTablero(Partida p1) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("| " + p1.tablero.getPosiciones()[i][j]);
            }
            System.out.println("\n --------------------");
        }
        System.out.println("\n");
    }

    public static Partida buscarPartida(String id) {
        Partida p1 = new Partida();

        int identificador = Integer.parseInt(id);
        
        for (int i = 0; i < listaPartidas.size(); i++) {
            if (identificador == (listaPartidas.get(i).getID())) {
                p1 = listaPartidas.get(i);
                return p1;
            }
        }
        return p1;
    }

    public static void colocarFicha(String idPartida, String movCOL, String user) {
        Partida p = buscarPartida(idPartida);

        int col = Integer.parseInt(movCOL);
        int fil = determinarFila(p, col);

  
        p.tablero.posiciones[fil][col] = user.substring(0,2);
        
        
        //Actualizamos el turno al otro usuario
        if (p.getTurno().equals(p.getUsuario2())) {
            p.setTurno(p.getUsuario1());
        } else {
            p.setTurno(p.getUsuario2());
        }
        
        String ganador = comprobarGanador(p);
        if (!ganador.equals("NO")) {
            System.out.println("EL GANADOR ES: " + ganador);
            p.setGanador(ganador);
            p.turno = "null"; //El turno=null es un indicador qu ela partida está finalizada
            //Se registra la partida en el fichero
            FicherosPartidas.registrarPartida(p);
            //Cerrar la partida
        }
        
        imprimirTablero(p);
    }
    
    public static boolean comprobarColumnaLlena (Partida p, String colum){
        int col = Integer.parseInt(colum);
        if(p.tablero.getPosiciones()[0][col].equals("0")){
            return true;
        } else {
            return false;
        }
    }
        
    //Falta comprobar que funciona
    public static boolean comprobarTableroLleno (Partida p) {
        int cont = 0;
        
        for (int i = 0; i < 6; i++) {
           if(!p.tablero.getPosiciones()[0][i].equals("0")){
            cont++;
            } 
        }
        
        if (cont == 7) {
            return true;
        } else {
            return false;
        }  
    }
    
    public static int determinarFila (Partida p, int col){
        int fila = 0;
        
        for (int i = 5; i >0; i--) {
            if (p.tablero.getPosiciones()[i][col].equals("0")) {
                return i;
            }
        }
        
        return fila;
    }
    
    public static boolean comprobarTurno (Partida p, String nick) {
        boolean turno = false;
        
        if (p.turno.equals(nick)) {
            turno = true;
            return turno;
        }
        
        return turno;
    }
    
    public static String comprobarGanador (Partida p) {
        String winner = "NO";
        
        //  COMPROBACIÓN HORIZONTAL
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i][j+1]) &&
                        p.tablero.posiciones[i][j+1].equals(p.tablero.posiciones[i][j+2]) &&
                        p.tablero.posiciones[i][j+2].equals(p.tablero.posiciones[i][j+3])) {
                            return p.tablero.posiciones[i][j];
                }
            }   
        }
                
        //  COMPROBACIÓN VERTICAL
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i+1][j]) &&
                        p.tablero.posiciones[i+1][j].equals(p.tablero.posiciones[i+2][j]) &&
                        p.tablero.posiciones[i+2][j].equals(p.tablero.posiciones[i+3][j])) {
                            return p.tablero.posiciones[i][j];
                }
            }
        }
        
        //  COMPROBACIÓN DIAGONAL
                // Primera pasada (de izquierda a derecha)
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i+1][j+1]) &&
                        p.tablero.posiciones[i+1][j+1].equals(p.tablero.posiciones[i+2][j+2]) &&
                        p.tablero.posiciones[i+2][j+2].equals(p.tablero.posiciones[i+3][j+3])) {
                            return p.tablero.posiciones[i][j];
                }
            }   
        }        
        
                // Segunda pasada (de derecha a izquierda)
        for (int j = 0; j < 6; j++) {
            for (int i = 5; i > 2; i--) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i-1][j+1]) &&
                        p.tablero.posiciones[i-1][j+1].equals(p.tablero.posiciones[i-2][j+2]) &&
                        p.tablero.posiciones[i-2][j+2].equals(p.tablero.posiciones[i-3][j+3])) {
                            return p.tablero.posiciones[i][j];
                }
            }
        }     

        // si hay ganador --> FicherosPartidas.registrarPartida
        return winner;
    }

}
