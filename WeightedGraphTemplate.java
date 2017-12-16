import java.util.*; 
import java.io.*; 

public class WeightedGraphTemplate{
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		ArrayList<LinkedList<Edge>> graph = new ArrayList<>(); 

		//Each index in the array list is a node in the graph
		//Stored in each index is a linked list of Edges, each edge has a weight(int) and a destination(int)
		//For Example: graph[2]: Edge(3,5) -> Edge(4,7) , this means nodes number 2 is connected to two other nodes,
		//it connects to node 2 with a weight of 5 and node 4 with a weight of 7

		String line[] = br.readLine().split(" "); 

		int numNodes = Integer.parseInt(line[0]); 
		int numConnections = Integer.parseInt(line[1]);
		int numQueries = Integer.parseInt(line[2]); 

		for(int i = 1; i<=numNodes; i++){
			graph.add(new LinkedList<Edge>()); 
		}

		for(int i = 1; i<=numConnections; i++){
			line = br.readLine().split(" "); 
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);

			graph.get(a).add(new Edge(b,w)); 
			graph.get(b).add(new Edge(a,w)); //Remove this line if graph is directed 
		}
	}

	public static class Edge{
		int destination;
		int weight; 

		public Edge(int d, int w){
			destination = d; 
			weight = w; 
		}
	}
} 