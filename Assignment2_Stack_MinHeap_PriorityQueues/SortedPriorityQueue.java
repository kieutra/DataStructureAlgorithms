//Thi Thanh Tra Kieu #261066512
//reference: lecture of Farhad

/**
 * array-based sorted priority queue
 */
public class SortedPriorityQueue {
	private int [] arr;
	private int size;
	private int capacity = 100;
	public SortedPriorityQueue() {
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
//			find value max in array
			int max = arr[capacity-size];
			for(int i = capacity-1; i>=capacity-size; i--) {
				if(arr[i] > max)
					max = arr[i];
			}
//			in the case of data smaller than max
			if(data < max) {
				for(int i=capacity-1; i>=capacity-size; i--) {
					if(data < arr[i]) {		
						for(int j = capacity-size-1; j<i; j++) {
							arr[j] = arr[j+1];
						}					
						arr[i] = data;
						size++;
						break;	
					}
				}
//			in the case of data equal or bigger than max
			}else {
				arr[capacity-size-1] = data;
				size++;
			}
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
		return min;
	}
	
/**
 * 
 * @return and remove minimum value
 */
	public int removeMin() {
		if(size==0)
			throw new IllegalStateException("the queue is empty");
		int data = arr[capacity-1];
		capacity--;
		size--;
		return data;
		
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
