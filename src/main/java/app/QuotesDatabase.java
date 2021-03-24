package app;

import java.util.ArrayList;
import java.util.List;

public class QuotesDatabase {

    private static QuotesDatabase instance = null;
    private final List<Quote> quotes;


    private QuotesDatabase(){
        quotes = new ArrayList<>();
    }

    public static QuotesDatabase getInstance() {
        if (instance == null){
            instance = new QuotesDatabase();
        }
        return instance;
    }

    public String getAllQuotesAsHTMLListItems(){
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("QUOTES LENGTH IS "+this.quotes.size());
        for (Quote quote: this.quotes
             ) {
            System.out.println(quote);
            stringBuilder.append("<li class=\"list-group-item\">").append(quote.getAuthor()).append(": ").append(quote.getQuote()).append("</li>");
        }
        return stringBuilder.toString();
    }

    public List<Quote> getQuotes() {
        return quotes;
    }


}
