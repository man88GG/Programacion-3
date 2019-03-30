/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Inicio extends javax.swing.JFrame {

    int Dato_Pedido;
    Nodo Primero;
    Random Numero_Aleatorio = new Random();
   
    DefaultTableModel Tabla_Lista = new DefaultTableModel();
     
    public Inicio() {
        
        initComponents();
        
        Tbl_Lista.setModel(Tabla_Lista);
        Tabla_Lista.addColumn("Posicion de Lista");
        Tabla_Lista.addColumn("Valor en la Lista");
     
    }
    
    //metodo para limpiar la lista 
    public void LimpiarLista(){
        while (Tabla_Lista.getRowCount() > 0) {
               Tabla_Lista.removeRow(0);
        }
        
    }
    
   

        
        public void InsertarEnPrimero(int Dato){
	Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
	Temporal.Siguiente=Primero; //corre al primero
	Primero=Temporal;   //lo coloca de primero
	}//fin Insertar en Primero
        
    
        
        //Metodo de Borrar Primera Posicion
	public void borrarPrimero(){
		Primero=Primero.Siguiente;
	}//fin borrar Primero
        
        //metodo de mostrar 
        public String Listar(){
        
	String Dato=" ";
        //vector que ira guardando los valores para despues colocarlos en la lista
        String Data[] = new String[2];
	Nodo aux=Primero;
        //variable de contador para las posiciones de la lista
        int posicion=-1;
        
	while (aux!=null){
                posicion+=1;    
		Dato+="{" + aux.info + "}";
                //se guardan en las posiciones del vector los valores para cada fila de la lista
                Data[0]=String.valueOf(posicion);
                Data[1]= String.valueOf(aux.info);
                //se muestra el vector en la tabla
                Tabla_Lista.addRow(Data);
		aux=aux.Siguiente;
	    }
	return(Dato);
        }//fin listar
        
        //Metodo que borra ultima posicion
	public void borrarUltimo(){
	Nodo anterior=Primero;
	Nodo actual=Primero;
	while (actual.Siguiente!=null){
	    anterior=actual;
	    actual=actual.Siguiente;
	    }
	    anterior.Siguiente=null;
	}//fin borrar Ultimo
           
         //Metodo Borrar Posicion
	public void borrarPosicion(int pos){
        Nodo anterior=Primero;
	Nodo actual=Primero;
	int k=0;
	if (pos>0){
                    
	while (k!=pos && actual.Siguiente != null){
                            
       	    anterior=actual;
	    actual=actual.Siguiente;
				
		}
	     anterior.Siguiente=actual.Siguiente;
	    }
        
        
	}//fin borrar Posicion
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerar_Lista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Lista = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGenerar_Lista.setText("Generar un dato de Lista");
        btnGenerar_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar_ListaActionPerformed(evt);
            }
        });

        Tbl_Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_Lista);

        jButton2.setText("Borrar Primera Posicion Lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar Ultima Posicion Lista");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Borrar Posicion Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(btnGenerar_Lista))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerar_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar_ListaActionPerformed
       //se llama al metodo de limpiar para ir actualizando la lista 
       LimpiarLista();
      //se genera una variable que sera aleatoria para llenar los valores de la lista
       Dato_Pedido=Numero_Aleatorio.nextInt(10)+1;
       //el valor aleatorio se usa en el metodo para insertarlo como primer valor
       InsertarEnPrimero(Dato_Pedido);
       //se llama al metodo que muestra la lista 
       Listar();
        
    }//GEN-LAST:event_btnGenerar_ListaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //se llama al metodo de limpiar para ir actualizando la lista 
        LimpiarLista();
        //se llama al metodo para borrar el primer valor de la lista
        borrarPrimero();
        //se llama al metodo que muestra la lista 
        Listar();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //se llama al metodo de limpiar para ir actualizando la lista 
        LimpiarLista();
        //se llama al metodo para borrar el ultimo valor de la lista
        borrarUltimo();
        //se llama al metodo que muestra la lista 
        Listar();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //solo borra ultima posicion, revisar
        //
        //
        //
        
        Dato_Pedido=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la Posicion de la Lista que Desea Eliminar:"));
        LimpiarLista();
        borrarPosicion(Dato_Pedido);
        Listar();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JTable Tbl_Lista;
    private javax.swing.JButton btnGenerar_Lista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
