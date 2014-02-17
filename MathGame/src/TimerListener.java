import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class TimerListener
{
	private String str = "";
	private static String name; 
	private static Scanner sca;
	private static Game g;
	private static UserInput uI;

	TimerTask task = new TimerTask(){
		public void run(){
			if( str.equals("") ){
				System.out.println( "you input nothing. exit..." );
				System.exit( 0 );
			}
		}
	};

	public void getInput() throws Exception{
		Timer timer = new Timer();
		timer.schedule( task, 10*1000 );

		System.out.println( "Input a string within 10 seconds: " );
		

		timer.cancel();
		System.out.println( "you have entered: "+ str ); 
	}

	public static void main( String[] args )
	{
		try{
			(new TimerListener()).getInput();
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
		catch( Exception e ){
			System.out.println( e );
		}
		System.out.println( "main exit..." );
	}
	
	private static void Intro(Scanner sca) throws InterruptedException{



		System.out.println("This is a game where you race against time to be the very best!");

		Thread.sleep(1000); // makes the current session sleep for the amount of time

		System.out.print("\nEnter your name: ");
		name = sca.nextLine();

		System.out.println("\nOkay " + name + " let's get this started!\n");

	}
	
	private static void gameCheck(Scanner sca, String operation){
		System.out.print("\n" + name + " enter your answer for ");
		for(int i=0; i<uI.getNumbers(); i++){
			System.out.print(g.getNum(i) + (i<uI.getNumbers()-1 ? operation : "= "));   
		}

		if(sca.nextDouble() == g.getAnswer())
			System.out.println("GOOD JOB!! :D");	
		else
			System.out.println("ARE YOU DUMB?? THAT'S WRONG!!");
	}
	
	public static void continueGame() throws InterruptedException{

		g.playGame(uI.getDifficulty(), uI.getNumbers(), uI.getOperation());
		gameCheck(sca, g.getOperation());


	}
}