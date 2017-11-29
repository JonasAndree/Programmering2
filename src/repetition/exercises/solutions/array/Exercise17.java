package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise17 {
	public static void main(String[] args) {

		int[] myArray = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };

		int max = myArray[0];
		int secondMax = myArray[0];

		System.out.println("Original numeric array : " + Arrays.toString(myArray));

		for (int i = 0; i < myArray.length; i++) {

			if (myArray[i] > max) {
				secondMax = max;
				max = myArray[i];

			} else if (myArray[i] > secondMax) {
				secondMax = myArray[i];

			}
		} 
		System.out.println("Second largest number is : " + secondMax); 
	}
}