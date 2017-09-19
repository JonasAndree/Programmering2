package lesson.arrays.exercises;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author jonas.andree
 * @category Exercises in arrays
 * @version 1.0
 */
public class ArrayExercises {
	public static void main(String[] args) {
		
		System.out.println("You can finde help at https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html \n "
				+ "and always make sure you print out the result to chek if it is correct.\n");
		
		System.out.println("1. Write a Java program to sort an numeric array and a string array.\nUse:\n"
				+ "int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };\n"
				+ "String[] my_array2 = { \"Java\", \"Python\", \"PHP\", \"C#\", \"C Programming\", \"C++\" };\n");

		System.out.println("2. Write a Java program to sum values of an array.\nUse:\n"
				+ "int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };\n");
		
		System.out.println("3. Write a Java program to print the following grid. Using a two dimentional array\n"
		+ "Expected Output :\n"
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"                                                                                         
		+"	- - - - - - - - - - \n"
		+"");
		
		System.out.println("4. Write a Java program to calculate the average value of array elements.\nUse:\n" 
				+ "int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };\n");
		
		int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };
		
		System.out.println( Arrays.stream(my_array1).sum() / my_array1.length);
		
		int sum = 0;
		for (int i = 0; i < my_array1.length; i++) {
			sum += my_array1[i];
		}
		System.out.println(sum/my_array1.length);
		
		
		System.out.println("5. Write a Java program to test if an array contains a specific value.\n Use same array as yes in the previus exercise.\n And print the result.\n");
		
		int specificValue = 2013;
		for (int i = 0; i < my_array1.length; i++) {
			if (specificValue == my_array1[i]) {
				System.out.println("Found value at index:" + i);
				break;
			}
		}
		
		System.out.println("6.Write a Java program to find the index of an array element.\n And print the result.\n");
		
		
		
		System.out.println("7. Write a Java program to remove a specific element from an array.\n And print the result.+\n");
		
		int specificValue2 = 2013;
		int indexOfSpecificElement = 0;
		for (int i = 0; i < my_array1.length; i++) {
			if (specificValue2 == my_array1[i]) {
				indexOfSpecificElement = i;
			}
		}
		int[] newMyArray1 = new int[my_array1.length - 1];
		for (int i = 0; i < indexOfSpecificElement; i++) {
			newMyArray1[i] = my_array1[i];
		}
		for (int i = indexOfSpecificElement + 1; i < my_array1.length; i++) { 
			newMyArray1[i - 1] = my_array1[i];
		}
		System.out.println(Arrays.toString(my_array1));
		System.out.println(Arrays.toString(newMyArray1));
		
		
		System.out.println("8. Write a Java program to copy an array by iterating the array. \n And print the result.\n");
		
		System.out.println("9. Write a Java program to insert an element (specific position) into an array. \\n");
		
		
		int specificValue3 = 2013;
		int indexOfSpecificElement3 = 8;
		int[] newMyArray2 = new int[my_array1.length + 1];
		for (int i = 0; i < indexOfSpecificElement3; i++) {
			newMyArray2[i] = my_array1[i];
		}
		newMyArray2[indexOfSpecificElement3] = specificValue3;
		for (int i = indexOfSpecificElement3; i < my_array1.length; i++) { 
			newMyArray2[i + 1] = my_array1[i];
		}
		
		
		
		
		System.out.println("10. Write a Java program to find the maximum and minimum value of an array.\n");
		
		
		int min = my_array1[0];
		int max = my_array1[0];
		
		for (int i = 1; i < my_array1.length; i++) {
			if (min > my_array1[i]) {
				min = my_array1[i];
			}
			if (max < my_array1[i]) {
				max = my_array1[i];
			}
		}
		System.out.println("Min: " + min + ", Max: " + max);
		
		
		Arrays.sort(my_array1);
		min = my_array1[0];
		max = my_array1[my_array1.length - 1];

		System.out.println("Min: " + min + ", Max: " + max);
		
		
		
		System.out.println("11. Write a Java program to reverse an array of integer values.\n");
		
		
		int[] tempArray = new int[my_array1.length];
		for (int i = 0; i < my_array1.length; i++) {
			tempArray[i] = my_array1[my_array1.length - 1 - i];
		}
		
		System.out.println(Arrays.toString(my_array1));

		System.out.println(Arrays.toString(tempArray));
		
		
		System.out.println("12. Write a Java program to find the duplicate values of an array of integer values.\n");
		
		int[] my_array2 = { 189, 2035, 189, 156, 2013, 1458, 245, 254, 172, 265, 156, 265, 457, 256 };
		
		for(int i = 0; i < my_array1.length; i++) {
			for (int j = 0; j < my_array2.length; j++) {
				if(my_array1[i] == my_array2[j]) {
					System.out.println(my_array1[i] + " == " + my_array2[j] );
				}
			}
		}
		
		
		
		
		
		
		
		
		System.out.println("13. Write a Java program to find the duplicate values of an array of string values.\n");
		System.out.println("14. Write a Java program to remove duplicate elements from an array. \n");
		System.out.println("15. Write a Java program to find the second largest element in an array.\n");
		System.out.println("16. Write a Java program to find the second smallest element in an array. \n");
	}
}
