import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Cesar
 *Checks/Gets user input
 */
public class UserInput {

	private ArrayList<String> userDifficulty;
	private ArrayList<Double> userNumbers;

	@SuppressWarnings("resource")
	public UserInput(){

		Scanner sca = new Scanner(System.in); 
		userDifficulty = new ArrayList<String>();
		userNumbers = new ArrayList<Double>();

		System.out.print("Choose your difficulty: Easy, Medium, Hard, Extreme: ");
		String answer = sca.nextLine();
		while(!answer.equalsIgnoreCase("easy") && !answer.equalsIgnoreCase("medium") // checks to see if the input string matches the difficulty 
				&& !answer.equalsIgnoreCase("hard") && !answer.equalsIgnoreCase("extreme")){
			System.out.print("Enter a correct difficulty! ");
			answer = sca.nextLine();
		}
		userDifficulty.add(answer);

		System.out.print("What math operation do you want to work on? 1 = addition; 2 = subtraction; 3 = multiplication; 4 = division. ");
		Double operation = 0.0; 
		Object o = null;
		while(operation > 4 || operation < 1){
			try {
				operation = Double.parseDouble((String) (o = sca.nextLine()));
				if(operation > 2 || operation < 1){ // checks to see if number is greater than 1
					System.out.print("Enter a number in scope: ");
				}
			} catch (NumberFormatException e) { // checks to see if the input is actually a number and not some random thing 
				System.out.print("Bad input: " + o.toString() + " Input a number! ");
			}
		}
		userNumbers.add(Math.floor(operation));

		System.out.print("Choose the number of integers you want to do operations on. (Between 2-100): ");
		Double number = 0.0;
		Object i = null;
		while (number < 2 || number > 100) { // runs until number is greater or equal to 2 
			try {
				number = Double.parseDouble((String) (i = sca.nextLine()));
				if(number < 2 ){ // checks to see if number is greater than 1
					System.out.print("Enter a larger number: ");
				}
				if(number > 100){
					System.out.print("Enter a smaller number: ");
				}
			} catch (NumberFormatException e) { // checks to see if the input is actually a number and not some random thing 
				System.out.print("Bad input: " + i.toString() + " Input a number! ");
			}
		}

		userNumbers.add(Math.floor((number)));

	}

	/**<pre> check if the number being asked for is in scope
	 * @param i is the number at position i in the arrayList
	 * @return the number requested 
	 */
	public String getDifficulty(){

		return userDifficulty.get(0);
	}

	/**
	 * @return the number in the current slot
	 */
	public double getNumbers(){

		return userNumbers.get(1);
	}

	/**
	 * @return the operation needed
	 */
	public double getOperation(){

		return userNumbers.get(0);
	}
}
