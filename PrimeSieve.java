import java.util.*; 
import java.io.*; 

public class PrimeSieve {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		String line[] = br.readLine().split(" "); 

		long cap = Long.parseLong(line[0]); 
		long q = Long.parseLong(line[1]);
		cap++; 

		BitSet primes = new BitSet(cap); 
		primes.flip(0,cap); 

		primes.set(1,false);
	//	primes.set(cap)

		for(long i = 2; i<cap; i++){
			if(primes.get(i) == true){
				for(long j = i*i; j<cap; j+=i){
					primes.set(j,false); 
				}
			}
		}
		long count = 0; 

		for(long i = 1; i<cap; i++)
			if(primes.get(i) == true)
				count++;

		System.out.println(count); 

		for(int i = 0; i<q; i++){
			long val = Long.parseLong(br.readLine()); 

			if(primes.get(val) == true)
				System.out.println("1");
			else
				System.out.println("0"); 
		}
	}
} 