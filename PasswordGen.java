import java.util.*;

public class PasswordGen {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    print("Enter password length: ");
    int length = scan.nextInt();

     String password[] = generateNewPassword(length);

     for(int i = 0; i<length; i++) {
       print(password[i]);
     }


  }

  public static String[] generateNewPassword(int length) {
    Random ran = new Random();

    String password[] = new String[length];

    String symbols[] = {"@" , "~" , "*", "%" , "$" , "#" , "!" , "A", "B", "C", "D", "F", "F", "S", "R", "Q"};
    String nums[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"n};


    for(int i = 0; i<length; i++) {
      if(i%2==0) password[i] = symbols[ran.nextInt(symbols.length)];

      else password[i] = nums[ran.nextInt(nums.length)];


    }

    return password;
         }

  public static void print(String s) {
    System.out.print(s);
  }

  public static void println(String s) {
    System.out.println(s);
  }
}
