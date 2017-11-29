package repetition.exercises.solutions.array;

import java.util.*;

public class Exercise35 {
	public static ArrayList<Integer> twoSumArrayTarget(final List<Integer> a, int b) {

		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		for (int i = 0; i < a.size(); i++) {
			if (myMap.containsKey(a.get(i))) {
				int index = myMap.get(a.get(i));
				result.set(0, index + 1);
				result.set(1, i + 1);
				break;
			} else {
				myMap.put(b - a.get(i), i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		myArray.add(1);
		myArray.add(2);
		myArray.add(4);
		myArray.add(5);
		myArray.add(6);
		int target = 6;
		ArrayList<Integer> result = twoSumArrayTarget(myArray, target);
		for (int i : result)
			System.out.print("Index: " + i + " ");
	}
}