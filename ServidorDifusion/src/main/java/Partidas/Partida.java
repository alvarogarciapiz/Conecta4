package Partidas;

import java.util.ArrayList;

public class Partida {
    public static String usuario1;
    public static String usuario2;
    public static Tablero tablero;
    public static String ganador;
    public static int ID;
    public static String turno;

    public Partida() {
    }

    public Partida(String usuario1, String usuario2, ArrayList<String> movimientos, String ganador, int ID) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.ganador = ganador;
        this.ID = ID;
        this.tablero = new Tablero();
    }

    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }


    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public static int solicitarIDPartida () {
        int id = Ficheros.FicherosPartidas.obtenerUltimoIDPartida() + 1;
        return id;
    }

    public static Tablero getTablero() {
        return tablero;
    }

    public static void setTablero(Tablero aTablero) {
        tablero = aTablero;
    }

    public static String getTurno() {
        return turno;
    }

    public static void setTurno(String aTurno) {
        turno = aTurno;
    }
}