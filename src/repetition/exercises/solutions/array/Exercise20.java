package repetition.exercises.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise20 {
	public static void main(String[] args) {
		String[] myArray = new String[] { "Python", "JAVA", "PHP", "Perl", "C#", "C++" };
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(myArray));

		System.out.println(list);
	}
}
