package Partidas;

import java.util.ArrayList;

public class Partida {
    private String usuario1;
    private String usuario2;
    private ArrayList<String> movimientos = new ArrayList<String>();
    private String ganador;
    private int ID;
    
    /* Cuando se inicia una nueva partida será necesario conocer los dos usuarios
    que juegan así como un registro de los movimientos almacenados en un array de
    cadenas. Los datos en el fichero de partidas se guardarán de la siguiente manera:
    
    ID=ganador=usuario1=usuario2=primerMovimientoUsuario1=primerMovimientoUsuario2=segundoMovimientoUsuario1=segundoMovimientoUsuario2= [...]
    */

    public Partida() {
    }

    public Partida(String usuario1, String usuario2, ArrayList<String> movimientos, String ganador, int ID) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.movimientos = movimientos;
        this.ganador = ganador;
        this.ID = ID;
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

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }
}