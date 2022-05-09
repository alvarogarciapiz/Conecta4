package com.mycompany.servidordifusion;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorDifusion implements Runnable {
    
    private ServerSocket servidor;
    public static ArrayList<ClienteDifusion> listaUsuarios = new ArrayList<>(); 
    private Thread t;
    
    public ServidorDifusion() throws Exception {
        servidor = new ServerSocket(5666);
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
        System.out.println("Un cliente conectado...");
        ClienteDifusion unCliente = new ClienteDifusion(sck);
        listaUsuarios.add(unCliente); //El número en listausuarios = nº usuarios conectados
        }
    }
    
    public static void difusionMensaje(byte[] mensaje){
        
            try{
               String msg = new String(mensaje);
               String respuesta;
               ClienteDifusion user;
               Boolean error = false;
               String [] partesmensaje = msg.split("#");
                // VALIDADOR
                switch (partesmensaje[0]) {
                    case "REGISTRO": //#REGISTRO#EMAIL#NICK#PASSWORD# ----------------------------------
                        user = listaUsuarios.get(0);
                        
                        if (partesmensaje.length!=4) {
                            respuesta = "#REGISTRO#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (Ficheros.Ficheros.comprobarEmailRepetido(partesmensaje[1]) == true) {
                            respuesta = "#REGISTRO#NOK#EMAIL#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (Ficheros.Ficheros.comprobarUsernameRepetido(partesmensaje[2])==true){
                            respuesta = "#REGISTRO#NOK#NICK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (RegistroyLogin.Registro.comprobarPassword(partesmensaje[3])==true){
                            respuesta = "#REGISTRO#NOK#PASSWORD#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (error == false) {
                            respuesta = "#REGISTRO#OK#";
                            RegistroyLogin.Registro.registrarNuevoUsuario(partesmensaje[1], partesmensaje[2], partesmensaje[3]);
                            user.sendMessage(respuesta.getBytes());
                        }
                        break;

                        
                    case "LOGIN": //#LOGIN#EMAIL#PASSWORD# -----------------------------------------------
                        System.out.println("Se está logeando alguien");
                        user = listaUsuarios.get(0);
                        if (partesmensaje.length!=3) {
                            respuesta = "#LOGIN#NOK#";
                            user.sendMessage(respuesta.getBytes());
                        }
                        
                        else if (RegistroyLogin.login.loginUsuario(partesmensaje[1], partesmensaje[2])==true) {
                            respuesta = "#LOGIN#OK#";
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
                        user = listaUsuarios.get(0);
                        String error2 = "ERROR";
                        mensaje = error2.getBytes();
                        user.sendMessage(mensaje);
                        
                    
                }
                         
                
            } catch (Exception e){
                    System.out.println("Error de difusion: " + e.toString());
            }   
    }
    
    
    public static ClienteDifusion buscarCliente (String nick){
        ClienteDifusion user = null;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (nick.equals(listaUsuarios.get(i).nick)) {
                user = listaUsuarios.get(i);
            }
        }
        
        return user;
    }
    
}
