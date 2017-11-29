package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise28 {
	public static void main(String[] args) {
		int[] arrayNums = { 5, 7, 2, 4, 9 };
		System.out.println("Original Array: " + Arrays.toString(arrayNums));
		int maxVal = arrayNums[0];
		int min = arrayNums[0];
		for (int i = 1; i < arrayNums.length; i++) {
			if (arrayNums[i] > maxVal)
				maxVal = arrayNums[i];
			else if (arrayNums[i] < min)
				min = arrayNums[i];
		}
		System.out.println("Difference between the largest and smallest values of the said array: " + (maxVal - min));
	}
}
