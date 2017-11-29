package repetition.exercises.solutions.array;

import java.util.*;

public class Exercise26 {
	public static void main(String[] args) throws Exception {
		int[] arrayNums = { 0, 0, 1, 0, 3, 0, 5, 0, 6 };
		int i = 0;
		System.out.print("\nOriginal array: \n");
		for (int n : arrayNums)
			System.out.print(n + "  ");

		for (int j = 0, l = arrayNums.length; j < l;) {
			if (arrayNums[j] == 0)
				j++;
			else {
				int temp = arrayNums[i];
				arrayNums[i] = arrayNums[j];
				arrayNums[j] = temp;
				i++;
				j++;
			}
		}
		while (i < arrayNums.length)
			arrayNums[i++] = 0;
		System.out.print("\nAfter moving 0's to the end of the array: \n");
		for (int n : arrayNums)
			System.out.print(n + "  ");
		System.out.print("\n");
	}
}