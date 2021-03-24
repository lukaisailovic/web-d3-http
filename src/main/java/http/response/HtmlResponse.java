package http.response;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlResponse extends Response {

    private String html;
    private final HashMap<String,String> parameters = new HashMap<>();
    private static final String START_PATTERN = "{{";
    private static final String END_PATTERN = "}}";
    public HtmlResponse(String html) {
        this.html = html;
    }

    public void addParameter(String key, String value){
        this.parameters.put(key,value);
    }

    private void replaceParameters(){
        String regexString = Pattern.quote(START_PATTERN) + "(.*?)" + Pattern.quote(END_PATTERN);
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String textInBetween = matcher.group(1);
            if (this.parameters.containsKey(textInBetween)){
                String regexReplaceString = Pattern.quote(START_PATTERN) + textInBetween + Pattern.quote(END_PATTERN);
                this.html = this.html.replaceAll(regexReplaceString,this.parameters.get(textInBetween));
            }
        }
    }

    @Override
    public String getResponseString() {
        this.replaceParameters();
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
        response += html;

        return response;
    }
}
