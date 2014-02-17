import java.util.ArrayList;

/**
 * @author Cesar
 *
 */
public class Game {

	private RandomNumberGen RNG; 
	//private Stopwatch stpWatch;  
	private double answer; 
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	private double operation; 

	/**
	 * @param difficulty the difficulty the player wants to play the game in
	 * @param option number of number the player wants to play with 
	 */
	public void playGame(String difficulty, double option, double operation){

		int multiplierFirst = 0;
		int multiplierSecond = 0;
		this.operation = operation;

		if(difficulty.equalsIgnoreCase("easy")) {multiplierFirst = 1; multiplierSecond = 10;}

		else if(difficulty.equalsIgnoreCase("medium")) {multiplierFirst = 10; multiplierSecond = 20;}

		else if(difficulty.equalsIgnoreCase("hard")) {multiplierFirst = 20; multiplierSecond = 40;}

		else if(difficulty.equalsIgnoreCase("extreme")) {multiplierFirst = 40; multiplierSecond = 100;}

		diffChecker(option, multiplierFirst, multiplierSecond);
	}

	private void diffChecker(double option, double multiplierFirst, double multiplierSecond){

		RNG = new RandomNumberGen(1*multiplierFirst, 1*multiplierSecond, option);

		if(operation == 1){ // Addition 

			for(int i=0; i<option; i++){
				numbers.add(RNG.getRanNum(i));
				answer += numbers.get(i);
			}
		}

		else if(operation == 2){ // subtraction
			numbers.add(RNG.getRanNum(0));
			answer = numbers.get(0);
			for(int i=1; i<option; i++){	
				numbers.add(RNG.getRanNum(i));
				answer -= numbers.get(i);
			}
		} 

		else if(operation == 3){ // multiplication 
			numbers.add(RNG.getRanNum(0));
			answer = numbers.get(0);
			for(int i=1; i<option; i++){
				numbers.add(RNG.getRanNum(i));  
				answer *= numbers.get(i);
			}
		}

		else if(operation == 4){ // division 
			numbers.add(RNG.getRanNum(0));
			answer = numbers.get(0);
			for(int i=1; i<option; i++){
				numbers.add(RNG.getRanNum(i));
				answer /= numbers.get(i);
			}
		}
	}

	/**
	 * @param i slot specified 
	 * @return the int in the specified slot
	 */
	public int getNum(int i){

		return numbers.get(i);
	}

	/**
	 * @return the answer from the addition/mult/div/sub
	 */
	public double getAnswer(){
		System.out.println((double)Math.round(answer*100)/100);
		return (double)Math.round(answer*100)/100;
	}

	public String getOperation(){
		if(operation == 1) return "+";
		else if(operation == 2) return "-";
		else if(operation == 3) return "*";
		else return "/";
	}
}
