import java.util.Scanner;

public class TestGraph {
  public static void main(String[] args) {
    Graph g = new Graph(8);

    //ADD IN THE NODES TO THE GRAPH
    for(int i = 1; i<=8; i++){
      g.add(i);
    }

    //JOIN THE APPROPRIATE NODES TOGETHER
    g.connect(0, 1, 6); //Node 1
    g.connect(1, 0, 2); //Node 2
    g.connect(2, 1, 3); //Node 3
    g.connect(3, 6, 2, 4); //Node 4
    g.connect(4, 5, 6, 3); //Node 5
    g.connect(5, 4, 6); //Node 6
    g.connect(6, 0, 5, 4, 3); //Node 7
    
    //NOTE THE NODE CONTAINING THE NUMBER 8 IS NOT CONNECTED TO ANYTHING 

    //GRAPH IS NOW CREATED
    g.printGraph();
    System.out.println(g.isPathDFS(0, 4)); //Returns true 
    System.out.println(g.pathBFS(0,7)); //Returns false 


  }
}
