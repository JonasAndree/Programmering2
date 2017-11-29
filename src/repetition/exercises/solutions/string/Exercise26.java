package repetition.exercises.solutions.string;

public class Exercise26 {

	public static void main(String[] args) {
		String string1 = "Red is favorite color.";
		String string2 = "Orange is also my favorite color.";

		// The String to check the above two Strings to see
		// if they start with this value (Red).
		String startStr = "Red";

		// Do either of the first two Strings start with startStr?
		boolean starts1 = string1.startsWith(startStr);
		boolean starts2 = string2.startsWith(startStr);

		// Display the results of the startsWith calls.
		System.out.println(string1 + " starts with " + startStr + "? " + starts1);
		System.out.println(string2 + " starts with " + startStr + "? " + starts2);
	}
}