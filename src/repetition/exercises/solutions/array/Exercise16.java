package repetition.exercises.solutions.array;

import java.util.Arrays;

public class Exercise16 {
	static void uniqueArray(int[] myArray) {
		System.out.println("Original Array : ");

		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + "\t");
		}

		// Assuming all elements in input array are unique

		int noUniqueElements = myArray.length;

		// Comparing each element with all other elements

		for (int i = 0; i < noUniqueElements; i++) {
			for (int j = i + 1; j < noUniqueElements; j++) {
				// If any two elements are found equal

				if (myArray[i] == myArray[j]) {
					// Replace duplicate element with last unique element

					myArray[j] = myArray[noUniqueElements - 1];

					noUniqueElements--;

					j--;
				}
			}
		}

		// Copying only unique elements of my_array into array1

		int[] array1 = Arrays.copyOf(myArray, noUniqueElements);

		// Printing arrayWithoutDuplicates

		System.out.println();

		System.out.println("Array with unique values : ");

		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}

		System.out.println();

		System.out.println("---------------------------");
	}

	public static void main(String[] args) {
		uniqueArray(new int[] { 0, 3, -2, 4, 3, 2 });
		uniqueArray(new int[] { 10, 22, 10, 20, 11, 22 });
	}
}