package RegistroyLogin;

import Ficheros.Ficheros;
import java.util.Scanner;

/**
 * Clase cuya responsabilidad es dar la posibilidad a los usuarios de que se registren
 * incluyendo todas las verificaciones necesarias de seguridad asociadas como la verificación
 * de contraseñas, que estas contengan una longitud suficiente, un número y una Mayúscula
 * @author alvaro
 * @version 1.0
 * @since 21/04/2021
 */
public class Registro {
    /**
     * Método que registra un nuevo usuario si se cumplen todas las verificaciones 
     * de seguridad y si no hay ningún dato ya existente (repetido) como email o nick
     * @param email
     * @param username
     * @param password
     * @return acceso que será true si todo es correcto y sino un error
     */
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
    
    /**
     * Método encargado de comprobar que la contraseña tiene al menos 8 caracteres,
     * un número y una mayúscula
     * @param pass Se le pasa la contraseña del usuario
     * @return error que es un booleano que se pondrá a true si no se cumple una de las condiciones
     */
    public static boolean comprobarPassword(String pass){
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
    
    /**
     * Método encargado de verificar que el email contiene el caracter arroba '@'
     * @param email
     * @return error que es booleano, en caso de haber un error se establece a true
     */
    public static boolean comprobarArrobaMail(String email){
        boolean error=false;        
        error = !email.contains("@");
        return error;
    }
}

