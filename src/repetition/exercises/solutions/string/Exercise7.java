package repetition.exercises.solutions.string;

public class Exercise7 {

	public static void main(String[] args) {
		String string1 = "PHP Exercises and ";
		String string2 = "Python Exercises";

		System.out.println("String 1: " + string1);
		System.out.println("String 2: " + string2);

		// Concatenate the two strings together.
		String string3 = string1.concat(string2);

		// Display the new String.
		System.out.println("The concatenated string: " + string3);
	}
}