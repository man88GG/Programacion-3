/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock_tienda;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author alumno
 */
public class Stock_Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Declaracion para generar numeros aleatorios
       Random Nombre_Prod = new Random();
       //Declaracion Matriz 
       String Matriz_stock[][]= new String[10][4];
       
       //Declaracion para las variables totales
      int Tot_Asociado,Tot_General=0,Subtotal=0;
    //Declaracion de la variable para el nombre del producto
    String Nom_Product="";
 
    String Resultados="";
 
    //Inicio primer ciclo for para las filas de la matriz
    for(int fila=0;fila<10;fila++){
          //Declaracion de variables e Igualacion a la Variable Nombre_Prod para generar los datos aleatorios necesarios
       int Tipo_Prod=Nombre_Prod.nextInt(10)+1;
       int Precio_Product=Nombre_Prod.nextInt(70)+1;
       int Cant_Stock=Nombre_Prod.nextInt(30)+1;
       
    //Inicio segundo ciclo for para las columnas de la matriz 
    for(int columna=0;columna<4;columna++){
  
   
    
    //Condicion switch para dar un valor tipo cadena a la variable Nom_Product
    switch(fila){
        
        case 1: {Nom_Product="Huevos    |";}break;
        case 2: {Nom_Product="Frijoles  |";}break;
        case 3: {Nom_Product="Arroz     |";}break;
        case 4: {Nom_Product="Leche     |";}break;
        case 5: {Nom_Product="Soda      |";}break;
        case 6: {Nom_Product="Jugo      |";}break;
        case 7: {Nom_Product="Jamon     |";}break;
        case 8: {Nom_Product="Salchicha |";}break;
        case 9: {Nom_Product="Tocino    |";}break;
        case 0: {Nom_Product="Harina    |";}break;  
    }
  
    //Calculo del total Asociado
    Tot_Asociado=Precio_Product*Cant_Stock; 
     
    //ciclo switch para guardado en columnas
    switch(columna){
        
        case 0:{Matriz_stock[fila][columna]=(Nom_Product);}break;
        case 1:{Matriz_stock[fila][columna]=String.valueOf(Precio_Product)+"\t |";}break;
        case 2:{Matriz_stock[fila][columna]=String.valueOf(Cant_Stock)+"\t  |";}break;
        case 3:{Matriz_stock[fila][columna]=String.valueOf(Tot_Asociado)+"\t|";}break;
    
    
    }//fin switch columna
   
    Subtotal+=Tot_Asociado;
    
        }//fin ciclo for columna
      
    }//fin ciclo for fila
    //4436
    
    //ciclos para guardar y luego mostrar la matriz
    for(int fila=0;fila<10;fila++){
        for(int columna=0;columna<4;columna++){
            
            Resultados+=Matriz_stock[fila][columna]+" ";
        }
        Resultados+="\n";
    }
    
    //Impresion en pantalla
    
    Tot_General=Subtotal/2;
    System.out.println("Producto  |"+"Precio|"+"Cantidad|"+"Tot.Asociado|");
    System.out.println(Resultados+"\n");
    System.out.println("Total General :" + Tot_General/2);
        
        
        
    }
    
}
