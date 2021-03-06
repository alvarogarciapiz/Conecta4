package Servidor;

import Ficheros.FicherosPartidas;
import java.io.*;
import java.net.*;
import java.util.*;
import Partidas.*;
import Servidor.ClienteDifusion;

/**
 * Clase que maneja toda la lógica del servidor, aquí llegan todas las
 * peticiones de los diferentes clientes y serán gestionadas mediante hilos
 *
 * @author alvaro
 * @version 1.0
 * @since 01/04/2021
 */
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
            //System.out.println("Esperando clientes...");
            Socket sck = servidor.accept();

            //--> Aquí tengo el usuario conectado
            //System.out.println(listaUsuarios.size() + 1 + " clientes conectados...");
            ClienteDifusion unCliente = new ClienteDifusion(sck);
            listaUsuarios.add(unCliente); //El número en listausuarios = nº usuarios conectados
        }
    }

    /**
     * Método que con el mensaje recibido del servidor realiza acciones
     * (validador): START: Busca al cliente y lo añade a la lista REGISTRO:
     * Realiza las correspondientes verificaciones y si todas son correctas lo
     * añade al fichero y a la lista de usuarios LOGIN: Si el login es correcto
     * se añade al usuario a la lista DISPONIBLES: Devuelve al usuaio que lo
     * solcitó una lista con todos los usuarios conectados al servidor sin
     * contarle a él RETAR: Manda al usuario al que estñán retando la
     * notificación del reto RESPUESTARETO: Si la respuesta al reto es
     * afirmativa se crea una partida y se aceptan movimientos RANKING: Devuelve
     * un String con los 5 mejores jugadores al usuario que lo solcitó (los 5
     * mejores jugadores bajo el criterio de más partidas ganadas) FICHA:
     * Permite colocar una ficha, para ello se realizan todas las verificaciones
     * correspondientes antes de colocarla.
     *
     * @param mensaje
     */
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

                respuesta = "START#OK#";
                user.sendMessage(respuesta.getBytes());
            } else {
                int posicionCliente = buscarCliente(partesmensaje[0]);
                ClienteDifusion user = listaUsuarios.get(posicionCliente);

                // VALIDADOR
                switch (partesmensaje[1]) {

                    case "REGISTRO": // #NICK#REGISTRO#EMAIL#NICK#PASSWORD# ----------------------------------    
                        if (partesmensaje.length != 5) {
                            respuesta = "REGISTRO#NOK#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (Ficheros.Ficheros.comprobarEmailRepetido(partesmensaje[2]) == true) {
                            respuesta = "REGISTRO#NOK#EMAIL#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (Ficheros.Ficheros.comprobarUsernameRepetido(partesmensaje[3]) == true) {
                            respuesta = "REGISTRO#NOK#NICK#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (RegistroyLogin.Registro.comprobarPassword(partesmensaje[4]) == true) {
                            respuesta = "REGISTRO#NOK#PASSWORD#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (error == false) {
                            respuesta = "REGISTRO#OK#";
                            RegistroyLogin.Registro.registrarNuevoUsuario(partesmensaje[2], partesmensaje[3], partesmensaje[4]);
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                    case "LOGIN": // #NICK#LOGIN#EMAIL#PASSWORD# -----------------------------------------------   
                        if (partesmensaje.length != 4) {
                            respuesta = "LOGIN#NOK#";
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
                            respuesta = "LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        // --> Al hacer login activo los campos en clienteDifusion

                        break;

//                    case "REDIFUSION": // Ejemplo de redifusión (ENVIAR A TODOS)
//
//                        for (ClienteDifusion unCliente : listaUsuarios) {
//                            String julio = "MENSAJE";
//                            mensaje = julio.getBytes();
//                            unCliente.sendMessage(mensaje);
//                        }
//
//                        break;
                    case "DISPONIBLES": //Se devuelven todos los usuarios disponibles
                        respuesta = "DISPONIBLES#";
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
                        ClienteDifusion user2 = listaUsuarios.get(buscarCliente(partesmensaje[0]));

                        if (partesmensaje[2].equals("NO")) { //No se comienza la partida
                            respuesta = "PARTIDA#NO#" + partesmensaje[3] + "#" + partesmensaje[0] + "#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (partesmensaje[2].equals("SI")) { //Se comienza la partida
                            respuesta = "PARTIDA#SI#" + partesmensaje[3] + "#" + partesmensaje[0] + "#";
                            user.sendMessage(respuesta.getBytes());

                            registrarPartida(partesmensaje[0], partesmensaje[3], user, user2);
                        }

                        break;

                    case "FICHA": //nickOrigen#FICHA#IDpartida#posiciónCOL#
                        posicionDest = buscarCliente(partesmensaje[0]);
                        user = listaUsuarios.get(posicionDest);
                        Partida p = buscarPartida(partesmensaje[2]);

                        if (p.turno.equals("null")) {
                            respuesta = "ERROR#FINPARTIDA#" + p.ganador + "#";
                            user.sendMessage(respuesta.getBytes());
                        } else if (comprobarTurno(p, partesmensaje[0]) == false) {
                            //Error: no es su turno
                            respuesta = "ERROR#NOTURNO#";
                            user.sendMessage(respuesta.getBytes());

                        } else if (comprobarColumnaLlena(p, partesmensaje[3]) == false) {
                            //Error: columna ya llena
                            respuesta = "ERROR#COLUMNA#";
                            user.sendMessage(respuesta.getBytes());

                        } else {
                            colocarFicha(partesmensaje[2], partesmensaje[3], partesmensaje[0]);
                            int fila = determinarFila(p, Integer.parseInt(partesmensaje[3]));
                            respuesta = "FICHA#EXITO#" + fila + "#" + partesmensaje[3] + "#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                    case "RANKING":
                        respuesta = "RANKING" + "#" + Partidas.Ranking.obtenerRanking();
                        user.sendMessage(respuesta.getBytes());
                        break;
                    case "JUGAPER":
                        respuesta = "JUGAPER#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasJugadas(partesmensaje[0]) + "#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasGanadas(partesmensaje[0]) + "#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasPerdidas(partesmensaje[0]) + "#";
                        user.sendMessage(respuesta.getBytes());
                        break;

                    case "JUGAPERival":
                        respuesta = "JUGAPERival#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasJugadas(partesmensaje[2]) + "#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasGanadas(partesmensaje[2]) + "#";
                        respuesta = respuesta + Ficheros.Ficheros.obtenerPartidasPerdidas(partesmensaje[2]) + "#";
                        user.sendMessage(respuesta.getBytes());
                        break;

                    case "PINTARFICHARIVAL":
                        respuesta = "PINTARFICHA#" + partesmensaje[2] + "#" + partesmensaje[3] + "#";
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

    /**
     * Método que con el nick del cliente se busca y obtiene el objeto de tipo
     * usuario, este devuelve su posición en el arraylist
     *
     * @param nick
     * @return
     */
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

    /**
     * Método que establece las credenciales del usuario para el objeto del lado
     * del servidor
     *
     * @param nick
     * @param email
     * @param password
     */
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

    /**
     * Método que crea un objeto de tipo partida y lo añade al arraylist que
     * almacena el servidor
     *
     * @param usuario1
     * @param usuario2
     */
    public static void registrarPartida(String usuario1, String usuario2, ClienteDifusion user1, ClienteDifusion user2) throws Exception {
        Partida p1 = new Partida();
        p1.setID(Partida.solicitarIDPartida());
        p1.usuario1 = usuario1;
        p1.usuario2 = usuario2;
        p1.setTurno(usuario1);
        p1.tablero = new Tablero();

        // ¿? FicherosPartidas.nuevaPartida(usuario1, usuario2, "null", p1.getID());
        listaPartidas.add(p1);

        String mensaje = "IDPARTIDA#" + p1.getID() + "#";
        user1.sendMessage(mensaje.getBytes());
        user2.sendMessage(mensaje.getBytes());
    }

    /**
     * Método que imprime por pantalla del servidor la partida
     *
     * @param p1, la partida
     */
    public static void imprimirTablero(Partida p1) {
        System.out.println("===================================");
        System.out.println("Partida: " + p1.getID());
        System.out.println(p1.getUsuario1() + " vs " + p1.getUsuario2());
        System.out.println("Estado actual del tablero: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("| " + p1.tablero.getPosiciones()[i][j]);
            }
            System.out.println("\n --------------------");
        }
        System.out.println("===================================");
        System.out.println("\n");
    }

    /**
     * Método que con el ID de la partida devuelve el objeto partida
     *
     * @param id de la partida
     * @return Partida
     */
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

    /**
     * Método que escribe en el tablero la ficha que se ha colocado, comprueba
     * si hay un ganador y en caso de no haberlo cambia el turno a otros usuario
     *
     * @param idPartida
     * @param movCOL, la Columna
     * @param user, el USuario
     */
    public static void colocarFicha(String idPartida, String movCOL, String user) throws Exception {
        Partida p = buscarPartida(idPartida);

        int col = Integer.parseInt(movCOL);
        int fil = determinarFila(p, col);

        p.tablero.posiciones[fil][col] = user;

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

            //Se actualizan los datos en el fichero
            actualizarRegistroPartidas(p, ganador);

            //Se comunica el ganador
            if (p.getUsuario1().equals(ganador)) {
                comunicarGanador(ganador, p.getUsuario2());
            } else {
                comunicarGanador(ganador, p.getUsuario1());
            }
        }

        //imprimirTablero(p);  //Descomentar para ver el tablero e información de la partida cada vez que un usuario realiza un movimiento en el juego
    }

    /**
     * Método que actualiza el número de partidas ganadas, jugadas y perdidas de
     * los dos usuarios que juegan la partida una vez ésta ha sido finalizada.
     *
     * @param p, la partida
     * @param ganador
     */
    public static void actualizarRegistroPartidas(Partida p, String ganador) {
        int posCliente = buscarCliente(ganador);
        ClienteDifusion ganad = listaUsuarios.get(posCliente);
        ganad.partidasGanadas++;
        ganad.partidasJugadas++;

        ClienteDifusion perd;
        if (p.getUsuario1().equals(ganador)) {
            posCliente = buscarCliente(p.getUsuario2());
            perd = listaUsuarios.get(posCliente);
        } else {
            posCliente = buscarCliente(p.getUsuario1());
            perd = listaUsuarios.get(posCliente);
        }
        perd.partidasPerdidas++;
        perd.partidasJugadas++;
        Ficheros.Ficheros.actualizarFicheroJugadores(ganad, perd);
    }

    /**
     * Método encargado de comunicar al ganador y al perdedor de la partida su
     * resultado
     *
     * @param ganador
     * @param perdedor
     * @throws Exception
     */
    public static void comunicarGanador(String ganador, String perdedor) throws Exception {
        String respuesta = "GANADOR#" + ganador + "#";
        int posCliente = buscarCliente(ganador);
        ClienteDifusion usuario = listaUsuarios.get(posCliente);
        usuario.sendMessage(respuesta.getBytes());

        //Se avisa al perdedor
        posCliente = buscarCliente(perdedor);
        usuario = listaUsuarios.get(posCliente);
        usuario.sendMessage(respuesta.getBytes());
    }

    /**
     * Método que comprueba si una dterminada columna está llena
     *
     * @param p, l apartida
     * @param colum, la columna
     * @return true si está llena y sino false
     */
    public static boolean comprobarColumnaLlena(Partida p, String colum) {
        int col = Integer.parseInt(colum);
        if (p.tablero.getPosiciones()[0][col].equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que verifica si el tablero está lleno y de estar lleno envía la
     * notificación a ambos usuarios para informarles.
     *
     * @param p, la partida
     * @return true si está lleno el tablero
     */
    public static boolean comprobarTableroLleno(Partida p) throws Exception {

        int posicionCliente = buscarCliente(p.getUsuario1());
        ClienteDifusion user1 = listaUsuarios.get(posicionCliente);

        posicionCliente = buscarCliente(p.getUsuario2());
        ClienteDifusion user2 = listaUsuarios.get(posicionCliente);

        String mensaje = "EMPATE#";
        int cont = 0;

        for (int i = 0; i < 6; i++) {
            if (!p.tablero.getPosiciones()[0][i].equals("0")) {
                cont++;
            }
        }

        if (cont == 7) {
            user1.sendMessage(mensaje.getBytes());
            user2.sendMessage(mensaje.getBytes());

            //Se registra la partida en el fichero
            p.setGanador("EMPATE");
            FicherosPartidas.registrarPartida(p);

            //Se actualizan los registros en el fichero
            Ficheros.Ficheros.actualizarFicheroJugadoresEmpate(user1, user2);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método encargado de determinar la fila en la que colocar la ficha una vez
     * nos la indica el usuario (la columna)
     *
     * @param p, la partida
     * @param col, la columna donde se quiere meter la ficha
     * @return fila donde hay que colocar la ficha
     */
    public static int determinarFila(Partida p, int col) {
        int fila = 0;
        for (int i = 5; i > 0; i--) {
            if (p.tablero.getPosiciones()[i][col].equals("0")) {
                return i;
            }
        }

        return fila;
    }

    /**
     * Método encargado de comprobar el turno del usuario
     *
     * @param p que es la partida
     * @param nick del usuario a comprobar
     * @return turno que es false si no es su turno
     */
    public static boolean comprobarTurno(Partida p, String nick) {
        boolean turno = false;

        if (p.turno.equals(nick)) {
            turno = true;
            return turno;
        }

        return turno;
    }

    /**
     * Método que comprueba en cada turno si una determinada partida tiene unn
     * ganador, para ello se hace una comprobación horizontal, vertical y en las
     * dos direcciones de las diagonales
     *
     * @param p, la partida que se debe comprobar
     * @return un String con 'SI' o 'NO'
     */
    public static String comprobarGanador(Partida p) {
        String winner = "NO";

        //  COMPROBACIÓN HORIZONTAL
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i][j + 1])
                        && p.tablero.posiciones[i][j + 1].equals(p.tablero.posiciones[i][j + 2])
                        && p.tablero.posiciones[i][j + 2].equals(p.tablero.posiciones[i][j + 3])) {
                    return p.tablero.posiciones[i][j];
                }
            }
        }

        //  COMPROBACIÓN VERTICAL
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i + 1][j])
                        && p.tablero.posiciones[i + 1][j].equals(p.tablero.posiciones[i + 2][j])
                        && p.tablero.posiciones[i + 2][j].equals(p.tablero.posiciones[i + 3][j])) {
                    return p.tablero.posiciones[i][j];
                }
            }
        }

        //  COMPROBACIÓN DIAGONAL
        // Primera pasada (de izquierda a derecha)
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i + 1][j + 1])
                        && p.tablero.posiciones[i + 1][j + 1].equals(p.tablero.posiciones[i + 2][j + 2])
                        && p.tablero.posiciones[i + 2][j + 2].equals(p.tablero.posiciones[i + 3][j + 3])) {
                    return p.tablero.posiciones[i][j];
                }
            }
        }

        // Segunda pasada (de derecha a izquierda)
        for (int j = 0; j < 6; j++) {
            for (int i = 5; i > 2; i--) {
                if (!p.tablero.posiciones[i][j].equals("0") && p.tablero.posiciones[i][j].equals(p.tablero.posiciones[i - 1][j + 1])
                        && p.tablero.posiciones[i - 1][j + 1].equals(p.tablero.posiciones[i - 2][j + 2])
                        && p.tablero.posiciones[i - 2][j + 2].equals(p.tablero.posiciones[i - 3][j + 3])) {
                    return p.tablero.posiciones[i][j];
                }
            }
        }

        // si hay ganador --> FicherosPartidas.registrarPartida
        return winner;
    }

    public static void gestorServidor(String mensaje) throws InterruptedException {
        String parts[] = mensaje.split("-");
        switch (parts[0]) {
            case "1":
                System.out.println("-------------------------------");
                System.out.println("Nick: " + parts[1]);
                System.out.println("Partidas Jugadas: " + Ficheros.Ficheros.obtenerPartidasJugadas(parts[1]));
                System.out.println("Partidas Ganadas: " + Ficheros.Ficheros.obtenerPartidasGanadas(parts[1]));
                System.out.println("Partidas Perdidas: " + Ficheros.Ficheros.obtenerPartidasPerdidas(parts[1]));
                System.out.println("Posición en el ranking: " + Partidas.Ranking.obtenerPosicionRanking(parts[1]));
                System.out.println("-------------------------------");      
                break;

            case "2":
                String data = Ficheros.FicherosPartidas.infoPartida(parts[1]);
                System.out.println("-------------------------------");
                System.out.println(data);
                System.out.println("-------------------------------");
                break;

            case "3":
                System.out.println("-------------------------------");
                System.out.println("Ranking completo: ");
                ArrayList<String> usuarios = Partidas.Ranking.obtenerRankingCompleto();              
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("[" + (i+1) + "] " + usuarios.get(i));
                }
                System.out.println("-------------------------------");
                break;

            case "4":
                System.out.println("El sistema se apagará en 3 segundos");
                Thread.sleep(1000);
                System.out.println("2");
                Thread.sleep(1000);
                System.out.println("1");
                Thread.sleep(1000);
                System.out.println("0");
                System.exit(1);
                break;

            default:
                System.out.println("Introduce una opción válida");
        }
    }

}
