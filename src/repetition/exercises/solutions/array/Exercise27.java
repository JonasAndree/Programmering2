package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise27 {
	public static void main(String[] args) {
		int[] arrayNums = { 5, 7, 2, 4, 9 };
		System.out.println("Original Array: " + Arrays.toString(arrayNums));
		int ctr = 0;
		for (int i = 0; i < arrayNums.length; i++) {
			if (arrayNums[i] % 2 == 0)
				ctr++;
		}
		System.out.println("Number of even numbers : " + ctr);
		System.out.println("Number of odd numbers  : " + (arrayNums.length - ctr));
	}
}