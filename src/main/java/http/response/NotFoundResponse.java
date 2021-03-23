package http.response;

public class NotFoundResponse extends Response{
    @Override
    public String getResponseString() {
        return "HTTP/1.1 404 NOT FOUND\r\nContent-Type: text/html\r\n\r\n";
    }
}
