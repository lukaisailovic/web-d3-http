package app;

import http.HttpMethod;
import http.Server;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.getRouter().registerRoute(HttpMethod.GET,"/newsletter",QuotesController::getQuotes);
        server.getRouter().registerRoute(HttpMethod.POST,"/save-quote",QuotesController::saveQuote);
        server.start(8080);
    }
}
