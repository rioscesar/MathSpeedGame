import java.util.ArrayList;

/**
 * @author Cesar
 *Generates Random number that the player works with 
 */
public class RandomNumberGen {

	private ArrayList<Integer> ranNum; 
	private double size; 

	public RandomNumberGen(double lowerBound, double upperBound, double howManyNums){ // allows the addition of 2 < numbers

		ranNum = new ArrayList<Integer>();
		size = howManyNums;

		for(int i=0; i<howManyNums; i++)
			ranNum.add((int)(lowerBound + ( Math.random())*upperBound));
	}

	/**
	 * @return the number that has been generated 
	 */
	public int getRanNum(int i){ // 

		if(i>=size || i<0) 
			throw new IllegalArgumentException("Number not in Scope!");

		return ranNum.get(i); 
	}

	/**
	 * @return the size of the ArrayList
	 */
	public double getSize(){

		return size; 
	}
}
