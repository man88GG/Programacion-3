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
/**
 * Interfaz para arboles binarios de busqueda
 * @author Amparo Lopez Gaona
 * @version 1a. ed.
 */
public interface ArbolBuscable {
    /**
     * Metodo para determinar si un arbol esta o no vacio.
     * @return boolean -- true si el arbol esta vacio y false en otro caso.
     */
  public boolean estaVacio();

    /**
     * Metodo para eliminar todos los elementos de un arbol
     */
  public void vaciar();

    /**
     * Metodo para conocer el tamano de un arbol
     * @return int -- cantidad de elementos en el arbol
     */
  public int tamanio();

    /**
     * Metodo para introducir un elemento en el arbol
     * @param elem -- elemento a introducir en el arbol
     */
  public void agregar(Object elem); 

    /**
     * Metodo para determinar si un elemento esta en el arbol
     * @param elem -- elemento a buscar en el arbol
     * @return boolean -- true si el arbol contiene el elemento y false en otro caso
     */
  public boolean contiene(Object elem);

    /**
     * Metodo para eliminar el elemento del arbol
     */
  public void eliminar(Object elem);
}
