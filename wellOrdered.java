/* This program takes every three digit number and checks it to see if it is a well ordered number.
An example of a number that is well ordered is 123, an example of a number that is not well ordered is 143. 
*/

public class wellOrdered {
	public static void main(String args[]) {

		int count = 0;


		for(int i =100; i<1000; i++) {
			int num1;
			int num2;
			int num3;
			int num4;

			num1 = i/100;

			num2 = i%100;
			num3 = num2/10;

			num4 = i%10;



				if(num1<num3  &&  num3<num4) {
					System.out.println(i);
						count++;
				}


		}

	System.out.println("The number of 3 digit well ordered numbers is " +count);
	}
}
