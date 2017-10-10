import java.util.*;

public class RemoveDups {
  public static void main(String[] args) {
    int arr[] = {1,2,2,2,3,3,3,4,5,5,5,5,3,3,2,2,2};

    int newArr[] = removeDups(arr);

    for(int i: newArr){
      System.out.print(i+" ");
    }
  }

  public static int[] removeDups(int arr[]){
    Set<Integer> set = new HashSet<Integer>();

    for(int i = 0; i<arr.length; i++){
      set.add(arr[i]);
    }

    int newArr[] = new int[set.size()];

    Iterator it =  set.iterator();
    int j = 0;
    while(it.hasNext()){
      newArr[j] = (int)it.next();
      j++;
    }

    return newArr; 
  }
}
