package RegistroyLogin;

import Ficheros.Ficheros;

public class login {
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
