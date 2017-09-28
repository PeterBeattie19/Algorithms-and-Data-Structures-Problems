/*
Ackermann's function is inatley recursive, ie not primitive recursive, it cannot be computed
recursively, each value is easily computed until m=4 n=2 which takes (3*2^65353)minutes,
the resulting value will have 26,000 decimal places. 
*/


public class Ackermann{
  public static void main(String[] args) {
    for(int i = 0; i<6; i++){
      for(int j = 0; j<9; j++){
        System.out.println("m: " +i+" , n: "+j+" , value: " +ackermann(i,j));
      }
      System.out.println();
      System.out.println();
      System.out.println();
    }
  }

  public static int ackermann(int m, int n){
    if(m==0) return n+1;
    else if(m>0 && n==0) return ackermann(m-1,1);
    else return ackermann(m-1,ackermann(m,n-1));
  }
}
