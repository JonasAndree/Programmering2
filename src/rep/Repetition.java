package rep;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Repetition {
	/**
	 * Main metoden det som kör programmet
	 * @param args
	 */
	public static void main(String[] args) {
		// Varibaler innehåller variabeltyp och variabel namn 
		int heltal = 15;
		float decimaltal = 1235.12f;
		double storreDecimaltal = 1234.324;
		// true or false
		boolean binary = true;
		String text = "asdasdas";
		char tecken = 'a';
		
		
		
		System.out.println("HEJ");
		//Scanner scanner = new Scanner(System.in);
		//String inputFromUser = scanner.nextLine();
		//System.out.println("User input: " + inputFromUser);
		
	/*	
		System.out.println((heltal + 15) / 3);
		System.out.println("Hej" + (15 + 15));
		
		ImageIcon testIcon = new ImageIcon("C:/Users/jonas.andree/Desktop/dice.png");
		JOptionPane.showMessageDialog(null, "Jonas1");
		JOptionPane.showMessageDialog(null, "Jonas2", "Heading", -1);
		JOptionPane.showMessageDialog(null, "Jonas3", "title", -1, testIcon);
		
		
		String userInputFromOptionPane = JOptionPane.showInputDialog("Input: ");
		JOptionPane.showMessageDialog(null, userInputFromOptionPane);
		
		*/
		while (true) {
			String userInputFromOptionPane1 = JOptionPane.showInputDialog(null, "Hur många kg kött äter du?");
		/*String userInputFromOptionPane2 = JOptionPane.showInputDialog("message2", "initialSelectionValue");
		String userInputFromOptionPane3 = JOptionPane.showInputDialog(null, "message3", "initialSelectionValue2");
		String userInputFromOptionPane4 = JOptionPane.showInputDialog(null, "message4", "title1", -1);
		JOptionPane.showInputDialog(null, "message5", "title2", 3, testIcon, null, null);
		*/
		
			int integerInput = Integer.parseInt(userInputFromOptionPane1);
			
			if (integerInput >= 35) {
				JOptionPane.showMessageDialog(null, "Oj vad mycket!");
			} else if (integerInput >= 10) {
				JOptionPane.showMessageDialog(null, "Ganska bra!");
			} else {
				JOptionPane.showMessageDialog(null, "Vad bra!");
				break;
			}
			
		}
		
		
	}

}
