/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import testdilemas.VariablesGlobales;
import java.awt.event.MouseEvent;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import testdilemas.Archivo;
import testdilemas.ElementosDilemas;
import static testdilemas.VariablesGlobales.indice;

/**
 *
 * @author manue
 */
public class PruebaLectura extends javax.swing.JFrame {
    
    String[] arreglo = new String[3];
    private static int contador = 0;
    public static String dilema1;
    public String text1;
    public String text2;
    public String text3;
    private int longitud = 0;
    public static Timer temporizador;
    int counter = 0;
    long total1 = 0;
    int i = 0;
    public static String [] Opciones;
    public static long [] inicioTime;
    public static long [] finTime;
    public static long startPrueba, start1, end1, endPrueba;
    private boolean bandera;
    /**
     * Creates new form DilemaTren1
     * @throws java.lang.InterruptedException
     */
    public PruebaLectura() throws InterruptedException {
        ElementosDilemas elementos = new ElementosDilemas();
        arreglo=elementos.Elementos(VariablesGlobales.indice);
        text1="Alan Turing fue un pionero de los campos de la computación, la inteligencia artificial y uno de los padres de la informática actual.";
        text2="La máquina de Turing es un modelo matemático que opera y lee instrucciones de una cinta, también es capaz de emular la lógica de cualquier algoritmo de una computadora. ";
        text3="La hipercomputación es la resolución de las tareas que no puede resolver una máquina de Turing. Turing lanzó la idea de las máquinas oráculo, dedicadas a realizar las tareas que no pueden ser resueltas mediante un algoritmo.";

         startPrueba = System.currentTimeMillis();
        //bandera = true;
        this.setUndecorated(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jButton1.setVisible(false);
        jPanel1.setVisible(false);
            // Esta parte es un desmadre :v
            longitud = text1.length();
            temporizador = new Timer(VariablesGlobales.retraso_dilema, new ActionListener() { //El primer argumento de timer es en milisegundos por caracter
                @Override
                public void actionPerformed(ActionEvent e) {
                    counter++;
                    if(counter > longitud){
                        temporizador.stop();
                        longitud = text2.length();
                               try {
                                    Thread.sleep(VariablesGlobales.tiempo_sleep);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(PruebaLectura.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        temporizador = new Timer(VariablesGlobales.retraso_dilema, new ActionListener() {
                            
                            @Override
                            
                            public void actionPerformed(ActionEvent e) {
                            counter++;
                            if(counter > longitud){
                                temporizador.stop();
                                longitud = text3.length();
                                try {
                                    Thread.sleep(VariablesGlobales.tiempo_sleep);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(PruebaLectura.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                temporizador = new Timer(VariablesGlobales.retraso_dilema, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                    counter++;
                                    if(counter > longitud){
                                        temporizador.stop();
                                        bandera = true;
                                        jButton1.setVisible(true);
                                        if(VariablesGlobales.bandera_cuadro){
                                            jPanel1.setVisible(true);
                                        }
                                        start1 = System.currentTimeMillis();//Este no estaba asi
                                        counter=0;//Este no estaba asi
                                    }else{
                                        jTextPane1.setText(text3.substring(0,counter));
                                    }
                                    }
                                    });
                                    temporizador.start();
                                    counter=0;
                            }else{
                                jTextPane1.setText(text2.substring(0,counter));
                            }
                            }
                        });
                        temporizador.start();
                        counter=0;
                    }else{
                        jTextPane1.setText(text1.substring(0,counter));
                    }
                }
            });
            temporizador.start();
            //VariablesGlobales.indice++;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextPane1MouseClicked(evt);
            }
        });
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jButton1.setText("Terminar Test Lectura");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(28, 28));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CambioVelocidad().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MouseClicked
   
    }//GEN-LAST:event_jTextPane1MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
 
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        String nomUsuario,apeUsuario;
        
        if(c == 112){
            new MenuOculto().setVisible(true);
        }                                

    }//GEN-LAST:event_jTextPane1KeyPressed

    private void jPane6KeyPressed(java.awt.event.KeyEvent evt) {                                      
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        String nomUsuario,apeUsuario;
        
        if(c == 112){
            new MenuOculto().setVisible(true);
        }                                

    }       
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PruebaLectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaLectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaLectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaLectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PruebaLectura().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PruebaLectura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void CustomCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("/Imagenes/cursor.png");
        Point point = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "cursor");
        
        setCursor(cursor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
