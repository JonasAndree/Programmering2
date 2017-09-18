package lesson.arraylists;

import java.util.*;

public class IntroArrayListRemove {

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
	    
	    // display the array list
	    System.out.println("Contents of myFirstArrayList: " + myFirstArrayList);
	    
	    
	    // Remove elements from the array list
	    myFirstArrayList.remove("F");
	    myFirstArrayList.remove(2);
	    System.out.println("Size of myFirstArrayList after deletions: " + myFirstArrayList.size());
	    System.out.println("Contents of myFirstArrayList: " + myFirstArrayList);
	}

}
