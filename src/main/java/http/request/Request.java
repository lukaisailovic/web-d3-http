package http.request;

import http.HttpMethod;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private final HttpMethod httpMethod;

    private final String path;

    private final Map<String,String> body = new HashMap<>();

    public Request(HttpMethod httpMethod, String path) {
        this.httpMethod = httpMethod;
        this.path = path;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Request{" +
                "httpMethod=" + httpMethod +
                ", path='" + path + '\'' +
                '}';
    }

    public void addRequestBody(String body){
        String[] data = body.split("&");
        for (String param : data) {
            String[] parts = param.split("=");
           if (parts.length > 0){
               if (parts.length == 2){
                   this.body.put(URLDecoder.decode(parts[0], StandardCharsets.UTF_8),URLDecoder.decode(parts[1], StandardCharsets.UTF_8));
               } else {
                   this.body.put(URLDecoder.decode(parts[0], StandardCharsets.UTF_8),"");
               }
           }
        }
    }

    public Map<String, String> getBody() {
        return body;
    }

    @Override
    public int hashCode() {
        return (this.path + this.getHttpMethod().toString()).hashCode();
    }
}
