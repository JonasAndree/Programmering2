package repetition.exercises.solutions.string;

public class Exercise9 {
	public static void main(String[] args) {
		String string1 = "example.com", string2 = "Example.com";
		CharSequence cs = "example.com";
		System.out.println("Comparing " + string1 + " and " + cs + ": " + string1.contentEquals(cs));
		System.out.println("Comparing " + string2 + " and " + cs + ": " + string2.contentEquals(cs));
	}
}