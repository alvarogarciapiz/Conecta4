package com.mycompany.servidordifusion;

import java.io.*;
import java.net.*;
import java.util.*;
import Partidas.Partida;
import com.mycompany.servidordifusion.ClienteDifusion;

public class ServidorDifusion implements Runnable {
    
    private ServerSocket servidor;
    public static ArrayList<ClienteDifusion> listaUsuarios = new ArrayList<>();
    public static ArrayList<Partida> listaPartidas = new ArrayList<>();
    private Thread t;
    public static int cont=0;
    
    public ServidorDifusion() throws Exception {
        servidor = new ServerSocket(5665);
        t = new Thread(this);
        t.start();
    }
    
    public void run(){
        try {
            startListeningUsers();
        } catch (Exception e){
            
        }
    }
    
    public void startListeningUsers() throws Exception {
        while (true) {
        System.out.println("Esperando clientes...");
        Socket sck = servidor.accept();
        
        //--> Aquí tengo el usuario conectado
        System.out.println(listaUsuarios.size()+1 + " clientes conectados...");
        
        ClienteDifusion unCliente = new ClienteDifusion(sck);
        listaUsuarios.add(unCliente); //El número en listausuarios = nº usuarios conectados
        }
    }
    
    public static void difusionMensaje(byte[] mensaje){
    
            try{
                               
               String msg = new String(mensaje);
               String [] partesmensaje = msg.split("#");
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
                        if (partesmensaje.length!=5) {
                            respuesta = "#REGISTRO#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (Ficheros.Ficheros.comprobarEmailRepetido(partesmensaje[2]) == true) {
                            respuesta = "#REGISTRO#NOK#EMAIL#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (Ficheros.Ficheros.comprobarUsernameRepetido(partesmensaje[3])==true){
                            respuesta = "#REGISTRO#NOK#NICK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (RegistroyLogin.Registro.comprobarPassword(partesmensaje[4])==true){
                            respuesta = "#REGISTRO#NOK#PASSWORD#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (error == false) {
                            respuesta = "#REGISTRO#OK#";
                            RegistroyLogin.Registro.registrarNuevoUsuario(partesmensaje[2], partesmensaje[3], partesmensaje[4]);
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                        
                    case "LOGIN": // #NICK#LOGIN#EMAIL#PASSWORD# -----------------------------------------------   
                        if (partesmensaje.length!=4) {
                            respuesta = "#LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (RegistroyLogin.login.loginUsuario(partesmensaje[2], partesmensaje[3])==true) {      
                            //Aquí como el login es correcto deberé iniciar las variables del objeto con lo que tengo almacenado en el fichero
                            hacerLogin(partesmensaje[0], partesmensaje[2], partesmensaje[3]); //Se hace login el clienteDifusion
                            String nick = Ficheros.Ficheros.buscarNickPorEmail(partesmensaje[2]);
                            respuesta = "LOGIN#OK#" + nick + "#";                         
                            
                            int posNueva= buscarCliente(nick);
                            user = listaUsuarios.get(posNueva);
                            
                            user.sendMessage(respuesta.getBytes());
                            
                        } else {
                            respuesta = "#LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        // --> Al hacer login activo los campos en clienteDifusion
                        
                        break;
                    
                    case "REDIFUSION": // Ejemplo de redifusión (ENVIAR A TODOS)
                            
                        for (ClienteDifusion unCliente : listaUsuarios){
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
                            respuesta =  "PARTIDA#NO#" + partesmensaje[3] + "#";
                            user.sendMessage(respuesta.getBytes());
                            
                        } else if(partesmensaje[2].equals("SI")) { //Se comienza la partida
                            respuesta =  "PARTIDA#SI#" + partesmensaje[3] + "#";
                            user.sendMessage(respuesta.getBytes());
                            
                            registrarPartida(partesmensaje[0], partesmensaje[3]);
                        }
                        
                        break;
     
                    default:
                        respuesta = "ERROR";
                        user.sendMessage(respuesta.getBytes());         
                    }
            }         
                
            } catch (Exception e){
                    System.out.println("Error de difusion: " + e.toString());
            }   
    }
    
    
    public static int buscarCliente (String nick){
        ClienteDifusion user = null;
        int i=0;

        for (i = 0; i < listaUsuarios.size(); i++) {
            if (nick.equals(listaUsuarios.get(i).nick)) {
                user = listaUsuarios.get(i);                
                return i;
            }
        }
        
        return i;
    }
    
    public static void hacerLogin (String nick ,String email, String password) {
        
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
    
    public static void registrarPartida (String usuario1, String usuario2) {
        Partida p1 = new Partida();
        p1.setID(Partida.solicitarIDPartida());
        p1.setUsuario1(usuario1);
        p1.setUsuario2(usuario2);
        
        listaPartidas.add(p1);
    }
    
    public static void registrarMovimiento (String id, String movimiento) {
        
        for (int i = 0; i < listaPartidas.size(); i++) {
            if (listaPartidas.get(i).getID()==Integer.parseInt(id)) {
                
                String cadena = movimiento + "#";
                listaPartidas.get(i).getMovimientos().add(cadena);
            }
        }  
    }

    
}
