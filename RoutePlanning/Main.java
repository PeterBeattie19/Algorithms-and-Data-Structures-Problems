import java.util.*; 
import java.io.*; 

public class Main{
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		String line[] = br.readLine().split(" "); 

		int r1,c1; 
		r1 = Integer.parseInt(line[0]); 
		c1 = Integer.parseInt(line[1]); 

		int numV = Integer.parseInt(line[2]); 
		int numR = Integer.parseInt(line[3]);
		int bonus = Integer.parseInt(line[4]);
		int steps = Integer.parseInt(line[5]);

		Car cars[] = new Car[numV]; 

		for(int i = 0; i<numV; i++){
			cars[i] = new Car(); 
			cars[i].id = i; 
		}

		Ride rides[] = new Ride[numR]; 


		for(int i = 0; i<numR; i++){
			line = br.readLine().split(" ");

		int x1 = Integer.parseInt(line[0]); 
		int y1 = Integer.parseInt(line[1]); 
		int x2 = Integer.parseInt(line[2]); 
		int y2 = Integer.parseInt(line[3]);
		int e = Integer.parseInt(line[4]);
		int l = Integer.parseInt(line[5]);

		rides[i] = new Ride(x1,y1,x2,y2,e,l); 
		rides[i].id = i; 

		}


		//Pick first ride
		int completed = 0; 

		ArrayList<ArrayList<Ride>> sol = new ArrayList<>(); 
		for(int i = 0; i<numV; i++)
			sol.add(new ArrayList<>()); 


		Car optionC = cars[0]; 
		Ride optionR = rides[0]; 

		while(completed < numR){
			int current = Integer.MAX_VALUE; 

			for(Car c: cars){
				for(Ride r: rides){
					if(r==null)
						continue; 
					if(computeTime(c,r,steps) < current){
						optionC = c;
						optionR = r; 
					}

				}
			}

			calculate(optionC,optionR); 
			sol.get(optionC.id).add(optionR); 

			rides[optionR.id] = null; 

			completed++; 

		}


		for(int i = 0; i<numV; i++){
			System.out.print(sol.get(i).size() +" "); 
			for(int j = 0; j<sol.get(i).size(); j++){
				System.out.print(sol.get(i).get(j).id +" "); 
			}
			System.out.println(); 
		}




	}

	public static int dist(int x1, int y1, int x2, int y2){
		return Math.abs(y2-y1) + Math.abs(x2-x1); 
	}


	public static int computeTime(Car c, Ride r, int steps){
		int total = r.earlyStart - c.time; 
		total += dist(c.x, c.y, r.startX, r.startY); 
		total += dist(r.startX, r.startY, r.finX, r.finY); 


		if (total > steps)
			return Integer.MAX_VALUE; 

		return total; 


	}


	public static void calculate(Car c, Ride r){
		int total = r.earlyStart - c.time; 
		total += dist(c.x, c.y, r.startX, r.startY); 
		total += dist(r.startX, r.startY, r.finX, r.finY); 

		c.time = total; 
		c.x = r.finX;
		c.y = r.finY; 
	}
	
} 
