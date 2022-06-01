package Cliente;

import java.net.*;
import java.io.*;
import java.util.*;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Hola");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(761, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
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
        switch (partesMensaje[1]) {
            case "TERETAN":
                System.out.println(partesMensaje[1] + " te quiere retar");
                System.out.println("¿Aceptas su desafío? introduce lo asociado");
                System.out.println("SI -->  RESPUESTARETO#NO#" + partesMensaje[1] + "#");
                System.out.println("NO -->  RESPUESTARETO#SI#" + partesMensaje[1] + "#");
                break;

            case "PARTIDA":
                String nombreUser = partesMensaje[2];
                if (partesMensaje[1].equals("SI")) {
                    System.out.println("El usuario " + nombreUser + " aceptó tu reto.");
                } else if (partesMensaje[1].equals("NO")) {
                    System.out.println("El usuario " + nombreUser + " NO aceptó tu reto.");
                }
                break;
            case "HOLA":
                System.out.println("SI QUE LLEGÓ");
                break;
            default:
                System.out.println(" ");
        }

    }

}
