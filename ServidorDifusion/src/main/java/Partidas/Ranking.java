package Partidas;

import Ficheros.Ficheros;
import java.util.ArrayList;

public class Ranking {
    public static ArrayList<String> obtenerRanking (){
        ArrayList<String> ranking = new ArrayList<String>();
        ArrayList<String> usuarios = Ficheros.obtenerListadoNicks();
        boolean ordenado = false;
        final int tamRanking = 5;
        
        
        System.out.println("RANKING ANTES: ");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
        
        while (!ordenado){
        ordenado = true;
        for (int i = 0; i < usuarios.size()-1; i++) {
            if (Ficheros.obtenerPartidasGanadas(usuarios.get(i)) < Ficheros.obtenerPartidasGanadas(usuarios.get(i+1))) {
                String aux = usuarios.get(i);
                usuarios.set(i, usuarios.get(i+1));
                usuarios.set(i+1, aux);
                ordenado = false;
            }
        }
        }
        
        //Sólo nos quedamos con los X (tamRanking) primeros
        for (int i = 0; i < tamRanking; i++) {
            ranking.add(i, usuarios.get(i));
        }
        
        
        System.out.println("RANKING SÓLO 3: ");
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println(ranking.get(i));
        }
        
        
        return ranking;
    }
}
