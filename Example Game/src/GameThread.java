
/**
 * This is the game thread, it will run the game while it is running and keep telling things to happen.
 * @author robert.lancaster
 *
 */
public class GameThread extends Thread {

	private GamePanel game; 	// A reference to the GamePanel
	private boolean running; 	// A boolean to determine whether the game should keep running.
	private int time; 			// To keep track of a number for time
	
	/**
	 * This is how you construct the thread.  It needs the GamePanel so it can call its methods.
	 * @param g The GamePanel Object
	 */
	public GameThread(GamePanel g){
		game = g;
	}
	
	/**
	 * This is the loop that keeps running and running while the game is going.
	 */
	public void run(){
		running = true;
		while(running){
			time += 1;
			game.animate(time);
			game.repaint();
			try{
				sleep(10);	// This is important so the game takes a pause for 10 milliseconds at least, or it will freeze.
			}catch(Exception e){};
		}
	}
	
	/**
	 * This is a command to end the game.
	 */
	public void endGame(){
		running = false;
	}
}
