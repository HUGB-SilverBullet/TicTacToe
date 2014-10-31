package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

import javax.print.DocFlavor;

public class TicTacToeWeb implements SparkApplication {

    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication TicTacToeWeb = new TicTacToeWeb();
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }
        TicTacToeWeb.init();
    }

    public void init() {

        final TicTacToe game = new TicTacToe();



        post(new Route("/reset") {
            @Override
            public Object handle(Request request, Response response) {
                game.resetBoard();
                response.status(200);
                return response;
            }
        });

        post(new Route("/playerMove") {
            @Override
            public Object handle(Request request, Response response) {
                Integer x = Integer.valueOf(request.queryParams("number1"));
                Integer y = Integer.valueOf(request.queryParams("number2"));

                if(game.isGameOver()){
                    return "The game is over! Reset the game to keep playing!";
                }

                if (game.playerMove(x, y)) {
                    response.status(200);

                    StringBuilder tableBoard = new StringBuilder();
                    tableBoard.append("<table class=\"table board table-bordered\" >\n" +
                            "                <tbody>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"c00\" class=\"cell\">"+ game.board[0][0] +"</td>\n" +
                            "                    <td id=\"c01\"class=\"cell\">"+ game.board[0][1] +"</td>\n" +
                            "                    <td id=\"c02\"class=\"cell\">"+ game.board[0][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"c10\"class=\"cell\">"+ game.board[1][0] +"</td>\n" +
                            "                    <td id=\"c11\"class=\"cell\">"+ game.board[1][1] +"</td>\n" +
                            "                    <td id=\"c12\"class=\"cell\">"+ game.board[1][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"20\"class=\"cell\">"+ game.board[2][0] +"</td>\n" +
                            "                    <td id=\"21\"class=\"cell\">"+ game.board[2][1] +"</td>\n" +
                            "                    <td id=\"22\"class=\"cell\">"+ game.board[2][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                </tbody>\n" +
                            "            </table>");
                    if(game.isBoardFull() && !game.checkForWin()){
                        game.resetBoard();
                        return tableBoard.toString() + "The game is a draw! Start over!";
                    }
                    if(game.checkForWin()){
                        game.resetBoard();
                        return tableBoard.toString() + "Game over! " + game.currPlayer + " won!";
                    }

                    game.changePlayer();
                    return tableBoard.toString();
                }
                response.status(500);
                return response;
            }
        });
    }
}