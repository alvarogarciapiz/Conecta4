package Partidas;

import Ficheros.Ficheros;
import java.util.ArrayList;

/**
 * Clase cuya finalidad es la gestión del ranking
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
                if (Ficheros.obtenerPartidasGanadas(usuarios.get(i)) < Ficheros.obtenerPartidasGanadas(usuarios.get(i + 1))) {
                    String aux = usuarios.get(i);
                    usuarios.set(i, usuarios.get(i + 1));
                    usuarios.set(i + 1, aux);
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
}
