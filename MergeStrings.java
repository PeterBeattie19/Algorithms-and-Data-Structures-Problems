import java.util.*;
import java.lang.*; 

public class MergeStrings {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 

		String a = scan.next();
		String b = scan.next(); 

		String m = merge(a,b); 

		System.out.println(m); 

	}

	public static String merge(String a, String b){
		StringBuilder s = new StringBuilder(); 
		int i = 0; 

		while(a.length() > 0 && b.length() > 0){
			if(i%2 == 0) {
				s.append(a.charAt(0)); 
				a = a.substring(1,a.length()); 
			}

			else {
				s.append(b.charAt(0)); 
				b = b.substring(1,b.length()); 
			}

			i++; 
		}

		if(a.length() > 0) s.append(a);
		else if(b.length() > 0) s.append(b); 

		return s.toString(); 
	}
}