import java.util.*; 

public class GA{
	int mutationRate = 0.015; 
	public Population evolvePopulation(Population p){
		Population newPop = new Population(p.size(), false); 

		Tour t = p.getFittest(); 

		newPop.setTour(0,t); 

		for(int i = 1; i<p.size(); i++){
			Tour t1 = tournamentSelection(p);
			Tour t2 = tournamentSelection(p); 

			Tour finalTour = crossOver(t1,t2); 

			newPop.setTour(i,finalTour);  
		}

		for(int i = 0; i<newPop.size(); i++){
			Tour temp = mutate(newPop.getTour(i)); 
			newPop.setTour(i,temp); 
		}

		return newPop; 
	}

	public Tour crossOver(Tour t1, Tour t2){
		Tour child = new Tour(); //***Make default constructor***//
		HashSet<Node> vis = new HashSet<>(); 
		int start = Math.random()*t1.size(); 
		int end = Math.random()*t1.size();

		if(start > end){
			//Swap
			end = end + start; 
			start = end - start; 
			end = end - start; 
		} 



		for(int i = 0; i<t1.size(); i++){
			if(i >= start || i<=end){
				child.setNode(i,t1.getNode(i)); 
				vis.add(t1.getNode(i)); 
			}
		}
	}

	public Tour mutate(Tour t){
		for(int i = 0; i<t.size(); i++){
			int pos1 = i; 
			int pos2 = Math.random()*t1.size(); 

			if(pos2 < mutationRate){
				//***FILL IN***//
				int count = 0; 
				while(!check(t.getNode(pos1-1),t.getNode(pos2),t.getNode(pos1+1)) && check(t.getNode(pos2-1),t.getNode(pos1),t.getNode(pos2+1))){
					int pos2 = Math.random()*t1.size(); 
				}
				//Swap
				Node temp = t.getNode(pos1); 
				t.setNode(pos1,t.getNode(pos2)); 
				t.setNode(pos2,temp); 
			}
		}
		return t; 
	}

	public Tour tournamentSelection(Population p){

	}

	private boolean check(Node n1,Node n2,Node n3){
		return (Math.abs(n1.id-n2.id) <= 100 && Math.abs(n2.id-n3.id)<=100); 
	}
}