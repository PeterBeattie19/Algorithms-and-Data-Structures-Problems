import java.util.*; 
import java.io.*; 
//Foo Bar Question
public class MinionScheduling {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		String line[] = br.readLine().split(" "); 
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[line.length]; 
		HashMap <Integer,Integer> map = new HashMap<>(); 
		int freq[]; 
		int largest = 0; 

		for(int i = 0; i<line.length; i++){
			arr[i] = Integer.parseInt(line[i]); 

			if(arr[i] > largest)
				largest = arr[i];

			if(map.containsKey(arr[i])){
				int prev = map.get(arr[i]);
				prev++;
				map.put(arr[i],prev);

			}

			else{
				map.put(arr[i],1); 
			}

		}


		for(int i = 1; i<=largest; i++){
			if(map.containsKey(i)){
				if(map.get(i) >= n)
					System.out.print(i +" "); 
			}
		}


	}
} 
