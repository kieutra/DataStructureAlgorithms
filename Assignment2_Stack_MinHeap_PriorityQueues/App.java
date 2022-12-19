//Thi Thanh Tra Kieu #261066512

//reference: https://www.youtube.com/watch?v=8mJ-OhcfpYg
//reference: https://www.youtube.com/watch?v=EwjnF7rFLns&t=429s

import java.util.Arrays;
import java.util.Random; // this creates random for our program 

public class App {

//  sample code for methods, create your own
/**
 * insertion sort 
 * @param arr
 */
    public static void insertionSort(int[]arr) {
    	SortedPriorityQueue q = new SortedPriorityQueue();
    	for(int i =0; i<arr.length; i++) {
    		q.insert(arr[i]);
    	}
    	for(int i=0; i<arr.length; i++) {
    		arr[i]= q.removeMin();
    	}
    }
/**
 *  seleciton sort
 * @param arr
 */  
    public static void selectionSort(int[]arr) {
    	PriorityQueue q = new PriorityQueue();
     	for(int i =0; i<arr.length; i++) {
    		q.insert(arr[i]);
    	}
    	for(int i=0; i<arr.length; i++) {
    		arr[i]= q.removeMin();
    	}
    }
/**
 * heap sort
 * @param arr
 */
    public static void heapSort(int [] arr) {
    	MinHeap heap = new MinHeap();
    	for(int i = 0; i< arr.length; i++) {
    		heap.add(arr[i]);
    	}    	
    	for(int i = 0; i<arr.length; i++) {
    		arr[i] = heap.removeMin();
    	}
    }
/**
 * 
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {
        int numItem = 100; // This decide how big you array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
//      create three arrays the same as the random array.       
        int array1[] = Arrays.copyOf(myArr, myArr.length);
        int array2[] = Arrays.copyOf(myArr, myArr.length);
        int array3[] = Arrays.copyOf(myArr, myArr.length);

//      use Selection Sort
        double startTime1 = System.nanoTime();
        selectionSort(array1);        
        double endTime1 = System.nanoTime();
        double duration1 = (endTime1 - startTime1); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to Selection sort is " + duration1);
        
        
//      use Insertion Sort
        double startTime2 = System.nanoTime();
        insertionSort(array2);        
        double endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to Insertion sort is " + duration2);
        
//      use Heap Sort
        double startTime3 = System.nanoTime();
        heapSort(array3);        
        double endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to Heap sort is " + duration3);       
    }	
}