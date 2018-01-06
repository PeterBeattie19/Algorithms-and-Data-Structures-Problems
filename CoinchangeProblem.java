import java.util.*; 
import java.io.*; 

public class CoinchangeProblem {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int arr[] = {1,2,3}; 
		int n = 5;

		int memo[][] = new int[n+1][arr.length]; 

		System.out.println(count(arr, memo, arr.length, n)); 

	}

	public static int count(int arr[], int memo[][], int m, int sum){

		if(sum == 0)
			return 1;

		if(sum < 0)
			return 0;

		if(m<=0 && sum >= 1)
			return 0;

		if(memo[sum][m-1] != 0)
			return memo[sum][m-1]; 

		// num of ways including m-1 and num of ways excluding it 
		return memo[sum][m-1] =  count(arr,memo, m-1, sum) + count(arr, memo, m, (sum - arr[m-1])); 

		//return memo[sum][m]; 
	}
} 