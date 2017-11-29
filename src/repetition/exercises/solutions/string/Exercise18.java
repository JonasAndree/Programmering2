package repetition.exercises.solutions.string;

public class Exercise18 {

	public static void main(String[] args) {
		String str = "Python Exercises.";

		// Get the hash code for the above string.
		int hashCode = str.hashCode();

		// Display the hash code.
		System.out.println("The hash for " + str + " is " + hashCode);
	}
}