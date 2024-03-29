package Project_LL;

//create master LinkedList class for coupons

class CouponLL {
	//instance variable of the class
	private Node head;
	private Node tail;
	int size = 0;
	  
	//create separate class to have Node type, and store data and link field
	class Node { 
		
		private Coupon data; //data variable from Coupon class
	    public Node next; //next variable will link nodes
	    public Node(Coupon input) { //constructor to input data
	      this.data = input; 
	      this.next = null; //set the link null
	    }
	    public String toString() { //to print the data
	      return String.valueOf(this.data); 
	    }
	    //isFull true-> if the data input is from user manually or from file, false -> data from dummy data
	    public boolean isFull; 
		public Node() {
			
		}
	}
	
	//constructor for user to input more data manually
	public CouponLL() {
		
	}
	public CouponLL (int size) { //user size input method
		this.size = size;
		Node prev = null; // create empty node
		// to create number of nodes that user input(size)
		for (int i = 0; i < size; i++) {
			Coupon s = new Coupon("ZZZZZZZZZ", "ZZZZZZZZ", Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, "ZZZZ");
			s.finalPrice = Double.MAX_VALUE; //dummy data to fill the nodes that was not in the data file
			Node node = new Node(s); //make nodes for 'size' times
			if(head == null) { //if head is empty, the first node becomes head and tail
				head = node;
				tail = head;
				}
			if(prev != null) { //if previous node is not empty, the new node is linked after the prev node, and now prev becomes new node
				prev.next = node;
				}
			prev = node;
			}
		}
	
	// add method for Linked List
	public void add(Coupon input) {
		if(tail != null) { 
			tail.isFull = true; //meaning that list is filled with data from user input or data file 
			tail.data = input;
			tail = tail.next;
			}
		//if tail is the last node of the list, link the new node after
		else {
			Node node = new Node(input); 
			size++;
			node.isFull = true;
			tail.next = node;
			tail = node;
			}
		}
	
	// merge sort method by the keyField that user input on the menu
	public void sort(String key) { //constructor 
		head = mergeSort(head, key);
		}
	//merge each separated lists
	public Node mergeSort(Node head, String key) {
		if (head == null || head.next == null) 
			return head;
		Node mid = getMiddle(head);
	    Node midNext = mid.next;
	    mid.next = null;

	    Node leftHead = mergeSort(head, key);
	    Node rightHead = mergeSort(midNext, key);

	    return merge(leftHead, rightHead, key);
	    }
	// switch the position after comparing
	private Node merge(Node left, Node right, String key) {
		if (left == null) 
			return right;
	    if (right == null) 
	    	return left;
	    if (left.data.compare(right.data, key) < 0) {
	      left.next = merge(left.next, right, key);
	      return left;
	    } else {
	      right.next = merge(left, right.next, key);
	      return right;
	    }
	  }
	//method to get midpoint of the linkedlist by loop
	public Node getMiddle(Node head) {
		if (head == null) 
			return head;
		Node slow = head;
	    Node fast = head;
	    while (fast.next != null && fast.next.next != null) {
	      slow = slow.next; //1st mid
	      fast = fast.next.next; //2nd mid
	    }
	    return slow;
	  }
	
	// create linear search method by name of the product 
	public SearchNode search(String productName) {
		Node currPointer = head;
	    int index = 1;
	    //search the node until the head is equal to the productName that user input on the menu
	    while (currPointer != null) {
	      if (currPointer.data.productName.equals(productName)) {
	        return new SearchNode(true, index, currPointer.data);
	        }
	      index++;
	      currPointer = currPointer.next;
	      }
	    return new SearchNode(false, index, null); // the coupon is not found on the list
	    }
	
	//toString method to print the output 
	public String toString() {
		//if head is empty, print empty list
		if(head == null) {
			return "[]";
		}
		Node temp = head;
	    String str = "";
	    // the list is not empty and filled with data from file or user, distinguish each node data with ",\n"
	    while(temp.next != null && temp.isFull) { //dont show dummy data
	    	str += temp.data.toString() + ", \n";
	    	temp = temp.next;
	    	}
	    return str + "";
	    }
	}

