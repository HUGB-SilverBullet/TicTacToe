package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

import java.net.ResponseCache;

public class TicTacToeWeb implements SparkApplication {

	public static void main(String[] args){
		staticFileLocation("/public");
		SparkApplication TicTacToeWeb = new TicTacToeWeb();
		String port = System.getenv("PORT");
		if(port != null){
			setPort(Integer.valueOf(port));
		}
        final TicTacToe game = new TicTacToe();

        get(new Route("/"){
            @Override
            public Object handle(Request request, Response responce){
                String title = "TicTacToe";
                String reset_game = "<a href='/index/reset'>Reset game</a>";
                StringBuilder html = new StringBuilder();

                html.append("<h1>").append(title).append("</h1>").append(reset_game);
                html.append("<hr>");

                game.resetBoard();

                    for(Char i : game.) {
                        html.append("Title: ").append(article.getTitle())
                                .append("<br/>")
                                .append(article.getCreatedAt())
                                .append("<br/>")
                                .append("Summary: ").append(article.getSummary())
                                .append("<br/>")
                                .append(article.getEditLink()).append(" | ").append(article.getDeleteLink())
                                .append("</p>");
                    }
                }

                return html.toString();
            }
        });
        post(new Route("/reset"){
            @Override
            public Object handle(Request request, Response response){
                game.resetBoard();
                response.status(200);
                return response;
            }
        });
	}
}
