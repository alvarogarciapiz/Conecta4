package com.mycompany.servidordifusion;

import java.io.*;
import java.net.*;
import java.util.*;
import com.mycompany.servidordifusion.ClienteDifusion;

public class ServidorDifusion implements Runnable {
    
    private ServerSocket servidor;
    public static ArrayList<ClienteDifusion> listaUsuarios = new ArrayList<>(); 
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
                            respuesta = "#LOGIN#OK#";
                            //Aquí como el login es correcto deberé iniciar las variables del objeto con lo que tengo almacenado en el fichero
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

        for (i = 0; i <= listaUsuarios.size(); i++) {
            System.out.println("BUSCANDO CLIENTE:");
                System.out.println("El " + i + " es: " + listaUsuarios.get(i).nick);
            if (nick.equals(listaUsuarios.get(i).nick)) {
                System.out.println("SE ENCUENTRA");
                user = listaUsuarios.get(i);                
                return i;
            }
        }
        
        return i;
    }
    
}
