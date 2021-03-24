package http.response;

public class RedirectResponse extends Response {

    private final String path;

    public RedirectResponse(String path) {
        this.path = path;
    }

    @Override
    public String getResponseString() {
        return "HTTP/1.1 303 See Other\r\nLocation: "+path+"\r\n\r\n";
    }
}
