package repetition.exercises.solutions.string;

public class Exercise27 {

	public static void main(String[] args) {
		String string = "The quick brown fox jumps over the lazy dog.";

		// Get a substring of the above string starting from
		// index 10 and ending at index 26.
		String newString = string.substring(10, 26);

		// Display the two strings for comparison.
		System.out.println("old = " + string);
		System.out.println("new = " + newString);
	}
}
