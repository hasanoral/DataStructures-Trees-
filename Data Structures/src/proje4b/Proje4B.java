
package proje4b;

import java.util.*; 
import java.lang.*; 
import java.io.*; 




class MST{
    
     
    private static final int V = 5; 
  
    
    int minKey(int key[], Boolean mstSet[]) 
    { 
        
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    
    void printMST(int parent[], int graph[][]) 
    { 
        System.out.println("Köşe \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
    } 
  
    
    void primMST(int graph[][]) 
    { 
        
        int parent[] = new int[V]; 
  
         
        int key[] = new int[V]; 
  
         
        Boolean mstSet[] = new Boolean[V]; 
  
        
        for (int i = 0; i < V; i++) { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
         
        key[0] = 0;  
        parent[0] = -1; 
  
        
        for (int count = 0; count < V - 1; count++) { 
            
            int u = minKey(key, mstSet); 
  
             
            mstSet[u] = true; 
  
            
            for (int v = 0; v < V; v++) 
  
                
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
         
        printMST(parent, graph); 
    }
    
    
}

public class Proje4B {

    public static int INFINITY = 1000;
    public static void main(String[] args) {
        // TODO code application logic here
         RedBlackTree t = new RedBlackTree( );
        final int NUMS = 400000;
        final int GAP  =  35461;
         
        System.out.println( "KONTROL EDİLİYOR... (BAŞKA OUTPUT YOK YANİ BAŞARILI)" );
         
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( new Integer( i ) );
         
        if( ((Integer)(t.findMin( ))).intValue( ) != 1 ||
                ((Integer)(t.findMax( ))).intValue( ) != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );
         
        for( int i = 1; i < NUMS; i++ )
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i )
                System.out.println( "Find error1!" );
        
        System.out.println("-----------------------------------------------------------------------------");
        
        int N=5;
        int[][] cost	= {
   		{ 1000,    5,    3, 1000,    2},
   		{ 1000, 1000,    2,    6, 1000},
   		{ 1000,    1, 1000,    2, 1000},
   		{ 1000, 1000, 1000, 1000, 1000},
   		{ 1000,    6,   10,    4,    8}  };
   
   	int distances[] = new int[N];
   
   	Distance(N, cost, distances);
   
        for (int i=0; i<distances.length; ++i)
            System.out.println(distances[i]);
        
        
        System.out.println("-----------------------------------------------------------------------------");
        MST mst = new MST(); 
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } }; 
  
        // Print the solution 
        mst.primMST(graph); 
        System.out.println("-----------------------------------------------------------------------------");
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("GENİŞLİK İÇİN İLK GEÇİŞ "+ 
                           "(KÖŞE 2'DEN BAŞLAYARAK)"); 
  
        g.BFS(2); 
     
    }     
    public static void Distance(int N, int[][] cost, int[] D)
{

int w, v, min;

boolean visited[] = new boolean[N];

D[0] = 0;
for(v=1; v<N; v++) {
  visited[v] = false;
  D[v] = cost[0][v];
};

for(int i=1; i<N; ++i)
{
  	min = INFINITY;
  	for(w=1; w<N; w++)
  	  if(!visited[w])
  	    if(D[w]<min) {
  	    	v = w;
  	    	min = D[w];
  	    }

  	visited[v] = true;

  	for(w=1; w<N; w++)
	  if(!visited[w])
	    if(min+cost[v][w] < D[w])
	      D[w] = min + cost[v][w];  	
}
}
}
