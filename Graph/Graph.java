import java.util.*;

public class Graph {
  private Node graph[];
  private int currentsize;
  private int maxsize;

  public Graph(int size){
    graph = new Node[size];
    currentsize = -1;
    maxsize = size;
  }

  public void add(int key){
    graph[++currentsize] = new Node(key);
  }

  public void connect(int index, int... others){
    Node n = graph[index];

    for(int i: others){
      n.addEdge(graph[i]);
    }
  }

  public boolean isPathDFS(int from, int to){
    Set<Node> visited = new HashSet<Node>();
  //  visited.add(graph[from]);
    return path(graph[from], graph[to], visited);
  }

  public boolean path(Node from, Node to, Set<Node> visited){
    if(visited.contains(from) == true) return false;

    if(from == to) return true;

    visited.add(from);
    LinkedList<Node> next = from.getAdjacent();

    for(Node n: next){
      if(path(n, to, visited)) return true;
    }
    return false;
  }

  public void printGraph(){
    for(Node n: graph){
      System.out.print("For Node "+ n.getKey() +"      ");
      LinkedList<Node> list = n.getAdjacent();
      for(Node node: list){
        System.out.print(node.getKey() +" ");
      }
      System.out.println();
    }
  }
}
