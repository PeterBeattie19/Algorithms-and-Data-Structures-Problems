import java.util.Random;

public class TestBST {

public static void main(String arg[]){

    BinarySearchTree bst = new BinarySearchTree();
    Random ran = new Random();
    int arr[] = new int[30];

   for(int i = 0; i<30; i++){
      arr[i] = ran.nextInt(100);
      System.out.print(arr[i] +" ");
    }

      System.out.println();
      System.out.println();


    for(int i = 0; i<arr.length; i++){
      bst.insert(arr[i]);
    }


   bst.print();

  }

}
