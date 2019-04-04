/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alumno
 */
public class Menu extends javax.swing.JFrame {

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
     
    
    
    public Menu() {
        
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
            posicion=txtPosicion.getText();
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
            txtPosicion.setText("");
            
        }
        //metodo que verifica si lo ingresado en el txtPosicion es un numero o si esta vacio
        public static boolean Numero(String Posicion) {
        boolean resultado;
        try {
            Integer.parseInt(Posicion);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
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
        
      
           
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jButton2 = new javax.swing.JButton();
        btnEliminar_Primer_Dato = new javax.swing.JButton();
        btnEliminar_Ultimo_Dato = new javax.swing.JButton();
        btn_Borrar_Lista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPosicion = new javax.swing.JLabel();
        txtPosicion = new javax.swing.JTextField();
        btnPosicion_Siguiente = new javax.swing.JButton();
        btn_Borrar_Posicion = new javax.swing.JButton();

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

        jButton1.setText("Ingresar Inicio Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ingresar Final Lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnEliminar_Primer_Dato.setText("Eliminar Primer Dato Lista");
        btnEliminar_Primer_Dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_Primer_DatoActionPerformed(evt);
            }
        });

        btnEliminar_Ultimo_Dato.setText("Eliminar Ultimo Dato Lista");
        btnEliminar_Ultimo_Dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_Ultimo_DatoActionPerformed(evt);
            }
        });

        btn_Borrar_Lista.setText("Borrar Lista");
        btn_Borrar_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Borrar_ListaActionPerformed(evt);
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
                    .addComponent(btn_Borrar_Lista)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEliminar_Ultimo_Dato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar_Primer_Dato, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Autor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar_Primer_Dato)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Titulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar_Ultimo_Dato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Isbn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar_Lista)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblPosicion.setText("Posición Actual Lista");

        btnPosicion_Siguiente.setText("Ingresar en Posicion Siguiente Lista");
        btnPosicion_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosicion_SiguienteActionPerformed(evt);
            }
        });

        btn_Borrar_Posicion.setText("Borrar Posicion Lista");
        btn_Borrar_Posicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Borrar_PosicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPosicion)
                        .addGap(26, 26, 26)
                        .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btn_Borrar_Posicion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addComponent(btnPosicion_Siguiente)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosicion)
                    .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btn_Borrar_Posicion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPosicion_Siguiente)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(19, 19, 19))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void btnPosicion_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosicion_SiguienteActionPerformed
        
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //llamado metodo de igualacion de variables a textfields 
        IgualacionVariables();
        //se agregan los 3 datos anteriores a la clase 'Libro' por medio de 'ingreso'
        Libro ingreso_pos_siguiente= new Libro(autor,titulo,isbn); 
        //se declara una variable tipo booleana y se iguala al metodo numero 
        boolean Numero = Numero(posicion);
        //condicion de si numero es un numero en la variable de caracter posicion
        if (Numero==true) { 
            IntPosicion = Integer.parseInt(posicion);
            insertarDespues(IntPosicion, ingreso_pos_siguiente);
        }else{
            JOptionPane.showMessageDialog(rootPane, "No ha Ingresado Un Numero Valido", "ERROR", HEIGHT);
        }
         //se muestran los datos en la tabla
        Mostrar();
        //se limpian las cajas de texto para otro ingreso
        LimpiarTextFields();
        
        
    }//GEN-LAST:event_btnPosicion_SiguienteActionPerformed

    private void btn_Borrar_PosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Borrar_PosicionActionPerformed
        //se llama al metodo para limpiar la lista y no se sobreescriban los datos
        LimpiarLista();
        //llamado metodo de igualacion de variables a textfields 
        IgualacionVariables();
        //se agregan los 3 datos anteriores a la clase 'Libro' por medio de 'ingreso'
        boolean Numero = Numero(posicion);
         //condicion de si numero es un numero en la variable de caracter posicion
        if (Numero==true) {
            IntPosicion = Integer.parseInt(posicion);
            eliminarLibro(IntPosicion);
        }else{
            JOptionPane.showMessageDialog(rootPane, "No ha Ingresado Un Numero Valido", "ERROR", HEIGHT);
        }   
        //se muestran los datos en la tabla
        Mostrar();
         //se limpian las cajas de texto para otro ingreso
        LimpiarTextFields();
        
    
    }//GEN-LAST:event_btn_Borrar_PosicionActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tbl_Lista;
    private javax.swing.JButton btnEliminar_Primer_Dato;
    private javax.swing.JButton btnEliminar_Ultimo_Dato;
    private javax.swing.JButton btnPosicion_Siguiente;
    private javax.swing.JButton btn_Borrar_Lista;
    private javax.swing.JButton btn_Borrar_Posicion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPosicion;
    private javax.swing.JLabel lbl_Autor;
    private javax.swing.JLabel lbl_Isbn;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtPosicion;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}
