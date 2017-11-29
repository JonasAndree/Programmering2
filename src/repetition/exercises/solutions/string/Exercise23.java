package repetition.exercises.solutions.string;

public class Exercise23 {

	public static void main(String[] args) {
		// String str1 = "Red Green Orange Yellow";
		// String str2 = "Yellow Orange Green Red";

		String text1 = "Shanghai Houston Colorado Alexandria";
		String text2 = "Alexandria Colorado Houston Shanghai";

		// Determine whether characters 0 through 7 in str1
		// match characters 28 through 35 in str2.
		boolean match1 = text1.regionMatches(0, text2, 28, 8);

		// Determine whether characters 9 through 15 in str1
		// match characters 9 through 15 in str2.
		boolean match2 = text1.regionMatches(9, text2, 9, 8);

		// Display the results of the regionMatches method calls.
		System.out.println("str1[0 - 7] == str2[28 - 35]? " + match1);
		System.out.println("str1[9 - 15] == str2[9 - 15]? " + match2);
	}
}