import java.sql.*;
import javax.swing.JOptionPane;
public class Ingresp_empleado extends javax.swing.JFrame {

    /**
     * Creates new form Ingresp_empleado
     */
    public Ingresp_empleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        BtnIngreso = new javax.swing.JButton();
        TxtSalario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtCod_Emp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CmbPuesto = new javax.swing.JComboBox<>();
        BtnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnEliminar = new javax.swing.JButton();
        CmbDepto = new javax.swing.JComboBox<>();
        TxtNombre_Emp = new javax.swing.JTextField();
        BtnModificar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RBT_igssSi = new javax.swing.JRadioButton();
        RBT_igssNo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setText("Salario");

        BtnIngreso.setText("Ingresar Empleado");
        BtnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresoActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Puesto");

        jLabel6.setText("Codigo Puesto");

        jLabel7.setText("Codigo Dept");

        CmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------", "Gerente", "Supervisor", "Contador", "Reclutador", "Programador", "Tecnico", "Planificador" }));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Empleado");

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        CmbDepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------", "Proyectos", "Informatica", "Capacitacion y Desarrollo", "Reclutamiento y Seleccion", "Nominas" }));

        BtnModificar.setText("Actualizar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jLabel2.setText("IGSS");

        RBT_igssSi.setText("Sí");

        RBT_igssNo.setText("No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(BtnIngreso)
                .addGap(21, 21, 21)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBT_igssSi)
                            .addComponent(RBT_igssNo))
                        .addContainerGap(315, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtSalario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre_Emp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCod_Emp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CmbDepto, 0, 179, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtCod_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombre_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(CmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RBT_igssSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBT_igssNo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresoActionPerformed
//declaracion de variables string para combobox puesto
        String caso_puesto,cod_puesto="",Igss;
        caso_puesto=String.valueOf(CmbPuesto.getSelectedItem());
//declaracion de variables string para combobox departamento
        String caso_dept,cod_dept="";
        caso_dept=String.valueOf(CmbDepto.getSelectedItem());
        //validacion de ambos combobox para que seleccione 
        if ("----------------".equals(caso_puesto) || "----------------".equals(caso_dept)){
            //Mensaje de error de combobox
            JOptionPane.showMessageDialog(null,"No ha Completado Todos los Datos");
        }else if(RBT_igssSi.isSelected()==false && RBT_igssNo.isSelected()==false ){
            //mensaje de error de iggs
            JOptionPane.showMessageDialog(null,"No se ha Seleccionado el IGSS");
        }else{
            //validacion de radiobuttons iggs
            if (RBT_igssSi.isSelected()) {
                Igss="1";
            }else{
                Igss="0";
            }
            //sentencia try para ingreso
            try{
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
                PreparedStatement pst = cn.prepareStatement("insert into empleado values(?,?,?,?,?,?)");
                //switch para cambiar los textos a codigos para la base de datos
                switch(caso_puesto){
                    case "Gerente":{cod_puesto="P1";}break;
                    case "Supervisor":{cod_puesto="P2";}break;
                    case "Contador":{cod_puesto="P3";}break;
                    case "Reclutador":{cod_puesto="P4";}break;
                    case "Programador":{cod_puesto="P5";}break;
                    case "Tecnico":{cod_puesto="P6";}break;
                    case "Planificador":{cod_puesto="P7";}break;

                }//fin switch
                //switch para cambiar los textos a codigos para la base de datos
                switch(caso_dept){
                    case "Proyectos":{cod_dept="D1";}break;
                    case "Informatica":{cod_dept="D2";}break;
                    case "Capacitacion y Desarrollo":{cod_dept="D3";}break;
                    case "Reclutamiento y Seleccion":{cod_dept="D4";}break;
                    case "Nominas":{cod_dept="D5";}break;

                }//fin switch
                
                pst.setString(1, TxtCod_Emp.getText().trim());
                pst.setString(2, TxtNombre_Emp.getText().trim());
                pst.setString(3, TxtSalario.getText().trim());
                pst.setString(4,Igss);
                pst.setString(5,cod_puesto);
                pst.setString(6 ,cod_dept);

                pst.executeUpdate();
                //limpieza para un nuevo ingreso
                TxtCod_Emp.setText("");
                TxtNombre_Emp.setText("");
                TxtSalario.setText("");
                RBT_igssSi.setSelected(false);
                RBT_igssNo.setSelected(false);
                CmbPuesto.setSelectedItem("----------------");
                CmbDepto.setSelectedItem("----------------");

                JOptionPane.showMessageDialog(null,"Registro Exitoso");
            }catch (Exception e){

                JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
            }
        }//fin if
        
    }//GEN-LAST:event_BtnIngresoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
       
        if ("".equals(TxtCod_Emp.getText())) {
           JOptionPane.showMessageDialog(null, "Ingrese el Código Empleado"); 
        }else{
            
        String puesto,depto,showpuesto="",showdepto="";

        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from empleado where codigo_empleado = ?");
            pst.setString(1, TxtCod_Emp.getText().trim());

            ResultSet rs = pst.executeQuery();

            if(rs.next()){

                TxtNombre_Emp.setText(rs.getString("nombre_empleado"));
                TxtSalario.setText(rs.getString("sueldo_empleado"));

                puesto=rs.getString("codigo_puesto");
                depto=rs.getString("codigo_departamento");

                switch(puesto){
                    case "P1":{showpuesto="Gerente";}break;
                    case "P2":{showpuesto="Supervisor";}break;
                    case "P3":{showpuesto="Contador";}break;
                    case "P4":{showpuesto="Reclutador";}break;
                    case "P5":{showpuesto="Programador";}break;
                    case "P6":{showpuesto="Tecnico";}break;
                    case "P7":{showpuesto="Planificador";}break;

                }//fin switch puesto

                switch(depto){
                    case "D1":{showdepto="Proyectos";}break;
                    case "D2":{showdepto="Informatica";}break;
                    case "D3":{showdepto="Capacitacion  y Desarrollo";}break;
                    case "D4":{showdepto="Reclutamiento y Seleccion";}break;
                    case "D5":{showdepto="Nominas";}break;

                }//fin switch depto

                CmbPuesto.setSelectedItem(showpuesto);
                CmbDepto.setSelectedItem(showdepto);

            } else {
                JOptionPane.showMessageDialog(null, "Empleador no Encontrado");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido Realizar la Busqueda");

        }
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if ("".equals(TxtCod_Emp.getText())) {
           JOptionPane.showMessageDialog(null, "Ingrese el Código Empleado"); 
        }else{
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("delete from empleado where codigo_empleado = ?");

            pst.setString(1, TxtCod_Emp.getText().trim());
            pst.executeUpdate();

            TxtCod_Emp.setText("");
            TxtNombre_Emp.setText("");
            TxtSalario.setText("");
            CmbPuesto.setSelectedItem("----------------");
            CmbDepto.setSelectedItem("----------------");

            JOptionPane.showMessageDialog(null, "Puesto Eliminado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido Eliminar");
        }    
        }
        
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if ("".equals(TxtCod_Emp.getText())) {
           JOptionPane.showMessageDialog(null, "Ingrese el Código Empleado"); 
        }else{
        String puesto,depto,showpuesto="",showdepto="",Igss;

        //Codigo que permite actualizar registros en la base de datos
        try {
            if (RBT_igssSi.isSelected()) {
                Igss="1";
            }else{
                Igss="0";
            }
            String ID = TxtCod_Emp.getText().trim();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("update empleado set nombre_empleado = ?, sueldo_empleado = ?, IGSS = ?, codigo_puesto = ?,codigo_departamento = ? where codigo_empleado ='"+ ID +"'");

            pst.setString(1, TxtNombre_Emp.getText().trim());
            pst.setString(2, TxtSalario.getText().trim());

            puesto=String.valueOf(CmbPuesto.getSelectedItem());
            depto=String.valueOf(CmbDepto.getSelectedItem());

            switch(puesto){
                case "Gerente":{showpuesto="P1";}break;
                case "Supervisor":{showpuesto="P2";}break;
                case "Contador":{showpuesto="P3";}break;
                case "Reclutador":{showpuesto="P4";}break;
                case "Programador":{showpuesto="P5";}break;
                case "Tecnico":{showpuesto="P6";}break;
                case "Planificador":{showpuesto="P7";}break;

            }

            switch(depto){
                case "Proyectos":{showdepto="D1";}break;
                case "Informatica":{showdepto="D2";}break;
                case "Capacitacion y Desarrollo":{showdepto="D3";}break;
                case "Reclutamiento y Seleccion":{showdepto="D4";}break;
                case "Nominas":{showdepto="D5";}break;

            }//switch depto
            
            pst.setString(3, Igss.trim());
            pst.setString(4, showpuesto.trim());
            pst.setString(5, showdepto.trim());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido Modificar los Datos del Empleado" + e);
        }
        }

    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed

        TxtCod_Emp.setText("");
        TxtNombre_Emp.setText("");
        TxtSalario.setText("");
        CmbPuesto.setSelectedItem("----------------");
        CmbDepto.setSelectedItem("----------------");

        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        Inicio ingreso = new Inicio();
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
            java.util.logging.Logger.getLogger(Ingresp_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresp_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresp_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresp_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresp_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnIngreso;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JComboBox<String> CmbDepto;
    private javax.swing.JComboBox<String> CmbPuesto;
    private javax.swing.JRadioButton RBT_igssNo;
    private javax.swing.JRadioButton RBT_igssSi;
    private javax.swing.JTextField TxtCod_Emp;
    private javax.swing.JTextField TxtNombre_Emp;
    private javax.swing.JTextField TxtSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
