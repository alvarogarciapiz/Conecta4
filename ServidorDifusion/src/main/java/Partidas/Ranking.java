package Partidas;

import Ficheros.Ficheros;
import java.util.ArrayList;

/**
 * Clase cuya finalidad es la gestión del ranking del juego
 * @author alvaro
 * @version 1.0
 * @since 12/04/2021
 */
public class Ranking {

    /**
     * Método que obtiene los cinco mejores jugadores del ranking en función
     * de las partidas ganadas
     *
     * @return String que contiene los cinco usuarios registrados con más partidas
     * ganadas separados por el caracter '='
     *
     */
    public static String obtenerRanking() {
        String ranking = new String();
        ArrayList<String> usuarios = Ficheros.obtenerListadoNicks();
        boolean ordenado = false;
        final int tamRanking = 5;

        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < usuarios.size() - 1; i++) {
                if (Ficheros.obtenerPartidasGanadas(usuarios.get(i)) < Ficheros.obtenerPartidasGanadas(usuarios.get(i+1))) {
                    String aux = usuarios.get(i);
                    usuarios.set(i, usuarios.get(i + 1));
                    usuarios.set(i+1, aux);
                    ordenado = false;
                }
            }
        }

        //Sólo nos quedamos con los X (tamRanking) primeros
        for (int i = 0; i < tamRanking; i++) {
            ranking = ranking + usuarios.get(i) + "#";
        }

        return ranking;
    }
    
    
    /**
     * Método que devuelve la posición en el ranking de un usuario en específico
     * @param nickUsuario
     * @return 
     */
    public static int obtenerPosicionRanking(String nickUsuario) {
        int posicion=0;
        ArrayList<String> usuarios = Ficheros.obtenerListadoNicks();
        boolean ordenado = false;
        
        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < usuarios.size() - 1; i++) {
                if (Ficheros.obtenerPartidasGanadas(usuarios.get(i)) < Ficheros.obtenerPartidasGanadas(usuarios.get(i+1))) {
                    String aux = usuarios.get(i);
                    usuarios.set(i, usuarios.get(i + 1));
                    usuarios.set(i+1, aux);
                    ordenado = false;
                }
            }
        }

        for (int i = 0; i < usuarios.size() - 1; i++) {
            if (usuarios.get(i).equals(nickUsuario)) {
                posicion = i;
                return i;
            }
        }

        return posicion;
    }
    
    /**
     * Devuelve el ranking completo para cuando es solicitado por el servidor a 
     * nivel interno.
     * @return 
     */
    public static ArrayList<String> obtenerRankingCompleto() {
        String ranking = new String();
        ArrayList<String> usuarios = Ficheros.obtenerListadoNicks();
        boolean ordenado = false;

        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < usuarios.size() - 1; i++) {
                if (Ficheros.obtenerPartidasGanadas(usuarios.get(i)) < Ficheros.obtenerPartidasGanadas(usuarios.get(i+1))) {
                    String aux = usuarios.get(i);
                    usuarios.set(i, usuarios.get(i + 1));
                    usuarios.set(i+1, aux);
                    ordenado = false;
                }
            }
        }

        return usuarios;
    }
}
