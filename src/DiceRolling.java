import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceRolling {

	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		boolean userWannaContinue;
		System.out.println("Welcome to the Grand Circus Casino!");
		do {
			/* Enter the number of sides for a pair of dice */
			int dieNumSides = getUserInput();

			/* Roll the first dice */
			int dice1_numRolls = generateRandomDieRoll(dieNumSides);

			/* Roll the second dice */
			int dice2_numRolls = generateRandomDieRoll(dieNumSides);

			System.out.println("Roll 1: \n" + dice1_numRolls + "\n" + dice2_numRolls);

			celebrateSpecialRolls(dice1_numRolls, dice2_numRolls);

			/* user wants to go on? */
			userWannaContinue = userChoice();

		} while (userWannaContinue);
		System.out.println("Exiting...!");
	}

	public static int getUserInput() {
		int numSides;
		System.out.println("\nHow many sides should each die have?");
		numSides = scnr.nextInt();
		return numSides;

	}

	public static int generateRandomDieRoll(int numSides) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(1, numSides + 1); /* I got this from StackOverFlow :D */
		return randomNum;
	}

	public static void celebrateSpecialRolls(int dice1_numRolls, int dice2_numRolls) {
		if ((dice1_numRolls == 1) && (dice2_numRolls == 1)) {
			System.out.println("WOW!!!  SNAKE EYE");
		} else if ((dice1_numRolls == 6) && (dice2_numRolls == 6)) {
			System.out.println("WOW!!!  BOX CARs");
		} else if ((dice1_numRolls + dice2_numRolls) == 7 || (dice1_numRolls + dice2_numRolls) == 11) {
			System.out.println("WOW!!!  CRAPS");
		}
	}

	public static boolean userChoice() {
		System.out.println("Roll again? (y/n)");
		char userChoice = scnr.next().charAt(0);

		if (userChoice == 'y') {
			return true;
		} else {
			return false;
		}

	}
}
