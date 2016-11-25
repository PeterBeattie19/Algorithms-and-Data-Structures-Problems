import java.util.Scanner;

public class Clumps {

 public static void main(String args[]) {
     Scanner scan = new Scanner(System.in);

     int size = scan.nextInt();
     int clump[] = new int[size];
     int test =1;

     int j = 0;


     int arr[] = new int[size];

     for(int i = 0; i<size; i++) {
         arr[i] = scan.nextInt();
     }



       for(int i = 1; i<size; i++) {
           if(arr[i] == arr[i-1]) {
               test++;
           }

           else if(arr[i]!=arr[i-1]) {
               clump[j] = test;
               j++;
               test = 1;

           }
       }

       int y = clump[0];

       for(int i = 1; i<size; i++) {
           if(clump[i] > clump[i-1] && clump[i]>y) {
               y = clump[i];
           }
       }

       System.out.print("Biggest Clump Size: " +y);



 }

}