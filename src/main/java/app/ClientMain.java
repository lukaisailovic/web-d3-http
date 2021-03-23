package app;

import http.Client;
import http.HttpMethod;
import http.request.Request;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost",8080);
        Request request = new Request(HttpMethod.GET,"/newsletter");
        client.sendRequest(request);
    }
}
