import java.util.*; 

public class Node{
	LinkedList<Edge> adj;
	int key; 
	//String key; 

	public Node(int u){
		adj = new LinkedList<>();
		key = u; 
	}

	public Node(){
		adj = new LinkedList<>();
		key = 0; 
	}

	public void setEdge(Node v , int weight){
		adj.add(new Edge(v, weight)); 
	} 

	public void setKey(int value){
		this.key = key; 
	}
}
