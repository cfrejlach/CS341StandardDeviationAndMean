package chris;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedList.
 * 
 * @author Chris
 * 
 */
public class LinkedList {   

	      
	    /** The head. */
    	public static Node head = null;    
	    
    	/** The tail. */
    	public static Node tail = null; 
	    
	    /** The size. */
    	public static int size = 0;
	        
	      
	    /**
    	 * Adds the node.
    	 *
    	 * @param data the data
    	 */
    	public static void addNode(double data) {    
	  
	        Node newNode = new Node(data);    
    
	        if(head == null) { 
	        	size++;
	            head = newNode;    
	            tail = newNode;    
	        }    
	        else { 
	        	size++;
	            tail.next = newNode;      
	            tail = newNode;    
	        }    
	    }    
	            
	    /**
    	 * Gets the head.
    	 *
    	 * @return the head
    	 */
    	public static Node getHead() {
			return head;
		}

		/**
		 * Gets the tail.
		 *
		 * @return the tail
		 */
		public static Node getTail() {
			return tail;
		}

		/**
		 * Display.
		 */
		public void display() {    
	        //mainly for tests for displaying nodes in linked list
	        Node current = head;    
	            
	        if(head == null) {    
	            System.out.println("List is empty");    
	            return;    
	        }    
	        System.out.println("Nodes of singly linked list: ");    
	        while(current != null) {      
	            System.out.print(current.data + " ");    
	            current = current.next;    
	        }    
	        System.out.println();    
	    }

		/**
		 * Gets the size.
		 *
		 * @return the size
		 */
		public static double getSize() {
			// TODO Auto-generated method stub
			return size;
		}    
}    