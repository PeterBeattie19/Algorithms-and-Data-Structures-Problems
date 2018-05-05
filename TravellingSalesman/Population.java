import java.util.*; 
import java.io.*;

public class Population{
	Tour tours[]; 

	public Population(int size, boolean init) throws IOException{
		tours = new Tour[size]; 
		ArrayList<Node> graph = new ArrayList<>(); 
		readCSV(graph); 

		if(init){
			for(int i = 0; i<size; i++){
				tours[i] = new Tour(); 
				tours[i].generateTour(graph); 
			}
		}
	}

	public void setAll(Tour t){
		for(int i = 0; i<tours.length; i++){
			tours[i] = t; 
		}
	}
	public void setTour(int pos, Tour t){
		tours[pos] = t; 
	}

	public Tour getTour(int pos){
		return tours[pos]; 
	}

	public Tour getFitest(){
		double bestDist = Double.POSITIVE_INFINITY; 
		Tour bestTour = new Tour(); 
		for(Tour t: tours){
			double d = t.getDistance(); 
			if(d < bestDist){
				bestTour = t; 
				bestDist = d;
			}
		}
		return bestTour; 
	}

	public int size(){
		return this.tours.length; 
	}

	public void mutateAll(){
		for(int i = 0; i<tours.length; i++){
			Tour t = mutate(tours[i]); 
			setTour(i,t); 
		}
	}

	public Tour mutate(Tour t){
		for(int i = 1; i<t.size()-1; i++){
			int pos1 = i; 
			int pos2 = (int)(Math.random()*(t.size()-3))+1; 

			if(Math.random() < 0.015){
				//***FILL IN***//
				int count = 0; 
				while(check(t.getNode(pos1-1),t.getNode(pos2),t.getNode(pos1+1)) == false || check(t.getNode(pos2-1),t.getNode(pos1),t.getNode(pos2+1)) == false){
					pos2 = (int)(Math.random()*997)+1;  
				}


				double x = t.getNode(pos1).x; 
				double y = t.getNode(pos1).y; 
				int id = t.getNode(pos1).id; 
				String name = t.getNode(pos1).name; 


				t.getNode(pos1).resetAttributes(t.getNode(pos2).x, t.getNode(pos2).y,t.getNode(pos2).id,t.getNode(pos2).name); 
				t.getNode(pos2).resetAttributes(x,y,id,name);
				
			}
		}



		return t; 
	}

	private boolean check(Node n1,Node n2,Node n3){
		if(Math.abs(n1.id-n2.id) > 100 || Math.abs(n2.id-n3.id) > 100){
			return false;
		}
		return true; 
	}

	public static void readCSV(ArrayList<Node> graph) throws IOException{
        String fileNameDefined = "Book1.csv";
        File file = new File(fileNameDefined);

        BufferedReader br = new BufferedReader(new FileReader(file)); 

        String line = br.readLine(); 

        while(true){   
        	line = br.readLine();  
        	//System.out.println(line);   
        	if(line == null)
        		break;
			graph.add(new Node(line)); 
		}
		
		br.close();  

	}

}