import java.util.NoSuchElementException;

public class CellList {
	private Node head;
	private int size;
	
	private class Node{
		private CellPhone cell;
		private Node next;
		
		public Node() {
			cell = null;
			next = null;
		}
		public Node(CellPhone cell, Node next) {
			this.cell = cell.clone();
			this.next = next;
		}
		public Node(Node node) {
			this.cell = node.cell.clone();
			this.next = node.next;
		}
		public Node clone() {
			return new Node(this);
		}
		public CellPhone getCell() {
			return cell;
		}public Node getNext() {
			return next;
		}public void setCell(CellPhone cell) {
			this.cell = cell;
		}public void setNext(Node next) {
			this.next = next;
		}
	}
	public CellList() {
		head = null;
	}
	public CellList(CellList list) {
		if(list.head == null) {
			head = null;
		}else {
			head = null;
			Node t1, t2, t3;
			t1 = list.head;
			t2 = t3 = null;
			while(t1 != null)	
			{
				if (head == null)	// this happens only once
				{
					t2 = new Node(t1);	
					head = t2;
				}
				else 
				{
					t3 = new Node(t1);		
					t2.next = t3;
					t2 = t3;												
				}
				t1 = t1.next;
				this.size++;
			}
			t2 = t3 = null; 	// t1 is already null by now
		}
		
	}
	public void addToStart(CellPhone cell)
	{
		Node n = new Node(cell, head);	     
		head = n; 						
		n = null;							
	}
	public boolean insertAtIndex(CellPhone cell, int index) {
		if (head == null)
		{
			System.out.println("\nList is empty. Value " + index + " cannot be found"+
	                                 "in the list. No insertion is possible");
			return false;
		}
		if(index < 0 || index > this.size - 1) {
			throw new NoSuchElementException();
		}
		if(index == 0) {
			addToStart(cell);
		}
		Node node = head;
		while (--index > 0) {
            node = node.next;
        }
		Node newNode = new Node(cell, node.next);
		node.next = newNode;
		this.size++;
		return true;
	}
	public void deleteFromIndex(int index) {
		if(index < 0||index > this.size -1) {
			throw new NoSuchElementException();
		}
		Node prev = null, node = head;
	    // Find node to remove:
	    while (index > 0 && node != null) {
	        --index;
	        prev = node;
	        node = node.next;
	    }
	    // If exists, unpin it from the list:
	    if (node != null) {
	        if (prev == null) {
	            // Removed 1st, so change the head:
	            deleteFromStart();
	        } else {
	            // Just connect prev with next:
	            prev.next = node.next;
	        }
	    }
	}
	public boolean deleteFromStart()
	{
		if (head != null)
		{
			head = head.next;
			return true;
		}
		else
			return false;
	}
	public void replaceAtIndex(CellPhone cell, int index) {
		if(index < 0 || index > this.size - 1) {
			return;
		}
		Node n = find(cell.getSerialNum());
		if(n == null) {
			System.out.println("Could not find value " + index + " in the list"+
					  "no replacement is possible.");
			
		}
		n.setCell(cell);
	}
	public Node find(long sn)
	{
		int iterations = 0;
		Node t = head;
		while(t != null)
		{
			if (t.cell.getSerialNum() == sn)
				return t;		// Is that dangerous ?????? 
			t = t.next;
			iterations++;
		}
		return null;			// value was not found in the list
	}
	public boolean contains(long sn)
	{
		if(find(sn) != null)
			return true;
		else 
			return false;
	}
	public void showContents()
	{
		Node temp = head;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list is"+
                                         "empty." );
		else {
			System.out.print("The current size of the list is: "+this.size);
			System.out.println("\nHere are the contents of the list." );
			while(temp != null)
			{
				System.out.println("["+temp.cell+"]"+" ---> ");
				temp = temp.next;		
			}
			System.out.println("X");
		}			
	}
	public boolean equals(CellList list) {
		if(this.size != list.size)
			return false;
		Node node1 = this.head;
		Node node2 = list.head;
		while(node1 != null && node2 != null) {
			if(node1.cell.equals(node2.cell))
	            return false;
	        node1 = node1.next;
	        node2 = node2.next;
		}
		return true;
	}

}
