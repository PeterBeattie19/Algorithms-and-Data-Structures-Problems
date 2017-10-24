import java.util.*;

public class TestHeap {
  public static void main(String[] args) {
    Random ran = new Random();


    int size = 10;
    HeapMin h = new HeapMin(size);
    int arr[] = new int[size];
    for(int i = 0; i<size; i++){
      int val = 1 + ran.nextInt(100);
      h.insert(val);
    }

    for(int i = 0; i<size; i++){
      arr[i] = h.remove().getKey();
      System.out.print(arr[i]+ " ");
    }
  }
}
