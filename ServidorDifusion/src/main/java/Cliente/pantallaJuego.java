package Cliente;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pantallaJuego extends javax.swing.JFrame implements Runnable {

    public static String nick;
    public static Socket sck;
    
    public pantallaJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Conecta 4");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        retar1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        top1 = new javax.swing.JLabel();
        top2 = new javax.swing.JLabel();
        top3 = new javax.swing.JLabel();
        top4 = new javax.swing.JLabel();
        top5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        retar2 = new javax.swing.JLabel();
        retar3 = new javax.swing.JLabel();
        retar4 = new javax.swing.JLabel();
        retar5 = new javax.swing.JLabel();
        cargarJugadores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        conectado3 = new javax.swing.JLabel();
        conectado1 = new javax.swing.JLabel();
        conectado2 = new javax.swing.JLabel();
        conectado4 = new javax.swing.JLabel();
        conectado5 = new javax.swing.JLabel();
        conectado6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jugadores conectados");

        retar1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar1.setText("⚔");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("4.");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("2.");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("3.");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("5.");

        top1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top1.setText(" ");

        top2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top2.setText(" ");

        top3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top3.setText(" ");

        top4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top4.setText(" ");

        top5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top5.setText(" ");

        jButton1.setText("Actualizar Ranking");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel7.setText("★ Ranking ★");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setText("1. ");

        retar2.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar2.setText("⚔");

        retar3.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar3.setText("⚔");

        retar4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar4.setText("⚔");

        retar5.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar5.setText("⚔");

        cargarJugadores.setText("Cargar Jugadores");
        cargarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarJugadoresActionPerformed(evt);
            }
        });

        jLabel2.setText("Haz clic en el botón para cargar");

        jLabel9.setText("los usuarios conectados");

        conectado3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado3.setText(" ");

        conectado1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado1.setText(" ");

        conectado2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado2.setText(" ");

        conectado4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado4.setText(" ");

        conectado5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado5.setText(" ");

        conectado6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado6.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(952, 952, 952)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(conectado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(conectado6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(conectado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(conectado5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(retar2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(retar4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(retar5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(retar3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(top3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(top4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(top1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(top5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                                        .addComponent(conectado3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(top2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(conectado1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(retar1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(cargarJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel9)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(top2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(top3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(top1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(top4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(top5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(conectado3)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectado1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retar3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectado2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectado5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retar4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectado4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retar5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectado6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(cargarJugadores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mensaje = nick + "#" + "RANKING" + "#";
        try {
            sck.getOutputStream().write(mensaje.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarJugadoresActionPerformed
        String mensaje = nick + "#" + "DISPONIBLES" + "#";
        try {
            sck.getOutputStream().write(mensaje.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cargarJugadoresActionPerformed

    public static void main(String args[]) throws IOException {
        
        pantallaJuego j = new pantallaJuego();
        Thread t1 = new Thread(j);
        t1.start();

        //Inicializo conexión con el servidor
        String inicio = nick + "#PRUEBA# ";
        j.getSck().getOutputStream().write(inicio.getBytes());
        System.out.println("Envio: " + inicio);
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaJuego().setVisible(true);
            }
        });
    }

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
            }
        } catch (Exception ex) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarJugadores;
    public static javax.swing.JLabel conectado1;
    public static javax.swing.JLabel conectado2;
    public static javax.swing.JLabel conectado3;
    public static javax.swing.JLabel conectado4;
    public static javax.swing.JLabel conectado5;
    public static javax.swing.JLabel conectado6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel retar1;
    private javax.swing.JLabel retar2;
    private javax.swing.JLabel retar3;
    private javax.swing.JLabel retar4;
    private javax.swing.JLabel retar5;
    public static javax.swing.JLabel top1;
    public static javax.swing.JLabel top2;
    public static javax.swing.JLabel top3;
    public static javax.swing.JLabel top4;
    public static javax.swing.JLabel top5;
    // End of variables declaration//GEN-END:variables
    public static Socket getSck() {
        return sck;
    }

    public static void setSck(Socket aSck) {
        sck = aSck;
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
            case "TERETAN":
                System.out.println(partesMensaje[1] + " te quiere retar");
                System.out.println("¿Aceptas su desafío? introduce lo asociado");
                System.out.println("SI -->  RESPUESTARETO#NO#" + partesMensaje[1] + "#");
                System.out.println("NO -->  RESPUESTARETO#SI#" + partesMensaje[1] + "#");
                break;

            case "PARTIDA":
                String nombreUser = partesMensaje[1];
                if (partesMensaje[1].equals("SI")) {
                    System.out.println("El usuario " + nombreUser + " aceptó tu reto.");
                } else if (partesMensaje[1].equals("NO")) {
                    System.out.println("El usuario " + nombreUser + " NO aceptó tu reto.");
                }
                break;
                
            case "RANKING":
            top1.setText(partesMensaje[1]);
            top2.setText(partesMensaje[2]);
            top3.setText(partesMensaje[3]);
            top4.setText(partesMensaje[4]);
            top5.setText(partesMensaje[5]);
                break;
                
            case "DISPONIBLES":
                if (partesMensaje[1]==null) {
                    conectado1.setText("No hay jugadores disponibles");
                } else if(partesMensaje[1]!=null){
                    conectado1.setText(partesMensaje[1]);
                } if(partesMensaje[2]!=null){
                    conectado2.setText(partesMensaje[2]);
                } if(partesMensaje[3]!=null){
                    conectado3.setText(partesMensaje[3]);
                } if(partesMensaje[4]!=null){
                    conectado4.setText(partesMensaje[4]);
                } if(partesMensaje[5]!=null){
                    conectado5.setText(partesMensaje[5]);
                }
                break;
                
            default:
                System.out.println(" ");
        }

    }

}
