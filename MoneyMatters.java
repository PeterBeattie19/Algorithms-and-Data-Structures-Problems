import java.util.*;

public class MoneyMatters{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);


    boolean visited[] = new boolean[10001];

    int debt[] = new int[10001];

    int n = scan.nextInt();
    int m = scan.nextInt();

    for(int i = 0; i<n; i++){
      debt[i] = scan.nextInt();
    }


    @SuppressWarnings("unchecked") LinkedList<Integer> graph[] = new LinkedList[n];
    for(int i = 0; i<n; i++){
      graph[i] = new LinkedList<>();
    }

    for(int i = 0; i<m; i++){
      int x = scan.nextInt();
      int y = scan.nextInt();

      graph[x].add(y);
      graph[y].add(x);
    }

    boolean check = false;

    for(int i = 0; i<n && !check; i++){
        check = check | (!visited[i] && (dfs(i,visited,graph,debt) != 0));
    }

    if(check){
      System.out.println("IMPOSSIBLE");
    }

    else  System.out.println("POSSIBLE");
  }

  public static int dfs(Integer i, boolean visit[], LinkedList<Integer> graph[], int debts[]){
    visit[i] = true;
    int sum = debts[i];
    //int j = i;

    ListIterator<Integer> it = graph[i].listIterator();

    while(it.hasNext()){
      int j = it.next();
      if(!visit[j]){
        sum += dfs(j, visit, graph, debts);
      }
    }
    return sum;
  }
}
