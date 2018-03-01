import java.util.*; 

public class Ride implements Comparable<Ride>{
	int startX, startY; 
	int finX, finY; 
	int earlyStart, lateFin; 
	int id; 

	public Ride(int x1, int y1, int x2, int y2, int e, int l){
		this.startY = y1;
		this.startX = x1;

		this.finY = y2;
		this.finX = x2; 

		this.earlyStart = e;
		this.lateFin = l; 
	}

   public int compareTo(Ride object){ 

   	return this.earlyStart - object.earlyStart; 

   }
}
