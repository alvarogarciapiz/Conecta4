package Cliente;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pantallaLogin extends javax.swing.JFrame implements Runnable {

    private static String nick;
    public static boolean login = false;
    private static Socket sck;

    /**
     * Creates new form pantallaLogin
     */
    public pantallaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLoginTExt = new javax.swing.JLabel();
        passLoginText = new javax.swing.JLabel();
        passLogin = new javax.swing.JPasswordField();
        botonAcceder = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonRegistro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        emailRegistroText = new javax.swing.JLabel();
        passRegistroText = new javax.swing.JLabel();
        nickRegistroText = new javax.swing.JLabel();
        nickRegistro = new javax.swing.JTextField();
        emailRegistro = new javax.swing.JTextField();
        passRegistro = new javax.swing.JTextField();
        emailLogin = new javax.swing.JTextField();
        resultLogin = new javax.swing.JLabel();
        resultRegistro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imagen = new javax.swing.JPanel();
        accederJuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        emailLoginTExt.setText("Email: ");

        passLoginText.setText("Contraseña: ");

        passLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passLoginActionPerformed(evt);
            }
        });

        botonAcceder.setText("Acceder");
        botonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccederActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Iniciar sesión");

        botonRegistro.setText("Registro");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Registro");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        emailRegistroText.setText("Email: ");

        passRegistroText.setText("Contraseña: ");

        nickRegistroText.setText("Nick:");

        nickRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickRegistroActionPerformed(evt);
            }
        });

        emailRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRegistroActionPerformed(evt);
            }
        });

        passRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passRegistroActionPerformed(evt);
            }
        });

        emailLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailLoginActionPerformed(evt);
            }
        });

        resultLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultLogin.setText(" ");

        resultRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultRegistro.setText(" ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Conecta 4");

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        accederJuego.setBackground(new java.awt.Color(153, 204, 255));
        accederJuego.setText("Acceder al Juego");
        accederJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accederJuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passLoginText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLoginTExt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resultLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAcceder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accederJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(resultRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(passRegistroText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nickRegistroText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailRegistroText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nickRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(375, 375, 375))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailRegistroText)
                                    .addComponent(emailRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passRegistroText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nickRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nickRegistroText))
                                .addGap(18, 18, 18)
                                .addComponent(botonRegistro)
                                .addGap(38, 38, 38)
                                .addComponent(resultRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLoginTExt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passLoginText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(botonAcceder)
                                .addGap(18, 18, 18)
                                .addComponent(resultLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accederJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAccederActionPerformed
        String passLoginContent = passLogin.getText();
        String emailLoginContent = emailLogin.getText();

        try {
            hacerLogin(emailLoginContent, passLoginContent);
        } catch (IOException ex) {
            Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botonAccederActionPerformed

    private void nickRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nickRegistroActionPerformed

    private void emailRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRegistroActionPerformed

    private void passRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passRegistroActionPerformed

    private void passLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passLoginActionPerformed

    }//GEN-LAST:event_passLoginActionPerformed

    private void emailLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailLoginActionPerformed

    /**
     * Botón que cuando es clickado obtiene el contenido de los campos de registro y manda un mensaje 
     * al servidor con ello
     * @param evt 
     */
    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed

        String passRegistroContent = passRegistro.getText();
        String emailRegistroContent = emailRegistro.getText();
        String nickRegistroContect = nickRegistro.getText();

        try {
            hacerRegistro(emailRegistroContent, passRegistroContent, nickRegistroContect);
        } catch (IOException ex) {
            Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonRegistroActionPerformed

    /**
     * Método que cuando su botón el clickado manda los campos de login al servidor
     * @param evt 
     */
    private void accederJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accederJuegoActionPerformed
        if (login==true) {
            try {
                pantallaJuego.main(null);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            resultLogin.setText("Primero debes hacer login.");
        }
    }//GEN-LAST:event_accederJuegoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        pantallaLogin c = new pantallaLogin();
        c.sck = new Socket("127.0.0.1", 5666);
        c.nick = generarRandomID(); //Hasta que no se logee el nick será un identificador
        Thread t1 = new Thread(c);
        t1.start();

        //Inicializo conexión con el servidor
        String inicio = getNick() + "#START# ";
        c.getSck().getOutputStream().write(inicio.getBytes());
        System.out.println("Envio: " + inicio);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaLogin().setVisible(true);
               
                
            }
        });
        
        
    }
public static javax.swing.JLabel aa;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton accederJuego;
    private javax.swing.JButton botonAcceder;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JTextField emailLogin;
    private javax.swing.JLabel emailLoginTExt;
    private javax.swing.JTextField emailRegistro;
    private javax.swing.JLabel emailRegistroText;
    private javax.swing.JPanel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nickRegistro;
    private javax.swing.JLabel nickRegistroText;
    private javax.swing.JPasswordField passLogin;
    private javax.swing.JLabel passLoginText;
    private javax.swing.JTextField passRegistro;
    private javax.swing.JLabel passRegistroText;
    public static javax.swing.JLabel resultLogin;
    public static javax.swing.JLabel resultRegistro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            InputStream is = getSck().getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = null;
            int nb;

            //¿Lo que recibe el cliente?
            while (true) {
                baos = new ByteArrayOutputStream();
                do {
                    nb = is.read(buffer);
                    baos.write(buffer, 0, nb);
                } while (is.available() > 0);
                String mensajeRecibido = new String(baos.toByteArray());
                System.out.println("\tRecibido. > " + mensajeRecibido);
                gestorRespuestas(mensajeRecibido);
                pantallaJuego.gestorRespuestas2(mensajeRecibido);
            }
        } catch (Exception ex) {

        }
    }

    /**
     * Método encargado de enviar el contenido del login al servidor
     * @param email
     * @param password
     * @throws IOException 
     */
    public static void hacerLogin(String email, String password) throws IOException {
        String mensaje = getNick() + "#LOGIN" + "#" + email + "#" + password + "#";
        sck.getOutputStream().write(mensaje.getBytes());
    }
    
    /**
     * Método encargado de enviar el contenido del registro al servidor
     * @param email
     * @param password
     * @param nick
     * @throws IOException 
     */
    public static void hacerRegistro (String email, String password, String nick) throws IOException {
        String mensaje = getNick() + "#REGISTRO" + "#" + email + "#" + nick + "#" + password + "#";
        sck.getOutputStream().write(mensaje.getBytes());
    }

    /**
     * Método que genera un ID aleatorio entre 0 y 50000 que se utiliza justo al
     * comienzo de la ejecución del programa cuando todavía el cliente no está
     * logeado o registrado y el servidor tiene que tener alguna forma de
     * localizarlo
     *
     * @return id en String
     */
    public static String generarRandomID() {
        Random rand = new Random();
        int RandId = rand.nextInt(50000);
        String id = Integer.toString(RandId);
        return id;
    }

    /**
     * Método que recibe el mensaje del servidor y lo gestiona ya sea la
     * respuesta correcta o incorrecta del login, que le llegue un reto al
     * usuario o que tiene que mover una ficha
     *
     * @param mensaje
     * @throws IOException
     */
    public static void gestorRespuestas(String mensaje) throws IOException {
        String[] partesMensaje = mensaje.split("#");
        Scanner sc = new Scanner(System.in);
        switch (partesMensaje[0]) {
            
            case "LOGIN":
                if (partesMensaje[1].equals("OK")) {
                    nick = partesMensaje[2]; //De esta manera actualizamos el nick del lado del cliente
                    resultLogin.setText("Login correcto, haz clic abajo para acceder al juego");
                    login = true;
                    pantallaJuego.nick = nick;
                    pantallaJuego.setSck(sck);        
                } else if (partesMensaje[1].equals("NOK")){
                    resultLogin.setText("Error al hacer login");
                }
                break;

            case "REGISTRO":
                if (partesMensaje[1].equals("OK")) {
                    resultRegistro.setText("Registro completado con éxito.\n Haz login"
                            + "para acceder al juego");
                } else if(partesMensaje[2].equals("EMAIL")) {
                    resultRegistro.setText("Error, ese email ya se encuentra registrado.\n Prueba con uno diferente o login");
                } else if(partesMensaje[2].equals("NICK")) {
                    resultRegistro.setText("Nickname en uso");
                } else if(partesMensaje[2].equals("PASSWORD")) {
                    resultRegistro.setText("Tu contraseña deberá contener al menos un número, una mayúscula y 8 caracteres.");
                }
                
                break;
                
            default:
                System.out.println(" ");
        }

    }

    /**
     * Método que retorna el nick del usuario
     * @return 
     */
    public static String getNick() {
        return nick;
    }

    /**
     * Método que establece el nick del usuario
     * @return 
     */
    public static Socket getSck() {
        return sck;
    }
}
