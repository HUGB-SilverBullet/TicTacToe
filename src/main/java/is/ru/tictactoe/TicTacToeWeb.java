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
                if (game.playerMove(x, y)) {
                    response.status(200);

                    StringBuilder tableBoard = new StringBuilder();
                    tableBoard.append("<table class=\"table board\">\n" +
                            "                <tbody>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"c00\">"+ game.board[0][0] +"</td>\n" +
                            "                    <td id=\"c01\">"+ game.board[0][1] +"</td>\n" +
                            "                    <td id=\"c02\">"+ game.board[0][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"c10\">"+ game.board[1][0] +"</td>\n" +
                            "                    <td id=\"c11\">"+ game.board[1][1] +"</td>\n" +
                            "                    <td id=\"c12\">"+ game.board[1][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td id=\"20\">"+ game.board[2][0] +"</td>\n" +
                            "                    <td id=\"21\">"+ game.board[2][1] +"</td>\n" +
                            "                    <td id=\"22\">"+ game.board[2][2] +"</td>\n" +
                            "                </tr>\n" +
                            "                </tbody>\n" +
                            "            </table>");
                    game.changePlayer();
                    return tableBoard.toString();
                }
                response.status(500);
                return response;
            }
        });
    }
}