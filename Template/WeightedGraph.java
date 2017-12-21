import java.util.*; 

public class WeightedGraph{ //Undirected 
	Node[] graph; 

	public WeightedGraph(int numVert, boolean setKey){
		if(setKey == false){
			graph = new Node[numVert]; 
			for(int i = 0; i<numVert; i++){
				graph[i] = new Node(); 
			}
		}

		else{
			graph = new Node[numVert]; 
			for(int i = 0; i<numVert; i++){
				graph[i] = new Node(i); 
			}
		}
	}

	public void createEdge(int u, int v, int weight){
		graph[u].setEdge(graph[v], weight);
		graph[v].setEdge(graph[u], weight);
	}

	/*public void createEdge(int u, int weight, int... v){
		for(int i: v){
		graph[u].setEdge(graph[i], weight);
		graph[i].setEdge(graph[u], weight);
		}
	}*/ 

	public void createNode(int n){ //Nodes are already constructed, it really means set the ID/Key value, used to label each Node
		graph[n].setKey(n); 
	}

	public boolean DFS(int from, int to){
		HashSet<Node> visited = new HashSet<>(); 
		return DFS(graph[from], graph[to], visited); 
	}

	private boolean DFS(Node from, Node to, HashSet<Node> visited){
		if(from == to) return true; 

		for(Edge n: to.adj){
			if(visited.add(n.v) == true){
				return DFS(from, n.v, visited); 
			}
		}
		return false; 
	}
}
