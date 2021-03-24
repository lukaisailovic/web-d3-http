package qotd_service;


import http.request.Request;
import http.response.Response;
import http.response.TextResponse;

import java.util.HashMap;
import java.util.Random;


public class QotdController {


    private static final HashMap<String,String> quotes;
    static {
        quotes = new HashMap<>();
        quotes.put("Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall.");
        quotes.put("Walt Disney", "The way to get started is to quit talking and begin doing.");
        quotes.put("Steve Jobs", "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.");
        quotes.put("Eleanor Roosevelt", "If life were predictable it would cease to be life, and be without flavor.");
        quotes.put("James Cameron", "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.");
    }

    public static Response get(Request request){
        Random random = new Random();
        Object[] keys = quotes.keySet().toArray();
        int r = random.nextInt(keys.length);
        String randomQuote = quotes.get(keys[r]);
        String content = keys[r]+": "+randomQuote;
        return new TextResponse(content);
    }
}
