package repetition.exercises.solutions.string;

public class Exercise11 {

	public static void main(String[] args) {
		// Character array with data.
		char[] arrayNumber = new char[] { '1', '2', '3', '4' };

		// Create a String containig the contents of arrNum
		// starting at index 1 for length 2.
		String string = String.copyValueOf(arrayNumber, 1, 3);

		// Display the results of the new String.
		System.out.println("\nThe book contains " + string + " pages.\n");
	}
}