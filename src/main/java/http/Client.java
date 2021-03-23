package http;

import http.request.Request;
import http.response.Response;

import java.io.*;
import java.net.Socket;

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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
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
