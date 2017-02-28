/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.Map;
import java.util.TreeMap;

public class Grafo {
    int nVertices;
    boolean adyacencia[][];
    int costes[][];
    int Aristas=0;
    
    public int NumAristas(){
        return Aristas;
    }
    public boolean conectados (int i, int j){
        return adyacencia[i][j];
    }
    public int Nvertices(){
        return nVertices;
    }
    
    public int coste(int i, int j){
        return costes[i][j];
    }
    
    public Grafo(int nVertices) {
        this.nVertices=nVertices;
        adyacencia = new boolean [nVertices][nVertices];
        costes =new int[nVertices][nVertices];
        
        for(int i=0; i<nVertices; i++){
            for(int j=0; j<nVertices;j++){
                adyacencia[i][j]=false;
                costes[i][j]=Integer.MAX_VALUE;
            }
        }
    }
    
    public void conectar(int i , int j, int coste){
        adyacencia[i][j]=true;
        adyacencia[j][i]=true;
        costes[i][j] = coste;
        costes[j][i] = coste;
        Aristas++;
    }
    
    public void desconectar(int i, int j){
        adyacencia[i][j]=false;
        adyacencia[j][i]=false;
        costes[i][j] = Integer.MAX_VALUE;
        costes[j][i] = Integer.MAX_VALUE;
        Aristas--;
    }    
    
    public Map<String, Integer> CreaMapa(){
        Map<String, Integer> nombreMap = new TreeMap<>();
        for (int i = 1; i < Nvertices(); i++) {
            for (int j = 1; j <= i; j++) {
                nombreMap.put(i+","+j, costes[i][j]);  
            }
        }
        return nombreMap;
    }
}    
