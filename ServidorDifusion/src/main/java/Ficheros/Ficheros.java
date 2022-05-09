package Ficheros;

import com.mycompany.servidordifusion.ClienteDifusion;
import com.mycompany.servidordifusion.ClienteDifusion;
import com.mycompany.servidordifusion.Principal;
import com.mycompany.servidordifusion.ServidorDifusion;
import java.io.*;

public class Ficheros {
    
    
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
    
    
    public static void escribirDatosUsuariosFicheros(String user, String pass, String mail){
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
    
}
