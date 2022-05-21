package Ficheros;

import Partidas.Partida;
import java.io.*;
import java.util.*;

public class FicherosPartidas {

    // Eliminar
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
