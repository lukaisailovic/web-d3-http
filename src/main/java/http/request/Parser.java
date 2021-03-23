package http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class Parser {

    public static String bodyParser(BufferedReader in, int contentLength) throws IOException {
        System.out.println("\nBODY:\n");
        StringBuilder body = new StringBuilder();
        int count = 0;
        int c = in.read();
        while ((c  != -1) && count < contentLength){
            body.append((char)c);
            count++;
            if (contentLength == count){
                break;
            }
            c = in.read();
        }
        return body.toString();
    }
}
