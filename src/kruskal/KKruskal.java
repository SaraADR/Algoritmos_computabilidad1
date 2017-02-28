/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KKruskal {
    /*Algoritmo de kruskal encargado de encontrar el MNT */
    public static List<String> Kruskal(Grafo G, Map mapa, String[] keys, int[] valores) {
        /* Le pasamos el grafo principal, el mapa con los datos y los arrays ordenados*/
        int t=0;
        List<String> a = new ArrayList<>(); //Se va guardando la solucion aqui
        int n = G.Nvertices();
        int Cvert[]=new int[n];
        Inicializa(Cvert, n);
            
        while( a.size() < n-2){
            /*Con este if nos eliminamos los no conectados del grafo, si hemos
            llegado a ahi al estar ordenado, es que hemos terminado*/
            if(valores[t] == Integer.MAX_VALUE){
                System.out.println(a);
                return a;
            }
            String UV = keys[t];
            t++;
            /* Separamos nuestro string de la key para buscar cada arista por separado*/
            int U= Integer.parseInt(UV.split(",")[0]);
            int V= Integer.parseInt(UV.split(",")[1]);
            int uconj= Buscar(Cvert, n, U);
            int vconj= Buscar(Cvert, n , V); 
            if(uconj != vconj){
                Fusionar(Cvert, n, uconj, vconj);
                a.add(UV);
            }
          
        }
        
        return a;
        
    }
    
    public static void Inicializa( int conjunto[] ,int n){
        for (int i = 0; i <= n-1; i++) {
            conjunto[i]=0;   
        }
        
    }
    
    public static int Buscar(int conjunto[], int n, int conj){
        int i = conj;
        while(conjunto[i]>0){
            i=conjunto[i];
        }
        return i;
    }
    
    public static void Fusionar (int conjunto[], int n, int a, int b){
        
        if (conjunto[a]==conjunto[b]){
            conjunto[a]=conjunto[a]-1;
            conjunto[b]=a;
        }else{
            if(conjunto[a]< conjunto[b]){
                conjunto[b]=a;
            }else{
                conjunto[a]=b;
            }
        }   
    }
}
