//This is Phil's Solution
import java.util.*;
public class LargestPossibleNum{
 public static void main(String args[]) throws Exception {
	 Scanner myscanner = new Scanner(System.in);
	 int num1 = myscanner.nextInt();
	 int num2 = myscanner.nextInt();
	 int record=Integer.MIN_VALUE;
 	 for(int i = 0;i<=32;i++){
 		 for(int j=0;j<=32;j++){
 			 if(((num1<<i)|(num2<<j))>record){
 				 record=((num1<<i)|(num2<<j));
 			 }
 			 if(((num1>>i)|(num2<<j))>record){
 				 record=((num1>>i)|(num2<<j));
			 }
			 if(((num1<<i)|(num2>>j))>record){
				 record=((num1<<i)|(num2>>j));
			 }
			 if(((num1>>i)|(num2>>j))>record){
				 record=((num1>>i)|(num2>>j));
			 }
 		 }
 	 }
	 System.out.println(record);
//This is just brute force - try everything, no thinking required
 }
}