//Thi Thanh Tra Kieu #261066512

//reference: lecture of Farhad

/**
 * array-base min heap
 */
public class MinHeap {
	private int [] arr;
	private int size;
	private int capacity = 100;
	public MinHeap() {
		arr = new int[capacity];
		size = 0;
	}
	
/**
 * 
 * @return size of heap
 */
	public int size() {
		return size;
	}

/**
 * 
 * @return true if heap is empty
 */
	public boolean isEmpty() {
		if(size==0) return true;
		return false;
	}

/**
 * add data into heap
 * @param data
 */
	public void add(int data) {
		if(size==0) {
			arr[0] = data;
			size++;	
		}else if(size > 0 && size < capacity) {
			arr[size] = data;
			upHeap(size);
			size++;	
		}else 
			System.out.println("The heap array is full");
	}

/**
 * 
 * @return and remove minimum value
 */
	public int removeMin() {
		int min=arr[0];
		arr[0] = arr[size-1];
		arr[size-1]=0;
		size--;
		downHeap(0);	
		return min;
	}

	
/**
 * To swap parent and child if parent value is greater than its child value, up until root.
 * @param childIndex
 */
	public void upHeap(int childIndex) {	
		while(childIndex!=0) {
			int parentIndex;
			if(childIndex%2==0)
				parentIndex = (childIndex-2)/2;
			else 
				parentIndex = (childIndex-1)/2;
			if(arr[parentIndex] > arr[childIndex]) {
				swapParentChild(parentIndex, childIndex);
				childIndex = parentIndex;		
			}else break;					
		}	
	}
	
/**
 * To swap parent and child if parent value is greater than its child value, down until leaves.
 * @param parentIndex
 */
	public void downHeap(int parentIndex){	
		while(parentIndex * 2  + 1  < size){
			int childLeftIndex = parentIndex * 2  + 1;
			int childRightIndex = parentIndex * 2 + 2;
//			if parent has only left child, swap parent and left child if parent value is greater than child value
			if(parentHasLeftChild(parentIndex) && parentHasRightChild(parentIndex)==false) {
				if(arr[parentIndex] > arr[childLeftIndex]) {
					swapParentChild(parentIndex, childLeftIndex);
					parentIndex = childLeftIndex;
				}else break;
			}

//			if parent has 2 children, swap parent with the one with minimum value
			if(parentHasRightChild(parentIndex) && parentHasLeftChild(parentIndex)) {
				if(arr[childRightIndex] > arr[childLeftIndex] && arr[parentIndex]>arr[childLeftIndex]) {
					swapParentChild(parentIndex, childLeftIndex);
					parentIndex = childLeftIndex;
				} else if(arr[childLeftIndex] > arr[childRightIndex] && arr[parentIndex] > arr[childRightIndex]) {
					swapParentChild(parentIndex, childRightIndex);
					parentIndex = childRightIndex;
				}else if(arr[childLeftIndex] == arr[childRightIndex] && arr[parentIndex] > arr[childLeftIndex]) {
					swapParentChild(parentIndex, childLeftIndex);
					parentIndex = childLeftIndex;
				}
				else break;		
			}
		}
	}	
	
/**
 * To swap parent and child if parent value is greater than its child value
 * @param parentIndex
 * @param childIndex
 */
	public void swapParentChild(int parentIndex, int childIndex) {
		int temp = arr[parentIndex];
		arr[parentIndex] = arr[childIndex];
		arr[childIndex] = temp;	
	}
	public boolean parentHasLeftChild(int parentIndex) {
		if(2*parentIndex + 1<size) return true;
		return false;		
	}
	public boolean parentHasRightChild(int parentIndex) {
		if(2*parentIndex+2 <size) return true;
		return false;
	}

/**
 * @override toString()
 * @return s
 */
	public String toString() {
		String s = "";
		for(int i=0; i<size; i++) {
			s = s+arr[i] + ", ";
		}
		return s;	
	}
}
