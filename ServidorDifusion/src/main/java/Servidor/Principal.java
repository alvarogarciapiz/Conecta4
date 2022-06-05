package Servidor;

import static Servidor.ServidorDifusion.*;
import java.util.Scanner;

/**
 * Clase Principal desde la que se inicia el servidor
 * @author alvaro
 * @version 1.0
 * @since 01/04/2021
 */
public class Principal {
/**
 * 
 * @param args
 * @throws Exception 
 */
    public static void main(String[] args) throws Exception {
        ServidorDifusion srv = new ServidorDifusion();
        //System.in.read();
        
        while (true){
            //MENU
        System.out.println("\n");    
        System.out.println(" -------------------- Conecta 4 ---------------------");
        System.out.println("| Usuarios conectados: " + srv.listaUsuarios.size() + "                            |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("| [1] INFO JUGADOR: Introduce '1-nick'              |");
        System.out.println("| [2] INFO PARTIDA: Introduce '2-IDPartida'         |");
        System.out.println("| [3] RANKING: Ver Ranking completo, introduce '3'  |");
        System.out.println("| [4] APAGAR: Apaga el servidor, introduce '4'      |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("\n");
        
            Scanner inr = new Scanner(System.in);
            String mensajeServidor = inr.nextLine();
            gestorServidor(mensajeServidor);
        }
    }   
}
