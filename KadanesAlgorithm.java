public class KadanesAlgorithm {
	public static void main(String[] args) {
		int arr[] = {4,1,2,3}; 

		System.out.println(findMaxDiff(arr));
	}

	public static int findMaxDiff(int arr[]){
		int max = arr[1] - arr[0]; 
		int small = arr[0]; 

		for(int i = 1; i<arr.length; i++){
			if((arr[i] - small) > max){
				max = (arr[i] - small); 
			}

			if(arr[i] < small){
				small = arr[i]; 
			}
		}

		return max; 
	}
}