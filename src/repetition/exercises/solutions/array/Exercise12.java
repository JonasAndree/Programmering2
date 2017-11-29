package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise12 {
	public static void main(String[] args) {
		int[] myArray = { 1, 2, 5, 5, 6, 6, 7, 2 };

		for (int i = 0; i < myArray.length - 1; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if ((myArray[i] == myArray[j]) && (i != j)) {
					System.out.println("Duplicate Element : " + myArray[j]);
				}
			}
		}
	}
}