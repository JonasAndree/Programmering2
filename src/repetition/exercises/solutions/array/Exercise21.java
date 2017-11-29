package repetition.exercises.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise21 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("Python"); 
		list.add("Java"); 
		list.add("PHP"); 
		list.add("C#"); 
		list.add("C++"); 
		list.add("Perl");

		String[] myArray = new String[list.size()];

		list.toArray(myArray);

		for (String string : myArray) {
			System.out.println(string);
		}
	}
}