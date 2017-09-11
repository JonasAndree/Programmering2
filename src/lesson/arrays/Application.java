package lesson.arrays;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };
		String[] my_array2 = { "Java", "Python", "PHP", "C#", "C Programming", "C++" };
		
		// Uppgift1 
		Arrays.sort(my_array1);
		Arrays.sort(my_array2);
		
		System.out.println(Arrays.toString(my_array1));
		System.out.println(Arrays.toString(my_array2));
		
		// Uppgift2
		int sumOfArray1 = 0;
		for (int i = 0; i < my_array1.length; i++) {
			sumOfArray1 = sumOfArray1 + my_array1[i];
		}
		
		// Uppgigft3 
		
		
	}

}
