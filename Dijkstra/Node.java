import java.util.*; 

public class Node{
	LinkedList<Edge> adj;
	int key; 
	
	int dist = Integer.MAX_VALUE;

	public Node(int u){
		adj = new LinkedList<>();
		key = u; 
	}

	public void setEdge(Node n, int w){
		adj.add(new Edge(n,w)); 
	}
}