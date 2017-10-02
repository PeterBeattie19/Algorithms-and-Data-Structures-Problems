class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}

	public int getData(){
		return this.data; 
	}

	public void setData(int n){
		this.data = n;
	}
}
