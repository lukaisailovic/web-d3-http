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
            HtmlResponse response = new HtmlResponse(content);
            response.addParameter("qotd_author","Neki lik");
            response.addParameter("qotd_content","Neki quote");
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return new NotFoundResponse();
        }
    }

    public static Response saveQuote(Request request){

        if (request.getBody().containsKey("author") && request.getBody().containsKey("quote")){
            String quote = request.getBody().get("quote");
            String author = request.getBody().get("author");
            if (!quote.equals("") && !author.equals("")){
                Quote newQuote = new Quote(author,quote);
                QuotesDatabase.getInstance().getQuotes().add(newQuote);
            }
        }

        return new RedirectResponse("/newsletter");
    }




}
