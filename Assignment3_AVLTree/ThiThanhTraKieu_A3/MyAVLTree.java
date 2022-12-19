//reference: https://www.baeldung.com/java-avl-trees

//Thi Thanh Tra Kieu #261066512

/**
 * create class AVL tree
 */
public class MyAVLTree{	
	 Node root;
	private int size;
	public MyAVLTree(){
		size = 0;
		root = null;
	}

/**
 * Get size of AVL BinaryTree
 */	
	public int getSize() {
		return size;
	}
	

/**
 * use recursive to add data into tree
 * Adding allows duplicated values
 * @param data
 * @param node
 * @return node
 */
	public Node recursiveForAddding(int data, Node node) {  
		Node newNode = new Node(data);
		if(node==null) 
			node = newNode;
		else if(data < node.data) {			
			node.left = recursiveForAddding(data, node.left);
			if(getHeight(node.left) - getHeight(node.right) == 2) {
				if(data < node.left.data)
					node = rotateTowardsRight(node);
				else
					node = rotateRightLeft(node);
			}
		}else {
			node.right = recursiveForAddding(data, node.right);		
			if((getHeight(node.right) - getHeight(node.left) == 2)) {
				if(data >= node.right.data)
					node = rotateTowardsLeft(node);
				else node = rotateLeftRight(node);
			}
		}			
		 node.height = updateHeight(node);
		 return node;
	}

/**
 * insert data into tree
 * insert allows duplicated values
 * @param data
 */
	public void insert(int data) {
	 root = recursiveForAddding(data, root);		
		size++;	
	}	
	
/**
 * delete data
 * @param data
 */
	public void delete(int data) {
		root = recursiveForDeleting(data, root);
		size--;
	}
	
/**
 * find min value of node in its left side
 * @param node
 * @return node
 */
	private Node min (Node node) {
			Node min = node;
			while(min.left != null)
					min = min.left;
			return min;
	}

/**
 * use recursive for deleting
 * @param data
 * @param node
 * @return node
 */
	public Node recursiveForDeleting(int data, Node node) {

		if(node == null)
			return node;
		else if(data < node.data)
			node.left = recursiveForDeleting(data, node.left);
		else if(data > node.data)
			node.right = recursiveForDeleting(data, node.right);
		else {
	// 	node has only 1 side or it is a leave
			if(node.left == null || node.right ==null) {
				Node temp = null;
				if(temp == node.left)
					temp = node.right;
				else
					temp = node.left;
				node = temp;
				temp = null;
	//	node has two sides
			}else {
				Node temp = min(node.right);
				node.data = temp.data;
				node.right = recursiveForDeleting(temp.data, node.right);
			}
		}		
	//	when it is not a leave, use rebalance to rotate the nodes into right positions	
			if(node != null) {
				node = rebalance(node);	
			}	
		return node;	
	}

/**
 * get balance of a node
 * @param node
 * @return
 */
	int getBalance(Node node) { 
        if (node == null) 
            return 0; 
        return getHeight(node.left) - getHeight(node.right); 
    } 

/**
 * rebalance to rotate the nodes into right positions
 * @param node
 * @return node
 */
	private Node rebalance(Node node) {
	// update the height of node
		updateHeight(node);
	// if balance of node is equal to 2 or equal to -2, rotate it into right position.
		int balance = getBalance(node);
		if(balance == 2) {
			if(getHeight(node.left.left) > getHeight(node.left.right))
				node = rotateTowardsRight(node);
			else 
				node = rotateRightLeft(node);			
		}else if(balance == -2) {
			if(getHeight(node.right.right) >= getHeight(node.right.left))
				node = rotateTowardsLeft(node);
			else 
				node = rotateLeftRight(node);								
		}
		return node;
	}
	
/**
 * finding height of a node
 * @param node
 * @return height of node
 */
	public int getHeight(Node node) {
		if(node == null) return -1;
		return node.height;
	}

/**
 * 
 * @param node
 * @return
 */
	private int updateHeight(Node node) {
		node.height = Math.max(getHeight(node.left), getHeight(node.right))  +1;
		return node.height;
	}

/**
 * rotate node from left to right    
 * @param node
 * @return node
 */
	private Node rotateTowardsRight(Node node)  
	    {  
	        Node temp = node.left;  
	        node.left = temp.right;  
	        temp.right = node;  
	        node.height = updateHeight(node);  
	        temp.height = Math.max( getHeight(temp.left), node.height ) + 1;  
	        return temp;  
	    }  
	   
/**
 * rotate node from right to left 
 * @param node
 * @return
 */
	private Node rotateTowardsLeft(Node node)  
	    {  
	    	Node temp = node.right;
	    	node.right = temp.left;
	    	temp.left = node;
	        node.height = updateHeight(node);  
	        temp.height = Math.max(getHeight(temp.right), node.height)  + 1;	        
	        return temp;  
	    }  
	    
/**
 * first rotate the left node with the right node, and after that, node with the new left node  
 * @param node
 * @return node
 */    
	private Node rotateRightLeft(Node node){    
	        node.left = rotateTowardsLeft( node.left );  
	        return rotateTowardsRight( node );  
	    }  
	  	
/**
 * first rotate the right node with the left node and after that node with the new right node  
 * @param node
 * @return
 */
	private Node rotateLeftRight(Node node){  
	        node.right = rotateTowardsRight( node.right );  
	        return rotateTowardsLeft( node);  
	    }      	

/**
 * search data in the tree
 * @param data
 * @param node
 * @return true or false
 */
	public boolean search(int data, Node node) {
		if(node == null)
			return false;		
		else if(data < node.data)
				return search(data, node.left);
		else if(data > node.data)
				return search(data, node.right);
		else {
				return true;							
		}		
	}

/**
 * print tree in preorder
 * @param node
 */
	public void printPreorder (Node node) {
		if(node==null)
			return;
		System.out.print(node.data+ " ");
		
		printPreorder(node.left);
		
		printPreorder(node.right);
	}
	
}

/**
 * create class Node
 */
class Node{
	int data;
	int height;
	Node left; 
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
		height = 0;
	}
}
