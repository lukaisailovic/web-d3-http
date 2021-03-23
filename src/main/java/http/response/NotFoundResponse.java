package http.response;

public class NotFoundResponse extends Response{
    @Override
    public String getResponseString() {
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
        response += "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Not found</title></head><body>Requested route is not found</body></html>";
        return response;
    }
}
