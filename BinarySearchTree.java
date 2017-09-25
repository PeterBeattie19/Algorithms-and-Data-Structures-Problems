public class BinarySearchTree {
	private Node root;

	public void insert(int n){
		Node newNode = new Node(n);

		if(root==null) root = newNode;

		else {
			Node parent;
			Node current = root;

			while(true){
				parent = current;

				if(n<current.data){
					current = current.left;

					if(current==null){
						parent.left = newNode;
						return;
					}
				}

				else {
					current = current.right;

					if(current==null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}


	public Node find(int n){

		Node current = root;

		while(current.data!=n){
			if(n<current.data) current = current.left;

			else current = current.right;

			if(current==null) return null;
		}

		return current;
	}

	public void print(){
		inOrder(root);
	}


	private void inOrder(Node n){
		if(n != null){
			inOrder(n.left);

			System.out.print(n.data +" ");

			inOrder(n.right);
		}
	}

	public int height(){
			return height2(root);
	}

	private int height2(Node n){
			if(n == null) return 0;

			else {
					return 1 + Math.max(height2(n.left), height2(n.right));
			}
	}



}
