import java.util.*;

public class TwoDHourGlass {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int arr[][] = new int[6][6];

    for(int i =0; i<arr.length; i++) {
      for(int j = 0; j<arr.length; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

int largest = Integer.MIN_VALUE;

for(int i =1; i<arr.length-1; i++) {

  for(int j = 1; j<arr.length-1; j++) {

    int hourglass = 0;

    hourglass += arr[i][j];
    hourglass += arr[i-1][j];
    hourglass += arr[i-1][j-1];
    hourglass += arr[i-1][j+1];
    hourglass += arr[i+1][j-1];
    hourglass += arr[i+1][j];
    hourglass += arr[i+1][j+1];

    if(hourglass > largest) {
      largest = hourglass;
    }
  }

}

System.out.println(largest);




  }
}
