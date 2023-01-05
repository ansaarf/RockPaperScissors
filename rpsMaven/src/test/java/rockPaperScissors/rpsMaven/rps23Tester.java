package rockPaperScissors.rpsMaven;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
//import rockPaperScissors.rpsMaven.Game;
import rockPaperScissors.rpsMaven.Game.Move;

class rps23Tester {


	@Test
	void testCaseTie() throws IOException {
		Game game = new Game();
		assertTrue(game.referee(Move.ROCK, Move.ROCK)==0);		
	}

	@Test
	void testCaseWin() {
		Game game = new Game();
		assertTrue(game.referee(Move.ROCK, Move.SCISSORS)==1);
	}
	
	@Test
	void testCaseLoss() {
		Game game = new Game();
		assertTrue(game.referee(Move.ROCK, Move.PAPER)==-1);
	}
}
