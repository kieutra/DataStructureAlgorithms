//Thi Thanh Tra KIEU - 261066512
//Part 1
//Reference: https://www.youtube.com/watch?v=5XJGIDonHg4



public class MyLinkedList {
	private static class Node{
		int data;
		Node next;
		Node (int data){
			this.data = data;
			next = null;
		}
	}
	private Node head = null;
	private int size =0;

//	Add the elements to the head of the Linked List
	public void add (int data) {
		Node newNode = new Node (data);
		if(head !=null)		
			newNode.next = head;					
		head = newNode;
		size++;
	}
	
//	Delete a node including given data
	public void remove (int data) {
		
		Node currentNode;
		if (head !=null) {
			currentNode = head;
			if(currentNode.data == data) {
				head = currentNode.next;
				size --;
			}else {
				Node previousNode = null;
				while(currentNode!=null) {					
					if(currentNode.data == data) break;
					else
						{
							previousNode = currentNode;							
							currentNode = currentNode.next;
						}
				}
				if(currentNode !=null){
					previousNode.next = currentNode.next;		
					size --;	
				} 
				
			}		
			
		}
	}
	
	//Return head of linked list
	public Node getHead() {
		return head;
	}
//	Return the size of linked list
	public int size() {
		 return size;
	}
	
//	Check if a Linked List has a value
	public boolean contain(int data) {
		if(head !=null) {
			Node currentNode = head;
			while(currentNode !=null) {
				if(currentNode.data == data) {
					return true;					
				}
				currentNode = currentNode.next;
			}
		}
		return false;
		
	}
	
//	Return a string
	public String toString() {
		String s = "";
		if(head!=null) {
			Node currentNode = head;
			while(currentNode!=null) {
				s += currentNode.data;
				if(currentNode.next!=null) s+="->";
				currentNode = currentNode.next;
			}
		}
		return s;
		
	}
	/**
	 * 
	 * @param b
	 * @return true
	 */
//	Compare two linked list to check if they have the same value
	public boolean compare(MyLinkedList b) {
		if(this.size!=b.size) return false;
		else {
			Node currentNode = this.head;
			Node currentB = b.head;
			for(int i = 0; i < this.size; i++) {
				if(currentNode.data != currentB.data) return false;
				else {
					currentNode = currentNode.next;
					currentB = currentB.next;
				}
			}			
		}
		return true;
		
	}
/**
 * 
 * @param s
 */
	public static void fun(Node s){
			if(s==null) return;
			System.out.print(s.data+" ");
			if(s.next!=null){
				fun(s.next.next);
				System.out.print(s.data+" ");
			}
	}

	/**
	 * 
	 * @param buffer
	 */
	public static void inversePrint(Node buffer){
		if(buffer.next ==null) 
			System.out.print(buffer.data+"->");
		else buffer = buffer.next;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyLinkedList a = new MyLinkedList();
		// a.add(3);
		// a.add(1);
		// a.add(3);
		// a.add(2);
		// a.add(1);
		// System.out.println("MyLinkedList a: ");
		// System.out.println("The size is: "+a.size());
		// System.out.println("The string is: "+ a.toString());
		
		// a.remove(3);

		
		// System.out.println("MyLinkedList a after removing 3");
		// System.out.println("The size is: "+a.size());
		// System.out.println("The string is: "+ a.toString());
		// System.out.println("My linked list a contains 4?: "+a.contain(4));
		
		// MyLinkedList b = new MyLinkedList();
		// b.add(3);
		// b.add(2);
		// b.add(1);
		// b.add(3);
		// b.add(1);
		
		// System.out.println("MyLinkedList b:");
		// System.out.println("The size is: "+b.size());
		// System.out.println("The string is: "+ b.toString());
		
		// b.remove(1);

		
		// System.out.println("MyLinkedList b after removing 1: ");
		// System.out.println("The size is: "+b.size());
		// System.out.println("The string is: "+ b.toString());
		// System.out.println("My linked list contains 2?: "+b.contain(2));

		// System.out.println("Linked list a has the same value as b? "+ a.compare(b));
		
		a.add(6);
		a.add(5);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);

		System.out.println("The string is: "+ a.toString());
		Node buffer = a.getHead();
		inversePrint(buffer);

	}
	

}
