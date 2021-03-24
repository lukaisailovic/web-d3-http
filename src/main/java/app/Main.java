package app;

import http.HttpMethod;
import http.request.Request;
import http.Server;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.getRouter().registerRoute(new Request(HttpMethod.GET,"/newsletter"),QuotesController::getQuotes);
        server.getRouter().registerRoute(new Request(HttpMethod.GET,"/test"),QuotesController::test);

        server.start(8080);
    }
}
