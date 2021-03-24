package app;

import http.client.Client;
import http.HttpMethod;
import http.client.Response;
import http.request.Request;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost",8080);
        Request request = new Request(HttpMethod.GET,"/test");
        Response response = client.sendRequest(request);
        System.out.println(response);
    }
}
