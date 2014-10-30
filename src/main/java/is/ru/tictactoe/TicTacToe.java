
import java.util.Scanner;

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
	public boolean checkRows(){
		for(int i = 0; i < 3; i++){
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
				return true;
		}
		return false;
	}
	public boolean checkColumns(){
		for(int i = 0; i < 3; i++)
		{
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
				return true;
		}
		return false;
	}
	public boolean checkForWin(){
		return (checkDiagonal() || checkRows() || checkColumns());
	}
	public boolean isGameOver(){
		return (isBoardFull() || checkForWin());
	}
	public void print(){
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j <3; j++){
                                System.out.print(board[i][j]);
                        }
                        System.out.println();
                }
        }
        public int getInt(Scanner in){
                int z = in.nextInt();
                return z;
        }
        public static void main(String[] args){
                TicTacToe tic = new TicTacToe();
                int x = 0;
                int y = 0;
                Scanner in = new Scanner(System.in);
                while(!tic.isGameOver()){
                        x = tic.getInt(in);
                        y = tic.getInt(in);
                        while(!tic.playerMove(x, y)){
                                System.out.println("Reyndu aftur");
                                x = tic.getInt(in);
                                y = tic.getInt(in);
                        }
                        tic.print();
                        tic.changePlayer();
                }
		tic.changePlayer();
		if(tic.checkForWin()){
			System.out.print("Til hamingju ");
			System.out.print(tic.currPlayer);
			System.out.println(", þú vannst!");
		}
		else if(tic.isBoardFull()){
			System.out.println("Jafntefli");
		}
        }

}
