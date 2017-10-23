import java.util.Scanner;

public class SwapWithoutTemp {
  public static void main(String[] args) {

    int arr[] = new int[2];
    arr[0] = 3;
    arr[1] = 5;
    System.out.println("Before " +arr[0]+ " " +arr[1]);
    swap(arr, 0, 1);
    System.out.println("After " +arr[0]+ " " +arr[1]);
  }

  public static void swap(int arr[], int a, int b){
    arr[a] = Math.abs(arr[a] - arr[b]);
    arr[b] = Math.abs(arr[a] - arr[b]);
    arr[a] = arr[a] + arr[b];
  }
}
