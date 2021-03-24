package http.response;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TextResponse extends Response{

    private final String data;


    public TextResponse(String data) {
        this.data = data;
    }


    @Override
    public String getResponseString() {
        String content = URLEncoder.encode(data, StandardCharsets.UTF_8);
        int contentLength = content.length();
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: "+contentLength+"\r\n\r\n";
        response+= content;
        return response;

    }
}
