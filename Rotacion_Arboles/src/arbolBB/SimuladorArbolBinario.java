
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class SimuladorArbolBinario {
    
   ArbolBB miArbol = new ArbolBB();
    public SimuladorArbolBinario() {
    }

    public boolean insertar(Integer dato) {
        return (this.miArbol.insertar(dato));
    }
    
    //metodos para mostrar los 3 diferentes recorridos del arbol
    //Recorrido PreOrden
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }
    //Recorrido InOrden
    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }
    //Recorrido PostOrden
    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }
    
    //metodo que guarda el orden de los datos dependiendo el recorrido en una variable
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "";
            i++;
        }
        return (r);
    }
   
    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
