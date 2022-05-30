package Partidas;
/**
 * Clase cuyo fin es la gestión del tablero de la partida
 * @author alvaro
 * @version 1.0
 * @since 12/04/2021
 */
public class Tablero {

    public static String[][] posiciones = new String[6][7];

    public Tablero() {
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                posiciones[i][j] = "0";
            }
        }
    }
    /**
     * Se obtienen las posiciones del tablero
     * @return Un array bidimensional con las posiciones del tablero
     */
    public static String[][] getPosiciones() {
        return posiciones;
    }

    /**
     * Establece las posiciones en el tablero
     * @param Posiciones del tablero en String
     */
    public static void setPosiciones(String[][] aPosiciones) {
        posiciones = aPosiciones;
    }
    
    
    
}
