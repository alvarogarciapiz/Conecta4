package Servidor;

import java.io.*;
import java.net.*;

/**
 * Clase que maneja toda la lógica del cliente desde el lado del servidor
 * @author alvaro
 * @version 1.0
 * @since 01/04/2021
 */
public class ClienteDifusion extends Thread {
    private Socket cliente; //--> canal de lectura y escritura
    private OutputStream os;
    private InputStream is;
    
    public String email, nick, password;
    public int partidasJugadas, partidasGanadas, partidasPerdidas;

    /**
     * Constructor vacío de ClienteDifusion
     */
    public ClienteDifusion() {
    }

    /**
     * Constructor de ClienteDifusion
     * @param email
     * @param nick
     * @param password
     * @param partidasJugadas
     * @param partidasGanadas
     * @param partidasPerdidas 
     */
    public ClienteDifusion(String email, String nick, String password, int partidasJugadas, int partidasGanadas, int partidasPerdidas) {
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
    }
     
    /**
     * Constructor de ClienteDifusion para el socket
     * @param email
     * @param nick
     * @param password
     * @param partidasJugadas
     * @param partidasGanadas
     * @param partidasPerdidas 
     */
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
        //System.out.println("Haciendo difusión: " + new String(mensaje));
        getOs().write(mensaje);
    }

    
    
    /**
     * Retorna el objeto cliente
     * @return Cliente
     */
    public Socket getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente
     * @param cliente 
     */
    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el OutPutStream
     * @return os
     */
    public OutputStream getOs() {
        return os;
    }

    /**
     * Establece el OutPutStream
     * @param os 
     */
    public void setOs(OutputStream os) {
        this.os = os;
    }

    /**
     * Retorna el InPutStream
     * @return is
     */
    public InputStream getIs() {
        return is;
    }

    /**
     * Establece el InPutStream
     * @param is 
     */
    public void setIs(InputStream is) {
        this.is = is;
    }

    /**
     * Retorna el email del cliente
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del cliente
     * @return email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna el nick del cliente
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * Establece el nick del cliente
     * @return nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Retorna el password del cliente
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Establece el password del cliente
     * @return password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna las partidas jugadas del cliente
     * @return partidasJugadas
     */
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Establece la spartidas jugadas del cliente
     * @param partidasJugadas 
     */
    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    /**
     * Obtiene las partidas ganadas
     * @return partidasGanadas
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece las partidas ganadas
     * @param partidasGanadas 
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Retorna las partidas perdidas
     * @return partidasPerdidas
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * Establece las partidas perdidas
     * @return partidasPerdidas
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
    
}
