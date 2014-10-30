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
                if(x >=  0 && y >=  0 && x < 3 && y < 3){
			if(board[x][y] == ' '){
				board[x][y] = currPlayer;
				return true;
			}
		}
		return false;
	}
	public boolean checkDiagonal(){
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){
			return true;
		}
		else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != ' '){
			return true;
		}
		return false;
	}

}
