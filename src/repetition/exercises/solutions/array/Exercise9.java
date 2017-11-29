package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise9 {

	public static void main(String[] args) {

		int[] myArray = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };

		// Insert an element in 3rd position of the array (index->2, value->5)

		int indexPosition = 2;
		int newValue = 5;

		System.out.println("Original Array : " + Arrays.toString(myArray));

		for (int i = myArray.length - 1; i > indexPosition; i--) {
			myArray[i] = myArray[i - 1];
		}
		myArray[indexPosition] = newValue;
		System.out.println("New Array: " + Arrays.toString(myArray));
	}
}