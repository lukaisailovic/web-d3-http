package app;

import http.Request;
import http.response.HtmlResponse;
import http.response.Response;

public class NewsletterController extends Controller {

    public NewsletterController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        String htmlBody = "" +
                "<form method=\"POST\">" +
                "<label>Email: </label><input name=\"email\" type=\"email\"><br><br>" +
                "<button>Submit</button>" +
                "</form>";

        String content = "<html><head><title>Odgovor servera</title></head>\n";
        content += "<body>" + htmlBody + "</body></html>";

        return new HtmlResponse(content);
    }

    @Override
    public Response doPost() {
        // TODO: obradi POST zahtev
        return null;
    }
}
