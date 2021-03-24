package app;

import http.request.Request;
import http.StaticFiles;
import http.response.*;

import java.io.IOException;


public class QuotesController {

    public static Response getQuotes(Request request){
        String content ="";
        try {
            content = StaticFiles.load("index.html");
        } catch (IOException e) {
            e.printStackTrace();
            return new NotFoundResponse();
        }
        return new HtmlResponse(content);
    }

    public static Response saveQuote(Request request){
        return new RedirectResponse("/newsletter");
    }




}
