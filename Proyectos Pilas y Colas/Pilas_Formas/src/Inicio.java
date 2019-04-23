/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Inicio extends javax.swing.JFrame {

    
     //Variables String para los 3 campos de la clase Libro y para guardar los datos ingresados por el usuario
    String autor="",titulo="",isbn="";
    //Variable posicion que guarda la posicion de la lista, ingresada por el usuario 
   
    //variable entera de posicion para ingresar el dato de la lista despues de una posicion determinada
    int IntPosicion;

    Nodo cabeza=null; //Se Declara Una variable Nodo iniciandola en Null
    //variable int que ira aumentando en base se agreguen mas datos a la lista para conocer su tamaño
    int longitud=0;
    
    DefaultTableModel Tabla_Lista = new DefaultTableModel();
    
    DefaultTableModel Tabla_ListaTOP = new DefaultTableModel();
    
    
    public Inicio() {
        initComponents();
        Tbl_Lista.setModel(Tabla_Lista);
        Tbl_TOP.setModel(Tabla_ListaTOP);
        //agregado de cantidad y nombre de columnas a la tabla
        Tabla_Lista.addColumn("Posicion Lista");    
        Tabla_Lista.addColumn("Título");
        Tabla_Lista.addColumn("Autor");
        Tabla_Lista.addColumn("ISBN");
        
        Tabla_ListaTOP.addColumn("Posicion Lista");    
        Tabla_ListaTOP.addColumn("Título");
        Tabla_ListaTOP.addColumn("Autor");
        Tabla_ListaTOP.addColumn("ISBN");
       
    }
    
   
        public void LimpiarLista(){
        while (Tabla_Lista.getRowCount() > 0) {
               Tabla_Lista.removeRow(0);
        }        
    }
     
        public void LimpiarListaTOP(){
        while (Tabla_ListaTOP.getRowCount() > 0) {
               Tabla_ListaTOP.removeRow(0);
        }        
    }
         
       
       
        public class Nodo {
        
		public Libro libro;
		public Nodo siguiente=null;
                
                
		public Nodo(Libro libro) {
			this.libro=libro;
		}
                
                
	}
        
    
        //metodo para insertar al final de la lista los datos de libro
        public void insertarFinal(Libro libro) {
		Nodo nodo=new Nodo(libro);
		if (cabeza==null){
                    cabeza=nodo;
		}else{
                    Nodo puntero=cabeza;
                    while (puntero.siguiente!=null) {
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=nodo;
		}
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
        
        public void TOP(){
                String Data[] = new String[4];
                int Contador = 0;
		Nodo aux=cabeza;		
               while (aux!=null){
                        Data[0]= String.valueOf(Contador);
                        Data[1]= String.valueOf(aux.libro.titulo);
                        Data[2]= String.valueOf(aux.libro.autor);
                        Data[3]= String.valueOf(aux.libro.isbn);                    
			aux=aux.siguiente;
                        Contador = Contador + 1;
		}
		Tabla_ListaTOP.addRow(Data);
    }
        
        
        
        
        
           //metodo donde se obtienen los datos de la clase libro en cada posicion de la lista
        public Libro obtener(int n) {
		if (cabeza==null) {
			return null;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			if (contador!=n) {
				return null;
			} else {
				return puntero.libro;
			}
		}
	}
      
        // metodo para eliminar la lista completa
        public void EliminarPila(){
              if (cabeza!=null){
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente=null;
                longitud--;
            }
        }
        //metodo para eliminar los datos de la ultima posicion de la lista
        public void eliminarUltimo() {
            if (cabeza!= null) {
                if (cabeza.siguiente==null) {
                    cabeza=null;  
                    longitud--;
                } else {
                    Nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=null;
                    longitud--;
                }
            }
        }
        //metodo que limpia las cajas de text 
        public void LimpiarTextFields(){
            
            txtAutor.setText("");
            txtLibro.setText("");
            txtisbn.setText("");
           
            
        }
       
        //metodo que inserta los datos en la pósicion siguiente de la establecida por el usuario en la lista
	public void insertarDespues(int n, Libro libro) {  
		Nodo nodo=new Nodo(libro);
		if (cabeza==null) {
			cabeza=nodo;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			nodo.siguiente=puntero.siguiente;
			puntero.siguiente=nodo;
		}
		longitud++;
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
        Push = new javax.swing.JButton();
        btn_Borrar_Lista = new javax.swing.JButton();
        btnEliminar_Ultimo_Dato = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_TOP = new javax.swing.JTable();

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

        Push.setText("Insertar A Pila");
        Push.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PushActionPerformed(evt);
            }
        });

        btn_Borrar_Lista.setText("Borrar Pila");
        btn_Borrar_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Borrar_ListaActionPerformed(evt);
            }
        });

        btnEliminar_Ultimo_Dato.setText("Eliminar Ultimo Dato Lista");
        btnEliminar_Ultimo_Dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_Ultimo_DatoActionPerformed(evt);
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
                    .addComponent(Push, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btn_Borrar_Lista))
                    .addComponent(btnEliminar_Ultimo_Dato))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Push)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Autor))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Titulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Isbn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnEliminar_Ultimo_Dato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Borrar_Lista)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Top");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tbl_TOP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PushActionPerformed
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //llamado metodo de igualacion de variables a textfields
        IgualacionVariables();
        //se agregan los 3 datos anteriores a la clase 'Libro' por medio de 'ingreso'
        Libro ingresofinal= new Libro(autor,titulo,isbn);
        //se llama el metodo de ingresar al inicio de la lista que tiene dentro los datos de la clase 'Libro
        insertarFinal(ingresofinal);
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto para otro ingreso
        LimpiarTextFields();
    }//GEN-LAST:event_PushActionPerformed

    private void btn_Borrar_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Borrar_ListaActionPerformed
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //se llama al metodo para eliminar toda la lista
        EliminarPila();
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto en caso se quiso escribir algo en las cajas de texto
        LimpiarTextFields();
    }//GEN-LAST:event_btn_Borrar_ListaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarListaTOP();
        //llamado metodo de igualacion de variables a textfields
        IgualacionVariables();
        TOP();       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminar_Ultimo_DatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_Ultimo_DatoActionPerformed

        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //se llama al metodo que elimina los datos en la ultima posicion de la lista
        eliminarUltimo();
        //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto en caso se quiso escribir algo en las cajas de texto
        LimpiarTextFields();

    }//GEN-LAST:event_btnEliminar_Ultimo_DatoActionPerformed

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
    private javax.swing.JButton Push;
    private javax.swing.JTable Tbl_Lista;
    private javax.swing.JTable Tbl_TOP;
    private javax.swing.JButton btnEliminar_Ultimo_Dato;
    private javax.swing.JButton btn_Borrar_Lista;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Autor;
    private javax.swing.JLabel lbl_Isbn;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}
