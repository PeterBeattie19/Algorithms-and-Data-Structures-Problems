import java.util.*; 
import java.io.*; 

public class MaximumFlow {
    public static void main (String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        String line[] = br.readLine().split(" "); 

        int n = Integer.parseInt(line[0]); 
        int m = Integer.parseInt(line[1]);
        int s = Integer.parseInt(line[2]);
        int t = Integer.parseInt(line[3]);

        int graph[][] = new int[n][n]; 

        for(int i = 0; i<m; i++){
            line = br.readLine().split(" "); 
            int u = Integer.parseInt(line[0]); 
            int v = Integer.parseInt(line[1]);
            int flow = Integer.parseInt(line[2]);

            graph[u][v] = flow; 
        }

        int result[][] = fordFulkerson(graph,s,t); 

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
               /* if(graph[i][j] != 0 && result[i][j] != 0)
                    System.out.println(i +" "+ j +" "+ result[i][j]); */
                    System.out.print(result[i][j] +" "); 
            }
            System.out.println(); 
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
               /* if(graph[i][j] != 0 && result[i][j] != 0)
                    System.out.println(i +" "+ j +" "+ result[i][j]); */
                    System.out.print(graph[i][j] +" "); 
            }
            System.out.println(); 
        }

    }
    // Returns tne maximum flow from s to t in the given graph
    public static int[][] fordFulkerson(int graph[][], int s, int t){

        int u, v;
        int V = graph.length; 
 
        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph
 
        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
 
        // This array is filled by BFS and to store path
        int parent[] = new int[V];
 
        int max_flow = 0;  // There is no flow initially
 
        // Augment the flow while tere is path from source
        // to sink
        while (bfs(rGraph, s, t, parent))
        {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
 
            // update residual capacities of the edges and
            // reverse edges along the path
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
 
            // Add path flow to overall flow
            max_flow += path_flow;
        }
 
        // Return the overall flow
        return rGraph;
    }

    public static boolean bfs(int rGraph[][], int s, int t, int parent[]){

        // Create a visited array and mark all vertices as not
        // visited
        int V = rGraph.length;

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
 
        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
 
        // Standard BFS Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();
 
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
 
        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }
} 