package Ficheros;

public class Correspondencias {
    public static String obtenerLetra (String numero){
        String letra="c";
        
        switch (numero) {
            case "0":
                letra = "A";
                break;
            case "1":
                letra = "B";
                break;
            case "2":
                letra = "C";
                break;
            case "3":
                letra = "D";
                break; 
            case "4":
                letra = "E";
                break;
            case "5":
                letra = "F";
                break;    
        }
        
        return letra;
    }
}
