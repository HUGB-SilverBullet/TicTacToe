package TicTacToe;

public class TicTacToe{
	public static char[][] board;
	public char currPlayer;

	public TicTacToe(){
		board = new char[3][3];
		currPlayer = 'x';
		resetBoard();
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
	public boolean isBoardFull(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
	}
	public boolean playerMove(int x, int y ){
		if(board[x][y] == ' '){
			board[x][y] = currPlayer;
			return true;
		}
		return false;
	}


}
