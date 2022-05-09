package com.mycompany.servidordifusion;

//--> El cliente que  se conecta al servidor

import java.io.*;
import java.net.*;

public class ClienteDifusion extends Thread {
    private Socket cliente; //--> canal de lectura y escritura
    private OutputStream os;
    private InputStream is;
    
    public ClienteDifusion(Socket sck) throws Exception {
        cliente = sck;
        os = cliente.getOutputStream();
        is = cliente.getInputStream();
        
        start(); //--> Se ejecuta el método run
    }
    
    public void run() { //--> AQUI ES DONDE IMPLEMENTO LA SOLUCIÓN
        while (true){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try{
            byte[] buffer = new byte[1024]; //Un byte por caracter, nos caben 1024 caracteres
            int nb; //--> número de bytes
            
            do{
                nb = is.read(buffer);
                if (nb>0){
                    baos.write(buffer, 0, nb);
                }
            } while (is.available()>0);
            ServidorDifusion.difusionMensaje(baos.toByteArray());
            
            } catch(Exception ex) {
                
            }
        }
    } //-> Fin del run()
    
    public void sendMessage (byte[] mensaje) throws Exception {
        System.out.println("Haciendo difusión...");
        os.write(mensaje);
    }
    
}
