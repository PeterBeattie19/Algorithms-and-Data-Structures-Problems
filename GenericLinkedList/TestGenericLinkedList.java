public class TestGenericLinkedList {
  public static void main(String[] args) {
    LinkedList<String> listStrings = new LinkedList<String>();

    list.push("John");
    list.push("Paul");
    list.push("James");
    list.push("Joany");

    list.printList();
    list.pop();
    list.printList();

    LinkedList<Integer> listIntegers = LinkedList<Integer>();
    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);
    list.push(5);
    list.push(6);

    list.pop();
    list.printList();
  }
}
