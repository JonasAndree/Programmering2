package repetition.exercises.solutions.array;

public class Exercise23 {
	static void equalityCheckingTwoArrays(int[] myArray1, int[] myArray2) {
		boolean equalOrNot = true;

		if (myArray1.length == myArray2.length) {
			for (int i = 0; i < myArray1.length; i++) {
				if (myArray1[i] != myArray2[i]) {
					equalOrNot = false;
				}
			}
		} else {
			equalOrNot = false;
		}

		if (equalOrNot) {
			System.out.println("Two arrays are equal.");
		} else {
			System.out.println("Two  arrays are not equal.");
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 2, 5, 7, 9, 11 };
		int[] array2 = { 2, 5, 7, 8, 11 };
		int[] array3 = { 2, 5, 7, 9, 11 };

		equalityCheckingTwoArrays(array1, array2);
		equalityCheckingTwoArrays(array1, array3);
	}
}