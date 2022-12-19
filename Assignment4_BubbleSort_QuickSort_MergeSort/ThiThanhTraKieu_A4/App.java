import java.util.Arrays;
import java.util.Random;
//Thi Thanh Tra Kieu #261066512

//reference https://www.youtube.com/watch?v=3j0SWDX4AtU
//https: www.youtube.com/watch?v=HrCPqJHQSxY
//https://www.youtube.com/watch?v=Vtckgz38QHs
//https://www.youtube.com/watch?v=Dv4qLJcxus8


public class App {
/** 
 * merge sort function
 * @param arr;
 * 
*/
	public static void mergeSort(int[] arr) {
		 int n = arr.length;
		 if(n <=1) return;
		 int mid = n/2;
		 int[]leftArray = new int[mid];
		 int[]rightArray = new int[n - mid];

			int i = 0; //left array
			int j = 0; //right array
		 // populate leftArray and rightArray
			while(i < n) {
				if( i < mid) {
					leftArray[i] = arr[i];
					i++;
				}else {
					rightArray[j] = arr[i];
					i++;
					j++;
				}
			}
		 mergeSort(leftArray);
		 mergeSort(rightArray);
		 merge(leftArray, rightArray, arr);
	}

/**
 * merge function to merge two arrays into one
 * @param leftArray, rightArray, arr
 */
	public static void merge(int[]leftArray, int[]rightArray, int[]arr) {
		int index = 0, left= 0, right = 0;
		int leftSide = arr.length/2;
		int rightSide = arr.length - leftSide;

    //merge leftArray and rightArray into array           
		while (left < leftSide && right < rightSide) {
			if(leftArray[left] < rightArray[right]) {
				arr[index] = leftArray[left];
				index++;
				left++;
			}else {
				arr[index] = rightArray[right];
				index++;
				right++;
			}
		}
	
		//copy the rest of leftArray into the end of array
		while(left < leftSide) {
			arr[index] = leftArray[left];
			index++;
			left++;
		}
		//copy the rest of rightArray into the end of array
		while (right < rightSide) {
			arr[index] = rightArray[right];
			index++;
			right++;
		}
	}

/** 
 * quick sort function
 * @param arr, startIndex, endIndex
 **/	
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(endIndex <=startIndex) return;
		int pivotIndex = partition(arr, startIndex, endIndex);
		quickSort(arr, startIndex, pivotIndex-1);
		quickSort(arr, pivotIndex+1, endIndex);
	}

/** 
 * partition function
 * @param arr, startIndex, endIndex
 * @return index i
 */
	public static int partition(int[]arr, int startIndex, int endIndex) {
		// choose random index in array, swap array at random and array at endIndex
		int random = new Random().nextInt(endIndex-startIndex)+startIndex;
		int temp5 = arr[random];
		arr[random] = arr[endIndex];
		arr[endIndex] = temp5;
		//after swap random and endIndex, declare pivotValue = array at endIndex
		int pivotValue = arr[endIndex];	
		int i = 0, j = endIndex-1;
		while(i<j) {
			//smaller value than pivotValue is on left side
			if(arr[i] <= pivotValue)
				i++;
			//higher value than pivotValue is on rightSide
			else {
				int temp2 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp2;
				j--;
			}				
		}
		//when i = j, swap arr[i] and arr[index] to put pivotValue into the position where its left side containes smaller values, and its right side containes higher values.
		if(arr[i] > pivotValue) {
			int temp = arr[i];
			arr[i] = arr[endIndex];
			arr[endIndex] = temp;
		}else {
			i++;
			int temp = arr[i];
			arr[i] = arr[endIndex];
			arr[endIndex] = temp;
		}		
		return i;	
	}

 /**
  * bubble sort function
  * @param arr
  **/	
	public static void bubbleSort(int []arr) {
		for(int i = 0; i<arr.length -1; i++) {
			for(int j = 0; j<arr.length -i -1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}


	public static void main(String[] args) {
		int numItem = 100; // This decide how big you array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
//		Range for random to select from
        int min = 10;
        int max = 1000;

//      Create two random equal arrays
        for (int i = 0; i < myArr.length; i++) 
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        
        int[]myArr2 = Arrays.copyOf(myArr, myArr.length);
        int[]myArr3 = Arrays.copyOf(myArr, myArr.length);
        
        double []mergeSortData = new double[100];
        double []quickSortData = new double[100];
        double []bubbleSortData = new double[100];
        
      //run feach sort 100 times to calculate the time average for each
      for(int i =0; i<100; i++) {
				 // sort with mergeSort
    	 	 double startTime1 = System.nanoTime();
          mergeSort(myArr);
          double endTime1 = System.nanoTime();
          double duration1 = endTime1 - startTime1; 
          
          //sort with quickSort
          double startTime2 = System.nanoTime();
          quickSort(myArr2, 0, myArr2.length-1);
          double endTime2 = System.nanoTime();
          double duration2 = endTime2 - startTime2; 
          
          //sort with bubbleSort
          double startTime3 = System.nanoTime();
          bubbleSort(myArr3);
          double endTime3 = System.nanoTime();
          double duration3 = endTime3 - startTime3; 
          
          mergeSortData[i] = duration1;
          quickSortData[i] = duration2;
          bubbleSortData[i] = duration3;     
      }
   
      double sum1 = 0, sum2= 0, sum3= 0;
      for(int i = 0; i<100; i++) {
    	  sum1 = sum1 + mergeSortData[i];
      }
      for(int i = 0; i<100; i++) {
    	  sum2 = sum2 + quickSortData[i];
      }
      for(int i = 0; i<100; i++) {
    	  sum3 = sum3 + bubbleSortData[i];
      }
     System.out.println("the time average it took for mergeSort is " + sum1/100);
     System.out.println("the time average it took for quickSort is " + sum2/100);
     System.out.println("the time average it took for bubbleSort is " + sum3/100);
         
     //create theory array for worst case. The array is in descending order.
     int [] theoryArray = new int[100];
     for(int i = 0; i<100; i++) {
    	 theoryArray[i] = 100-i;
     }
     int [] theoryArray2 = Arrays.copyOf(theoryArray, theoryArray.length);
     int [] theoryArray3 = Arrays.copyOf(theoryArray, theoryArray.length);
     
     for(int i =0; i<100; i++) {
   	 		 double startTime1 = System.nanoTime();
         mergeSort(theoryArray);
         double endTime1 = System.nanoTime();
         double duration1 = endTime1 - startTime1; 
         
         //sort with quickSort
         double startTime2 = System.nanoTime();
         quickSort(theoryArray2, 0, theoryArray2.length-1);
         double endTime2 = System.nanoTime();
         double duration2 = endTime2 - startTime2; 
         
         //sort with bubbleSort
         double startTime3 = System.nanoTime();
         bubbleSort(theoryArray3);
         double endTime3 = System.nanoTime();
         double duration3 = endTime3 - startTime3; 
         
         mergeSortData[i] = duration1;
         quickSortData[i] = duration2;
         bubbleSortData[i] = duration3;     
     }
     double sum4 = 0, sum5= 0, sum6= 0;
     for(int i = 0; i<100; i++) {
   	  sum4 = sum4 + mergeSortData[i];
     }
     for(int i = 0; i<100; i++) {
   	  sum5 = sum5 + quickSortData[i];
     }
     for(int i = 0; i<100; i++) {
   	  sum6 = sum6 + bubbleSortData[i];
     }
     
     System.out.println("the time average it took for mergeSort theoryArray is " + sum4/100);
     System.out.println("the time average it took for quickSort theoryArray is " + sum5/100);
     System.out.println("the time average it took for bubbleSort theoryArray is " + sum6/100);

//     With n = 10, bubbleSort is quickest, then mergeSort, then quickSort.
//     the time average it took for mergeSort is 1617.0
//     the time average it took for quickSort is 12832.0
//     the time average it took for bubbleSort is 970.0
     
// 	   With n = 100, mergeSort is quickest, then quickSort, then bubbleSort.
//     the time average it took for mergeSort is 11660.0
//     the time average it took for quickSort is 32676.0
//     the time average it took for bubbleSort is 42579.0
     
//	   With n = 1000, mergeSort is quickest, then quickSort, then bubbleSort
//	   the time average it took for mergeSort is 266920.0
//	   the time average it took for quickSort is 331928.0
//	   the time average it took for bubbleSort is 717684.0
// Normally, big O of quickSort and mergeSort is O(nlogn) and of bubbleSort is O(n^2). But when n is small, bubbleSort seems quicker than the others.
//     With n= 100, random array vs theory array(worst case where array is in descending order)
//     the time average it took for mergeSort is 10098.0
//     the time average it took for quickSort is 28283.0
//     the time average it took for bubbleSort is 32365.0
//     the time average it took for mergeSort theoryArray is 7795.0
//     the time average it took for quickSort theoryArray is 6680.0
//     the time average it took for bubbleSort theoryArray is 26453.0
// We can see that in random array, mergeSort is quickest, but in worst case, quickSort is quickest.
// The result above is extracted from the test on Eclipse. However, when running the programm on VS Code, mergeSort is always quickest.

	}
}
