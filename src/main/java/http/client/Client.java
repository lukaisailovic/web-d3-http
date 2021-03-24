package http.client;

import http.request.Parser;
import http.request.Request;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;


public class Client {

    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }
    public Response sendRequest(Request request){
        try{
            out.println(request.getHttpMethod().toString()+" "+request.getPath()+" HTTP/1.1\r\n\r\n");
            return parseResponse();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    private Response parseResponse() throws IOException {
        String requestLine = in.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

        stringTokenizer.nextToken();
        String statusCode = stringTokenizer.nextToken();


        int contentLength = 0;
        String contentType = null;

        System.out.println("\nHTTP ODGOVOR KLIJENTA:\n");
        do {
            System.out.println(requestLine);
            requestLine = in.readLine();
            if (requestLine.contains("Content-Length")){
                String[] parts = requestLine.split(":");
                contentLength = Integer.parseInt(parts[1].trim());
            }
            if (requestLine.contains("Content-Type")){
                String[] parts = requestLine.split(":");
                contentType = parts[1].trim();
            }
        } while (!requestLine.trim().equals(""));

        Response response = new Response(Integer.parseInt(statusCode),contentType);

        if (contentLength > 0) {
            String parsedBody = Parser.bodyParser(in,contentLength);
            response.setBody(parsedBody);
            System.out.println(parsedBody);
        }
        return response;

    }


    private void closeConnection(){
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
