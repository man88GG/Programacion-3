/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    
    public ArbolBB() {
        raiz = null;
    }
    
    
     public int Verificacion(Nodo equ){
        //verificacion si equ esta vacio 
        if(equ==null){
            //se devuelve un valor -1
            return -1;
        
        }else{
            //se retorna equilibrado
            return equ.equilibrado;
        }//fin else 
    }//fin Verificacion
     
    //Metodo para rotacion a la izquierda
    public Nodo rotarIzq(Nodo i){
        //se crea un nodo auxiliar que se igualara al nodo izquierdo
        Nodo aux= i.izq;
        //nodo izquierdo se iguala a la parte derecha del auxr
        i.izq=aux.der;
        //la parte derecha de aux se iguala a i 
        aux.der=i;
         //se obtiene el valor de equilibrio maximo del nodo i entre la derecha y la izqueirda
        i.equilibrado=Math.max(Verificacion(i.izq), Verificacion(i.der))+1;
        //se obtiene el valor máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.equilibrado=Math.max(Verificacion(aux.izq),Verificacion(aux.der))+1;
        //se retorna aux
        return aux;
    }//fin rotarIzq
    //método para rotacion a la derecha
    
    public Nodo rotarDer(Nodo d){
        //se crea un nodo auxiliar que se igualara al nodo derecho
        Nodo aux= d.der;
        //nodo derecho se iguala a la parte izquierda del aux
        d.der=aux.izq;
        //la parte izquierda del nodo aux se iguala a d
        aux.izq=d;
        //se obtiene el valor de equilibrio maximo del nodo d entre la derecha y la izqueirda
        d.equilibrado=Math.max(Verificacion(d.izq), Verificacion(d.der))+1;
         //se obtiene el valor máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.equilibrado=Math.max(Verificacion(aux.izq),Verificacion(aux.der))+1;
        //se retorna aux
        return aux;
    }//fin rotarDer
    
    //Metodo de Rotacion doble a la izquierda
    public Nodo rotacionDobleIzq(Nodo rdi){
        //creacion del nodo aux
        Nodo aux;
        //la parte izquierda de rdi se iguala al resultado del metodo "rotarDer" con los parametros del lado izquierdo de rdi
        rdi.izq=rotarDer(rdi.izq);
        //aux se iguala al resultado del método "rotarIzq" del nodo rdi
        aux=rotarIzq(rdi);
        //se retorna aux
        return aux;
    }//fin rotacionDobleIzq
    
    //Metodo de Rotacion doble a la derecha
    public Nodo rotacionDobleDer(Nodo rdd){
        //se crea nodo aux
        Nodo aux;
        //la parte izquierda de rdi se iguala al resultado del metodo "rotarIzq" con los parametros del lado derecho de rdd
        rdd.der=rotarIzq(rdd.der);
        //aux se iguala al resultado del metodo "rotarDer" del nodo rdd
        aux=rotarDer(rdd);
        //se retorna aux
        return aux;
    }//fin rotacionDobleDer
    
    //metodo para insertar las rotaciones en la grafica
    public Nodo InsertarRot(Nodo nuevo, Nodo actual){
        //se crea nodo auxiliar y se iguala al nodo actual
        Nodo auxiliar=actual;
        //condicion si el valor del nodo nuevo es menor al valor del nodo actual
         if(nuevo.dato<actual.dato){
             //verificacion si el nodo en la parte izquierda tiene algun dato
            if(actual.izq==null){
                //se ingresa nuevo en la parte izquierda de actual
                actual.izq=nuevo;
           
            }else{
                //igualacion de la parte izquierda de actual con el metodo InsertarRot teniendo de parametros el valor de nuevo y el valor de actual en la parte izquierda
                actual.izq=InsertarRot(nuevo, actual.izq);
                //verificacion si la suma del lado izquierdo y derecho del nodo es igual a 2 para el equilibrio del arbol
                if(Verificacion(actual.izq)-Verificacion(actual.der)==2){
                    //verificacion si el dato del nodo nuevo es menor al dato del nodo actual en la parte izquierda
                    if(nuevo.dato<actual.izq.dato){
                        //auxiliar se iguala al resultado del metodo "rotarIzq"
                        auxiliar=rotarIzq(actual);
                        
                    }else{
                        //auxiliar se iguala al resultado del metodo "rotacionDobleIzq"
                        auxiliar=rotacionDobleIzq(actual);
                    }//fin else
                }//fin if
            }//fin else
            //verificacion si dato en el nodo nuevo es menor al dato en el nodo actual
         }else if(nuevo.dato>actual.dato){
             //verificacion si la parte derecha de actual no tiene ningun dato
            if(actual.der==null){
                //la parte derecha de actual se igualara a nuevo
                actual.der=nuevo;
           
            }else{
                //la parte derecha de actual se iguala al resultado del metodo "InsertarRot" y tendra como parametros el valor de nuevo y la parte derecha de actual
                actual.der=InsertarRot(nuevo,actual.der);
                //verificacion si el resultado de la suma del lado izquierdo y derecho de actual es igual a 2 para el equilibrio
                if(Verificacion(actual.der)-Verificacion(actual.izq)==2){
                    //verificacion si el dato de nuevo es mayor al dato en la parte derecha de actual
                    if(nuevo.dato>actual.der.dato){
                        //auxiliar se iguala al resultado del metodo rotarDer
                        auxiliar=rotarDer(actual);
                    }else{           
                        //auxiliar se iguala al resultado del metodo rotacionDobleDer
                        auxiliar=rotacionDobleDer(actual);
                    }//fin else
                }//fin if
            }//fin else
         
         }else{
             
          //mensaje en caso se ingresen nodos duplicados
            JOptionPane.showMessageDialog(null,"El Nodo ingresado es un Duplicado de un nodo Anterior");
         }//fin else
         
         //verificacion si la parte izquierda de actual esta vacia y la parte derecha no lo esta
         if((actual.izq==null)&&(actual.der!=null)){
             //equilibrado sera igual al equilibrado en la parte derecha de actual + 1
            actual.equilibrado=actual.der.equilibrado+1;
     
        //verificacion si la parte izquierda de actual no esta vacia y la parte derecha si
         }else if((actual.der==null)&&(actual.izq!=null)){        
             //el equilibrado es igual al equilibrado en la parte izquierda de actual + 1
            actual.equilibrado=actual.izq.equilibrado+1;   
           
         }else{
             //en caso ninguna de las 2 condiciones anteriores se cumpla
             //equilibrado sera igual al valor maximo de la igualacion entre la parte izquierda y derecha de actual 
            actual.equilibrado=Math.max(Verificacion(actual.izq),Verificacion(actual.der))+1;         
         }
         //retorna auxuliar
         return auxiliar;
    }//fin InsertarRot
    
    
    //Metodo para insertar un dato en el arbol
  public boolean insertar(int d){
        Nodo nuevo= new Nodo(d,null,null);
        //ciclo de verificacion si la raiz esta vacia
        if(raiz==null){
            //se ingresa el nodo nuevo en la raíz
            raiz=nuevo;
            
        }else{
       
            //si la raiz no esta vacia se inserta en el metodo InsertarRot teniendo de parametros "nuevo" y "raiz"
            raiz=InsertarRot(nuevo,raiz);
        }
        //devuelve verdadero
        return true;
    }//fin insertar
  
  
    //metodo para obtener la raiz del arbol binario
    public Nodo getRaiz() {
        return raiz;
    }
    //metodo para colocar un nodo como raiz del arbol binario
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    //metodo que verifica si el nodo aux esta vacio y coloca los nodos hijos en su respectivo preorden
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    //metodo que verifica si el nodo aux esta vacio y coloca los nodos hijos en su respectivo inorden
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }
    
    
    
    
//metodo para obtener la altura del lado izquierdo y derecho del arbol
    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
     
     public void RSD(Nodo aux, LinkedList recorrido){
         int i=0,D,C;
         
          //nodos no se pueden igualar, raices izq,der,centro
          
         
     }
 
}
