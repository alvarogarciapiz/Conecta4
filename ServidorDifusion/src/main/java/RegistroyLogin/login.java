package RegistroyLogin;

import Ficheros.Ficheros;

/**
 * Clase cuya responsabilidad es verificar el login de los usuarios comprobando
 * sus credenciales
 * @author alvaro
 * @version 1.0
 * @since 15/04/2021
 */
public class login {
    
    /**
     * Método que se encarga de la verificación del login
     * @param email del usuario
     * @param password del usuario
     * @return acceso que es booleano, en caso de Login correcto será true, de lo contrario false
     */
    public static boolean loginUsuario(String email, String password){
        boolean acceso = false;
        
        if (Ficheros.comprobarEmailRepetido(email)==true) {
            acceso = Ficheros.loginUsuario(email, password);
        } else {
            System.out.println("El email no se encuentra registrado.");
            acceso = false;
        }
        
        return acceso;
    }
}
