package repetition.exercises.solutions.string;

public class Exercise8 {

	public static void main(String[] args) {
		String string1 = "PHP Exercises and Python Exercises";
		String string2 = "and";
		System.out.println("Original String: " + string1);
		System.out.println("Specified sequence of char values: " + string2);
		System.out.println(string1.contains(string2));
	}
}