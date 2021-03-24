package qotd_service;


import http.request.Request;
import http.response.Response;
import http.response.TextResponse;


public class QotdController {


    public static Response get(Request request){
        String content = "Author: This is some random quote";
        return new TextResponse(content);
    }
}
