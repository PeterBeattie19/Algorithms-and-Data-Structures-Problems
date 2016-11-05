import java.util.*;

public class Pallindrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int j =0;
        boolean check = true;
        char letter;

        for(int i = A.length()-1; i>=0; i--) {

            letter = A.charAt(i);
            if(letter == A.charAt(j)) {
                check = true;
                    j++;
            }

            else {
                check = false;
                i = -1;
            }
        }

        if(check == true) {
            System.out.println("Yes");
        }

        else if(check ==false) {
            System.out.println("No");
        }


    }
}
