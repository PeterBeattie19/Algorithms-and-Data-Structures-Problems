import java.util.Scanner;

public class MaximumSubArray {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int size = scan.nextInt();

    int arr[] = new int[size];
    for(int i = 0; i<size; i++){
      arr[i] = scan.nextInt();
    }

    int temp[] = findMaxSubArray(arr, 0, size-1);

    System.out.println(temp[0] +" "+ temp[1] +" "+ temp[2] +" ");
  }

  public static int[] maxCrossingSubarray(int a[], int low, int mid, int high){
    int leftsum = Integer.MIN_VALUE;
    int sum = 0;
    int maxleft = 0;

    for(int i = mid; i>=low; i--){
      sum += a[i];
      if(sum > leftsum) {
        leftsum = sum;
        maxleft = i;
      }
    }

    int rightsum = Integer.MIN_VALUE;
    int maxright = 0;
    sum = 0;

    for(int i = mid+1; i<high; i++){
      sum += a[i];
      if(sum > rightsum){
        rightsum = sum;
        maxright = i;
      }
    }
    int ret[] = new int[3];
    ret[0] = maxleft;
    ret[1] = maxright;
    ret[2] = (leftsum + rightsum);
    return ret;
  }

  public static int[] findMaxSubArray(int arr[], int low, int high){
    if(high==low){
      int t[] = {low,high,arr[low]};
      return t;
    }

    else {
      int mid = (low + high)/2;

      int rightarr[] = findMaxSubArray(arr, low, mid);
      int leftarr[] = findMaxSubArray(arr, mid+1, high);

      int cross[] = maxCrossingSubarray(arr, low, mid, high);

      if(leftarr[2] > rightarr[2] && leftarr[2] > cross[2]) return leftarr;

      else if(rightarr[2] > leftarr[2] && rightarr[2] > cross[2]) return rightarr;

      else return cross;
    }
  }
}
