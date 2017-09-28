
/* Program to compure nth fibonacci number using
  the memoization technique.
  If a fib. of value hasn't been computed already then compute it and store the result.
  If the value to be computed has been previously calculated then reurn it from the array.
  This makes computation much more efficient because if you were to calculate fib(64), then
  you would have to calculate fib(4) apporx. 24,000,000 times.
  */


import java.util.Scanner;
public class FibonacciMemoization{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int value = scan.nextInt();



    long arr[] = new long[value+2];

    System.out.println(fibMemo(arr,value));
  }

  public static long fibMemo(long arr[], int n){
    if(arr[n]>0) return arr[n];

    else if(n==0) return 0;

    else if(n==1) return 1;

    else{
      arr[n] = fibMemo(arr,n-1) + fibMemo(arr,n-2);

    }

    return arr[n];
  }


}
