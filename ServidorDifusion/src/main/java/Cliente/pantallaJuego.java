package Cliente;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pantallaJuego extends javax.swing.JFrame implements Runnable {

    public static String nick, nickRival;
    public static Socket sck;
    public static int pJugadas, pGanadas, pPerdidas, pJugadasRival, pGanadasRival, pPerdidasRival;
    public static boolean retoActivo;
    public static int IDPartida;
    
    public pantallaJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Conecta 4");
        vsNick.setText(nick);
        retoActivo = false;
        
        String mensaje = nick + "#" + "RANKING" + "#";
        try {
            sck.getOutputStream().write(mensaje.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDialog4 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        retar1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        top3 = new javax.swing.JLabel();
        top1 = new javax.swing.JLabel();
        top2 = new javax.swing.JLabel();
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
        noConectado = new javax.swing.JLabel();
        conectado1 = new javax.swing.JLabel();
        conectado2 = new javax.swing.JLabel();
        conectado4 = new javax.swing.JLabel();
        conectado3 = new javax.swing.JLabel();
        conectado5 = new javax.swing.JLabel();
        vsNick = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vsNickRival = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        partidasJugadasUser = new javax.swing.JLabel();
        partidasGanadasUser = new javax.swing.JLabel();
        partidasPerdidasUser = new javax.swing.JLabel();
        cargarStats = new javax.swing.JButton();
        partidasPerdidasRival = new javax.swing.JLabel();
        partidasGanadasRival = new javax.swing.JLabel();
        partidasJugadasRival = new javax.swing.JLabel();
        cargarStatsRival = new javax.swing.JButton();
        mensajeErrorRival = new javax.swing.JLabel();
        mensajeError = new javax.swing.JLabel();
        errorRetar = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        aceptarReto = new javax.swing.JButton();
        denegarReto = new javax.swing.JButton();
        leRetan = new javax.swing.JLabel();
        nickRetador = new javax.swing.JLabel();
        col0 = new javax.swing.JButton();
        col1 = new javax.swing.JButton();
        col2 = new javax.swing.JButton();
        col3 = new javax.swing.JButton();
        col4 = new javax.swing.JButton();
        col5 = new javax.swing.JButton();
        col6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTable();
        mensajeGanador = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jugadores conectados");

        retar1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        retar1.setText("⚔");
        retar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retar1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("4.");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("2.");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("3.");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("5.");

        top3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top3.setText(" ");

        top1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top1.setText(" ");

        top2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        top2.setText(" ");

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

        noConectado.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        noConectado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noConectado.setText(" ");

        conectado1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado1.setText(" ");

        conectado2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado2.setText(" ");

        conectado4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado4.setText(" ");

        conectado3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado3.setText(" ");

        conectado5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        conectado5.setText(" ");

        vsNick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsNick.setText(" ");

        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/alvaro/NetBeansProjects/ServidorDifusion/perfil.png")); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon("/Users/alvaro/NetBeansProjects/ServidorDifusion/perfil.png")); // NOI18N

        vsNickRival.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsNickRival.setText(" ");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel13.setText("Partidas jugadas:");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel14.setText("Partidas ganadas:");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setText("Partidas perdidas:");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setText("Partidas perdidas:");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setText("Partidas ganadas:");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel18.setText("Partidas jugadas:");

        partidasGanadasUser.setText("   ");

        partidasPerdidasUser.setText("   ");

        cargarStats.setText("Cargar mis stats");
        cargarStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarStatsActionPerformed(evt);
            }
        });

        partidasPerdidasRival.setText("   ");

        partidasGanadasRival.setText("   ");

        partidasJugadasRival.setText("   ");

        cargarStatsRival.setText("Cargar stats del rival");
        cargarStatsRival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarStatsRivalActionPerformed(evt);
            }
        });

        mensajeErrorRival.setText("   ");

        mensajeError.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        mensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeError.setText("   ");

        errorRetar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorRetar.setText(" ");

        aceptarReto.setText("Aceptar Reto");
        aceptarReto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarRetoActionPerformed(evt);
            }
        });

        denegarReto.setText("Denegar Reto");
        denegarReto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denegarRetoActionPerformed(evt);
            }
        });

        leRetan.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        leRetan.setText("Sin retos pendientes");

        nickRetador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nickRetador.setText(" ");

        col0.setText("⬇");
        col0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col0ActionPerformed(evt);
            }
        });

        col1.setText("⬇");
        col1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col1ActionPerformed(evt);
            }
        });

        col2.setText("⬇");
        col2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col2ActionPerformed(evt);
            }
        });

        col3.setText("⬇");
        col3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col3ActionPerformed(evt);
            }
        });

        col4.setText("⬇");
        col4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col4ActionPerformed(evt);
            }
        });

        col5.setText("⬇");
        col5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col5ActionPerformed(evt);
            }
        });

        col6.setText("⬇");
        col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                col6ActionPerformed(evt);
            }
        });

        tablero.setAutoCreateRowSorter(true);
        tablero.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        tablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "}
            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablero.setIntercellSpacing(new java.awt.Dimension(40, 5));
        tablero.setRowHeight(50);
        tablero.setRowSelectionAllowed(false);
        tablero.setShowGrid(true);
        tablero.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tablero);

        mensajeGanador.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        mensajeGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeGanador.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(col0, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(col6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(leRetan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nickRetador, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cargarStatsRival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(vsNickRival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11)
                                                .addGap(75, 75, 75))
                                            .addComponent(mensajeErrorRival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(errorRetar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(partidasPerdidasRival, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(partidasGanadasRival, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(partidasJugadasRival, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(denegarReto)
                                    .addComponent(aceptarReto))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                            .addComponent(mensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mensajeGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(vsNick, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(partidasJugadasUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(partidasGanadasUser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(partidasPerdidasUser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cargarStats, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(conectado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(conectado5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(conectado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(conectado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(retar2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(retar4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(retar5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(retar3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(top1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(noConectado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(top5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(top2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(top4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(top3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(conectado1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(retar1)))
                                        .addGap(0, 7, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(cargarJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel9)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(top1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(top2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(top3))
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
                        .addComponent(noConectado)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(retar3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conectado2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(retar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conectado3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(retar4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conectado4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(retar5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conectado5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargarJugadores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(retar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conectado1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(258, 258, 258)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vsNick)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(partidasJugadasUser, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(partidasGanadasUser))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(partidasPerdidasUser))
                                        .addGap(18, 18, 18)
                                        .addComponent(cargarStats)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mensajeGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(col0, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(col6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(62, 62, 62)
                                                        .addComponent(vsNickRival))
                                                    .addComponent(jLabel11))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel18)
                                                    .addComponent(partidasJugadasRival))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel17)
                                                    .addComponent(partidasGanadasRival))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel16)
                                                    .addComponent(partidasPerdidasRival))
                                                .addGap(18, 18, 18)
                                                .addComponent(cargarStatsRival)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(mensajeErrorRival)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(leRetan)
                                                    .addComponent(nickRetador))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(aceptarReto)
                                                .addGap(12, 12, 12))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(denegarReto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(errorRetar)
                                        .addGap(8, 8, 8)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)))))
                        .addContainerGap())))
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

    private void cargarStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarStatsActionPerformed
        String mensaje = nick + "#JUGAPER#";
        try {
            sck.getOutputStream().write(mensaje.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cargarStatsActionPerformed

    private void cargarStatsRivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarStatsRivalActionPerformed
        if (nickRival==null) {
            mensajeErrorRival.setText("Comienza una partida para verlo");
        } else{
        try {
            String mensaje = nick + "#JUGAPERival#" + nickRival + "#";
            sck.getOutputStream().write(mensaje.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_cargarStatsRivalActionPerformed

    private void retar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retar1MouseClicked
        
        if (conectado1.getText().equals(" ")) {
            noConectado.setText("Usuario sin conexion");
        } else {
        String nickRV = conectado1.getText();
            try {
            String mensaje = nick + "#RETAR#" + nickRV + "#";
            sck.getOutputStream().write(mensaje.getBytes());
            noConectado.setText(nickRV + " ha sido retado");
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_retar1MouseClicked

    private void aceptarRetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarRetoActionPerformed
        if (leRetan.getText().equals("Sin retos pendientes")) {
            errorRetar.setText("¡Sin retos pendientes!");
        } else {
            String mensaje = nick + "#RESPUESTARETO#SI#" + nickRetador.getText();
            try {
                nickRival = nickRetador.getText();
                sck.getOutputStream().write(mensaje.getBytes());
                leRetan.setText("Sin retos pendientes");
                nickRetador.setText(" ");
                retoActivo = true;
                limpiarTablero();
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_aceptarRetoActionPerformed

    private void denegarRetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denegarRetoActionPerformed
        if (leRetan.getText().equals("Sin retos pendientes")) {
            errorRetar.setText("¡Sin retos pendientes!");
        } else {
            String mensaje = nick + "#RESPUESTARETO#NO#" + nickRetador.getText();
            try {
                sck.getOutputStream().write(mensaje.getBytes());
                leRetan.setText("Sin retos pendientes");
                nickRetador.setText(" ");
                retoActivo = false;
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_denegarRetoActionPerformed

    private void col0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col0ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#0#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col0ActionPerformed

    private void col1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col1ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#1#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col1ActionPerformed

    private void col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col2ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#2#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col2ActionPerformed

    private void col3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col3ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#3#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col3ActionPerformed

    private void col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col4ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#4#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col4ActionPerformed

    private void col5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col5ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#5#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col5ActionPerformed

    private void col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_col6ActionPerformed
        if (retoActivo == false) {
            mensajeError.setText("Primero debes comenzar un reto");
        } else {
            try {
                String mensaje = nick + "#FICHA#" + IDPartida + "#6#";
                sck.getOutputStream().write(mensaje.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_col6ActionPerformed

    public static void main(String args[]) throws IOException {
        
        pantallaJuego j = new pantallaJuego();
        Thread t1 = new Thread(j);
        t1.start();
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
                gestorRespuestas2(mensajeRecibido);
            }
        } catch (Exception ex) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarReto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cargarJugadores;
    private javax.swing.JButton cargarStats;
    private javax.swing.JButton cargarStatsRival;
    private javax.swing.JButton col0;
    private javax.swing.JButton col1;
    private javax.swing.JButton col2;
    private javax.swing.JButton col3;
    private javax.swing.JButton col4;
    private javax.swing.JButton col5;
    private javax.swing.JButton col6;
    public static javax.swing.JLabel conectado1;
    public static javax.swing.JLabel conectado2;
    public static javax.swing.JLabel conectado3;
    public static javax.swing.JLabel conectado4;
    public static javax.swing.JLabel conectado5;
    private javax.swing.JButton denegarReto;
    public static javax.swing.JLabel errorRetar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    public static javax.swing.JLabel leRetan;
    public static javax.swing.JLabel mensajeError;
    public static javax.swing.JLabel mensajeErrorRival;
    public static javax.swing.JLabel mensajeGanador;
    public static javax.swing.JLabel nickRetador;
    public static javax.swing.JLabel noConectado;
    public static javax.swing.JLabel partidasGanadasRival;
    public static javax.swing.JLabel partidasGanadasUser;
    public static javax.swing.JLabel partidasJugadasRival;
    public static javax.swing.JLabel partidasJugadasUser;
    public static javax.swing.JLabel partidasPerdidasRival;
    public static javax.swing.JLabel partidasPerdidasUser;
    private javax.swing.JLabel retar1;
    private javax.swing.JLabel retar2;
    private javax.swing.JLabel retar3;
    private javax.swing.JLabel retar4;
    private javax.swing.JLabel retar5;
    public static javax.swing.JTable tablero;
    public static javax.swing.JLabel top1;
    public static javax.swing.JLabel top2;
    public static javax.swing.JLabel top3;
    public static javax.swing.JLabel top4;
    public static javax.swing.JLabel top5;
    private javax.swing.JLabel vsNick;
    private javax.swing.JLabel vsNickRival;
    // End of variables declaration//GEN-END:variables
    public static Socket getSck() {
        return sck;
    }

    public static void setSck(Socket aSck) {
        sck = aSck;
    }
    
    
    /**
     * Método encargado de limpiar el tablero (poner todo a '') cuando finalice una partida
     */
    public static void limpiarTablero(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero.setValueAt(" ", i, j);
            }
        }
    }

    /**
     * Método que recibe el mensaje del servidor y lo gestiona ya sea la
     * respuesta correcta o incorrecta del login, que le llegue un reto al
     * usuario o que tiene que mover una ficha
     *
     * @param mensaje
     * @throws IOException
     */
    public static void gestorRespuestas2(String mensaje) throws IOException {
        String[] partesMensaje = mensaje.split("#");
        Scanner sc = new Scanner(System.in);
        
        switch (partesMensaje[0]) {
            case "TERETAN":
                leRetan.setText("Te desafía: ");
                nickRetador.setText(partesMensaje[1]);
                break;

            case "PARTIDA":
                String nombreUser = partesMensaje[1];
                if (partesMensaje[1].equals("SI")) {
                    System.out.println("El usuario " + partesMensaje[3] + " aceptó tu reto.");
                    mensajeError.setText("El usuario " + partesMensaje[3] + " aceptó tu reto.");
                    nickRival = partesMensaje[3];
                    retoActivo = true;
                    limpiarTablero();
                } else if (partesMensaje[1].equals("NO")) {
                    System.out.println("El usuario " + partesMensaje[3] + " NO aceptó tu reto.");
                    mensajeError.setText("El usuario " + partesMensaje[3] + " NO aceptó tu reto.");
                    retoActivo = false;
                }
                break;
                
            case "RANKING":
            top3.setText(partesMensaje[1]);
            top1.setText(partesMensaje[2]);
            top2.setText(partesMensaje[3]);
            top4.setText(partesMensaje[4]);
            top5.setText(partesMensaje[5]);
                break;
                
            case "DISPONIBLES":
                if (partesMensaje.length<=1) {
                    noConectado.setText("No hay jugadores conectados");
                }else if(partesMensaje[1]!=null){
                    conectado1.setText(partesMensaje[1]);
                    noConectado.setText("  ");
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
            
            case "JUGAPER":
                    partidasJugadasUser.setText(partesMensaje[1]);
                    partidasGanadasUser.setText(partesMensaje[2]);
                    partidasPerdidasUser.setText(partesMensaje[3]);                    
                break;
            
            case "JUGAPERival":
                    partidasJugadasRival.setText(partesMensaje[1]);
                    partidasGanadasRival.setText(partesMensaje[2]);
                    partidasPerdidasRival.setText(partesMensaje[3]);                    
                break;
            
            case "ERROR":
                if (partesMensaje[1].equals("FINPARTIDA")) {
                    mensajeError.setText("¡FIN! La partida ya ha acabado, el ganador es: "  + partesMensaje[2]);
                    retoActivo = false;
                } if (partesMensaje[1].equals("NOTURNO")) {
                    mensajeError.setText("¡No es tu turno! Espera a tu rival");
                } if (partesMensaje[1].equals("COLUMNA")) {
                    mensajeError.setText("¡Columna llena! Selecciona otra diferente");
                }
                break;
             
            case "FICHA":
                if (partesMensaje[1].equals("EXITO")) {
                    mensajeError.setText("Ficha colocada con éxito, turno del rival");
                    int row = Integer.parseInt(partesMensaje[2]);
                    int column = Integer.parseInt(partesMensaje[3]);
                    tablero.setValueAt("X", row+1, column);
                    
                    //Se avisa al rival para que pinte esa ficha en el tablero
                    mensaje = nickRival + "#PINTARFICHARIVAL#" + row + "#" +  column + "#";
                    try {
                        sck.getOutputStream().write(mensaje.getBytes());
                    } catch (IOException ex) {
                        Logger.getLogger(pantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                break;
            
            case "PINTARFICHA":    
                int row = Integer.parseInt(partesMensaje[1]);
                int column = Integer.parseInt(partesMensaje[2]);
                tablero.setValueAt("O", row+1, column);
                break;
                
            case "IDPARTIDA":
                IDPartida = Integer.parseInt(partesMensaje[1]);
                break;
            
            case "GANADOR":
                if (partesMensaje[1].equals(nick)) {
                    mensajeGanador.setText("¡Felicidades! Eres el ganador de la partida");
                } else {
                    mensajeGanador.setText("¡Vaya! " + nickRival + " te ha ganado.");
                }
                break;
                
            default:
                System.out.println(" ");
        }

    }

}