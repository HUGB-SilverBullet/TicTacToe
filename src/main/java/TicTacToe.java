package TicTacToe;

public class TicTacToe{
	public static char[][] board;
	public char currPlayer;

	public TicTacToe(){
		board = new char[3][3];
		currPlayer = 'x';
	}
        public void resetBoard(){
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                                board[i][j] = ' ';
                        }
                }
        }
	public void changePlayer(){
		if(currPlayer == 'x'){
			currPlayer = 'o';
		}
		else
		currPlayer = 'x';
	}




}
