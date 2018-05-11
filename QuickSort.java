import java.util.*;

public class QuickSort {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("What size array? ");
    int size = scan.nextInt();
    int arr[] = new int[size];

    Random ran = new Random();

    for(int i = 0; i<arr.length; i++){
      arr[i] = ran.nextInt(100);
    }

    print(arr);
    long start = System.currentTimeMillis();
    quickSort(arr, 0, arr.length-1);
    long end = System.currentTimeMillis();
    print(arr);
    System.out.println("That took "+(end - start));
    //QUICK SORT HAS AN AVERAGE COMPLEXITY OF Nlog(N), IT'S WORST CASE WILL GIVE A COMPLEXITY OF N^2 .
    //INSERTION SORT WILL BE FASTER FOR AN ARRAY SIZE OF <1000 BUT GIVEN ARRAY OF 1 MILLION ELEMENTS
    //QUICK SORT WILL SURPASS INSERTION  BY QUITE A LARGE MARGIN
    //THE BEST WAY TO UNDERSTAND QUICKSORT IS TO WRITE OUT AN ARRAY AND RUN THROUGH IT WITH THE CODE BELOW 

  }

  /*-------QUICK SORT-------*/
public static void quickSort(int arr[], int low, int high){
  int pivot = arr[low + (high-low)/2]; //PICK A PIVOT POINT, USUALLY THE MID POINT IN THE ARRAY
  int i = low;
  int j = high;

  while(i<=j){

    while(arr[i]<pivot){ //LOOP UNTIL WE FIND A VALUE THAT BELONGS IN THE RIGHT HANDSIDE OF THE ARRAY
      i++;
    }

    while(arr[j]>pivot){
      j--;  //LOOP UNTIL WE FIND A VALUE THAT BELONGS IN THE LEFT HANDSIDE OF THE ARRAY
    }

    if(i<=j){ //IF i HASN'T PASSED j (AND VICE VERSA) SWAP THE ELEMENTS
      swap(i,j, arr);//BE CAREFUL WHEN SWAPPIING OBJECTS, JAVA AINT GREAT
      i++;
      j--;
    }
  }

  if(low < j){ //IF J HASN'T REACHED LOW (ie IF J HASN'T PAST THE PORTION OF THE ARRAY WE ARE SORTING, THEN CALL QUICK SORT AGAIN)
    quickSort(arr, low, j);
  }

  if(high>i){
    quickSort(arr, i, high);
  }
}

public static void print(int arr[]){
  for(int i: arr){
    System.out.print(i +" ");
  }

  System.out.println();
}

public static void swap(int n1, int n2, int []arr){
  int temp = arr[n1];
  arr[n1] = arr[n2];
  arr[n2] = temp;
}
}
