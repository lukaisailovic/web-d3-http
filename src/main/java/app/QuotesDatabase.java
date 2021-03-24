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

    public List<Quote> getQuotes() {
        return quotes;
    }
}
