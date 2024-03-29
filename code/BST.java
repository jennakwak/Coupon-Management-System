package Project_LL;

//create BST to search data from the data list

class BST {
	
	class Node {
		//instance variable of Node class
		public Coupon data;
	    public Node left;
	    public Node right;

	    //constructor for user or file input data
	    public Node(Coupon data) {
	    	this.data = data;
	        this.left = null;
	        this.right = null;
	        }
	    }
	// variable for root of the tree
	public Node root;
	
	// constructor to make root null initially
	public BST() {
		this.root = null;
		}
	
	// insert method to insert the new Data
	public void insert(Coupon Data) {
		this.root = insert(root, Data);
		}
	public Node insert(Node root, Coupon Data) {
		// if root is null, root has new node data
		if (root == null) {
			root = new Node(Data);
			return root; // return the current root to sub tree
			}
		//compare the root data and new data to determine where new data will be located in the tree
		else if (root.data.productName.compareTo(Data.productName) > 0) {
	          root.left = insert(root.left, Data); //new data goes left sub tree if the root data is greater than the new data
	          } else {
	        	  root.right = insert(root.right, Data);//new data goes right sub tree if the root data is less than the new data
	        	  }
		return root;
		}

	  // search method to search by the producName that user input on the menu
	public SearchNode search(String productName) {
		int[] counter = new int[] { 1 }; //first counter starts with 1
		return search(this.root, productName, counter);
		}
	
	private SearchNode search(Node root, String productName, int[] counter) {
		//if root is empty, nothing is found from the tree
		if (root == null) {
			return new SearchNode(false, counter[0], null);
			} 
		//if root data is equal to the producName that user input on the menu, the data is found from the list and return
		if (root.data.productName.equals(productName)) {
			return new SearchNode(true, counter[0], root.data);
			} 
		//if root data is greater than user input, search the data from left sub tree and increment the count until it's found
		else if (root.data.productName.compareTo(productName) > 0) {
			counter[0] = counter[0] + 1;
			return search(root.left, productName, counter);
			}
		//if root data is less than user input, search the data from right sub tree and increment the count until it's found
		counter[0] = counter[0] + 1;
		return search(root.right, productName, counter);
		}
}


	