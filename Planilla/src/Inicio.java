/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.table.DefaultTableModel;


/*
0901-17-65 Antonio Manuel Alejandro Garcia Gonzalez 

*/

public class Inicio extends javax.swing.JFrame {

    //Declaracion de variables tipo Entero
    int Salario_Bas, Tot_Deduc, Tot_Percep, Sueldo_Liquido, num_dept, Dept, Nrand;
    //Declaracion de variables tipo Texto
    String Nombre_Emp;
    //Declaracion de la Matriz y Vector de la Planilla
    String Matriz [][] = {};
    //Vector usado unicamente para los encabezados
    String Encab [] = {"Nombre","Salario Base","Total Deducciones","Total Percepciones","Sueldo Liquido","Num Dept."};
    String Encabezado [] = {"Num Dept.","Total Sueldo Liq"};
    //Declaracion de variable random para el sueldo y los totales
    Random NumR = new Random();
    //Declaracion para ingresar datos en la Tabla
    DefaultTableModel Modelo;
    DefaultTableModel ModeloVect;
    DefaultTableModel Tabla = new DefaultTableModel();
 
    public Inicio() {
        initComponents();
        //Sintaxis para el guardado de los datos en la Tabla
         Modelo = new DefaultTableModel(Matriz, Encab);
         ModeloVect=new DefaultTableModel(Matriz, Encabezado);
        tblDatos.setModel(Modelo);  
        tblData.setModel(ModeloVect);
    }

    //Metodo donde se llenan los datos para llenar la table
    public void Llenado_Datos(){
    
    //Llamada al metodo Rumero_random para obtener los valores al azar 
    Salario_Bas = Numero_random();
    Tot_Deduc = Numero_random();
    Tot_Percep = Numero_random();
    //Operacion aritmetica para el sueldo liquido
    Sueldo_Liquido = Salario_Bas- Tot_Deduc + Tot_Percep ; 
    //Uso del random para el Numero de Departamento, el +1 es para evitar el 0
    Dept =NumR.nextInt(4)+1;

}

public void Ingreso_Tabla(){
    //Obtenemos el valor del Nombre de la caja de texto
    Nombre_Emp = txtNom_Emp.getText();
    
    String Nombre, Salario_Base, Tot_Deducc, Tot_Percept, Sal_Liq,Depart;
    
    //Igualacion de las variables con los calculos y datos aleatorios para la matriz
    Nombre = Nombre_Emp;
    Depart = String.valueOf(Dept);
    Salario_Base = String.valueOf(Salario_Bas);
    Tot_Deducc = String.valueOf(Tot_Deduc);
    Tot_Percept = String.valueOf(Tot_Percep);
    Sal_Liq = String.valueOf(Sueldo_Liquido);
    //Guardado de los datos en un vector para ingresar a la tabla
    String Datos [] = {Nombre,Salario_Base,Tot_Deducc,Tot_Percept,Sal_Liq,Depart};
    //Agregando el vector a la fila de la tabla
    Modelo.addRow(Datos);
}
    
    //Metodo para obtener numeros aleatorios
    private int Numero_random(){    
        //declaracion de variable donde se puso el rango de valores aleatorios
       int NUMERO_RAND = ThreadLocalRandom.current().nextInt(2000, 5000);
       return ThreadLocalRandom.current().nextInt(2000, 5000);
   }
    
 public void TotalesVector(){

        String []agregar=new String[2];
        for(int a=1;a<=5;a++){
        agregar[0]=String.valueOf(a);
      
        ModeloVect.addRow(agregar);
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

        Pnl_Ingreso_Planilla = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        lblNom_Emp = new javax.swing.JLabel();
        txtNom_Emp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setText("Ingresar Dato a Planilla");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lblNom_Emp.setText("Ingrese el Nombre del Empleado:");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Salario Base", "Total Deducciones", "Total Percepcion", "Sueldo Liquido", "Numero Dept."
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout Pnl_Ingreso_PlanillaLayout = new javax.swing.GroupLayout(Pnl_Ingreso_Planilla);
        Pnl_Ingreso_Planilla.setLayout(Pnl_Ingreso_PlanillaLayout);
        Pnl_Ingreso_PlanillaLayout.setHorizontalGroup(
            Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                .addGroup(Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNom_Emp)
                        .addGap(45, 45, 45)
                        .addComponent(txtNom_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addGap(349, 349, 349))
        );
        Pnl_Ingreso_PlanillaLayout.setVerticalGroup(
            Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNom_Emp))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Num. Dept", "Total Sueldos Liq"
            }
        ));
        jScrollPane2.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        int cont=0;
        
        //Verificacion de que la caja de texto no este vacia
        if(txtNom_Emp.getText().length()==0){
            JOptionPane.showMessageDialog(null,"No ha ingresado el Nombre del Empleado");
        }else
        if(cont>11){
            JOptionPane.showMessageDialog(null,"Ha Ingresado la Cantidad Maxima de Empleados");
        }else{
            //Llamada a los metodos 
            Llenado_Datos();
            Ingreso_Tabla();
            TotalesVector();
            //Limpieza de la caja de texto
            
            txtNom_Emp.setText(" ");
            
            cont+=1; 
        
        }
        
        
    }//GEN-LAST:event_btnIngresarActionPerformed

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
    private javax.swing.JPanel Pnl_Ingreso_Planilla;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNom_Emp;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtNom_Emp;
    // End of variables declaration//GEN-END:variables
}
