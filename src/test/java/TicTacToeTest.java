package TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{
	@Test
	public void testResetBoard()
	{
		TicTacToe test = new TicTacToe();
		test.resetBoard();
		assertEquals(' ', test.board[1][1]);
	}
	@Test
	public void testChangePlayer()
	{
		TicTacToe test = new TicTacToe();
		test.changePlayer();
		assertEquals('o',test.currPlayer);
	}
	@Test
	public void testIsBoardFull()
	{
		TicTacToe test = new TicTacToe();
		assertEquals(false,test.isBoardFull());
	}
	@Test
	public void testPlayerMove()
	{
		TicTacToe test = new TicTacToe();
		test.playerMove(1,1);
		assertEquals('x',test.board[1][1]);
	}
}
