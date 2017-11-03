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
    return path(graph[from], graph[to], visited);
  }

  private boolean path(Node from, Node to, Set<Node> visited){
    if(visited.contains(from) == true) return false;

    if(from == to) return true;

    visited.add(from);
    LinkedList<Node> next = from.getAdjacent();

    for(Node n: next){
      if(path(n, to, visited)) return true;
    }
    return false;
  }

  public boolean isPathBFS(int from, int to){
    return pathBFS(graph[from], graph[to]); 
  }

  private boolean pathBFS(Node from, Node to){
    Set<Node> visited = new HashSet<Node>();
    if(from == to) return true;

    LinkedList<Node> nextUp = new LinkedList<Node>();
    addAdjacent(from.getAdjacent(), nextUp);
    visited.add(from);

    while(nextUp.size() != 0) {
      Node current = nextUp.poll();
      if(visited.contains(current)) continue;
      visited.add(current);
      if(current == to) return true;

      addAdjacent(current.getAdjacent(), nextUp);
    }
    return false;
  }

  public void addAdjacent(LinkedList<Node> list, LinkedList<Node> q){
    for(Node n: list) q.add(n);
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
