import java.util.*; 
import java.io.*; 

public class CompressionandDecompression {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		String compressedString = br.readLine();
		String result = "";
		String temp = ""; 

		int numStrt = 0;
		int numEnd = 0;
		int lstrt = 0;
		int lend = 0;

		while(numStrt < compressedString.length()){
			numEnd = findNextNumber(compressedString, numStrt); 
			int n = Integer.parseInt(compressedString.substring(numStrt,numEnd)); 

			lstrt = numEnd+1;

			lend = findEndOfArray(compressedString, lstrt); 

			temp = compressedString.substring(lstrt, lend); 

			for(int j = 0; j<n; j++){
				result += temp; 
			}

			numStrt = lend+1; 
		}

		System.out.println(result); 
	}

	public static int findNextNumber(String s, int start){
		int count = start; 

		while(s.substring(count,count+1).matches("[0-9]")){
			count++; 
		}
		return count; 
	}

	public static int findEndOfArray(String s, int start){
		int count = start; 
		while(s.charAt(count) != ']'){
			count++;
		}
		return count; 
	}
} 