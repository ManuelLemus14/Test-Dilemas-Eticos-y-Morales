/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

//import static Pantallas.DilemaSicarios1.contador;
//import java.awt.Image;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Set;
//import javax.swing.ImageIcon;
import javax.swing.Timer;
import testdilemas.VariablesGlobales;

/**
 *
 * @author manue
 */
public class PantallaBlanco extends javax.swing.JFrame {
    private static int contador = 0;
    private String text1 = " ";
    private String text2 = " ";
    private int longitud = 0;
    Timer temporizador;
    int counter = 0;
    /**
     * Creates new form DilemaTren1
     */
    public PantallaBlanco() {
        CustomCursor();
        this.setUndecorated(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
            longitud = text1.length();
            temporizador = new Timer(VariablesGlobales.retraso_transicion, new ActionListener() { //El primer argumento de timer es en milisegundos por caracter 4400
                @Override
                public void actionPerformed(ActionEvent e) {
                    counter++;
                    if(counter > longitud){
                        temporizador.stop();
                        longitud = text2.length();
                        temporizador = new Timer(100, new ActionListener() {  //100
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            counter++;
                            if(counter > longitud){
                                temporizador.stop();
                                Elementos elementos = new Elementos();
                                if(VariablesGlobales.indice<elementos.EncuentraUltimo()){
                                try {
                                    new Dilema1().setVisible(true);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(PantallaBlanco.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                setVisible(false);
                                dispose();
                                }else{
                                    new Agradecimiento().setVisible(true);
                                }
//                                switch (contador){
//                                    case 0:
//                                        new Dilema2().setVisible(true);
//                                        setVisible(false);
//                                        dispose();
//                                        break;
//                                    case 1:
//                                        new Dilema3().setVisible(true);
//                                        break;
//                                    case 2:
//                                        new Dilema4().setVisible(true);
//                                        break;
//                                    case 3:
//                                        new Dilema5().setVisible(true);
//                                        break;
//                                    case 4:
//                                        new Dilema6().setVisible(true);
//                                        break;
//                                    case 5:
//                                        new Dilema7().setVisible(true);
//                                        break;
//                                    case 6:
//                                        new Dilema8().setVisible(true);
//                                        break;
//                                    case 7:
//                                        new Dilema9().setVisible(true);
//                                        break;
//                                    case 8:
//                                        new Dilema10().setVisible(true);
//                                        break;
//                                    case 9:
//                                        new Dilema11().setVisible(true);
//                                        break;
//                                    case 10:
//                                        new Dilema12().setVisible(true);
//                                        break;
//                                    case 11:
//                                        new Agradecimiento().setVisible(true);
//                                        break;
//                                }
//                                contador ++;
                                dispose();
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(1020, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(668, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Dilema1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dilema1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dilema1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dilema1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaBlanco().setVisible(true);
            }
        });
    }
    
        public void CustomCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("cursor.png");
        Point point = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "cursor");
        
        setCursor(cursor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
