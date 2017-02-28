/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ordenacion {
    /*En este metodo se hace la ordenacion del grafo de menos a mayor y 
    se llama al metodo de kruskal para su ejecucion
    */
    public static List<String> ordena(Map mapa, Grafo G){ 
        int i=0;
        //Para ordenarlo, dividimos el mapa entre sus key y sus valores
        String Llaves[]=new String[mapa.size()];
        int valores[]=new int[mapa.size()];
        //Iteramos el mapa y vamos rellenando los arrays
        Iterator it = mapa.entrySet().iterator();
        while(it.hasNext()){
            
            Map.Entry elemento = (Map.Entry) it.next();
            
            Llaves[i]=(String) elemento.getKey();
            valores[i]=(int) elemento.getValue();
            i++;
            
        }
        //Llamamos al metodo de ordenacion intparejas para ordenar los vectores
        //Se ordenan los dos a la vez para no perder el orden de los datos
        intparejas(Llaves, valores,valores.length);
        List<String> a = KKruskal.Kruskal(G,mapa,Llaves,valores);
        return a;
         
    }
    public static int intparejas(String[] a, int[] b, int n){
        /*Metodo auxiliar encargado de ordenar los arrays de datos del grafo*/
        boolean cambio;
        int aux1;
        String aux2;
        for (int j = 0; j <= n; j++) {
            cambio = false;
            for (int i =((j+1)%2); i <n-1 ; i=i+2) {       
                if(b[i] > b[i+1]){
                    aux1=b[i+1];
                    aux2=a[i+1];
                    b[i+1]=b[i];
                    a[i+1]=a[i];
                    b[i]=aux1;
                    a[i]=aux2;
                    cambio=true;
                }          
            }
            if(cambio==false && j>1){
                return 0;
            }
        }
        return 0;
    }
}
