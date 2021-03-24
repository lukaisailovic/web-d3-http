package http.client;


public class Response {
    private final int httpStatus;
    private final String contentType;
    private String body;

    public Response(int httpStatus, String contentType) {
        this.httpStatus = httpStatus;
        this.contentType = contentType;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getContentType() {
        return contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body =body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "httpStatus=" + httpStatus +
                ", contentType='" + contentType + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
