package com.mycompany.servidordifusion;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorDifusion implements Runnable {
    
    private ServerSocket servidor;
    private static ArrayList<ClienteDifusion> listaUsuarios = new ArrayList<>(); 
    private Thread t;
    
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
        System.out.println("Un cliente conectado...");
        ClienteDifusion unCliente = new ClienteDifusion(sck);
        listaUsuarios.add(unCliente); //El número en listausuarios = nº usuarios conectados
        }
    }
    
    public static void difusionMensaje(byte[] mensaje){
        
            try{
               String msg = new String(mensaje);
               String [] partesmensaje = msg.split("#");
                // VALIDADOR
                switch (partesmensaje[0]) {
                    case "REGISTRO":
                        
                        break;
                        
                    case "LOGIN":
                        ClienteDifusion user = listaUsuarios.get(0);
                        String login = "LOGIN";
                        mensaje = login.getBytes();
                        user.sendMessage(mensaje);
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
                        String error = "ERROR";
                        mensaje = error.getBytes();
                        user.sendMessage(mensaje);
                        
                    
                }
                         
                
            } catch (Exception e){
                    System.out.println("Error de difusion: " + e.toString());
            }   
    }
    
    
    //Completar
    public static ClienteDifusion buscarCliente (){
        ClienteDifusion user;
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            
        }
        
        return user;
    }
    
}
