import java.util.*; 
import java.io.*;

public class MutateTSP {
	public static void main(String[] args) throws IOException{
		ArrayList<Node> graph = new ArrayList<>(); 
		readCSV(graph); 

		Population p = new Population(100,true); 
		double soFar = Double.POSITIVE_INFINITY; 
		Tour bestSoFar = new Tour(); 

		while(true){
			Tour t = p.getFitest(); 
			//System.out.println(t.toString()); 
			double dist = t.getDistance(); 
			if(dist < soFar){
				soFar = dist; 
				bestSoFar = t; 
				System.out.println(dist); 
				if(dist < 6900000)
					System.out.println(t.toString());

				
			}
			
			p.setAll(t); 
			p.mutateAll(); 



		}


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