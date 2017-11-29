package repetition.exercises.solutions.string;

public class Exercise3 {

	public static void main(String[] args) {

		String string = "w3resource.com";
		System.out.println("Original String : " + string);

		// codepoint before index 1
		int val1 = string.codePointBefore(1);

		// codepoint before index 9
		int val2 = string.codePointBefore(9);

		// prints character before index1 in string
		System.out.println("Character(unicode point) = " + val1);
		// prints character before index9 in string
		System.out.println("Character(unicode point) = " + val2);
	}
}