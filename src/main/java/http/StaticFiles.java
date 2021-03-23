package http;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StaticFiles {

    private static final String PATH = "./static/";

    public static String load(String filename) throws IOException {
        String filePath = PATH + filename;
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String str;
        while ((str = in.readLine()) != null) {
            contentBuilder.append(str);
        }
        in.close();
        return contentBuilder.toString();
    }
}
