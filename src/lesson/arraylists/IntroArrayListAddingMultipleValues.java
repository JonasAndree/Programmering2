package lesson.arraylists;

import java.util.*;

public class IntroArrayListAddingMultipleValues {

	public static void main(String[] args) {
		ArrayList myFirstArrayList = new ArrayList();

		myFirstArrayList.addAll(Arrays.asList(1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456));
	
		System.out.println(myFirstArrayList);
	}

}
