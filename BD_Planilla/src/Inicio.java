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
    String Pago_Iggs,Pagar_Iggs="";
   
    //variables para 2da tabla
   int t1=0,t2=0,t3=0,t4=0,t5=0;
    double ISR,IGGS;
    //Declaracion de variables tipo Texto
    String Nombre_Emp;
    //Declaracion de la Matriz y Vector de la Planilla
    String Matriz [][] = {};
    
    String Encab [] = {"Nombre","Salario Base","Total Deducciones","Total Percepciones","Paga IGGS ?","Cantidad IGGS","ISR","Sueldo Liquido","Num Dept."};
    
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
    
    //Uso del random para el Numero de Departamento, el +1 es para evitar el 0
    Dept=NumR.nextInt(4)+1;
    
    //ciclo if para identificar si esta Solvente para Iggs o no
    if(Pago_Iggs.equals("1")){
        
        Pagar_Iggs="Si";
        IGGS=Salario_Bas*0.0483;
        
    }else
        if(Pago_Iggs.equals("2")){
            IGGS=0;
            Pagar_Iggs="No";
        }
    
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
    
    
    
    //ciclo if para dejar Sueldo_Liquido en 0 en caso los valores random de deducciones sean mucho mayores que el sueldo base
    if (Sueldo_Liquido<0){
        Sueldo_Liquido=0;
    }
    
    
     //Operacion aritmetica para el sueldo liquido
    Sueldo_Liquido = Salario_Bas- Tot_Deduc + Tot_Percep-(int)IGGS-(int)ISR;
    
    //Switch para ir sumando el sueldo Liquido Total de cada departamento 
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
    
    int t1=0,t2=0,t3=0,t4=0,t5=0;
    
    String Nombre, Salario_Base, Tot_Deducc, Tot_Percept, Sal_Liq,Depart,Isr,iggs,pagar_iggs;
    //declaracion de formato para mostrar solamente 2 decimales en isr
    DecimalFormat formato = new DecimalFormat ("0.00");
    
    //Igualacion y conversion de las variables con los calculos y datos aleatorios para la matriz
    Nombre = Nombre_Emp;
    Depart = String.valueOf(Dept);
    Salario_Base = String.valueOf(Salario_Bas);
    Tot_Deducc = String.valueOf(Tot_Deduc);
    Tot_Percept = String.valueOf(Tot_Percep);
    pagar_iggs=(Pagar_Iggs);
    iggs=String.valueOf(formato.format(IGGS));
    Sal_Liq = String.valueOf(Sueldo_Liquido);
    Isr=String.valueOf(formato.format(ISR));
    //Guardado de los datos en un vector para ingresar a la tabla
    String Datos [] = {Nombre,Salario_Base,Tot_Deducc,Tot_Percept,pagar_iggs,iggs,Isr,Sal_Liq,Depart};
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pnl_Ingreso_Planilla.setBackground(new java.awt.Color(255, 255, 255));

        btnIngresar.setText("Ingresar Dato a Planilla");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Salario Base", "Total Deducciones", "Total Percepcion", "Paga IGSS ?", "Cantidad IGGS ", "ISR", "Sueldo Liquido", "Numero Dept."
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
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(btnIngresar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        Pnl_Ingreso_PlanillaLayout.setVerticalGroup(
            Pnl_Ingreso_PlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Ingreso_PlanillaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Ingreso_Planilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

         //Verificacion de que la caja de texto no este vacia
        if(cont>9){
            JOptionPane.showMessageDialog(null,"Ha Ingresado la Cantidad Maxima de Empleados");
        }else{
            for(int a=0;a<=10;a++){
            //Llamada a los metodos
            Nombre_Emp = JOptionPane.showInputDialog(null,"Ingrese Nombre del Empleado");
            Pago_Iggs = JOptionPane.showInputDialog(null,"¿ Esta Solvente de IGGS ?\n"+"1. SI\n"+"2. NO");
            Llenado_Datos();
            
            Ingreso_Tabla();
             cont+=1;
            
             //Ciclo if para cuando se llega al Maximo de 10 Empleados registrados muestra el Total Sueldo Liquido
            } 
            if(cont==11){
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
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
