/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @author alumno
 */
public class NodoAvl {
     public Object valor;           //Valor que almacenado en el nodo
  public NodoAvl izquierda;      //Liga a la izquierda
  public NodoAvl derecha;        //Liga a la derecha
  public int altura;       

    /*
     * Constructor a partir de un valor
     * @param valor -- valor que se almacena en el nodo
     */
        NodoAvl(Object valor) {
            this(valor, null, null );
        }

    /*
     * Constructor a partir de un valor y ligas al hijo izquierdo y al derecho
     * @param valor -- valor que se almacena en el nodo
     * @param izquierdo -- referencia al hijo izquiero
     * @param derecho -- referencia al hijo derecho
     */
        NodoAvl( Object valor, NodoAvl izquierdo, NodoAvl derecho) {
	    this.valor = valor;
	    this.izquierda = izquierdo;
	    this.derecha = derecho;
            altura = 0;
        }
}
