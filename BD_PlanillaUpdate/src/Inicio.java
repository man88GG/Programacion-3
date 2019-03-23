import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.sql.*;

public class Inicio extends javax.swing.JFrame {
    
    
    DefaultTableModel tabla = new DefaultTableModel();
    String IGSS, sueldo, ISR;
    double ValorDetalle, Igss, ValorTotal=0;
    
    private void Clear(){
        while (tabla.getRowCount() > 0) {
               tabla.removeRow(0);
        }
    }
    
    public void ObtenerDatos(){
        Clear();         
        if ("".equals(txt_CodigoNomina.getText())){
            JOptionPane.showMessageDialog(null,"No ha Completado Todos los Datos");
        }else{
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select encabezado_nomina.codigo_nomina, empleado.codigo_empleado,"
            + "empleado.sueldo_empleado, empleado.IGSS from encabezado_nomina, empleado where codigo_nomina = ?");
            pst.setString(1, txt_CodigoNomina.getText().trim());
            ResultSet ConsultaNomina = pst.executeQuery();
          
            while(ConsultaNomina.next()){
               Object []fila = new Object[4];
               fila[0] = ConsultaNomina.getString("codigo_nomina");
               fila[1] = ConsultaNomina.getString("codigo_empleado");
               fila[2] = ConsultaNomina.getString("sueldo_empleado");
               fila[3] = ConsultaNomina.getString("IGSS");
               sueldo = fila[2].toString();
               
               if ((Double.parseDouble(sueldo)>2600) && (Double.parseDouble(sueldo)<5000))
                    {
                        fila[2]="C3"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.03;
                        fila[3] = (ValorDetalle);
                    }
                    else if ((Double.parseDouble(sueldo) >= 5000) &&(Double.parseDouble(sueldo) < 10000) )
                    {
                        fila[2]="C4"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.05;
                        fila[3] = (ValorDetalle);
                    }
                    else if (Double.parseDouble(sueldo) >= 10000)
                    {
                        fila[2]="C5"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.1;
                        fila[3] = (ValorDetalle);
                    }
                    else
                    {
                        fila[2]="C2"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.00;
                        fila[4] = (ValorDetalle);
                    }
               ValorTotal=ValorTotal+ValorDetalle;
               tabla.addRow(fila);
               
           }

            
           }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No Se Encuentra La Nomina");
           }
            
           try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select encabezado_nomina.codigo_nomina, empleado.codigo_empleado,"
            + "empleado.sueldo_empleado, empleado.IGSS from encabezado_nomina, empleado where codigo_nomina = ?");
            pst.setString(1, txt_CodigoNomina.getText().trim());
            ResultSet ConsultaNomina = pst.executeQuery();
          
            while(ConsultaNomina.next()){
               Object []fila = new Object[4];
               fila[0] = ConsultaNomina.getString("codigo_nomina");
               fila[1] = ConsultaNomina.getString("codigo_empleado");
               fila[2] = ConsultaNomina.getString("sueldo_empleado");
               fila[3] = ConsultaNomina.getString("IGSS");
               sueldo = fila[2].toString();
               IGSS= fila[3].toString();
               
               if (Double.parseDouble(IGSS) == 1){
                   fila[2]="C1";
                   ValorDetalle =0.0483*Double.parseDouble(sueldo);
                   fila[3] = (ValorDetalle);
               }else{
                   fila[2]="C1";
                   ValorDetalle =0;
                   fila[3] = (ValorDetalle);
               }
               ValorTotal=ValorTotal+ValorDetalle;
               tabla.addRow(fila);
               
           }
     
           }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No Se Encuentra La Nomina");
           }
           try{
            String ID = txt_CodigoNomina.getText().trim();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("update encabezado_nomina set Valor_Nomina = ? where codigo_nomina ='"+ ID +"'");
            
            pst.setString(1, String.valueOf(ValorTotal).trim());
          
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se Actualizo La Nomina");
     
           }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No Se Actualizo La Nomina");
           }
        }
         
    }
    public Inicio() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.Tabla_Detalles.setModel(tabla);
        tabla.addColumn("Codigo Nomina");
        tabla.addColumn("Codigo Empleado");
        tabla.addColumn("Codigo Concepto");
        tabla.addColumn("Valor Detalle");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_InsNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Detalles = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_CodigoNomina = new javax.swing.JTextField();
        BtnEmpleado = new javax.swing.JButton();
        BtnNominaEn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BT_InsNombre.setText("Buscar");
        BT_InsNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_InsNombreActionPerformed(evt);
            }
        });

        Tabla_Detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Nomina", "Codigo Empleado", "Codigo Concepto", "Valor Detalle"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Detalles);

        jLabel5.setText("Codigo Nomina");

        BtnEmpleado.setText("Ingreso Nuevo Empleado");
        BtnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEmpleadoActionPerformed(evt);
            }
        });

        BtnNominaEn.setText("Mostrar Nomina Encabezado");
        BtnNominaEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNominaEnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_CodigoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(BT_InsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(BtnEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnNominaEn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNominaEn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(BtnEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_CodigoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_InsNombre))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_InsNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_InsNombreActionPerformed
        ObtenerDatos();

    }//GEN-LAST:event_BT_InsNombreActionPerformed

    private void BtnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEmpleadoActionPerformed
        new Ingresp_empleado().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEmpleadoActionPerformed

    private void BtnNominaEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNominaEnActionPerformed
        new EncabezadoNomina().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnNominaEnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        Login ingreso = new Login();
        ingreso.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_InsNombre;
    private javax.swing.JButton BtnEmpleado;
    private javax.swing.JButton BtnNominaEn;
    private javax.swing.JTable Tabla_Detalles;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_CodigoNomina;
    // End of variables declaration//GEN-END:variables
}
