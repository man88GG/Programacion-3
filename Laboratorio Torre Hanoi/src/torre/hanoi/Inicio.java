/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre.hanoi;

/**
 *
 * 
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inicio extends javax.swing.JFrame {

    DefaultTableModel Inicio = new DefaultTableModel();
    DefaultTableModel Auxiliar = new DefaultTableModel();
    DefaultTableModel Final = new DefaultTableModel();
    
    Nodo Tabla_Inicial = null;
    Nodo Tabla_Aux = null;
    Nodo Tabla_Final = null; 
    
    //variable num_discos que obtendra la cantidad de piezas para jugar
    //variable Cambio_Tabla que se utilizara para obtener un valor dependiendo el movimiento a una tabla y se usara para el switch de Movimientos_Tabla
    //variable num_movimientos que servira para controlar la cantidad de movimientos realizados por el jugador
    //variable Ganador que se verificara con la variable num_discos para saber si ha ganado
    int num_discos, Cambio_Tabla, num_movimientos = 0, Ganador=0;
    
    public Inicio() {
        initComponents();
        
        this.Tbl_Inicial.setModel(Inicio);
        Inicio.addColumn("Inicio");
        
        this.Tbl_Aux.setModel(Auxiliar);
        Auxiliar.addColumn("Pivote");
        
        this.Tbl_Final.setModel(Final);
        Final.addColumn("Final");
   
    }
    
 //Clase del Nodo
    public class Nodo {
	int info;
	public Nodo Siguiente;
        
	public Nodo (int dato){
            
		info=dato;
            }
         
	}
    
    Nodo cabeza=null; 
    int longitud=0;
   
    //Metodo de Limpiar Tablas
    public void Limpiar(){
        while (Inicio.getRowCount() > 0){
               Inicio.removeRow(0);
        }
        while (Auxiliar.getRowCount() > 0){
               Auxiliar.removeRow(0);
        }
        while (Final.getRowCount() > 0){
               Final.removeRow(0);
        }
    }
   
    //Metodo que Ingresara la cantidad de piezas que seleccione el Usuario
    public void Llenado(int num){
        
        Nodo nodo=new Nodo(num);
        if (Tabla_Inicial==null){
            Tabla_Inicial=nodo;
	}
        else{
            Nodo temp=Tabla_Inicial;
            while (temp.Siguiente!=null) {
                    temp=temp.Siguiente;
                  }
            temp.Siguiente=nodo;
        } 
    }
    
   //Metodo para mostrar los datos en las tablas
   public void Mostrar(){
       String Datos [] = new String[1];
       //igualacion de aux para mostrar en la tabla inicial
        Nodo aux = Tabla_Inicial;
        //ciclo donde se mostraran los Datos de la Tabla Inicial
        while (aux!=null){
                Datos[0] = String.valueOf(aux.info);
                Inicio.addRow(Datos);
                aux=aux.Siguiente;
            }
        //igualacion de aux para mostrar en la tabla auxiliar
        aux = Tabla_Aux;
        //ciclo donde se mostraran los Datos de la Tabla Auxiliar
        while (aux!=null){
                Datos[0] = String.valueOf(aux.info);
                Auxiliar.addRow(Datos);
                aux=aux.Siguiente;
            }
        //igualacion de aux para mostrar en la tabla final
        aux = Tabla_Final;
        //ciclo donde se mostraran los Datos de la Tabla Final
        while (aux!=null){
                Datos[0] = String.valueOf(aux.info);
                Final.addRow(Datos);
                aux=aux.Siguiente;
            }
        
        int mov_minimos;
        
        mov_minimos = (int) Math.pow(2, num_discos) - 1;
        this.lbl_Movimientos.setText(Integer.toString(mov_minimos));
 
   }
   
   //Metodo Donde se Verificara que Boton se Selecciono para el Moviemiento de una Pieza a otra Tabla
   public void Movimientos_Tabla(int Valor_Tabla){
       //declaracion de variables para la validacion de un movimiento de pieza
       int dato1, dato2 = 0;
       //switch para identificar el tipo de movimiento a una tabla
       switch (Valor_Tabla){
           //Case que mueve una pieza de la Tabla Inicial a la Tabla Auxiliar
           case 12:{
                   //validacion que existan datos en la tabla
                if(Tabla_Inicial == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                    
                }else{
                    
                    dato1 = Tabla_Inicial.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Aux == null){
                        Tabla_Aux = Nuevo;
                        Tabla_Inicial = Tabla_Inicial.Siguiente;
                        num_movimientos += 1;
                        
                    }else{
                        
                        dato2 = Tabla_Aux.info;
                        //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                            
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Aux;
                            Tabla_Aux = Nuevo;
                            Tabla_Inicial = Tabla_Inicial.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if 
                }//fin if
           }break;//fin case 
           
           //Case que mueve una pieza de la Tabla Inicial a la Tabla Final
           case 13:{
               //validacion que existan datos en la tabla
                if ( Tabla_Inicial == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                    
                }else{
                    
                    dato1 = Tabla_Inicial.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Final == null){
                        Tabla_Final = Nuevo;
                        Tabla_Inicial = Tabla_Inicial.Siguiente;
                        num_movimientos += 1;
                        
                    }else{
                        
                        dato2 = Tabla_Final.info;
                        //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Final;
                            Tabla_Final = Nuevo;
                            Tabla_Inicial = Tabla_Inicial.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if
                }//fin if
           }break;//fin case 
           
            //Case que mueve una pieza de la Tabla Auxiliar a la Tabla Final
           case 23:{
                //validacion que existan datos en la tabla
                if (Tabla_Aux == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                    
                }else{
                    
                    dato1 = Tabla_Aux.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Final == null){
                        Tabla_Final = Nuevo;
                        Tabla_Aux = Tabla_Aux.Siguiente;
                        num_movimientos += 1;
                        
                    }else{
                        
                        dato2 = Tabla_Final.info;
                        //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Final;
                            Tabla_Final = Nuevo;
                            Tabla_Aux = Tabla_Aux.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if 
                }//fin if
           }break;//fin case 
           
           
            //Case que mueve una pieza de la Tabla Auxiliar a la Tabla Inicial
           case 21:{
                //validacion que existan datos en la tabla
                if (Tabla_Aux == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }else{
                    
                    dato1 = Tabla_Aux.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Inicial == null){
                        Tabla_Inicial = Nuevo;
                        Tabla_Aux = Tabla_Aux.Siguiente;
                        num_movimientos += 1;
                        
                    }else{
                        
                        dato2 = Tabla_Inicial.info;
                        //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Inicial;
                            Tabla_Inicial = Nuevo;
                            Tabla_Aux = Tabla_Aux.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if 
                }//fin if
           }break;//fin case 
           
            //Case que mueve una pieza de la Tabla Final a la Tabla Auxiliar
           case 32:{
                //validacion que existan datos en la tabla
               if (Tabla_Final == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
               }else{
                    
                    dato1 = Tabla_Final.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Aux == null){
                        Tabla_Aux = Nuevo;
                        Tabla_Final = Tabla_Final.Siguiente;
                        num_movimientos += 1;
                    }else{
                        
                        dato2 = Tabla_Aux.info;
                        //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Aux;
                            Tabla_Aux = Nuevo;
                            Tabla_Final = Tabla_Final.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if 
                }//fin if
           }break;//fin case 
           
           //Case que mueve una pieza de la Tabla Final a la Tabla Inicial
           case 31:{
               //validacion que existan datos en la tabla
               if (Tabla_Final == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }else{
                    
                    dato1 = Tabla_Final.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(Tabla_Inicial == null){
                        Tabla_Inicial = Nuevo;
                        Tabla_Final = Tabla_Final.Siguiente;
                        num_movimientos += 1;
                    }else{
                        
                        dato2 = Tabla_Inicial.info;
                         //verificacion para saber si se puede realizar el moviemiento de la pieza
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }else{
                            
                            Nuevo.Siguiente = Tabla_Inicial;
                            Tabla_Inicial = Nuevo;
                            Tabla_Final = Tabla_Final.Siguiente;
                            num_movimientos += 1;
                        }//fin if
                    }//fin if 
                }//fin if
           }break;//fin case 
           
       }//fin Switch
   }
   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Iniciar = new javax.swing.JButton();
        lblCant_Movimientos = new javax.swing.JLabel();
        lbl_Movimientos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Inicial = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Final = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Aux = new javax.swing.JTable();
        Btn1_2 = new javax.swing.JButton();
        Btn2_3 = new javax.swing.JButton();
        Btn3_1 = new javax.swing.JButton();
        Btn1_3 = new javax.swing.JButton();
        Btn2_1 = new javax.swing.JButton();
        Btn3_2 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_Iniciar.setText("Iniciar");
        Btn_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_IniciarActionPerformed(evt);
            }
        });

        lblCant_Movimientos.setText("Cantidad de Movimientos para Completar el Juego:");

        lbl_Movimientos.setText("-");

        Tbl_Inicial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_Inicial);

        Tbl_Final.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Tbl_Final);

        Tbl_Aux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_Aux);

        Btn1_2.setText("De 1 a 2");
        Btn1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1_2ActionPerformed(evt);
            }
        });

        Btn2_3.setText("De 2 a 3");
        Btn2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2_3ActionPerformed(evt);
            }
        });

        Btn3_1.setText("De 3 a 1");
        Btn3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn3_1ActionPerformed(evt);
            }
        });

        Btn1_3.setText("De 1 a 3");
        Btn1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1_3ActionPerformed(evt);
            }
        });

        Btn2_1.setText("De 2 a 1");
        Btn2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2_1ActionPerformed(evt);
            }
        });

        Btn3_2.setText("De 3 a 2");
        Btn3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn3_2ActionPerformed(evt);
            }
        });

        lbl1.setText("1");

        lbl2.setText("2");

        lbl3.setText("3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn1_2)
                    .addComponent(Btn1_3))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn2_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn3_2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn2_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn3_1)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbl1)
                .addGap(132, 132, 132)
                .addComponent(lbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl3)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1)
                    .addComponent(lbl2)
                    .addComponent(lbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn1_2)
                    .addComponent(Btn2_3)
                    .addComponent(Btn3_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn1_3)
                    .addComponent(Btn2_1)
                    .addComponent(Btn3_2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblCant_Movimientos)
                                .addGap(16, 16, 16)
                                .addComponent(lbl_Movimientos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(Btn_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCant_Movimientos)
                    .addComponent(lbl_Movimientos))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(Btn_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_IniciarActionPerformed

        num_discos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de Piezas para Jugar"));
        
            Limpiar();
            Tabla_Inicial = null;
            Tabla_Aux = null;
            Tabla_Final = null;
            num_movimientos = 0;
            Ganador=0;
            for(int llenar = 1; llenar <= num_discos; llenar++){
                
                Llenado(llenar);  
            }
            
            Mostrar();
            
    }//GEN-LAST:event_Btn_IniciarActionPerformed

    private void Btn1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1_2ActionPerformed

        Cambio_Tabla = 12;
        Limpiar();
        Movimientos_Tabla(Cambio_Tabla);
        Mostrar();
       

    }//GEN-LAST:event_Btn1_2ActionPerformed

    private void Btn1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1_3ActionPerformed

        Cambio_Tabla = 13;
        Limpiar();
        Movimientos_Tabla(Cambio_Tabla);
        Mostrar();
        
        
    }//GEN-LAST:event_Btn1_3ActionPerformed

    private void Btn2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2_3ActionPerformed
        
        Cambio_Tabla = 23;
        Limpiar();
        Movimientos_Tabla(Cambio_Tabla);
        Mostrar();
    
        
    }//GEN-LAST:event_Btn2_3ActionPerformed

    private void Btn2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2_1ActionPerformed
           
        Cambio_Tabla = 21;
        Limpiar();
        Movimientos_Tabla(Cambio_Tabla);
        Mostrar();

        
    }//GEN-LAST:event_Btn2_1ActionPerformed

    private void Btn3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn3_1ActionPerformed

         Cambio_Tabla = 31;
         Limpiar();
         Movimientos_Tabla(Cambio_Tabla);
         Mostrar();
       
         
    }//GEN-LAST:event_Btn3_1ActionPerformed

    private void Btn3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn3_2ActionPerformed

        Cambio_Tabla = 32;
        Limpiar();
        Movimientos_Tabla(Cambio_Tabla);
        Mostrar();       
      
        
    }//GEN-LAST:event_Btn3_2ActionPerformed

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
    private javax.swing.JButton Btn1_2;
    private javax.swing.JButton Btn1_3;
    private javax.swing.JButton Btn2_1;
    private javax.swing.JButton Btn2_3;
    private javax.swing.JButton Btn3_1;
    private javax.swing.JButton Btn3_2;
    private javax.swing.JButton Btn_Iniciar;
    private javax.swing.JTable Tbl_Aux;
    private javax.swing.JTable Tbl_Final;
    private javax.swing.JTable Tbl_Inicial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblCant_Movimientos;
    private javax.swing.JLabel lbl_Movimientos;
    // End of variables declaration//GEN-END:variables
}
