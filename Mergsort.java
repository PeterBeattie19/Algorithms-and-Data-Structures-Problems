import java.util.*; 

public class Mergsort {
	public static void main(String[] args) {
		Random ran = new Random(); 

		int arr[] = new int[20]; 

		for(int i = 0; i<20; i++){
			int value = 1 + ran.nextInt(100);
			arr[i] = value;
			System.out.print(value +" "); 
		}

		
		System.out.println(); 

		mergesort(arr,0,20); 


		for(int i: arr) System.out.print(i +" "); 
		System.out.println();

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
		if(l+1 != r){
			int mid = (l+r)/2;
			mergesort(arr,l,mid);
			mergesort(arr,mid,r);
			merge(arr,l,mid,r); 
		}
	}
}