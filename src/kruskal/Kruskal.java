/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;
    import java.util.List;
import java.util.Map;
public class Kruskal {




  
    public static void main(String[] args) {
        Grafo A = new Grafo(10); // Inicializamos el número de nodos del grafo.
        
        // Insertamos los vertices con sus aristas correspondientes
        A.conectar(1,2,4);
        A.conectar(1,8,9);
        A.conectar(2,8,11);
        A.conectar(2,3,9);
        A.conectar(8,9,7);
        A.conectar(8,7,1);
        A.conectar(3,9,2);
        A.conectar(3,4,7);
        A.conectar(3,6,4);
        A.conectar(9,7,6);
        A.conectar(4,5,10);
        A.conectar(4,6,15);
        A.conectar(5,6,11);
        A.conectar(6,7,2);

        Map<String, Integer> mapa = A.CreaMapa();
        List<String> a = ordenacion.ordena(mapa, A);
        
        System.out.println("El camino mínimo de kruskal es el formado por los nodos: ");
        System.out.println(a);
        
        boolean T1 = TestKruskal.Test1(a, A);
        boolean T2 = TestKruskal.Test2(A, mapa, a);
        boolean T3 = TestKruskal.Test3(A);
        boolean T4 = TestKruskal.Test4(mapa ,a, A.Nvertices()-1);
        
        if(T1 == true || T2 == true || T3 == true || T4 == true){
            System.out.println("ERROR , No es el MNT");
        } else {
            System.out.println("Todas las prubas realizadas han concluido exitosamente.");
        }
        
    }  
}
   
