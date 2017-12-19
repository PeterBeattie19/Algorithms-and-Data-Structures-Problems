import java.util.*;
import java.io.*;

public class DijkstraTemplate {
	public static void main(String[] args) {
		
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

	public static class Node {
		int key;
		LinkedList<Edge> adj;
		int dist = Integer.MAX_VALUE; 

		public Node(int n){
			this.key = n;
			adj = new LinkedList<>(); 
		}

		public addEdge(Node n, int weight){
			adj.add(new Edge(n, weight));
		}
	}

	public static class Edge {
		Node destination; 
		int weight;

		public Edge(Node n, int weight){
			this.destination = n;
			this.weight = weight; 
		}
	}
}