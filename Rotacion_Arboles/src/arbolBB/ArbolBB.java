/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

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
    
    
     public int obtenerfe(Nodo r){
        //si el nodo esta vacío devuelve -1
        if(r==null){
            return -1;
        //si no está vacío devuelve el equilibrado
        }else{
            return r.equilibrado;
        } 
    }
     
    
      public Nodo rotacionIzq(Nodo r){
        //se hace un nodo auxiliar que se iguala al nodo izquierdo
        Nodo aux= r.izq;
        //nodo izquierdo se iguala a la parte derecha del nodo auxiliar
        r.izq=aux.der;
        //la parte derecha del nodo auxiliar se iguala al nodo mandado al método
        aux.der=r;
        //se  equilibra máximo del nodo r entre la parte derecha e izquierda
        r.equilibrado=Math.max(obtenerfe(r.izq), obtenerfe(r.der))+1;
        //se equilibra máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.equilibrado=Math.max(obtenerfe(aux.izq),obtenerfe(aux.der))+1;
        //devuelve auxiliar
        return aux;
    }
    //método para rotar el nodo a la izquierda
    public Nodo rotacionDer(Nodo r){
        //se hace un nodo auxiliar que se iguala al nodo derecho
        Nodo aux= r.der;
        //nodo derecho se iguala a la parte izquierda del nodo auxiliar
        r.der=aux.izq;
        //la parte izquierda del nodo auxiliar se iguala al nodo mandado al método
        aux.izq=r;
        //se saca el equilibrio máximo del nodo r entre la parte derecha e izquierda
        r.equilibrado=Math.max(obtenerfe(r.izq), obtenerfe(r.der))+1;
        //se saca el equilibrio máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.equilibrado=Math.max(obtenerfe(aux.izq),obtenerfe(aux.der))+1;
        //devuelve auxiliar
        return aux;
    }
    //método para rotar doblemente el nodo a la izquierda
    public Nodo rotacionDobleIzq(Nodo r){
        //se crea nodo auxiliar
        Nodo aux;
        //la parte izquierda del nodo r se iguala al resultado de llamar al método de rotar a la derecha
        //mandando de parámetro el lado izquierdo del nodo r
        r.izq=rotacionDer(r.izq);
        //el nodo auxiliar se iguala al resultado de llamar al método de rotar a la izquierda del nodo r
        aux=rotacionIzq(r);
        //devuelve auxiliar
        return aux;
    }
    public Nodo rotacionDobleDer(Nodo r){
        //se crea nodo auxiliar
        Nodo aux;
        //la parte derecha del nodo r se iguala al resultado de llamar al método de rotar a la izquierda
        //mandando de parámetro el lado derecho del nodo r
        r.der=rotacionIzq(r.der);
        //el nodo auxiliar se iguala al resultado de llamar al método de rotar a la derecha del nodo r
        aux=rotacionDer(r);
        //devuelve auxiliar
        return aux;
    }
    public Nodo insertAVL(Nodo nuevo, Nodo actual){
        //se crea nodo auxiliar y se iguala a 
        Nodo auxiliar=actual;
        //si el dato del nodo nuevo es menor al dato del nodo actual
         if(nuevo.dato<actual.dato){
             //si el nodo actual no tiene parte izquierda entonces se inserta el nodo
             //nuevo en la parte izquierda del nodo actual
            if(actual.izq==null){
                actual.izq=nuevo;
            //sino
            }else{
                //la parte izquierda del nodo actual se iguala al resultado de llamar el método de insertarAVL
                //mandando como parámetro el valor nuevo y la parte izquierda del nodo actual
                actual.izq=insertAVL(nuevo, actual.izq);
                //si el equilibrio de el lado izquierdo con el derecho es igual a 2
                if(obtenerfe(actual.izq)-obtenerfe(actual.der)==2){
                    //si el dato del nodo nuevo es menor al dato de la parte izquierda del nodo actual
                    if(nuevo.dato<actual.izq.dato){
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación de izquierda
                        auxiliar=rotacionIzq(actual);
                    }else{
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación doble de izquierda
                        auxiliar=rotacionDobleIzq(actual);
                    }
                }
            }
            //si el dato del nodo nuevo es menor al dato del nodo actual
         }else if(nuevo.dato>actual.dato){
             //si el nodo actual no tiene parte derecha entonces se inserta el nodo
             //nuevo en la parte derecha del nodo actual
            if(actual.der==null){
                actual.der=nuevo;
            //sino
            }else{
                //la parte derecha del nodo actual se iguala al resultado de llamar el método de insertarAVL
                //mandando como parámetro el valor nuevo y la parte derecha del nodo actual
                actual.der=insertAVL(nuevo,actual.der);
                //si el equilibrio de el lado derecho con el izquierdo es igual a 2
                if(obtenerfe(actual.der)-obtenerfe(actual.izq)==2){
                    //si el dato del nodo nuevo es mayor al dato de la parte derecha del nodo actual
                    if(nuevo.dato>actual.der.dato){
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación de derecha
                        auxiliar=rotacionDer(actual);
                    }else{
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación doble de derecha
                        auxiliar=rotacionDobleDer(actual);
                    }
                }
            }
            //de lo contrario se muestra de que no se pueden colocar nodos duplicados
         }else{
            System.out.println("Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura
         //si la parte izquierda del nodo actual está vacía y la parte derecha del nodo actual no está vacía
         if((actual.izq==null)&&(actual.der!=null)){
             //el equilibrio es igual al equilibrio de la parte derecha del nodo actual +1
            actual.equilibrado=actual.der.equilibrado+1;
        //si la parte derecha del nodo actual está vacía y la parte izquierda del nodo actual no está vacía
         }else if((actual.der==null)&&(actual.izq!=null)){
             //el equilibrio es igual al equilibrio de la parte izquierda del nodo actual +1
            actual.equilibrado=actual.izq.equilibrado+1;         
         }else{
             //el equilibrio es igual valor máximo del valor de equilibrio entre la parte izquierda y la parte derecha
            actual.equilibrado=Math.max(obtenerfe(actual.izq),obtenerfe(actual.der))+1;         
         }
         //devuleve auxiliar
         return auxiliar;
    }
    
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
  public boolean insertar(int d){
        Nodo nuevo= new Nodo(d,null,null);
        //si la raiz esta vacía
        if(raiz==null){
            //se ingresa el nodo nuevo en la raíz
            raiz=nuevo;
        }else{
            //sino en la raiz se inserta lo obtenido de llamar el método de insertarAVL mandando como parámetro el 
            //valor nuevo y la raiz
            raiz=insertAVL(nuevo,raiz);
        }
        //devuelve verdadero
        return true;
    }
    //método para obtener la raíz del arbol
    
    
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
