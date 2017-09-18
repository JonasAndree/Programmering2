package lesson.arraylists;

import java.util.*;

public class IntroArrayListDisplay {

	public static void main(String[] args) {
		ArrayList myFirstArrayList = new ArrayList();
		System.out.println("Initial size of myFirstArrayList: " + myFirstArrayList.size());
		
		// add elements to the array list
		myFirstArrayList.add("C");
		myFirstArrayList.add("A");
		myFirstArrayList.add("E");
		myFirstArrayList.add("B");
		myFirstArrayList.add("D");
		myFirstArrayList.add("F");
		myFirstArrayList.add("F");
		myFirstArrayList.add(1, "A2");
	    System.out.println("Size of myFirstArrayList after additions: " + myFirstArrayList.size());

	    // Get value of index
	    System.out.println(myFirstArrayList.get(5));
	    
	    // display the array list
	    System.out.println("Contents of myFirstArrayList: " + myFirstArrayList);
	    
	    
	}

}
