package http;


import http.request.Parser;
import http.request.Request;
import http.response.NotFoundResponse;
import http.response.Response;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.StringTokenizer;
import java.util.function.Function;

public class ServerThread implements Runnable {

    private final Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private final Router router;

    public ServerThread(Socket sock,Router router) {
        this.client = sock;
        this.initializeIO();
        this.router = router;

    }

    public void run() {
        try {
            // uzimamo samo prvu liniju zahteva, iz koje dobijamo HTTP method i putanju
            String requestLine = in.readLine();

            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();
            Request request = new Request(HttpMethod.valueOf(method), path);
            int contentLength = 0;

            System.out.println("\nHTTP ZAHTEV KLIJENTA:\n");
            do {
                System.out.println(requestLine);
                requestLine = in.readLine();
                if (requestLine.contains("Content-Length")){
                    String[] parts = requestLine.split(":");
                    contentLength = Integer.parseInt(parts[1].trim());
                }
            } while (!requestLine.trim().equals(""));

            if (method.equals(HttpMethod.POST.toString())) {
                String parsedBody = Parser.bodyParser(in,contentLength);
                request.addRequestBody(parsedBody);
                System.out.println(request.getBody());
            }


            // try to get handler;
            Function<Request,Response> handler = this.router.getHandler(request);
            Response response;
            if (handler == null){
                response = new NotFoundResponse();
            } else {
                response = handler.apply(request);
            }
            System.out.println("\nHTTP odgovor:\n");
            System.out.println(response.getResponseString());

            out.println(response.getResponseString());
            this.closeIO();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeIO() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            client.getInputStream()));
            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    client.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void closeIO() throws IOException {
        in.close();
        out.close();
        client.close();
    }
}
