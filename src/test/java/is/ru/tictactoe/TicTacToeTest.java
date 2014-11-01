package is.ru.tictactoe;

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
		assertEquals('o', test.currPlayer);
	}
	@Test
	public void testIsBoardFull()
	{
		TicTacToe test = new TicTacToe();
		assertEquals(false, test.isBoardFull());
	}
	@Test
	public void testPlayerMove()
	{
		TicTacToe test = new TicTacToe();
		test.playerMove(1,1);
		assertEquals('x',test.board[1 - 1][1 - 1]);
		assertEquals(false, test.playerMove(1,1));
		assertEquals(false, test.playerMove(4,4));
	}
	@Test
	public void testCheckDiagonal()
	{
		TicTacToe test = new TicTacToe();
		test.playerMove(1,1);
		test.playerMove(2,2);
		test.playerMove(3,3);
		assertEquals(true, test.checkDiagonal());
	}
	@Test
	public void testCheckRows()
	{
		TicTacToe test = new TicTacToe();
		test.playerMove(1,1);
                test.playerMove(1,2);
                test.playerMove(1,3);
		assertEquals(true, test.checkRows());
	}
	@Test
	public void testCheckColumns()
	{
		TicTacToe test = new TicTacToe();
		test.playerMove(1,1);
                test.playerMove(2,1);
                test.playerMove(3,1);
		assertEquals(true, test.checkColumns());
	}
	@Test
	public void testCheckForWin()
	{
		TicTacToe test = new TicTacToe();
		assertEquals(false, test.checkForWin());
	}
	@Test
	public void testIsGameOver()
	{
		TicTacToe test = new TicTacToe();
		assertEquals(false, test.isGameOver());
	}
}
