import java.util.*; 
import java.io.*; 

public class GraphTemplate {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		ArrayList<LinkedList<Integer>> graph = new ArrayList<>(); 

		String line[] = br.readLine().split(" "); 

		int numNodes = Integer.parseInt(line[0]); 
		int numConnections = Integer.parseInt(line[1]); 

		for(int i = 0; i<numNodes; i++){
			graph.add(new LinkedList<>()); 
		}

		for(int i = 0; i<numConnections; i++){
			line = br.readLine().split(" "); 

			int a = Integer.parseInt(line[0]); 
			int b = Integer.parseInt(line[1]);

			graph.get(a).add(b);
			graph.get(b).add(a); 
		}
	}

  public static boolean dfs(ArrayList<LinkedList<Integer>> graph, int from, int to, HashSet<Integer> visited){ //Remeber to add source into visited in main method 
  	if(from == to)
  		return true;

  	for(int i: graph.get(from)){
  		if(visited.add(i) != false){
  			return dfs(graph, i, to,visited);
  		}
  	}
  	return false; 
  }
} 