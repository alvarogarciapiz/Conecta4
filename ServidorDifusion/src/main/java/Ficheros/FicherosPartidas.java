package Ficheros;

import Partidas.Partida;
import java.io.*;
import java.util.*;

/**
 * Clase que cubre toa la lógica de gestión de Ficheros para el apartado de partidas
 * como puede ser el registro de partidas en ficheros y la obtención del último ID 
 * de partida registrado.
 * @author alvaro
 * @version 1.0
 * @since 09/04/2021
 */
public class FicherosPartidas {

    public static void nuevaPartida(String usuario1, String usuario2, String ganador, int ID) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("datosPartidas.dat", true);
            pw = new PrintWriter(fichero);

            pw.println(ID + "=" + ganador + "=" + usuario1 + "=" + usuario2 + "=");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Método que registra una nueva partida en el fichero 'datosPartidas.dat'
     * @param p1 Objeto de tipo partida
     */
    public static void registrarPartida(Partida p1) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("datosPartidas.dat", true);
            pw = new PrintWriter(fichero);

            pw.println(Partida.ID + "=" + Partida.ganador + "=" + Partida.usuario1 + "=" + Partida.usuario2 + "=");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }  

    /**
     * Método que lee el último ID de partida y lo develve
     * @return id de la partida
     */
    public static int obtenerUltimoIDPartida() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        int id = 0;

        try {
            archivo = new File("datosPartidas.dat");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Lectura del fichero
            while ((linea = br.readLine()) != null) {
                String linea2 = linea;
                String[] parts = linea2.split("=");

                id = Integer.parseInt(parts[0]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return id;
    }

}
