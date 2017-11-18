import java.util.Scanner;

public class LongestConsecutiveChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 

		String s = scan.nextLine().toLowerCase(); 
		String abc = "abcdefghijklmnopqrstuvwxyz"; 
		
		int arr[] = new int[26]; 
		char c[] = abc.toCharArray(); 

		for(int i = 0; i<s.length(); i++){
			arr[getIntVal(s.charAt(i))]++; 
		}

		int l = 0; 

		for(int i = 0; i<26; i++){
			if(arr[i] > arr[l]) l = i;
		}

		System.out.println(getCharVal(l, c)); 
	}

	public static int getIntVal(char c){
		return (c - 'a'); 
	}

	public static char getCharVal(int i, char arr[]){
		return arr[i]; 
	}
}