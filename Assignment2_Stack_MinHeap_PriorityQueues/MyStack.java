//Thi Thanh Tra Kieu #261066512
//reference: https://www.youtube.com/watch?v=AzMA2ldkt-w

/**
 * array-based Stack;
 */
import java.util.EmptyStackException;
import java.util.Scanner;
public class MyStack{
	private int size;
	private int [] array;
	public MyStack(int length) {
		this.size = 0;
		this.array = new int[length];
	}
	
/**
 * 
 * @param data
 */
	public void push(int data) {
		if(size < array.length) {
			if(size==0) 
				array[0] = data;
			else 
				array[size] = data;
			size++;	
		}
	}

/**
 * pop the last element
 * @return data
 */
	public int pop() {
		if(size <= 0) throw new EmptyStackException();
		int data = array[size-1];
		array[size-1] = 0;
		size--;
		return data;
	}

/**
 * add two last elements
 */
	public void add() {		
		if(size>=2 && size<array.length) {
			int data = 0;
			for(int i = 0; i<2; i++) {
				data += pop();
			}
			push(data);			
		}
	}

/**
 * 	multiply two last elements
 */
	public void multiply() {
		if(size>=2 && size<array.length) {
			int data = 1;
			for(int i = 0; i<2; i++) 
				data *= pop();
			push(data);			
		}
	}
	
//	print all the stacks items without popping them


/**
 * @override toString()
 * @return s
 */
	public String toString() {
		if(size ==0) throw new EmptyStackException();
		String s = "";
		for(int i = size-1; i>=0; i--) {
			if(i==0) 
				s+=array[i];
			else 
				s+=array[i] + ", ";		
		}
		return s;
	}

/**
 * add: +
 * multiply: *
 * print Stack: ?
 * pop: p, P
 * exit: z, Z
 * @param args
 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack(5);
		System.out.println("Please enter the next values or symbols: ");
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String s = scanner.nextLine();
			int data = -1;
			try{
				data = Integer.parseInt(s);
				myStack.push(data);	
			}catch (NumberFormatException e){
			if(s.equals("+")) 	
				myStack.add();
			else if(s.equals("*"))
				myStack.multiply();
			else if(s.equalsIgnoreCase("P")) {
				try{
				data = myStack.pop();
				System.out.println(data);
				}catch(Exception a) {};		
				
			}
			else if(s.equals("?"))
				try {
					System.out.println(myStack.toString());
				}catch (EmptyStackException b) {}
				
			else if(s.equalsIgnoreCase("Z")) break;
			}					
		}
		scanner.close();
	
	}
}



