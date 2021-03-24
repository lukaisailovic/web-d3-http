package qotd_service;


import http.request.Request;
import http.response.JsonResponse;
import http.response.Response;
import shared.Quote;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class QotdController {


    private static final List<Quote> quotes = new ArrayList<>(){{
        add(new Quote("Nelson Mandela","The greatest glory in living lies not in never falling, but in rising every time we fall."));
        add(new Quote("Walt Disney","The way to get started is to quit talking and begin doing."));
        add(new Quote("Steve Jobs","Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking."));
        add(new Quote("Eleanor Roosevelt","If life were predictable it would cease to be life, and be without flavor."));
        add(new Quote("James Cameron","If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success."));
    }};


    public static Response get(Request request){
        Random random = new Random();
        int r = random.nextInt(quotes.size());
        Quote randomQuote = quotes.get(r);
        return new JsonResponse(randomQuote.serialize());
    }
}
