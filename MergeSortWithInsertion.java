import java.util.*; 
//Regular mergesort is faster, don't waste your time putting insertion as one of the base cases in the mergesort method
public class MergeSortWithInsertion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		Random ran = new Random(); 

		int arr1[] = new int[1000]; 
		int arr2[] = new int[1000];

		for(int i = 0; i<arr1.length; i++){ 
			  
			arr1[i] = ran.nextInt(100);; 
			arr2[i] = ran.nextInt(100);;  
		}

		int threshold = 32; 

		long start = System.currentTimeMillis(); 
		mergesort(arr1, 0, arr1.length);
		long end = System.currentTimeMillis();

		System.out.println("TIME FOR REGULAR MERGE-SORT: " +(end-start)+ "ms");

		start = System.currentTimeMillis();
		mergesort(arr2,0,arr2.length, threshold); 
		end = System.currentTimeMillis(); 

		System.out.println("TIME FOR MERGE SORT COMBINED WITH INSERTION: " +(end-start) +"ms"); 

		/*for(int i: arr1)
			System.out.print(i+" "); 
		System.out.println(); 

		for(int i: arr2)
			System.out.print(i+" ");  */

	}

	public static void merge(int arr[], int p, int q, int r){
		int i = p;
		int j = q; 

		int temp[] = new int[r-p]; 
		int t = 0; 

		while(i<q && j<r){
			if(arr[i] <= arr[j]){
				temp[t] = arr[i];
				i++;
				t++;
			}
			else{
				temp[t] = arr[j]; 
				j++;
				t++; 
			}
		}

		//Add Remainder
		while(i<q){
			temp[t] = arr[i];
			i++;
			t++; 
		}

		while(j<r){
			temp[t] = arr[j];
			j++; 
			i++; 
		}

		//Copy back into arr
		i = p;
		t = 0;
		while(t<temp.length){
			arr[i] = temp[t]; 
			i++;
			t++;

		}
	}

	public static void mergesort(int arr[], int l, int r){
		if(l+1<r){
			int mid = (l+r)/2;
			mergesort(arr,l,mid);
			mergesort(arr,mid,r);
			merge(arr,l,mid,r); 
		}
	}

	public static void mergesort(int arr[], int l, int r, int threshold){
		if((r - l) <= threshold){
			insertion(arr,l,r); 
		}
		else{
			int mid = (l+r)/2;
			mergesort(arr,l,mid, threshold);
			mergesort(arr,mid,r, threshold);
			merge(arr,l,mid,r); 
		}
	}

	public static void insertion(int arr[], int r, int l){
		for(int i = r+1; i<l; i++){
			for(int j = i-1; j>=0; j--){
				if(arr[j+1] < arr[j]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp; 
				}
			}
		}
	}
}
