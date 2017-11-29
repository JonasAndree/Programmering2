package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] strings) {

		Scanner input = new Scanner(System.in);

		int numberOfDaysInMonth = 0;
		String monthOfName = "Unknown";

		System.out.print("Input a month number: ");
		int month = input.nextInt();

		System.out.print("Input a year: ");
		int year = input.nextInt();

		switch (month) {
		case 1:
			monthOfName = "January";
			numberOfDaysInMonth = 31;
			break;
		case 2:
			monthOfName = "February";
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				numberOfDaysInMonth = 29;
			} else {
				numberOfDaysInMonth = 28;
			}
			break;
		case 3:
			monthOfName = "March";
			numberOfDaysInMonth = 31;
			break;
		case 4:
			monthOfName = "April";
			numberOfDaysInMonth = 30;
			break;
		case 5:
			monthOfName = "May";
			numberOfDaysInMonth = 31;
			break;
		case 6:
			monthOfName = "June";
			numberOfDaysInMonth = 30;
			break;
		case 7:
			monthOfName = "July";
			numberOfDaysInMonth = 31;
			break;
		case 8:
			monthOfName = "August";
			numberOfDaysInMonth = 31;
			break;
		case 9:
			monthOfName = "September";
			numberOfDaysInMonth = 30;
			break;
		case 10:
			monthOfName = "October";
			numberOfDaysInMonth = 31;
			break;
		case 11:
			monthOfName = "November";
			numberOfDaysInMonth = 30;
			break;
		case 12:
			monthOfName = "December";
			numberOfDaysInMonth = 31;
		}
		System.out.print(monthOfName + " " + year + " has " + numberOfDaysInMonth + " days\n");
	}
}