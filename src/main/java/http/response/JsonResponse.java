package http.response;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class JsonResponse extends Response{

    private final String data;


    public JsonResponse(String data) {
        this.data = data;
    }


    @Override
    public String getResponseString() {
        String content = data;
        int contentLength = content.length();
        String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: "+contentLength+"\r\n\r\n";
        response+= content;
        return response;

    }
}
