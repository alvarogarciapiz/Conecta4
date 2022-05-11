package com.mycompany.cliente;

import java.io.*;
import java.net.*;

public class Cliente extends Thread {

    private Socket sck;
    public static String email, nick="Alvaro", password;
    public int partidasJugadas, partidasGanadas, partidasPerdidas;
    
    public static void main (String args[]) throws Exception{
        
        Cliente c = new Cliente();
        c.sck = new Socket ("127.0.0.1", 5666);
        c.start(); // Sigue funcionando...
        
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        // ¿Lo que envia el cliente?
        while (true){
            System.out.println("Mensaje: ");
            String elMensaje = br.readLine();
            elMensaje = nick + "#" + elMensaje;
            
            //Lo que envía el cliente
            c.sck.getOutputStream().write(elMensaje.getBytes());
            
            System.out.println("\t\t\tEnviando mensaje...");
        }
        
    }
    
    @Override
    public void run() {
        try {
            InputStream is = sck.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = null;
            int nb;
            
            //¿Lo que recibe el cliente?
            while (true){
                baos = new ByteArrayOutputStream();
                do {
                    nb = is.read(buffer);
                    baos.write(buffer, 0, nb);
                } while (is.available()>0);
                System.out.println("\tRecibido. > "+ new String (baos.toByteArray()));
            }
        } catch (Exception ex) {
            
        }
    }
    
    public static boolean hacerLogin (String email, String password) throws IOException {
        boolean acceso = false;
        byte[] buffer = new byte[1024];
        
        Cliente c = new Cliente();
        c.sck = new Socket ("127.0.0.1", 5665);
        
        String mensaje = "LOGIN" + "#" + email + "#" + password + "#";
        c.sck.getOutputStream().write(mensaje.getBytes());
        
        //
        return acceso;
    }
    
}
