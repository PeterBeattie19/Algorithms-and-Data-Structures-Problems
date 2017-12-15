//Convert a given integer in to binary and then re-arrange the bytes in a given order.
//Print the answer as an integer.
import java.util.*;

public class ByteManipulation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        String num = Integer.toBinaryString(n); //Converts number to string of 1s and 0s

		//If n is negative there will automatically be 32 digits
        if(n >= 0){ //If the number is positive you have to add zeroes to make up 32 digits
            String pad = "";
            for(int i = 0; i < 32 - num.length(); i++)
                pad = pad + 0; //
            num = pad + num;
        }
        //Split the 32 bits into it's four bytes
        String byte1 = num.substring(0, 8);
        String byte2 = num.substring(8, 16);
        String byte3 = num.substring(16, 24);
        String byte4 = num.substring(24, 32);

        String order = sc.nextLine();
        String finalNum = "";
        //Re-arrange the bytes in the given order
        for(int i = 0; i < 4; i++){
            if(order.charAt(i) == '4')
                finalNum = finalNum+byte4;
            else if(order.charAt(i) == '3')
                finalNum = finalNum+byte3;
            else if(order.charAt(i) == '2')
                finalNum = finalNum+byte2;
            else if(order.charAt(i) == '1')
                finalNum = finalNum+byte1;
        }
        boolean check = false;
        //If the re-arranged number is negative, invert all the bits
        if(finalNum.charAt(0) == '1'){
            check = true;
            String finalNum2 = "";
            for(int i = 0; i < finalNum.length(); i++){
                if(finalNum.charAt(i) == '1')
                    finalNum2 = finalNum2 + "0";
                else
                    finalNum2 = finalNum2 + "1";
            }
            finalNum = finalNum2;
        }
        int result;
        //If the number is negative convert it to an int and finish convertring it from two's complement
        if(check == true)
            result = -1 * ((Integer.parseInt(finalNum, 2)) + 1);
        //If the number is positive just convert it to an int
        else
            result = Integer.parseInt(finalNum, 2);
        System.out.println(result);
    }
}