import java.util.Random;
public class ConvertBinaryTreeToLinkedList{
  public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree(); //Binary search tree to be converted to linked list
    Random ran = new Random();

    for(int i = 0; i<20; i++){
      bst.insert(ran.nextInt(50));
    }

    bst.print();
    System.out.println();
    LinkedList list = new LinkedList(); //This is the Linked list we will we be putting the tree into

    convert(bst, list);

    list.printForward();
  }

  public static void convert(BinarySearchTree bst, LinkedList list){ //Given a binary tree and a linked list to put it into
    convertPrivate(bst.root, list); //Calling private method   //
  }

  private static void convertPrivate(Node n, LinkedList list){
    if(n != null){
      convertPrivate(n.left, list); //Recursive step to reach the smallest value.

    //  System.out.print(n.data +" ");
    list.insert(n.data); //The first time this method is called we will be at the smallest value in the tree.

      convertPrivate(n.right, list);
    }
  }
}
