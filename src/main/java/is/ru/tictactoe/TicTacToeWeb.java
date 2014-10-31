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

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                String title = "TicTacToe";
                String resetLink = "<a href='/reset'>Reset</a>";
                StringBuilder html = new StringBuilder();

                html.append("<h1>").append(title).append("</h1>").append(resetLink);
                html.append("<hr>");

                if(game.isGameOver()){
                    game.resetBoard();
                }
                else{
                    html.append("<div class=\"container\">\n" +
                            "        <table class=\"board\" cellspacing=\"6\">\n" +
                            "            <tbody>\n" +
                            "            <tr>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c1\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c2\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c3\" type=\"button\">\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c4\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c5\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c6\" type=\"button\">\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c7\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c8\" type=\"button\">\n" +
                            "                </td>\n" +
                            "                <td class=\"cell\">\n" +
                            "                    <input class=\"cell\" name=\"c9\" type=\"button\">\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "            </tbody>\n" +
                            "        </table>\n" +
                            "    </div>").append("<form method=\"post\" action=\"/playerMove\" class=\"form-inline\" role=\"form\">\n" +
                            "                <div class=\"form group\">\n" +
                            "                    <input type=\"text\" name=\"number\" id=\"number\" placeholder=\"1 1\">\n" +
                            "                </div>\n" +
                            "                <button type=\"submit\">Submit move</button>\n" +
                            "            </form>");
                }
                return html.toString();
            }
        });

        post(new Route("/reset") {
            @Override
            public Object handle(Request request, Response response) {
                game.resetBoard();
                response.status(200);
                return response;
            }
        });
    }
}