package http;

import http.request.Request;
import http.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Router {
    private final Map<Request,Function<Request, Response>> routes = new HashMap<>();

    public void registerRoute(HttpMethod httpMethod, String path,Function<Request,Response> handler){
        Request request = new Request(httpMethod,path);
        this.routes.put(request,handler);
    }
    public Function<Request,Response> getHandler(Request request){
        Function<Request,Response> handler = null;
        for (Map.Entry<Request,Function<Request, Response>> entry: this.routes.entrySet()){
            if (entry.getKey().hashCode() == request.hashCode()){
                handler = entry.getValue();
            }
        }
        return handler;
    }

}
