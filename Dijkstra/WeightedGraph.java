import java.util.*; 

public class WeightedGraph {  
	Node[] graph; 
	int numVert; 

	public WeightedGraph(int numVert, boolean setKey){
		this.numVert = numVert; 

		
			graph = new Node[numVert]; 
			for(int i = 0; i<numVert; i++){
				graph[i] = new Node(i); 
			}
		
	}

	public void createEdge(int u, int v, int weight){
		graph[u].setEdge(graph[v], weight);
		//
	}

	public void createNode(int n){ //Nodes are already constructed, it really means set the ID/Key value, used to label each Node
		graph[n].key = n; 
	}

}
