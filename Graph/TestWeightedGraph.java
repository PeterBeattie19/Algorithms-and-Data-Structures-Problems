public class TestWeightedGraph{
	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(10, true);

		g.createEdge(1,2,0);
		g.createEdge(1,3,0);
		g.createEdge(2,4,0);
		g.createEdge(3,4,0);
		//g.createEdge(4,7,0);
		g.createEdge(6,3,0);
		//g.createEdge(6,5,0);
		g.createEdge(5,7,0);

		System.out.println(g.DFS(1,7)); 

	}
}
