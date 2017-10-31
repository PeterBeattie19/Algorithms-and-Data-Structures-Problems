import java.util.*;

public class Array{

  private int length;
  private int arr[];
  private int lastIndex = 0;

         //CONSTRUCTORS
  public Array(){
    this.length = 1;
    this.arr = new int[this.length];
  }



  public Array(int length){
    this.length = length;
    this.arr = new int[this.length];
  }




         //GETTERS AND SETTERS
  public int get(int index){
    return arr[index];
  }



  public void set(int index, int val){
    arr[index] = val;
  }



        //PRINT

  public void print(){
    for(int i: arr){
      System.out.print(i +" ");
    }

    System.out.println();
  }



        //FILLING ARRAY

  public void fillRan(int max){
    Random ran = new Random();

    for(int i = 0; i<this.length; i++){
      arr[i] = ran.nextInt(max);
    }

    lastIndex = this.length;
  }



  public void fillStdin(){
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i<this.length; i++){
      arr[i] = scan.nextInt();
    }
  }



        //APPENDING AND CLEARING

  public void append(int n){
    if(lastIndex!=this.length){
      arr[lastIndex] = n;
      lastIndex++;
    }

    else {
      System.out.println("Array at Maximum Capacity!");
    }
  }



  public void clear(){
    int newArr[] = new int[this.length];
    arr = newArr;
  }



          //SORT METHOD

  public void sort(String type){
    if(type.equals("bubble")){
      bubbleSort();
    }

    else if (type.equals("selection")) {
      selectionSort();
    }

    else if(type.equals("insertion")) {
      insertionSort();
    }

    else if(type.equals("quick")){
      quickSort(arr, 0, arr.length-1); 
    }
    
    else if(type.equals("merge")){
      mergesort(arr); 
    }
  }



        //SORTING TECHNIQUES

  private void bubbleSort(){
    for(int i = 1; i<=arr.length; i++){
      for(int j = 0; j<arr.length-i; j++){
        if(arr[j]>arr[j+1]){
          int t = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = t;
        }//if statement
      }//j loop
    }//i loop
  } //Method



  private void selectionSort(){
    int min;

    for(int i = 0; i<arr.length; i++){
      min = i;
      for(int j = i+1; j<arr.length; j++){
        if(arr[j]<arr[min]) min = j;
      } //j loop
      swap(i,min);
    } //i loop

  } //Method



  private void insertionSort(){
    int j;
    for(int i = 1; i<arr.length; i++){
      j = i;
      int temp = arr[j];
      while(j>0 && arr[j-1]>=temp){
        arr[j] = arr[j-1];
        --j;
      }
      arr[j] = temp;
    }
  }


  private void quickSort(int arr[], int low, int high){
    int pivot = arr[low + (high-low)/2];
    int i = low;
    int j = high;

    while(i<=j){

      while(arr[i]<pivot){
        i++;
      }

      while(arr[j]>pivot){
        j--;
      }

      if(i<=j){
        swap(i,j);
        i++;
        j--;
      }
    }

    if(low < j){
      quickSort(arr, low, j);
    }

    if(high>i){
      quickSort(arr, i, high);
    }
  }


  public void mergesort(int arr[]){
    int temp[] = new int[arr.length];
    mergesort(arr, temp, 0, arr.length-1);
  }

  public void mergesort(int arr[], int temp[], int leftStart, int rightStart){
    if(leftStart >= rightStart){
      return;
    }

    int middle = (leftStart + rightStart) / 2;

    mergesort(arr, temp, leftStart, middle);
    mergesort(arr, temp, middle+1, rightStart);

    mergeHalves(arr, temp, leftStart, rightStart);
  }

  public void mergeHalves(int arr[], int temp[], int leftStart, int rightEnd){
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



    System.out.println();
  }


        //SWAPPING METHOD

  private void swap(int n1, int n2){
    int temp = arr[n1];
    arr[n1] = arr[n2];
    arr[n2] = temp;
  }


}
