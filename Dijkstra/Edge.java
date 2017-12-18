public class Edge{
	public Node destination;
	public int weight; 

	public Edge(Node v, int weight){
		this.destination = v;
		this.weight = weight; 
	}
}