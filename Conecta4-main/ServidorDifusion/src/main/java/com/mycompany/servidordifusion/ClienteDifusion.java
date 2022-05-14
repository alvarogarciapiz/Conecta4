package com.mycompany.servidordifusion;

import java.io.*;
import java.net.*;

public class ClienteDifusion extends Thread {
    private Socket cliente; //--> canal de lectura y escritura
    private OutputStream os;
    private InputStream is;
    
    public String email, nick, password;
    public int partidasJugadas, partidasGanadas, partidasPerdidas;

    public ClienteDifusion() {
    }

    public ClienteDifusion(String email, String nick, String password, int partidasJugadas, int partidasGanadas, int partidasPerdidas) {
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
    }
     
    
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
                nb = getIs().read(buffer);
                if (nb>0){
                    baos.write(buffer, 0, nb);
                }
            } while (getIs().available()>0);
            ServidorDifusion.difusionMensaje(baos.toByteArray());
            
            } catch(Exception ex) {
                
            }
        }
    } //-> Fin del run()
    
    public void sendMessage (byte[] mensaje) throws Exception {
        System.out.println("Haciendo difusión: " + new String(mensaje));
        getOs().write(mensaje);
    }

    
    
    //--> Setters y Getters
    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
    
}
