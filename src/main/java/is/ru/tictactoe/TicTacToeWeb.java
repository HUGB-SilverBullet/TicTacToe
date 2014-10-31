package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

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
                return response;
            }
        });
    }
}