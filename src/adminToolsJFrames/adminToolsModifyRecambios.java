/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adminToolsJFrames;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.DAO;

/**
 *
 * @author Hell
 */
public class adminToolsModifyRecambios extends javax.swing.JFrame {

    /**
     * Creates new form adminToolsModifyRecambios
     */
    public adminToolsModifyRecambios() {
        initComponents();
        rellenarTabla();
        initTipoRecambios();
    }
    
    private void rellenarTabla(){
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Tipo");
        
        jTable1.setModel(model);
        
        String[][] dato = DAO.getAllRecambios();

        
        for (int i =0; i<dato.length;i++){
            String [] input = new String[6];
            for (int x = 0; x<dato[i].length;x++){
                System.out.println(dato[i][x]);
                input[x] = dato[i][x];
            }
            model.addRow(input);
        }

    }
    
    private void showMessage(String text){
        JOptionPane.showMessageDialog(this, text,
                "AVISO", JOptionPane.WARNING_MESSAGE);
    }
    
    private void showInfo(String text){
        JOptionPane.showMessageDialog(this, text,
                "AVISO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void initTipoRecambios(){
        String[] metodos = {"ruedas", "shock", "horquilla", "cuadro", "frenos"};
        for (String metodo : metodos){
            comboRecambios.addItem(metodo);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dispose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        RecambioId = new javax.swing.JTextField();
        comboRecambios = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        recambioDinero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        recambioNombre1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        modifyRecambio = new javax.swing.JButton();
        dataLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 131, 190));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Modificación Recambios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(

        ));
        jScrollPane1.setViewportView(jTable1);

        dispose.setText("Atras");
        dispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Precio");

        RecambioId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RecambioIdFocusGained(evt);
            }
        });
        RecambioId.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                RecambioIdInputMethodTextChanged(evt);
            }
        });
        RecambioId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RecambioIdKeyTyped(evt);
            }
        });

        comboRecambios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Id del Recambio:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Nombre");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Tipo ");

        modifyRecambio.setText("Modificar");
        modifyRecambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRecambioActionPerformed(evt);
            }
        });

        dataLoad.setText("Cargar Datos");
        dataLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RecambioId, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(dataLoad))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recambioNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recambioDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboRecambios, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(modifyRecambio)))))
                .addGap(0, 159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecambioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recambioDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRecambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recambioNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyRecambio))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dispose)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(dispose)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_disposeActionPerformed

    private void modifyRecambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRecambioActionPerformed
        int idrecambio = -1;
        int preciorecambio = -1;
        
        idrecambio = Integer.parseInt(RecambioId.getText());
        preciorecambio = Integer.parseInt(recambioDinero.getText());
        String nombreRecambio = recambioNombre1.getText();
        String tiporecambio = (String) comboRecambios.getSelectedItem();
        
        if(idrecambio<0 || preciorecambio<0 || nombreRecambio.isEmpty() || tiporecambio.isEmpty()){
            showMessage("Debes introducir valores en todos los campos");
        }else{
            DAO.updateRecambio(idrecambio,nombreRecambio,preciorecambio,tiporecambio);
            rellenarTabla();
             showInfo("Recambio cambiado con exito");
        }
        
        
    }//GEN-LAST:event_modifyRecambioActionPerformed

    private void RecambioIdInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_RecambioIdInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_RecambioIdInputMethodTextChanged

    private void RecambioIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RecambioIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_RecambioIdFocusGained

    private void RecambioIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RecambioIdKeyTyped
        
    }//GEN-LAST:event_RecambioIdKeyTyped

    private void dataLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataLoadActionPerformed
        // TODO add your handling code here:
        int idrecambio = Integer.parseInt(RecambioId.getText());
        int selectItem = 0;
        String[] arrayDatosRecambio = new String[4];
        arrayDatosRecambio =  DAO.getRecambio(idrecambio);
        recambioNombre1.setText(arrayDatosRecambio[1]);
        recambioDinero.setText(arrayDatosRecambio[2]);
        
        //"ruedas", "shock", "horquila", "cuadro", "frenos"
        
        if(arrayDatosRecambio[3].equals("ruedas")){
            selectItem = 0;
        }else if(arrayDatosRecambio[3].equals("shock")){
            selectItem = 1;
        }else if(arrayDatosRecambio[3].equals("horquilla")){
            selectItem = 2;
        }else if(arrayDatosRecambio[3].equals("cuadro")){
            selectItem = 3;
        }else if(arrayDatosRecambio[3].equals("frenos")){
            selectItem = 4;
        }
        
        comboRecambios.setSelectedIndex(selectItem);
    }//GEN-LAST:event_dataLoadActionPerformed

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
            java.util.logging.Logger.getLogger(adminToolsModifyRecambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminToolsModifyRecambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminToolsModifyRecambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminToolsModifyRecambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminToolsModifyRecambios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RecambioId;
    private javax.swing.JComboBox<String> comboRecambios;
    private javax.swing.JButton dataLoad;
    private javax.swing.JButton dispose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyRecambio;
    private javax.swing.JTextField recambioDinero;
    private javax.swing.JTextField recambioNombre1;
    // End of variables declaration//GEN-END:variables
}