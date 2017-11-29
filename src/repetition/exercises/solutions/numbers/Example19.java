package repetition.exercises.solutions.numbers;

import java.util.Scanner;
import java.math.BigInteger;

public class Example19 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		String strNumber = scanner.nextLine().trim();
		BigInteger n = new BigInteger(strNumber);
		int len = strNumber.length() + 1;
		String string = String.valueOf(len);
		BigInteger number1 = new BigInteger(string);
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < (len - 1); i++) {
			buf.append('9');
		}
		BigInteger total = new BigInteger(buf.toString());
		if (n.multiply(number1).equals(total)) {
			System.out.println("It is a cyclic number.");
		} else {
			System.out.println("Not a cyclic number.");
		}
	}
}