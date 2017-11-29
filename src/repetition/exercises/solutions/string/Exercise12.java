package repetition.exercises.solutions.string;

public class Exercise12 {

	public static void main(String[] args) {
		String string1 = "Python Exercises";
		String string2 = "Python Exercise";

		// The String to check the above two Strings to see
		// if they end with this value (se).
		String endString = "se";

		// Check first two Strings end with end_str
		boolean ends1 = string1.endsWith(endString);
		boolean ends2 = string2.endsWith(endString);

		// Display the results of the endsWith calls.
		System.out.println("\"" + string1 + "\" ends with " + "\"" + endString + "\"? " + ends1);
		System.out.println("\"" + string2 + "\" ends with " + "\"" + endString + "\"? " + ends2);
	}
}