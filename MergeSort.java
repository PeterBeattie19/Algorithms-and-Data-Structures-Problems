import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {
    Random ran = new Random();

    int arr[] = new int[10];

    for(int i = 0; i<10; i++){
      arr[i] = ran.nextInt(50);
    }

    mergesort(arr);
    print(arr);
  }

  public static void mergesort(int arr[]){
    int temp[] = new int[arr.length];
    mergesort(arr, temp, 0, arr.length-1);
  }

  public static void mergesort(int arr[], int temp[], int leftStart, int rightStart){
    if(leftStart >= rightStart){
      return;
    }

    int middle = (leftStart + rightStart) / 2;

    mergesort(arr, temp, leftStart, middle);
    mergesort(arr, temp, middle+1, rightStart);

    mergeHalves(arr, temp, leftStart, rightStart);
  }

  public static void mergeHalves(int arr[], int temp[], int leftStart, int rightEnd){
    int leftEnd = (rightEnd + leftStart) / 2;  //Middle point in array
    int rightStart = leftEnd + 1; //mid point plus 1
    int size = rightEnd - leftStart + 1;

    int left = leftStart;
    int right = rightStart;
    int index = leftStart;

    while(left <= leftEnd && right <= rightEnd){
      if(arr[left] <= arr[right]){
        temp[index] = arr[left];
        left++;
      }

      else {
        temp[index] =arr[right];
        right++;
      }

      index++;
    }

    System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
    System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
    System.arraycopy(temp, leftStart, arr, leftStart, size);
  }

  public static void print(int arr[]){
    for(int i: arr){
      System.out.print(i +" ");
    }

    System.out.println();
  }
}
