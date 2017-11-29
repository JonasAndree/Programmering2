package repetition.exercises.solutions.string;

public class Exercise16 {

	public static void main(String[] args) {
		String str = "This is a sample String.";

		// Copy the contents of the String to a byte array.
		byte[] byteArray = str.getBytes();

		// Create a new String using the contents of the byte array.
		String newString = new String(byteArray);

		// Display the contents of the byte array.
		System.out.println("\nThe new String equals " + newString + "\n");
	}
}