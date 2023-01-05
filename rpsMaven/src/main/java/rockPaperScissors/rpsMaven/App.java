package rockPaperScissors.rpsMaven;

import java.io.IOException;

/**
 * This code runs a simple console game of rock-paper-scissors. A score is
 * generated, and the game loops until exited.
 * 
 * @author ansaar.fatehally The main class runs the game
 */
public class App {

	public static void main() {
		// TODO Auto-generated method stub
		try {
			Game game = new Game();
			game.gameplay();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
