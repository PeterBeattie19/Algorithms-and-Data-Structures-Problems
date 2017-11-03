import java.util.*;

public class Node {
  private int key;
  private LinkedList<Node> adjacent;

  //CONSTRUCTOR
  public Node(int key){
    this.key = key;
    adjacent = new LinkedList<Node>();
  }

  public void addEdge(Node node){
    adjacent.add(node);
  }

  public LinkedList<Node> getAdjacent(){
    return adjacent;
  }

  public int getKey(){
    return this.key; 
  }

}
