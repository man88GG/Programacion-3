/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Inicio extends javax.swing.JFrame {

    
    //Variables String para los 3 campos de la clase Libro y para guardar los datos ingresados por el usuario
    String autor="",titulo="",isbn="";
    //Variable posicion que guarda la posicion de la lista, ingresada por el usuario 
    String posicion;
    //variable entera de posicion para ingresar el dato de la lista despues de una posicion determinada
    int IntPosicion;

    Nodo cabeza=null; //Se Declara Una variable Nodo iniciandola en Null
    //variable int que ira aumentando en base se agreguen mas datos a la lista para conocer su tamaño
    int longitud=0;
    
    
    DefaultTableModel Tabla_Lista = new DefaultTableModel();
    
    public Inicio() {
        initComponents();
        
         Tbl_Lista.setModel(Tabla_Lista);
        //agregado de cantidad y nombre de columnas a la tabla
        Tabla_Lista.addColumn("Posicion Lista");
        Tabla_Lista.addColumn("Título");
        Tabla_Lista.addColumn("Autor");
        Tabla_Lista.addColumn("ISBN");
        
    }

 //metodo para limpiar la tabla donde se muestra la lista
        public void LimpiarLista(){
        while (Tabla_Lista.getRowCount() > 0) {
               Tabla_Lista.removeRow(0);
        }        
    }
    
        //metodo nodo donde se manejara la posicion actual y siguiente de este sobre los datos de la clase libro
        public class Nodo {
        
		public Libro libro;
		public Nodo siguiente=null;
                
                
		public Nodo(Libro libro) {
			this.libro=libro;
		}  
	}
        
        //metodo para insertar al principio de la lista los datos de libro
	public void insertarPrincipio(Libro libro) {
 
		Nodo nodo=new Nodo(libro);
		nodo.siguiente=cabeza;
		cabeza=nodo;
		longitud++;	
                
	}
   
        //metodo donde las variables guardan los valores de los textbox que el usuario lleno
        public void IgualacionVariables(){
            autor=txtAutor.getText();
            titulo=txtLibro.getText();
            isbn=txtisbn.getText();
           
        }
        //metodo de mostrar la lista en la tabla
        public void Mostrar(){
                String Data[] = new String[4];
                int Contador = 0;
		Nodo aux=cabeza;
		while (aux!=null){
                        Data[0]= String.valueOf(Contador);
                        Data[1]= String.valueOf(aux.libro.titulo);
                        Data[2]= String.valueOf(aux.libro.autor);
                        Data[3]= String.valueOf(aux.libro.isbn);
                        Tabla_Lista.addRow(Data);
			aux=aux.siguiente;
                        Contador = Contador + 1;
		}
    }
        
        //metodo para eliminar los datos que estan en la primera posicion de la lista
        public void eliminaPrincipio() {
          
            cabeza=cabeza.siguiente;
        }
        // metodo para eliminar la lista completa
        
        public void EliminarLista(){
              if (cabeza!=null){
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente=null;
                longitud--;
            }
        }
        
        //metodo que limpia las cajas de text 
        public void LimpiarTextFields(){
            
            txtAutor.setText("");
            txtLibro.setText("");
            txtisbn.setText("");
           
            
        }
        
           public void VerificarCola(){
            //se hace una condicion if para verificar si el puntero esta apuntando a null verificando si esta vacia
        if (cabeza==null) {
            
            JOptionPane.showMessageDialog(rootPane,"La Cola esta Vacia");
        //de lo contrario el puntero tiene un valor lo que indica que esta llena
        }else{
        
            JOptionPane.showMessageDialog(rootPane,"La Cola esta Llena");
        }
        
        }
                  
        //metodo para eliminar los datos de la posicion establecida por el usuario en la lista
        public void eliminarLibro(int n) {
            if (cabeza!=null){
                if (n==0){
                    Nodo primer=cabeza;
                    cabeza=cabeza.siguiente;
                    primer.siguiente=null;
                    longitud--;
                } else if (n<longitud) {
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<(n-1)){
                        puntero=puntero.siguiente;
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;
                    longitud--;
                }
            }
        }
        
        public void Tamaño(){
           
                int Contador = 0;
		Nodo aux=cabeza;
		while (aux!=null){
                       
			aux=aux.siguiente;
                        Contador = Contador + 1;
		}
                JOptionPane.showMessageDialog(null,"El Tamaño de la Cola es: "+Contador);
        }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Lista = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtisbn = new javax.swing.JTextField();
        lbl_Autor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lbl_Titulo = new javax.swing.JLabel();
        txtLibro = new javax.swing.JTextField();
        lbl_Isbn = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnEliminar_Primer_Dato = new javax.swing.JButton();
        btn_Borrar_Lista = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tbl_Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_Lista);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Autor.setText("Autor");

        lbl_Titulo.setText("Titulo");

        lbl_Isbn.setText("ISBN");

        jButton1.setText("Ingresar a Cola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminar_Primer_Dato.setText("Eliminar Dato Cola");
        btnEliminar_Primer_Dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_Primer_DatoActionPerformed(evt);
            }
        });

        btn_Borrar_Lista.setText("Borrar Cola");
        btn_Borrar_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Borrar_ListaActionPerformed(evt);
            }
        });

        jButton3.setText("Verificacion Cola");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Tamaño Cola");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Autor)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Isbn)
                            .addComponent(lbl_Titulo))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAutor)
                    .addComponent(txtLibro)
                    .addComponent(txtisbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(btn_Borrar_Lista)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEliminar_Primer_Dato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Autor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Titulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Isbn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar_Primer_Dato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Borrar_Lista)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //llamado metodo de igualacion de variables a textfields
        IgualacionVariables();
        //se agregan los 3 datos anteriores a la clase 'Libro' por medio de 'ingreso'
        Libro ingresoinicio= new Libro(autor,titulo,isbn);
        //se llama el metodo de ingresar al inicio de la lista que tiene dentro los datos de la clase 'Libro
        insertarPrincipio(ingresoinicio);
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto para otro ingreso
        LimpiarTextFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminar_Primer_DatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_Primer_DatoActionPerformed

        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //se llama al metodo que elimina los datos en la primera posicion de la lista
        eliminaPrincipio();
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto en caso se quiso escribir algo en las cajas de texto
        LimpiarTextFields();

    }//GEN-LAST:event_btnEliminar_Primer_DatoActionPerformed

    private void btn_Borrar_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Borrar_ListaActionPerformed
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //se llama al metodo para eliminar toda la lista
        EliminarLista();
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto en caso se quiso escribir algo en las cajas de texto
        LimpiarTextFields();
    }//GEN-LAST:event_btn_Borrar_ListaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //se llama al metodo de verificacion
        VerificarCola();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Tamaño();       
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnEliminar_Primer_Dato;
    private javax.swing.JButton btn_Borrar_Lista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Autor;
    private javax.swing.JLabel lbl_Isbn;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}
