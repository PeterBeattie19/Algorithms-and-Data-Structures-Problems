public class KnapSack {
	public static void main(String[] args) {
		int weight[] = {1,2,4,2,5}; 
		int value[] = {5,3,5,3,2}; 
		int n = weight.length;
		int c = 10; 
		
		System.out.println(KS(n-1,c,weight,value)); 

		int memo[][] = new int[n][c+1];

		System.out.println(KS(n-1,c,memo,weight,value)); 

	}

	public static int KS(int n, int c, int weight[], int value[]){ //n -> position in the array, c -> how much capacity we have left
		if(n==-1 || c==0)
			return 0;

		if(weight[n] > c)
			return KS(n-1, c, weight, value); 

		int temp1 = KS(n-1,c,weight,value); // Here we try not putting the item in the knapsack
		int temp2 = value[n] + KS(n-1, c-weight[n] , weight, value); // Here we try putting the item in the knapsack

		return (int)Math.max(temp1, temp2); 

		//Time Complexity: O(2^n)
	}

	public static int KS(int n, int c, int memo[][], int weight[], int value[]){ //n -> position in the array, c -> how much capacity we have left

		if(n==-1 || c==0)
			return 0;

		if(memo[n][c] != 0) //check if computed already.
			return memo[n][c]; 

		if(weight[n] > c)
			return KS(n-1, c, memo,weight, value); 

		int temp1 = KS(n-1,c,memo,weight,value); // Here we try not putting the item in the knapsack
		int temp2 = value[n] + KS(n-1, c-weight[n] , memo, weight, value); // Here we try putting the item in the knapsack

		memo[n][c] = (int)Math.max(temp1, temp2);  //Store result for this particular combination of n and c
		return memo[n][c]; 

		//Time Complexity: O(nc)
	}

}