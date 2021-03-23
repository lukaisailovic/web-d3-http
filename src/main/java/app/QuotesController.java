package app;

import http.Request;
import http.response.HtmlResponse;
import http.response.Response;

public class QuotesController {


    public static Response getQuotes(Request request){
        String htmlBody = "" +
                "<form method=\"POST\">" +
                "<label>Email: </label><input name=\"email\" type=\"email\"><br><br>" +
                "<input name=\"test\" value=\"some value\" type=\"hidden\"><br><br>" +
                "<button>Submit</button>" +
                "</form>";

        String content = "<html><head><title>Odgovor servera</title></head>\n";
        content += "<body>" + htmlBody + "</body></html>";

        return new HtmlResponse(content);
    }


}
