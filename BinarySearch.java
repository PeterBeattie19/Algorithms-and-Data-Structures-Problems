import java.util.*;

public class BinarySearch {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

  //  int size = scan.nextInt();
    int arr[] = {1,3,12,23,45,67,87,123};
  //  fillArray(arr);
//  arr = {1,2,34,56,67,77};
    printArray(arr);

    boolean check = true;

    while(check) {
      System.out.println("Enter number to search");
      int search = scan.nextInt();

      if(search<0) {
        check = false;
      }

      else {
          System.out.println(binarySearch(search, arr));
      }
    }


  }

  public static void printArray(int a[]) {
    for(int i: a) System.out.print(i+" ");

    System.out.println();
  }



public static boolean binarySearch(int s, int a[]) {
  int strt = 0;
  int lst = a.length-1;
  boolean check = true;
  boolean found = false;

  if(!inRange(s, a)) found = false;

  else {

  while(check && lst>strt) {
    int index = (strt + lst)/2;

    if(a[index]==s) {
      found = true;
      check = false;
}
    else if(a[index]<s) strt = index+1;

    else if(a[index]>s) lst = index-1;
  }


}
    return found;
}

public static boolean inRange(int n, int a[]) {
  boolean check = true;
  if(n>=a[0] && n<=a[a.length-1]) check = true;

  return check;

}

}
