package app;

import http.Request;
import http.response.HtmlResponse;
import http.response.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class QuotesController {

    public static Response getQuotes(Request request){

        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("./static/index.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HtmlResponse(contentBuilder.toString());
    }


}
