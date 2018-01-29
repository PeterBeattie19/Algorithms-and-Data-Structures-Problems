import java.util.*; 

public class TravellingSalesMan{
	public static void main (String args[]){
		Scanner scan = new Scanner(System.in); 

		ArrayList<Node> graph = new ArrayList<>(); 

		for(int i = 0; i<10; i++){
			graph.add(new Node(scan.nextInt(), scan.nextInt())); 
		}


		HashSet<Node> visited = new HashSet<>(); 
		ArrayList<Node> solution = new ArrayList<>(); 
		Node current = graph.get(0); 
		visited.add(current); 
		solution.add(current); 

		for(int i = 0; i<9; i++){
			double sml = Double.POSITIVE_INFINITY; 
			Node smallest = current; 
			for(Node n: graph){
				//if(current.equal(n))
					//continue;

				if((visited.contains(n) == false) && current.dist(n) < sml && current.equal(n)==false){
					sml = current.dist(n); 
					smallest = n; 
				}
				//System.out.println(n.x +" "+ n.y);
			}

			solution.add(smallest); 
			visited.add(smallest); 

			current = smallest; 
		}

		for(Node n: solution)
			System.out.println(n.x +" "+ n.y); 
	}

	public static class Node {
		int x;
		int y; 

		public Node(int x, int y){
			this.x = x;
			this.y = y; 
		}

		public boolean equal(Node n){
			if(n.x == this.x && n.y == this.y)
				return true; 

			return false; 
		}

		public double dist(Node n){
			int diffX = Math.abs(n.x - this.x);
			int diffY = Math.abs(n.y - this.y); 
			diffX *= diffX;
			diffY *= diffY; 

			return Math.sqrt(diffY + diffX); 
		}
	}
} 