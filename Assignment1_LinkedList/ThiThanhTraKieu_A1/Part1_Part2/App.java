import java.util.Random;

//Thi Thanh Tra KIEU - 261066512
//Part 2

public class App {
	
	public static int minFinder(int[] arr) {
		int index = 0;
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] < arr[index]) {
				
				index = i;
			}
		}
		return index;
	}
	
	public static int minFinder_recursive(int[]arr, int minIndex, int index) {
		
		if(arr[index] < arr[minIndex]) minIndex = index;
		
		if(index == arr.length-1) return minIndex;
		
		else return minFinder_recursive(arr, minIndex, index+1);	
				
	}
	


	public static void main(String[] args) throws Exception {
	
		int[] myArr = new int[100];
		Random myRand = new Random();
		
		int min = 5;
		int max = 1000;
		
		int indexMin = 0;
		int indexMin2 = 0;
		int index = 0;

		for (int i = 0; i < myArr.length; i++) {
			myArr[i] = myRand.nextInt(max-min+1) + min;
		}
		
		System.out.println(myArr[myArr.length - 1]);
		
//		Use loop method to find minimum Index
		indexMin = minFinder(myArr);
		System.out.println("The minimum is at location: "+ indexMin + " The value is: " + myArr[indexMin]);
		
//		Use recursive method to find minimum Index
		indexMin2 = minFinder_recursive(myArr, indexMin2, index);
		System.out.println("The minimum is at location: "+ indexMin2 + " The value is: " + myArr[indexMin2]);
		
	}

}
