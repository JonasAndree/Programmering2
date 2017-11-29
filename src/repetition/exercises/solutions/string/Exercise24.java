package repetition.exercises.solutions.string;

public class Exercise24 {

	public static void main(String[] args) {
		String string = "The quick brown fox jumps over the lazy dog.";

		// Replace all the 'd' characters with 'f' characters.
		String newString = string.replace('d', 'f');

		// Display the strings for comparison.
		System.out.println("Original string: " + string);
		System.out.println("New String: " + newString);
	}
}