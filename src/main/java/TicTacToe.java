package TicTacToe;

public class TicTacToe{
	public static char[][] board;


	public TicTacToe(){
		board = new char[3][3];
	}
        public void resetBoard(){
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                                board[i][j] = ' ';
                        }
                }
        }




}
