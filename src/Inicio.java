/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;


/*
0901-17-65 Antonio Manuel Alejandro Garcia Gonzalez.

*/

public class Inicio extends javax.swing.JFrame {

     //Declaracion de variables tipo Entero
    int Salario_Bas, Tot_Deduc, Tot_Percep, Sueldo_Liquido, num_dept, Dept, Nrand,cont=0;
    //variables para 2da tabla
   int t1=0,t2=0,t3=0,t4=0,t5=0;
    double ISR;
    //Declaracion de variables tipo Texto
    String Nombre_Emp;
    //Declaracion de la Matriz y Vector de la Planilla
    String Matriz [][] = {};
    
    String Encab [] = {"Nombre","Salario Base","Total Deducciones","Total Percepciones","ISR","Sueldo Liquido","Num Dept."};
    
    //vector para 2da tabla
  String Encabezado [] = {"Numero Dept.","1","2","3","4","5"};
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
    
    //ciclo if para el valor de ISR
    if(Sueldo_Liquido>=2600 && Sueldo_Liquido<=5000){
        
        ISR=Sueldo_Liquido*0.03;
        
    }else{
        if(Sueldo_Liquido>=5001 && Sueldo_Liquido<=10000){
            
             ISR=Sueldo_Liquido*0.05;
             
        }else{
            if(Sueldo_Liquido>=10001){
                
                 ISR=Sueldo_Liquido*0.1;
                 
            }//fin tercer if
        }//fin segundo if
    }//fin primer if
    
       switch(Dept){
        case 1:{t1+=Sueldo_Liquido;}break;
        case 2:{t2+=Sueldo_Liquido;}break;
        case 3:{t3+=Sueldo_Liquido;}break;
        case 4:{t4+=Sueldo_Liquido;}break;
        case 5:{t5+=Sueldo_Liquido;}break;
    }
    

}

public void Ingreso_Tabla(){
    //Obtenemos el valor del Nombre de la caja de texto
    Nombre_Emp = txtNom_Emp.getText();
    int t1=0,t2=0,t3=0,t4=0,t5=0;
    
    String Nombre, Salario_Base, Tot_Deducc, Tot_Percept, Sal_Liq,Depart,Isr;
    //declaracion de formato para mostrar solamente 2 decimales en isr
   DecimalFormat formato = new DecimalFormat ("0.00");
    
    //Igualacion y conversion de las variables con los calculos y datos aleatorios para la matriz
    Nombre = Nombre_Emp;
    Depart = String.valueOf(Dept);
    Salario_Base = String.valueOf(Salario_Bas);
    Tot_Deducc = String.valueOf(Tot_Deduc);
    Tot_Percept = String.valueOf(Tot_Percep);
    Sal_Liq = String.valueOf(Sueldo_Liquido);
    Isr=String.valueOf(formato.format(ISR));
    //Guardado de los datos en un vector para ingresar a la tabla
    String Datos [] = {Nombre,Salario_Base,Tot_Deducc,Tot_Percept,Isr,Sal_Liq,Depart};
    //Agregando el vector a la fila de la tabla
    Modelo.addRow(Datos);
   /*
    switch(Dept){
        case 1:{t1+=Sueldo_Liquido;}break;
        case 2:{t2+=Sueldo_Liquido;}break;
        case 3:{t3+=Sueldo_Liquido;}break;
        case 4:{t4+=Sueldo_Liquido;}break;
        case 5:{t5+=Sueldo_Liquido;}break;
 
    }
    */
    
}
    
    //Metodo para obtener numeros aleatorios
    private int Numero_random(){    
        //declaracion de variable donde se puso el rango de valores aleatorios
       int NUMERO_RAND = ThreadLocalRandom.current().nextInt(2000, 5000);
       return ThreadLocalRandom.current().nextInt(2000, 5000);
   }
    
 public void TotalesVector(){

        //agrega a la segunda tabla los totales de sueldo liquido
        String []agregar=new String[6];
        agregar[0]="Sueldo Liquido Total";
        agregar[1]=String.valueOf(t1);
        agregar[2]=String.valueOf(t2);
        agregar[3]=String.valueOf(t3);
        agregar[4]=String.valueOf(t4);
        agregar[5]=String.valueOf(t5);
        
        ModeloVect.addRow(agregar);
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
        jLabel1 = new javax.swing.JLabel();

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Salario Base", "Total Deducciones", "Total Percepcion", "ISR", "Sueldo Liquido", "Numero Dept."
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout Pnl_Ingreso_PlanillaLayout = new javax.swing.GroupLayout(Pnl_Ingreso_Planilla);
        Pnl_Ingreso_Planilla.setLayout(Pnl_Ingreso_PlanillaLayout);
        Pnl_Ingreso_PlanillaLayout.setHorizontalGroup(
            Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                .addGroup(Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                                .addComponent(lblNom_Emp)
                                .addGap(45, 45, 45)
                                .addComponent(txtNom_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(btnIngresar)))
                .addContainerGap(46, Short.MAX_VALUE))
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
                {"Salario Liquido", null, null, null, null, null}
            },
            new String [] {
                "Num. Dept", "1", "2", "3", "4", "5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblData);

        jLabel1.setText("Tabla de Totales Salario Liquido por Dept");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        //Verificacion de que la caja de texto no este vacia
        if(txtNom_Emp.getText().length()==0){
            JOptionPane.showMessageDialog(null,"No ha ingresado el Nombre del Empleado");
        }else
        if(cont>9){
            JOptionPane.showMessageDialog(null,"Ha Ingresado la Cantidad Maxima de Empleados");
        }else{
            //Llamada a los metodos
            Llenado_Datos();
            Ingreso_Tabla();

            //Limpieza de la caja de texto
            txtNom_Emp.setText(" ");

            cont+=1;

            if(cont==10){
                TotalesVector();
            }

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
    private javax.swing.JPanel Pnl_Ingreso_Planilla1;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNom_Emp;
    private javax.swing.JLabel lblNom_Emp1;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblDatos1;
    private javax.swing.JTextField txtNom_Emp;
    private javax.swing.JTextField txtNom_Emp1;
    // End of variables declaration//GEN-END:variables
}
