package com.mycompany.cliente;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente extends Thread {

    public static Socket sck;
    public static String email, nick, password;
    public int partidasJugadas, partidasGanadas, partidasPerdidas;
    boolean login = false;
    public static Cliente c = new Cliente();
    
    public static void main (String args[]) throws Exception{
        
        //Cliente c = new Cliente();
        c.sck = new Socket ("127.0.0.1", 5665);
        c.nick = generarRandomID(); //Hasta que no se logee el nick será un identificador
        c.start(); // Sigue funcionando...
        
        
        String inicio = nick + "#START# ";
        c.sck.getOutputStream().write(inicio.getBytes());
        System.out.println("Envio: " + inicio);
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
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
                String mensajeRecibido = new String(baos.toByteArray());               
                System.out.println("\tRecibido. > "+ mensajeRecibido);
                gestorRespuestas(mensajeRecibido);
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
    
    
    public static String generarRandomID () {
        Random rand = new Random();
        int RandId = rand.nextInt(50000);
        String id = Integer.toString(RandId);
        return id;
    }
    
    public static void gestorRespuestas (String mensaje) throws IOException {     //  "#LOGIN#OK#"  + nick  + "#"; 
        String [] partesMensaje = mensaje.split("#");
        Scanner sc = new Scanner(System.in); 
        
        switch (partesMensaje[0]) {
            case "LOGIN":
                if (partesMensaje[1].equals("OK")) {
                    nick = partesMensaje[2]; //De esta manera actualizamos el nick del lado del cliente
                }                             
                break;
                
                
            case "TERETAN":
                System.out.println(partesMensaje[1] + " te quiere retar");
                System.out.println("¿Aceptas su desafío? introduce lo asociado");
                System.out.println("SI -->  RESPUESTARETO#NO#" + partesMensaje[1] + "#");
                System.out.println("NO -->  RESPUESTARETO#SI#" + partesMensaje[1] + "#");
                break;
                
            case "PARTIDA":
                String nombreUser = partesMensaje[2];
                if (partesMensaje[1].equals("SI")) {
                    System.out.println("El usuario " + nombreUser + " aceptó tu reto.");
                } else if (partesMensaje[1].equals("NO")) {
                    System.out.println("El usuario " + nombreUser + " NO aceptó tu reto.");
                }
                
                break;
                
            default:
                System.out.println(" ");
        }
        
    }
    
    
    
}
