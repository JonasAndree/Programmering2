package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise11 {
	public static void main(String[] args) {
		int[] myArray1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };
		System.out.println("Original array : " + Arrays.toString(myArray1));
		for (int i = 0; i < myArray1.length / 2; i++) {
			int temp = myArray1[i];
			myArray1[i] = myArray1[myArray1.length - i - 1];
			myArray1[myArray1.length - i - 1] = temp;
		}
		System.out.println("Reverse array : " + Arrays.toString(myArray1));
	}
}