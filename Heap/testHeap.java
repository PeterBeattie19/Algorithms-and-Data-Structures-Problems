import java.util.*;

public class TestHeap {
  public static void main(String[] args) {
    Random ran = new Random();

    Heap h = new Heap(30);

    for(int i = 0; i<30; i++){
      h.insert(ran.nextInt(30));
    }

    h.displayHeap();
  }
}
