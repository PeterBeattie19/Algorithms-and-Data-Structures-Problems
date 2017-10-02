import java.util.Scanner;
public class TestLinkedList{
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    LinkedList list = new LinkedList();

    System.out.println("Enter numbers to be inserted into linked list, when finshed type 'done'!!");
    String s = new String("");
    s = scan.nextLine();

    while(!(s.equals("done"))){
      list.insert(Integer.parseInt(s));
      s = scan.nextLine();
    }

    System.out.println();
    System.out.println();
    list.printForward();
    System.out.println();
    System.out.println();

  //  list.insertAt(111,list.count(list.returnHead()));
  list.reverseList(); 

    list.printForward();











    /*
LinkedList list = new LinkedList(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.insert(6);

    list.printForward();
    list.PrivateInsertAt(list.head, 4, 111);
    //list.delete(4);
  //  System.out.println(list.count(list.head));
  //  list.reverse();
  //  list.printForward();
    System.out.println();
    list.printForward();
    */

  }
}
