package RegistroyLogin;

import Ficheros.Ficheros;
import java.util.Scanner;

public class Registro {
    public static String registrarNuevoUsuario(String email, String username, String password){
        Scanner sc = new Scanner(System.in);
        boolean error = false;
        String acceso = "true";
        
        if (email.equals("") || username.equals("") || password.equals("")) {
            return "Complete todos los campos";
        }
        
        error = Ficheros.comprobarEmailRepetido(email);
        if (error == true) {
            return "El email ya se encuentra registrado.";
        }
        
        if (comprobarArrobaMail(email)==true){
            return "Introduce un email válido (que contenga '@')";
        }

        error = Ficheros.comprobarUsernameRepetido(username);
        if (error==true){
            return "Ese nick ya se encuentra en uso";
        }
        

        error = comprobarPassword(password);
        if (error==true){
            return "La contaseña debe contener al menos 8 caracteres, una mayuscula y un numero.";
        }
        
        if (acceso.equals("true")) {
            Ficheros.escribirDatosUsuariosFicheros(username, password, email);
            Ficheros.crearUsuariosDeFichero();
        }
        
        return acceso;
    }
    
    
    public static boolean comprobarPassword(String pass){ //8 caracteres y tener al menos un número y una mayúscula.
        boolean error=false;
        int contador=0, i=0;
        
        if (pass.length()<8){
            error = true;
        }
        
        for (i = 0; i < pass.length(); i++) {
            if (!Character.isUpperCase(pass.charAt(i))) {
                contador++;
            }
            if (contador == pass.length()) {
                error = true;
            }
        }
        
        contador = 0;
        for (i = 0; i < pass.length(); i++) {
            if (!Character.isDigit(pass.charAt(i))) {
                contador++;
            }
            if (contador == pass.length()) {
                error = true;
            }
        }
        
        if (error==true) {
            System.out.println("La contaseña debe contener al menos 8 caracteres,"
                    + " una mayuscula y un numero.");
        }
        return error;
    }
    
    public static boolean comprobarArrobaMail(String email){
        boolean error=false;        
        error = !email.contains("@");
        return error;
    }
}

