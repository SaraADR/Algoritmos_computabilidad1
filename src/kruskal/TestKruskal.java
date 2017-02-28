/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestKruskal {
    /*En todos los test, si el resultado es verdadero, significa que ha fallado*/
    public static boolean Test1 (List<String> a, Grafo b){ 
        /* La primera prueba de que se haya el MST es que el numero de aristas
        sea en una unidad inferior al numero de vertices
        */
        
        if (a.size() == b.Nvertices()-2) return false; // es menos dos debido a la implementacion del grafo  
        return true; 
    }
    
    public static boolean Test2 ( Grafo grafo, Map A, List resultado){
        /*Comprobar que es un grafo no orientado antes de hacer kruskal*/

        Iterator it = A.entrySet().iterator();
        while(it.hasNext()){
            
            Map.Entry elemento = (Map.Entry) it.next();
            String key = (String) elemento.getKey();
            int valor = (int) elemento.getValue();
            int U= Integer.parseInt(key.split(",")[0]);
            int V= Integer.parseInt(key.split(",")[1]);
           
            if(valor != Integer.MAX_VALUE){
                if(grafo.conectados(V, U)!= true && grafo.conectados(U, V)!=true){
                    return true;
                }
 
            }
        }
        return false;
    }
    
    public static boolean Test3 (Grafo G){
        /*Comprobar que no hay ciclos una vez completado kruskal*/
        /*Para ello primero tenemos que comprobar que ninguno este relacionado
        con si mismo */
        
        for(int i=0; i<G.Nvertices()-1 ; i++){
            if(G.conectados(i, i)) return true;
        }
        
        return false;
    }
     
    public static boolean Test4 ( Map mapa, List solucion , int nAristas){
        /*Comprobar que todas las aristas esten conectadas. que no haya ningun
        nodo suelto ni en el grafo principal ni en el grafo solucion
        */
        for (int i = 0; i < nAristas; i++) {
            Set e = mapa.keySet();
            boolean index = false;
            for (int j= 1; j <= nAristas; j++) {
            for (Object elemento : e) {
                String union = (String) elemento;
                int U= Integer.parseInt(union.split(",")[0]);
                int V= Integer.parseInt(union.split(",")[1]);
                if (j == U || j ==V){
                    index = true;
                    break;
                }
            }
            if(index == false && j != nAristas)return true;
            if(index == true){
                index=false; 
            }  
            }   
        }
        
        boolean index = false;
        for (int j= 1; j <= nAristas; j++) {
            for (Object elemento : solucion) {
                String union = (String) elemento;
                int U= Integer.parseInt(union.split(",")[0]);
                int V= Integer.parseInt(union.split(",")[1]);
                if (j == U || j ==V){
                    index = true;
                    break;
                }
            }
            if(index == false && j != nAristas)return true;
            if(index == true){
                index=false; 
            }  
        }
        
       return false;
    }
  
}
