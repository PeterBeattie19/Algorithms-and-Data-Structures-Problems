import java.util.*; 
import java.io.*; 

public class SingleSourceShortestPathNegWeights {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		

		String line[] = br.readLine().split(" "); 

		int n = Integer.parseInt(line[0]); 
		int m = Integer.parseInt(line[1]);
		int q = Integer.parseInt(line[2]);
		int s = Integer.parseInt(line[3]);

		while(n != 0){
			@SuppressWarnings("unchecked") HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>(); 

			for(int i = 0; i<m; i++){
				line = br.readLine().split(" "); 
				int u = Integer.parseInt(line[0]); 
				int v = Integer.parseInt(line[1]);
				int w = Integer.parseInt(line[2]);

				if(graph.containsKey(u)){
					graph.get(u).add(new Edge(u,v,w)); 
				}

				else{
					graph.put(u, new ArrayList());
					graph.get(u).add(new Edge(u,v,w)); 
				}
			}
				int dist[] = new int[n]; 

				bellmanFord(graph, dist, s, n);

				/*for(int i = 0; i<q; i++){
					int query = Integer.parseInt(br.readLine());
				}*/

				for(int i: dist)
					System.out.println(i +" "); 
				System.out.println();

				line = br.readLine().split(" "); 

				 n = Integer.parseInt(line[0]); 
				 m = Integer.parseInt(line[1]);
				 q = Integer.parseInt(line[2]);
				 s = Integer.parseInt(line[3]);

			
		}
	}

	public static void bellmanFord(HashMap<Integer, ArrayList<Edge>> graph, int dist[], int src, int V){
		//dist = new int[V];

		for(int i = 0; i<V; i++){
			dist[i] = Integer.MAX_VALUE; 
		}

		dist[src] = 0; 

		for(int i = 1; i<V; i++){
			for(int j = 0; j<V; j++){
				ArrayList<Edge> ls = graph.get(j);

				for(Edge e: ls){
					int u = e.src;
					int v = e.dest; 
					int w = e.w; 

					//if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
					//	dist[v] = w + dist[u]; 

			        if (dist[v] == Integer.MAX_VALUE) {
              			dist[v] = w + dist[u];
           			} 

           			else if (w + dist[u] < dist[v]) {
              			dist[v] = w + dist[u];
		            }
				}



			}
		}

		for(int i = 0; i<V; i++){
			ArrayList<Edge> ls = graph.get(i); 
			for(Edge e: ls){
					int u = e.src;
					int v = e.dest; 
					int w = e.w;

				if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
					dist[v] = Integer.MIN_VALUE; 

			}
		}


	}

	public static class Edge{
		int src;
		int dest; 
		int w;

		public Edge(int src, int dest, int w){
			this.src = src;
			this.dest = dest;
			this.w = w;
		}
	}
} 
