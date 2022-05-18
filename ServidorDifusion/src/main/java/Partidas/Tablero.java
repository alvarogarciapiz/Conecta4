package Partidas;

public class Tablero {

    public static String[][] getPosiciones() {
        return posiciones;
    }

    public static void setPosiciones(String[][] aPosiciones) {
        posiciones = aPosiciones;
    }
    

    public static String[][] posiciones = new String[6][7];

    public Tablero() {
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                posiciones[i][j] = "0";
            }
        }
    }
    
}
