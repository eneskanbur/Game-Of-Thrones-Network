package gameofthronesnetwork;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphMatrix {
    LinkedList<Integer> adjacencyList[];
    int edges[][]; // can be anything, but int vertices handy
    // can be double if there are double weigths
    int numV;
    int numE;
    
    
    /**
     * @param V
     */
    public GraphMatrix(int V) {
        this.numV = V;
        edges = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                edges[i][j] = 0;
            }
        }
    }
    
    
    public void addEdge(int from, int to, int weight) {
        edges[from][to] = weight;
        edges[to][from] = weight;
    }

    public boolean isAdjacent(int v1, int v2) {
        return (edges[v1][v2] != 0);
    }

    public int degree(int v) {
        int degree = 0;
        for (int i = 0; i < numV; i++) {
            degree += edges[v][i];
        }
        return degree;
    }
    
    public static int findMaxDegree(GraphMatrix g){
        int degree = 0;
        int maxDegreeVertex = 0;
        for (int i = 0; i < g.numV; i++) {
            System.out.println("Degree: "+g.degree(i));
            if(g.degree(i)>degree){
                degree = g.degree(i);
                maxDegreeVertex = i;
            }
        }
        return maxDegreeVertex;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                s.append(edges[i][j] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public static GraphMatrix readfromFile(String f) {
        // TODO code application logic here

        try {
            Scanner sc = new Scanner(new File(f));
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("constructing a graph of " + v + " vertices and "
                    + e + " edges ");
            GraphMatrix g1 = new GraphMatrix(v);
            for (int i = 0; i < e; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                g1.addEdge(v1, v2,1);
            }
            System.out.println("Loaded " + e + " edges ");
            return g1;

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    boolean isThereAPath(String name1, String name2, LinearProbingHash hash){
        LinearProbingHash<String> findHash = hash;
        boolean[] marked = new boolean[numV];
        int name1Hash = findHash.contains(name1);
        int name2Hash = findHash.contains(name2);
        
        if(edges[name1Hash][name2Hash] >0 ){
            return true;
        }else{
            return false;
        }
            
    }
    
    String shortestPath(String name1, String name2 ){
        LinearProbingHash<String> findHash = new LinearProbingHash(107);
        
        int dist[] = new int[V]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will be true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist);
	}
       
    
    public int bfs(String row, String col, boolean[][] visited, LinearProbingHash hash){
     marked[source] = true;
        Integer[] a = (Integer[]) g.neighborsArray(source);
        if (a.length == 0) {
            return;
        }
        // this is to work as a queue
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(source);
        while (!q.isEmpty()) {
            source = q.removeFirst();
            a = (Integer[]) g.neighborsArray(source);
            for (int i = 0; i < a.length; i++) {
                int w = a[i];
                if (!marked[w]) {
                    System.out.println(w + ".");
                    q.addLast(w);
                    marked[w] = true;
                    edgeTo[w] = source;
                    distTo[w] = distTo[source] + 1;
                }
            }
        }
        return 1;
    }
    
    public void dfs (String name1, String name2, LinearProbingHash hash, boolean m[], ArrayList<String> a){
        int temp1 = hash.contains(name1);
        ArrayList<String> traversal = a;//new ArrayList<>();
        boolean[] marked = m;        
        marked[temp1] = true;
        
        System.out.println(name1);
        traversal.add(name1);
        for (int i = 0; i < edges.length; i++) {
            if(traversal.contains(name2)) break;
            if(hash.table[i].equals(name2) && isAdjacent(hash.contains(name2), temp1)){
                System.out.println(name2);
                traversal.add(name2);
                break;
            }
            else if (!marked[i] && edges[temp1][i]!=0 ) {
                dfs((String)hash.table[i], name2, hash, marked, traversal);
            }
        }
    }
}

