import java.util.*; 
import java.io.*; 

public class Dijkstra {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		WeightedGraph graph = new WeightedGraph(5,true); 


		graph.createEdge(0,1,4);
		graph.createEdge(0,2,2);
		graph.createEdge(1,2,3);
		//graph.createEdge(1,3,2);
		graph.createEdge(1,4,3);
		//graph.createEdge(2,3,4);
		graph.createEdge(2,4,5);
		graph.createEdge(2,1,1);
		//graph.createEdge(4,3,1);

		calculate(graph.graph[0]); 

		for(Node n: graph.graph)
			System.out.println(n.dist); 
	}

	public static void calculate(Node source){
		// Algo:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbours.
		// 3. Update the distances for all the neighbours (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.
		
		source.dist = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node> (){
        	public int compare(Node x, Node y){
            	if(x.dist == y.dist) return 0; 

            	return x.dist - y.dist; 
        	} 
		}); 


		queue.add(source);
		
		while(!queue.isEmpty()){
			
			Node u = queue.poll();
		
			for(Edge neighbour:u.adj){
				int newDist = u.dist+neighbour.weight;
				
				if(neighbour.destination.dist>newDist){
					// Remove the node from the queue to update the distance value.
					queue.remove(neighbour.destination);
					neighbour.destination.dist = newDist;
					
					// Take the path visited till now and add the new node.s
					//neighbour.destination.path = new LinkedList<Vertex>(u.path);
					//neighbour.target.path.add(u);
					
					//Reenter the node with new distance.
					queue.add(neighbour.destination); 					
				}
			}
		}
	}
} 