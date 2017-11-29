package repetition.exercises.solutions.string;

public class Exercise25 {

	public static void main(String[] args) {
		String string = "The quick brown fox jumps over the lazy dog.";

		// Replace all the 'dog' with 'cat'.
		String newString = string.replaceAll("fox", "cat");

		// Display the strings for comparison.
		System.out.println("Original string: " + string);
		System.out.println("New String: " + newString);
	}
}