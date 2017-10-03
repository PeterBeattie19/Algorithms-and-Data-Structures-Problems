public class ProjectEuler30 {
    public static void main(String[] args) {
        // TODO code application logic here
        long n = 10;
        long sum = 0;
		long start = System.currentTimeMillis();
        	while(n<355000){
        		if(isSum(n)){
        			sum += n;
        		//	System.out.println(n);
        		}
        			n = n + 1;
        	}

        	long end = System.currentTimeMillis();
        		System.out.println(end-start);
				System.out.println(sum);


    }

    public static boolean isSum(long n){
    	String s = String.valueOf(n);
    	long sum = 0;

    		for(int i = 0; i<s.length(); i++){
    		//	sum += (long)Math.pow(Long.parseLong(s.substring(i,i+1)),5);
    		sum += power5(Long.parseLong(s.substring(i,i+1)));
    			if(sum>n) return false;
    		}

    	if(sum==n) return true;

    	else return false;
    }

    public static long power5(long n){
    	long ret = 1;

    		for(long i = 1; i<=n; i++){
    			ret *=  n;
    		}

    		return ret;
    }
}
