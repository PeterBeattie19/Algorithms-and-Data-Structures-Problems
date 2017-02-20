import java.util.*; 

class test {

  	public static void main(String args[]) {
  	Scanner scan = new Scanner(System.in); 
  	
  	System.out.print("What size array? "); 
  	int size = scan.nextInt(); 
  	
  	int arr[] = new int [size];
  	fillArray(arr); 
  	 
  	printArray(arr); 
  	System.out.println(); 
  	
  	int n[] = new int[arr.length]; 
  	
  	for(int i = 0; i<size; i++) {
 		
 		//n[i] = findSmall(arr, i); 
 		int small = findSmall(arr, i); 
 		int index = findIndex(arr,i); 
 		 	
 		 	int temp = arr[i]; 
 		 	arr[i] = small;
 		 	arr[index] = temp; 
 		 	n[i] = small; 
 		 	
 		 	//printArray(arr); 
 		 	//System.out.println(); 
  	}
  	
  	//
  printArray(n); 
  	
  	
  	}
  	
  	public static int findSmall(int arr[], int j) {
  	
  	int s = arr[j]; 
  	
  	for(int i = j; i<arr.length; i++) {
  		if(arr[i]<s) s = arr[i]; 
  		
  	}
  	
  	
  	return s; 
  	
  	}
  	
  	
  	public static int findIndex(int arr[], int j) {
  	
  	int s = arr[j]; 
  	int index = 0; 
  	
  	for(int i = j; i<arr.length; i++) {
  		if(arr[i]<s) {
  		index = i; 
  		s = arr[i]; 
  		}
  	}
  	return index; 
  	}
  	
  	
  	
  	public static void printArray(int arr[]) {
  	
  	for(int i: arr) System.out.print(i+" "); 
  	
  	
  	}
  	
  	public static void fillArray(int arr[]) {
  	Random ran = new Random(); 
  	
  	for(int i = 0; i<arr.length; i++) {
  	arr[i] = ran.nextInt(60); 
  	}
  	}
  	
  	
  	
  	
  	
  	
  	
  	

}
