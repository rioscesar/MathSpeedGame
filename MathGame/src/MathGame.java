import java.util.Scanner;

/**
 * @author Cesar
 * Math game that checks how fast you can answer some math questions. 
 * Questions are in random numbers with your choice of mathematical operation and difficulty. 
 * Along with that quest you can also play tic tac toe against a computer 
 * that randomly chooses where to position its pieces. 
 * ENJOY!
 *
 */
public class MathGame {

	private static String name; 
	private static Scanner sca;
	private static Game g;
	private static UserInput uI;

	public static void main(String [] args) throws InterruptedException{ //Thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. 
		//Occasionally a method may wish to test whether the current thread has been interrupted, and if so, to immediately throw this exception.
		int count = 0; 
		sca = new Scanner(System.in); 

		Intro(sca);
		uI = new UserInput();

		while(count < 10){
			g = new Game();
			continueGame();
			count++;
		}
	}

	/**The intro of the game. 
	 * @throws InterruptedException
	 */
	private static void Intro(Scanner sca) throws InterruptedException{



		System.out.println("This is a game where you race against time to be the very best!");

		Thread.sleep(1000); // makes the current session sleep for the amount of time

		System.out.print("\nEnter your name: ");
		name = sca.nextLine();

		System.out.println("\nOkay " + name + " let's get this started!\n");

	}

	/**Method that checks if the user inputed a right answer or a wrong answer
	 * @param sca takes in a Scanner object in order to get user input
	 */
	private static void gameCheck(Scanner sca, String operation){
		System.out.println((operation.equals("/") ? "\nTwo significant figures!":""));
		System.out.print(name + " enter your answer for ");
		for(int i=0; i<uI.getNumbers(); i++){
			System.out.print(g.getNum(i) + (i<uI.getNumbers()-1 ? operation : "= "));   
		}



		Double number = -Double.MAX_VALUE;
		Object i = null;
		while (number <= -Double.MAX_VALUE || number >= Double.MAX_VALUE) { // runs until number is greater or equal to 2 
			try {
				number = Double.parseDouble((String) (i = sca.nextLine()));
				if(number <= -Double.MAX_VALUE){ // checks to see if number is greater than 1
					System.out.print("Enter a larger number: ");
				}
				if(number >= Double.MAX_VALUE){
					System.out.print("Enter a smaller number: ");
				}
			} catch (NumberFormatException e) { // checks to see if the input is actually a number and not some random thing 
				System.out.print("Bad input: " + i.toString() + " Input a number! ");
			}
		}

		if(number == g.getAnswer()) // checks to see if the user answered with a double 
			System.out.println("GOOD JOB!! :D");	
		else
			System.out.println("ARE YOU DUMB?? THAT'S WRONG!!");
	}

	public static void continueGame() throws InterruptedException{

		g.playGame(uI.getDifficulty(), uI.getNumbers(), uI.getOperation());
		gameCheck(sca, g.getOperation());


	}





}
