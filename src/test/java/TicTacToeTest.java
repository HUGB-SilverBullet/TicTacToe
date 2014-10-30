package TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("TicTacToe.TicTacToeTest");
	}
	@Test
	public void testResetBoard()
	{
		TicTacToe test = new TicTacToe();
		test.resetBoard();
		assertEquals(' ', test.board[1][1]);
	}

}
