package repetition.exercises.solutions.string;

public class Exercise5 {
	public static void main(String[] args) {
		String string1 = "This is Exercise 1";
		String string2 = "This is Exercise 2";

		System.out.println("String 1: " + string1);
		System.out.println("String 2: " + string2);

		// Compare the two strings.
		int result = string1.compareTo(string2);

		// Display the results of the comparison.
		if (result < 0) {
			System.out.println("\"" + string1 + "\"" + " is less than " + "\"" + string2 + "\"");
		} else if (result == 0) {
			System.out.println("\"" + string1 + "\"" + " is equal to " + "\"" + string2 + "\"");
		} else // if (result > 0) 
		{
			System.out.println("\"" + string1 + "\"" + " is greater than " + "\"" + string2 + "\"");
		}
	}
}