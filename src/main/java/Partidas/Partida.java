package Partidas;

import java.util.ArrayList;

/**
 * Clase cuya responsabilidad es cubrir toda la lógica de la partida: usuarios
 * que participan, ganador, turnos y tablero
 * @author alvaro
 * @version 1.0
 * @since 12/04/2021
 */
public class Partida {
    public static String usuario1;
    public static String usuario2;
    public static Tablero tablero;
    public static String ganador;
    public static int ID;
    public static String turno;

    /**
     * Constructor vacío de Partida
     */
    public Partida() {
    }

    /**
     * Constructor de Partida
     * @param usuario1 que juega
     * @param usuario2 que juega
     * @param movimientos como arraylist de String
     * @param ganador de la partida
     * @param ID de la partida (int)
     */
    public Partida(String usuario1, String usuario2, ArrayList<String> movimientos, String ganador, int ID) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.ganador = ganador;
        this.ID = ID;
        this.tablero = new Tablero();
    }

    /**
     * Retorna el usuario 1 de la partida
     * @return Usuario1
     */
    public String getUsuario1() {
        return usuario1;
    }

    /**
     * Establece el Usuario1
     * @param usuario1 
     */
    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    /**
     * Retorna el usuario 2 de la partida
     * @return Usuario2
     */
    public String getUsuario2() {
        return usuario2;
    }

    /**
     * Establece el usuario 2
     * @param usuario2 
     */
    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }

    /**
     * Retorna el ganador de la partida una vez haya uno
     * @return ganador de la partida
     */
    public String getGanador() {
        return ganador;
    }

    /**
     * Establece el ganador de la partida cuando haya uno
     * @param ganador 
     */
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    /**
     * Se obtiene el ID de la partida
     * @return ID de la partida
     */
    public int getID() {
        return ID;
    }

    /**
     * Establece el ID de la partida
     * @param ID 
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Método que devuelve un ID para partidas nuevas: solicita el último ID y suma 1
     * @return 
     */
    public static int solicitarIDPartida () {
        int id = Ficheros.FicherosPartidas.obtenerUltimoIDPartida() + 1;
        return id;
    }

    /**
     * Devuelve el tablero (con las posiciones)
     * @return Tablero
     */
    public static Tablero getTablero() {
        return tablero;
    }

    /**
     * Establece el tablero con sus posiciones
     * @param aTablero 
     */
    public static void setTablero(Tablero aTablero) {
        tablero = aTablero;
    }

    /**
     * Obtiene el turno (Usuario1 o Usuario2)
     * @return turno
     */
    public static String getTurno() {
        return turno;
    }

    /**
     * Establece el turno por cada ficha movida
     * @param aTurno 
     */
    public static void setTurno(String aTurno) {
        turno = aTurno;
    }
}