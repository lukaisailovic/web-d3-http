package qotd_service;


import http.HttpMethod;
import http.Server;

public class QotdMain {

    public static void main(String[] args) {
        Server server = new Server();
        server.getRouter().registerRoute(HttpMethod.GET,"/get-qotd", QotdController::get);
        server.start(8081);
    }
}
