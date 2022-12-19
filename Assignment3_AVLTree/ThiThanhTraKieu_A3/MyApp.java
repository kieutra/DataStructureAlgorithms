import java.util.Arrays;
import java.util.Random;
//Thi Thanh Tra Kieu #261066512

public class MyApp {
  //      Array search by looping all elements of array
  public static boolean arraySearch(int[]arr, int value) {
		boolean found = false;
		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i] == value) {
				found = true;
				break;
			}
		}
		return found;
	}

        public static void main(String[] args){
                int numItem = 100; // This decide how big you array is
                int[] myArr = new int[numItem];
                Random myRand = new Random(); // creating Random object
        //	Range for random to select from
                int min = 10;
                int max = 1000;
                int value = 5;

        //      Create two random equal arrays
                for (int i = 0; i < myArr.length; i++) 
                myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
                
                int[]myArr2 = Arrays.copyOf(myArr, myArr.length);
                
        //       Create AVL tree and insert the data into tree
                MyAVLTree tree = new MyAVLTree();
                for(int i = 0;i<myArr2.length; i++)
                        tree.insert(myArr2[i]);

        //      find value by Array Search
                double startTime1 = System.nanoTime();
                arraySearch(myArr, value);   
                double endTime1 = System.nanoTime();
                double duration1 = endTime1 - startTime1; 
                System.out.println("the time it took for Array Search is " + duration1);
                
        //      find value by AVL tree
                double startTime2 = System.nanoTime();
                tree.search(value, tree.root);
                double endTime2 = System.nanoTime();
                double duration2 = endTime2 - startTime2; 
                System.out.println("the time it took for AVL tree search is " + duration2);
        }
        //	With the length of array = 100, the difference between Array search and AVL tree search is not clear.
        //	Array search may be quicker or slower than AVL tree search.
        //	But if length of array = 10000, the difference between two search methods is obvious. AVL tree is much faster.
        //			the time it took for Array Search is 90900.0
        //			the time it took for AVL tree search is 4800.0

}
