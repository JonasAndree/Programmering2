package lesson.arrays;


public class MultiDimArryas {

	public static void main(String[] args) {
		String[][] names = {
				{"Mr. ", "Mrs. ", "Ms. ", "Lord. "},
				{"Jonas", "Peter", "Rene"}
		};

		System.out.println(names[0][0] + names[1][0]);
		System.out.println(names[0][3] + names[1][2]);
		
		System.out.println(names[0].length);
		
		
		for (int i = 0; i < names[1].length; i++) {
			if(names[1][i].equals("Jonas")) {
				names[1][i] = "Fredrik "; 
				break;
			}
			
		}
		System.out.println(names[1][0]);
		
		char[] copyFrom = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		
		char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 5);
		
		String newString = new String(copyTo);
		System.out.println(newString);
	}

	
}
