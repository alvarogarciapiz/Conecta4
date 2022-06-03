package Ficheros;

import Servidor.ClienteDifusion;
import Servidor.ClienteDifusion;
import Servidor.Principal;
import Servidor.ServidorDifusion;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase que cubre toda la lógica de gestión de Ficheros para el apartado de usuarios
 * como login, comprobación de datos repetidos y obtención de información sobre los 
 * usuarios como información sobre sus partidas. Se trabaja con el fichero datosUsuarios.dat
 * @author alvaro
 * @version 1.0
 * @since 08/04/2021
 */
public class Ficheros {
    
    /**
     * Método que verifica el login cuanod se reciben unas credenciales
     * @param email
     * @param password
     * @return acceso que será true si las credenciales existen y son correctas
     */
    public static boolean loginUsuario(String email, String password){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea="";
    boolean acceso = false;

        try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
            while((linea=br.readLine())!=null){
                String linea2=linea;
                String[] parts = linea2.split("=");

                if (parts[0].equals(email) && parts[2].equals(password)) {
                    acceso = true;
                    return acceso;
                }

            }
        } 
        catch(Exception e){
         e.printStackTrace();
        }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
        }catch (Exception e2){ 
            e2.printStackTrace();
        }
      }
        return acceso;
    }
    
    /**
     * Método que lee el fichero para comprobar si el mail que se intenta registrar
     * existe ya en el fichero
     * @param email
     * @return repetido que será true si ya está registrado
     */
    public static boolean comprobarEmailRepetido(String email){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea="";
    boolean repetido=false;

        try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
            while((linea=br.readLine())!=null){

                repetido = linea.contains(email);
                if (repetido==true) {
                    return repetido;
                }
            }
        } 
        catch(Exception e){
         e.printStackTrace();
        }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
        }catch (Exception e2){ 
            e2.printStackTrace();
        }
      }
        return repetido;
    }
    
    /**
     * Método que verifica si el username o nick que se intenta registrar ya está
     * en el ficheor registrado
     * @param username
     * @return repetido que será true si ya está registrado
     */
    public static boolean comprobarUsernameRepetido(String username){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea="";
    boolean repetido=false;

        try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
            while((linea=br.readLine())!=null){
                String linea2=linea;
                String[] parts = linea2.split("=");

                
                if (parts[1].equals(username)) {
                    repetido = true;
                    System.out.println("El username ya se encuentra en uso.");
                }

            }
        } 
        catch(Exception e){
         e.printStackTrace();
        }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
        }catch (Exception e2){ 
            e2.printStackTrace();
        }
      }
        return repetido;
    }
    
    /**
     * Método que se encarga de registrar el usuario en el frichero guardando su nick,
     * email y contraseña
     * @param user
     * @param pass
     * @param mail 
     */
    public static void escribirDatosUsuariosFicheros (String user, String pass, String mail){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("datosUsuarios.dat", true);
            pw = new PrintWriter(fichero);


                pw.println(mail + "=" + user + "=" + pass + "=" + "0" + "=" + "0" + "=" + "0");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    /**
     * Método que al comeinzo de la ejecución del programa carga en el servidor todos
     * los usuaarios registrados en formado de objeto usuario
     */
    public static void crearUsuariosDeFichero(){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
            ClienteDifusion user = new ClienteDifusion(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),
            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
            ServidorDifusion.listaUsuarios.add(user);
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    
    /**
     * Método que busca un nick por su email. Recube un email y devuelve el nick asociado
     * @param email
     * @return nick del usuario o ERROR si no se encuentra
     */
    public static String buscarNickPorEmail(String email){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    String nick = "ERROR";

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
             if (parts[0].equals(email)) {
                 nick = parts[1];
                 return nick;
             }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return nick;
    }
    
    /**
     * Método que devuelve el número de partidas jugadas de un determinado usuario
     * @param nick
     * @return número de partidas jugadas
     */
    public static int obtenerPartidasJugadas (String nick){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    int partidas = 0;

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
             if (parts[1].equals(nick)) {
                 partidas = Integer.parseInt(parts[3]);
                 return partidas;
             }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return partidas;
    }
    
    /**
     * Método que devuelve el número de partidas ganadas de un determinado usuario
     * @param nick
     * @return número de partidas ganadas
     */
    public static int obtenerPartidasGanadas (String nick){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    int partidas = 0;

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
             if (parts[1].equals(nick)) {
                 partidas = Integer.parseInt(parts[4]);
                 return partidas;
             }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return partidas;
    }
    
    /**
     * Método que devuelve el número de partidas perdidas de un determinado usuario
     * @param nick
     * @return número de partidas perdidas
     */
    public static int obtenerPartidasPerdidas (String nick){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    int partidas = 0;

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
             if (parts[1].equals(nick)) {
                 partidas = Integer.parseInt(parts[5]);
                 return partidas;
             }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return partidas;
    }
    
    /**
     * Método que devuelve un arraylist con todos los usuarios dn formato de arraylist
     * @return arraylist de usuarios
     */
    public static ArrayList<String> obtenerListadoNicks() { // #1
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    ArrayList<String> listUsers = new ArrayList<String>();

      try {
         archivo = new File ("datosUsuarios.dat");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //Lectura del fichero
         String linea;
         
         while((linea=br.readLine())!=null){
            String linea2=linea;
            String[] parts = linea2.split("=");
            listUsers.add(parts[1]);
                
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return listUsers;
    }
    
}
