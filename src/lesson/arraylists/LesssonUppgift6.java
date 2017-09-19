package lesson.arraylists;

import java.util.ArrayList;
import java.util.Arrays;

public class LesssonUppgift6 {

	public static void main(String[] args) {
		System.out.println("6.Write a Java program to find the index of an array element.\n And print the result.\n");

		ArrayList list = new ArrayList();
		int specificValue = 2013;

		list.addAll(Arrays.asList(1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456));
		System.out.println(list.contains(2035));

	}

}
