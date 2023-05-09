/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package resource;




import logic.CreacionFactura;

import logic.DAO;

/**
 *
 * @author a22ricardova
 */
public class ConfBicicletas extends javax.swing.JFrame {

    /**
     * Creates new form ConfBicicletas
     */
    public ConfBicicletas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cuadro = new javax.swing.JComboBox<>();
        Ruedas = new javax.swing.JComboBox<>();
        Horquilla = new javax.swing.JComboBox<>();
        Frenos = new javax.swing.JComboBox<>();
        Shock = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        PrecioFinal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 131, 190));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Configura tu bicicleta");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Selecciona las partes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        Cuadro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cuadro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadroActionPerformed(evt);
            }
        });

        Ruedas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Ruedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RuedasActionPerformed(evt);
            }
        });

        Horquilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Horquilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorquillaActionPerformed(evt);
            }
        });

        Frenos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Frenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenosActionPerformed(evt);
            }
        });

        Shock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Shock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShockActionPerformed(evt);
            }
        });

        jLabel3.setText("Cuadro");

        jLabel4.setText("Ruedas");

        jLabel5.setText("Shock");

        jLabel6.setText("Horquilla");

        jLabel7.setText("Frenos");

        jPanel3.setBackground(new java.awt.Color(67, 88, 130));

        jLabel8.setText("Precio:");

        PrecioFinal.setEditable(false);
        PrecioFinal.setText("0");
        PrecioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioFinalActionPerformed(evt);
            }
        });

        jLabel9.setText("€");

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(PrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cuadro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Ruedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Horquilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Frenos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Frenos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Horquilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Cuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Ruedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuadroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadroActionPerformed
        String nombreCuadro;
        nombreCuadro= (String) Cuadro.getSelectedItem();
        String nombreRuedas;
        nombreRuedas= (String) Ruedas.getSelectedItem();
        String nombreHorquilla;
        nombreHorquilla= (String) Horquilla.getSelectedItem();
        String nombreFrenos;
        nombreFrenos= (String) Frenos.getSelectedItem();
        String nombreShock;
        nombreShock= (String) Shock.getSelectedItem();
        int nuevoPrecio=DAO.actualizarPrecios(nombreCuadro)+DAO.actualizarPrecios(nombreRuedas)+DAO.actualizarPrecios(nombreHorquilla)+DAO.actualizarPrecios(nombreFrenos)+DAO.actualizarPrecios(nombreShock);
        CreacionFactura generacion=crearFactura();
        generacion.setPrecioTotal(nuevoPrecio); 
        String setPrecio= Integer.toString(generacion.getPrecioTotal());
        PrecioFinal.setText(setPrecio);
    }//GEN-LAST:event_CuadroActionPerformed

    private void RuedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuedasActionPerformed
        String nombreCuadro;
        nombreCuadro= (String) Cuadro.getSelectedItem();
        String nombreRuedas;
        nombreRuedas= (String) Ruedas.getSelectedItem();
        String nombreHorquilla;
        nombreHorquilla= (String) Horquilla.getSelectedItem();
        String nombreFrenos;
        nombreFrenos= (String) Frenos.getSelectedItem();
        String nombreShock;
        nombreShock= (String) Shock.getSelectedItem();
        int nuevoPrecio=DAO.actualizarPrecios(nombreCuadro)+DAO.actualizarPrecios(nombreRuedas)+DAO.actualizarPrecios(nombreHorquilla)+DAO.actualizarPrecios(nombreFrenos)+DAO.actualizarPrecios(nombreShock);
        CreacionFactura generacion=crearFactura();
        generacion.setPrecioTotal(nuevoPrecio); 
        String setPrecio= Integer.toString(generacion.getPrecioTotal());
        PrecioFinal.setText(setPrecio);
    }//GEN-LAST:event_RuedasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void HorquillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorquillaActionPerformed
        String nombreCuadro;
        nombreCuadro= (String) Cuadro.getSelectedItem();
        String nombreRuedas;
        nombreRuedas= (String) Ruedas.getSelectedItem();
        String nombreHorquilla;
        nombreHorquilla= (String) Horquilla.getSelectedItem();
        String nombreFrenos;
        nombreFrenos= (String) Frenos.getSelectedItem();
        String nombreShock;
        nombreShock= (String) Shock.getSelectedItem();
        int nuevoPrecio=DAO.actualizarPrecios(nombreCuadro)+DAO.actualizarPrecios(nombreRuedas)+DAO.actualizarPrecios(nombreHorquilla)+DAO.actualizarPrecios(nombreFrenos)+DAO.actualizarPrecios(nombreShock);
        CreacionFactura generacion=crearFactura();
        generacion.setPrecioTotal(nuevoPrecio); 
        String setPrecio= Integer.toString(generacion.getPrecioTotal());
        PrecioFinal.setText(setPrecio);
    }//GEN-LAST:event_HorquillaActionPerformed

    private void FrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenosActionPerformed
        String nombreCuadro;
        nombreCuadro= (String) Cuadro.getSelectedItem();
        String nombreRuedas;
        nombreRuedas= (String) Ruedas.getSelectedItem();
        String nombreHorquilla;
        nombreHorquilla= (String) Horquilla.getSelectedItem();
        String nombreFrenos;
        nombreFrenos= (String) Frenos.getSelectedItem();
        String nombreShock;
        nombreShock= (String) Shock.getSelectedItem();
        int nuevoPrecio=DAO.actualizarPrecios(nombreCuadro)+DAO.actualizarPrecios(nombreRuedas)+DAO.actualizarPrecios(nombreHorquilla)+DAO.actualizarPrecios(nombreFrenos)+DAO.actualizarPrecios(nombreShock);
        CreacionFactura generacion=crearFactura();
        generacion.setPrecioTotal(nuevoPrecio); 
        String setPrecio= Integer.toString(generacion.getPrecioTotal());
        PrecioFinal.setText(setPrecio);
    }//GEN-LAST:event_FrenosActionPerformed

    private void ShockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShockActionPerformed
        String nombreCuadro;
        nombreCuadro= (String) Cuadro.getSelectedItem();
        String nombreRuedas;
        nombreRuedas= (String) Ruedas.getSelectedItem();
        String nombreHorquilla;
        nombreHorquilla= (String) Horquilla.getSelectedItem();
        String nombreFrenos;
        nombreFrenos= (String) Frenos.getSelectedItem();
        String nombreShock;
        nombreShock= (String) Shock.getSelectedItem();
        System.out.println(nombreShock);
        int nuevoPrecio=DAO.actualizarPrecios(nombreCuadro)+DAO.actualizarPrecios(nombreRuedas)+DAO.actualizarPrecios(nombreHorquilla)+DAO.actualizarPrecios(nombreFrenos)+DAO.actualizarPrecios(nombreShock);
        CreacionFactura generacion=crearFactura();
        generacion.setPrecioTotal(nuevoPrecio); 
        String setPrecio= Integer.toString(generacion.getPrecioTotal());
        PrecioFinal.setText(setPrecio);
    }//GEN-LAST:event_ShockActionPerformed

    private void PrecioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioFinalActionPerformed

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
            java.util.logging.Logger.getLogger(ConfBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfBicicletas().setVisible(true);
            }
        });
    }
    
    public static CreacionFactura crearFactura() {
        CreacionFactura generacion= new CreacionFactura(0, "bicicleta");
        return generacion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cuadro;
    private javax.swing.JComboBox<String> Frenos;
    private javax.swing.JComboBox<String> Horquilla;
    private javax.swing.JTextField PrecioFinal;
    private javax.swing.JComboBox<String> Ruedas;
    private javax.swing.JComboBox<String> Shock;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
