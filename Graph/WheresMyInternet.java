import java.util.*;

public class WheresMyInternet {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int m = scan.nextInt();

    @SuppressWarnings("unchecked") LinkedList<Integer> graph[] = new LinkedList[n+1];

    for(int i = 1; i<=n; i++){
      graph[i] = new LinkedList<Integer>();
    }

    for(int i = 1; i<=m; i++){
      int a = scan.nextInt();
      int b = scan.nextInt();

      graph[a].add(b);
      graph[b].add(a);
    }

    ArrayList<Boolean> hasInternet = new ArrayList<Boolean>();
    for(int i = 0; i<=n; i++) hasInternet.add(i, false);
    ArrayList<Integer> noInternet = new ArrayList<Integer>();
    //hasInternet.add(0,false);
    hasInternet.add(1, true);

    for(int i = 2; i<=n; i++){ //Check every node has a path to 1
      boolean visited[] = new boolean[n+1];
      if(dfs(graph, i, hasInternet, visited) == false) noInternet.add(i);
      else hasInternet.add(i, true);
    }

    print(noInternet);
  }

  public static boolean dfs( LinkedList<Integer> graph[], int val, ArrayList<Boolean> hasInternet, boolean visited[]){
    visited[val] = true;
    if(hasInternet.get(val) == true) return true;
    ListIterator<Integer> it = graph[val].listIterator();

    while(it.hasNext()){
      int temp = it.next();
      if(visited[temp] == false)
        return dfs(graph, temp, hasInternet, visited);
    }

    return false;
  }

  public static void print(ArrayList<Integer> arr){
    if(arr.size() == 0) System.out.println("Connected");
    for(int i: arr){
      System.out.println(i);
    }
  }
}
