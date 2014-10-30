

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication {

	public static void main(String[] args){
		staticFileLocation("/public");
		SparkApplication TicTacToeWeb = new TicTacToeWeb();
		String port = System.getenv("PORT");
		if(port != null){
			setPort(Integer.valueOf(port));
		} 
		TicTacToeWeb.init();
	}
	
	public void init() {
	
		final TicTacToe TTT = new TicTacToe();
	}
}
