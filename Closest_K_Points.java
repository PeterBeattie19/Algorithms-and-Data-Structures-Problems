import java.util.*; 
import java.io.*; 

public class Closest_K_Points {

	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int numOfPoints = Integer.parseInt(br.readLine()); 
		int k = Integer.parseInt(br.readLine()); 
		String line[]; 

		Point arr[] = new Point[numOfPoints]; 

		for(int i = 0; i<numOfPoints; i++){
			line = br.readLine().split(" "); 

			int a = Integer.parseInt(line[0]); 
			int b = Integer.parseInt(line[1]); 

			arr[i] = new Point(a,b); 
		}

		Arrays.sort(arr, new PointComparator()); 

		for(int i = 1; i<=k; i++)
			System.out.println(arr[numOfPoints-i].x +" "+ arr[numOfPoints-i].y +" "+ arr[numOfPoints-i].dist); 

	}

	public static class Point {
		public int x;
		public int y;
		public double dist;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
			this.dist = Math.sqrt((x*x) + (y*y)); 
		}
	}


   public static class PointComparator implements Comparator<Point>{
        public int compare(Point str1, Point str2){
            if(str1.dist == str2.dist)
                return 0;
            else
                //if return > 0, str1 is the larger number
                if(str2.dist > str1.dist)
                	return 1; 
                return -1;
        }
}
} 