package rockPaperScissors.rpsMaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ansaar.fatehally This class contains all the logic to run the game.
 */
public class Game {
	private int wins;
	private int losses;
	private int ties;
	private Move userMove;
	private Move genMove;

	/**
	 * This constructor creates a game with all fields initialized.
	 */
	public Game() {
		super();
		this.wins = 0;
		this.losses = 0;
		this.ties = 0;
		this.userMove = null;
		this.genMove = null;
	}


	/**
	 * This enum contains the 3 valid moves. These moves are played by the computer
	 * and the player alike.
	 */
	public enum Move {
		ROCK, PAPER, SCISSORS;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	/**
	 * This method runs the while loop of the game. It takes in a string as an input
	 * and plays accordingly.
	 */
	public int gameplay() throws IOException {
		System.out.println("Welcome to Rock, Paper, Scissors!");
		while (true) {
			System.out.println(
					"Press R for Rock, P for Paper and S for scissors to see if you can beat the computer at it! Press 1 to see your score, 2 to exit.");

			// Read user input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String movestring = reader.readLine();

			// Check character/string entered:
			if (movestring.equals("1")) {
				System.out.println("Your score is:" + wins + " wins, " + losses + " losses, " + ties + " ties.");
				continue;
			} else if (movestring.equals("2")) {
				System.out.println("Thanks for playing, see you next time!");
				break;
			} else if (movestring.equals("R") || movestring.equals("r")) {
				this.userMove = Move.ROCK;
			} else if (movestring.equals("P") || movestring.equals("p")) {
				this.userMove = Move.PAPER;
			} else if (movestring.equals("S") || movestring.equals("s")) {
				this.userMove = Move.SCISSORS;
			} else {
				System.out.println("Invalid entry. Try again!");
				continue;
			}
			System.out.println("You played " + this.userMove);
			this.genMove = genMove(); // Computer plays
			referee(this.userMove, this.genMove); // Game is decided.
			
			//If the game is restarted, moves are back to null.
			userMove = null;
			genMove = null;
		}
		return 0;

	}

	/**
	 * the referee function decides the result of the round. If the computer wins,
	 * it is considered a loss. If the User wins, it is considered a win. A draw
	 * results in a tie. These numbers are tallied to display the scores.
	 * 
	 * @param userMove is the move played by the user.
	 */
	public short referee(Move userMove, Move genMove) {
		short result = -2; // result is -1 for loss, 0 for tie and 1 for win

		// Calculating the results:
		if (userMove == genMove) {
			result = 0;
		} else if (userMove.equals(Move.ROCK)) {
			if (genMove.equals(Move.PAPER)) // computer plays paper
				result = -1;
			else if (genMove.equals(Move.SCISSORS)) // computer plays scissors
				result = 1;
		} else if (userMove.equals(Move.PAPER)) {
			if (genMove.equals(Move.ROCK)) // computer plays rock
				result = 1;
			else if (genMove.equals(Move.SCISSORS)) // computer plays scissors
				result = -1;
		} else if (userMove.equals(Move.SCISSORS)) {
			if (genMove.equals(Move.ROCK)) // computer plays rock
				result = -1;
			else if (genMove.equals(Move.PAPER)) // computer plays paper
				result = 1;
		}

		// Announcing the results:
		switch (result) {
		case -1:
			System.out.println("You lost this round :(");
			this.losses++;
			break;
		case 0:
			System.out.println("You tied with the computer this round!");
			this.ties++;
			break;
		case 1:
			System.out.println("You win this round! :)");
			this.wins++;
			break;
		default:
			System.out.println("Unknown result case. Please contact the game admin.");
		}
		return result;// this is only used for testing.
	}

	/**
	 * genMove() generates a move by the computer
	 * 
	 * @Move is the return type, used for testing.
	 */
	private Move genMove() {
		int genMoveInt = -1;
		do {
			genMoveInt = (int) Math.floor(Math.random() * 3); // Generates 0,1,2 randomly.
		}while(genMoveInt ==3);
		
		switch (genMoveInt) {
		case 0:
			this.genMove = Move.ROCK;
			break;
		case 1:
			this.genMove = Move.PAPER;
			break;
		case 2:
			this.genMove = Move.SCISSORS;
			break;
		default:
			System.out.println("ERROR: Computer generated an invalid move. Please contact the game admin.");
			break;
		}
		System.out.println("The computer played " + genMove);
		return this.genMove;
	}

}