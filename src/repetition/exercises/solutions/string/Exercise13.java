package repetition.exercises.solutions.string;

public class Exercise13 {

	public static void main(String[] args) {
		String columnList1 = "Stephen Edwin King";
		String columnList2 = "Walter Winchell";
		String columnList3 = "Mike Royko";

		// Are any of the above Strings equal to one another?
		boolean equals1 = columnList1.equals(columnList2);
		boolean equals2 = columnList1.equals(columnList3);

		// Display the results of the equality checks.
		System.out.println("\"" + columnList1 + "\" equals \"" + columnList2 + "\"? " + equals1);
		System.out.println("\"" + columnList1 + "\" equals \"" + columnList3 + "\"? " + equals2);
	}
}