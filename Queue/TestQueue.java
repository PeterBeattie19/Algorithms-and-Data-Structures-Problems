public class TestQueue {
  public static void main(String[] args) {
    Queue q = new Queue();

    for(int i = 1; i<=10; i++){
      q.add(i);
    }

    System.out.println("Peek at first element " +q.peek());

    System.out.println("Look at all elements:");

    for(int i = 1; i<=10; i++){
      System.out.println("  "+ q.remove());
    }
  }
}
