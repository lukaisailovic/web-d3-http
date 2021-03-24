package app;

import http.HttpMethod;
import http.client.Client;
import http.request.Request;
import http.StaticFiles;
import http.response.*;
import shared.Quote;

import java.io.IOException;


public class QuotesController {

    public static Response getQuotes(Request request){
        String content ="";
        try {
            Client client = new Client("localhost",8081);
            Request qotdRequest = new Request(HttpMethod.GET,"/get-qotd");
            http.client.Response qotdResponse = client.sendRequest(qotdRequest);
            String[] qotdParts = qotdResponse.getBody().split(":");

            content = StaticFiles.load("index.html");
            HtmlResponse response = new HtmlResponse(content);
            response.addParameter("qotd_author",qotdParts[0]);
            response.addParameter("qotd_content",qotdParts[1]);
            response.addParameter("quotes",QuotesDatabase.getInstance().getAllQuotesAsHTMLListItems());
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
