package repetition.exercises.solutions.methods;

import java.util.Scanner;

public class Exercise11 {

	public static final int PASSWORD_LENGTH = 8;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("1. A password must have at least eight characters.\n"
				+ "2. A password consists of only letters and digits.\n"
				+ "3. A password must contain at least two digits \n"
				+ "Input a password (You are agreeing to the above Terms and Conditions.): ");
		String s = scanner.nextLine();

		if (isValidPassword(s)) {
			System.out.println("Password is valid: " + s);
		} else {
			System.out.println("Not a valid password: " + s);
		}

	}

	public static boolean isValidPassword(String password) {

		if (password.length() < PASSWORD_LENGTH)
			return false;

		int charCount = 0;
		int numCount = 0;
		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (isNumeric(ch))
				numCount++;
			else if (isLetter(ch))
				charCount++;
			else
				return false;
		}

		return (charCount >= 2 && numCount >= 2);
	}

	public static boolean isLetter(char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
	}

	public static boolean isNumeric(char ch) {

		return (ch >= '0' && ch <= '9');
	}

}
