package Cliente;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Clase Cliente que desarrolla toda la lógica de negocio desde el lado del cliente
 * @author alvaro
 * @version 2.0
 * @since 01/04/2021
 */
public class Cliente extends Thread {

    public static Socket sck;
    public static String email;
    public static String nick;
    public static String password;
    public int partidasJugadas, partidasGanadas, partidasPerdidas;
    public static boolean login = false;
    
    /**
     * Método principal, Primero establece una conexión con el servidor mediante el 'START'
     * acto seguido invoca a run()
     * @param args
     * @throws Exception 
     */
    public static void main (String args[]) throws Exception{
        
        Cliente c = new Cliente();
        c.sck = new Socket ("127.0.0.1", 5666);
        c.nick = generarRandomID(); //Hasta que no se logee el nick será un identificador
        c.start();
 
        //Inicializo conexión con el servidor
        String inicio = getNick() + "#START# ";
        c.getSck().getOutputStream().write(inicio.getBytes());
        System.out.println("Envio: " + inicio);
        
        //Inicializa la interfaz
        //pantallaLogin.main(null);
        
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        while (true){
            System.out.println("Mensaje: ");
            String elMensaje = br.readLine();
            elMensaje = getNick() + "#" + elMensaje;
            
            //Lo que envía el cliente
            c.getSck().getOutputStream().write(elMensaje.getBytes());
            
            System.out.println("\t\t\tEnviando mensaje...");
        }
        
    }
    
    /**
     * @Override
     */
    public void run() {
        try {
            InputStream is = getSck().getInputStream();
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
    
    /**
     * Método que se encarga de hacer login del usuario
     * @param email
     * @param password
     * @throws IOException 
     */
    public static void hacerLogin (String email, String password) throws IOException {
        String mensaje = nick + "#LOGIN" + "#" + email + "#" + password + "#";
        sck.getOutputStream().write(mensaje.getBytes());
    }
    
    /**
     * Método que genera un ID aleatorio entre 0 y 50000 que se utiliza justo al comienzo
     * de la ejecución del programa cuando todavía el cliente no está logeado o registrado y el 
     * servidor tiene que tener alguna forma de localizarlo
     * @return id en String
     */
    public static String generarRandomID () {
        Random rand = new Random();
        int RandId = rand.nextInt(50000);
        String id = Integer.toString(RandId);
        return id;
    }
    
    /**
     * Método que recibe el mensaje del servidor y lo gestiona ya sea la respuesta correcta
     * o incorrecta del login, que le llegue un reto al usuario o que tiene que mover una ficha
     * @param mensaje
     * @throws IOException 
     */
    public static void gestorRespuestas (String mensaje) throws IOException {     //  "#LOGIN#OK#"  + nick  + "#"; 
        String [] partesMensaje = mensaje.split("#");
        Scanner sc = new Scanner(System.in); 
        
        switch (partesMensaje[0]) {
            case "LOGIN":
                if (partesMensaje[1].equals("OK")) {
                    nick = partesMensaje[2]; //De esta manera actualizamos el nick del lado del cliente
                    login = true;
                    pantallaJuego.main(null);
                    int a = pantallaLogin.DISPOSE_ON_CLOSE;
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

    /**
     * Retorna el socket
     * @return sck (socket)
     */
    public static Socket getSck() {
        return sck;
    }

    /**
     * Retorna el Nick del cliente/usuario
     * @return nick
     */
    public static String getNick() {
        return nick;
    }
    
    
    
}
