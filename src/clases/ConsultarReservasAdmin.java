/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clases;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adiflp
 */
public class ConsultarReservasAdmin extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarReservasAdmin
     */
    public ConsultarReservasAdmin() {
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        mostrardatos();
       
        
    }
    public void mostrardatos(){
                 
        try {
           DefaultTableModel modelo = new DefaultTableModel();
           
           tablaReservas.setModel(modelo);
           
           PreparedStatement ps;
           ResultSet rs ;
           ConexionMYSQL con = new ConexionMYSQL();
           con.ConectarBasedeDatos();
           
           String SQL = "SELECT id_reservas, DNI, fecha_reserva, mesa, comensales FROM reservas";
           
           ps = con.conexion.prepareStatement(SQL);
           rs = ps.executeQuery();
           
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadcolumna = rsMd.getColumnCount();
            
            modelo.addColumn("id_reservas");
            modelo.addColumn("DNI");
            modelo.addColumn("fecha_reserva");
            modelo.addColumn("mesa");
            modelo.addColumn("comensales");            
            while(rs.next()){
                Object[]filas = new Object[cantidadcolumna];
                
                for (int i = 0;i< cantidadcolumna; i++)
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
           
           
        } catch (Exception e) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        eliminarReserva = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        btn_actualizarReserva = new javax.swing.JButton();
        btn_actualizarReserva1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_reservas", "DNI", "fecha_reserva", "mesa", "comensales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaReservas);
        if (tablaReservas.getColumnModel().getColumnCount() > 0) {
            tablaReservas.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservas");

        eliminarReserva.setText("Eliminar Reserva");
        eliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarReservaActionPerformed(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btn_actualizarReserva.setText("Agregar Reserva");
        btn_actualizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarReservaActionPerformed(evt);
            }
        });

        btn_actualizarReserva1.setText("Actualizar Reserva");
        btn_actualizarReserva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarReserva1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(336, 336, 336))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btn_actualizarReserva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_actualizarReserva1)
                                .addGap(60, 60, 60)
                                .addComponent(eliminarReserva))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizarReserva1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarReservaActionPerformed
        // TODO add your handling code here:
        int fila = tablaReservas.getSelectedRow();
        String valor = tablaReservas.getValueAt(fila, 0).toString();
        
        try {
           PreparedStatement ps; 
           ConexionMYSQL con = new ConexionMYSQL();
           
           con.ConectarBasedeDatos();           
           String sql;

           sql = "DELETE FROM reservas WHERE id_reservas ='"+valor+"'";
            try {
                 ps = con.conexion.prepareStatement(sql);

            //AQUÍ EN EL SEGUNDO TRY SE EJECUTARA LA SENTENCIA sql Y SI SE HA EJECUTADO CORRECTAMENTE NOS APARECERÁ UN JOPTION CON QUE SE HA ELIMINADO LA PELICULA CORRECTAMENTE
                try {
                    ps.executeUpdate();
                    mostrardatos();
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la reserva correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha eliminado la reserva correctamente");

                }
                
            } catch (Exception e) {
            }
                   
        } catch (Exception e) {
             
        }
        
        
    }//GEN-LAST:event_eliminarReservaActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        MenuAdmin ma = new MenuAdmin();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_actualizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarReservaActionPerformed

    private void btn_actualizarReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarReserva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarReserva1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarReservasAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizarReserva;
    public javax.swing.JButton btn_actualizarReserva1;
    public javax.swing.JButton btn_volver;
    public javax.swing.JButton eliminarReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
