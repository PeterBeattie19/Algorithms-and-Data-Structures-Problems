public class Node{
	double x;
	double y; 
	int id; 
	String name; 

	public Node(String s){
		String line[] = s.split(","); 
		this.name = "";
		this.id = Integer.parseInt(line[0]) - 1; 
		this.x = Double.parseDouble(line[line.length - 2]);
		this.y = Double.parseDouble(line[line.length - 1]);
			
		for(int i = 1; i < line.length-2; i++)
			this.name += line[i]; 
	}

	public double dist(Node n){
		return haversine(this.x, this.y, n.x, n.y); 
	}

	private double haversine(double lat1, double lon1, double lat2, double lon2) {
        double lat = Math.toRadians(lat2 - lat1);
        double lon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double x = Math.pow(Math.sin(lat/2),2)+Math.pow(Math.sin(lon/2),2)*Math.cos(lat1)*Math.cos(lat2);
        return 6371*(2 * Math.asin(Math.sqrt(x)));
	}

	public void resetAttributes(double x, double y, int id, String name){
		this.x = x;
		this.y = y; 
		this.id = id; 
		this.name = name; 
	}
}