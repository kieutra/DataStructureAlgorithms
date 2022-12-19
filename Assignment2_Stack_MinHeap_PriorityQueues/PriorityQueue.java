//Thi Thanh Tra Kieu #261066512
//reference: lecture of Farhad
/**
 * array-base priority queue
 */
public class PriorityQueue {
	private int [] arr;
	private int size;
	private int capacity=100;
	public PriorityQueue() {
		arr = new int[capacity];
		size = 0;
	}
/**
 * 
 * @return size of queue
 */
	public int size() {
		return size;
	}

/**
 * 
 * @return true if queue is empty
 */
	public boolean isEmpty() {
		if(size==0) return true;
		return false;
	}

/**
 * insert data into queue
 * @param data
 */
	public void insert(int data) {
		if(size==0) {
			arr[capacity-1]=data;
			size++;
		}else if(size>0 && size<capacity) {
			arr[capacity-1-size] = data;
			size++;
		}else 
			System.out.println("the queue is full");
	}	
	
/**
 * 
 * @return minimum value
 */
	public int min() {
		if(size==0)
			throw new IllegalStateException("The queue is empty");
		int min = arr[capacity-1];
		for(int i = capacity-1; i>=capacity-size; i--) {
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
/**
 * 
 * @return and remove minimum value
 */
	public int removeMin() {
		if(size==0)
			throw new IllegalStateException("The queue is empty");
		int min = arr[capacity-1];
		for(int i = capacity-1; i>=capacity-size; i--) {
			if(arr[i] < min)
				min = arr[i];
		}
		for(int i = capacity-1; i>=capacity-size; i--) {
			if(arr[i]==min) {
				for(int j=i; j>capacity-size;j--)
					arr[j]=arr[j-1];
				break;
			}		
		}
		size--;
		return min;		
	}	
	
	
/**
 * @override toString()
 * @return s
 */
	public String toString() {
		String s = "";
		for(int i = capacity-size; i<capacity; i++) {
			s= s+ arr[i]+", ";
		}
		return s;	
	}
}
