package shared;

import com.google.gson.Gson;

public class Quote {

    private String author;
    private String quote;

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }

    public String serialize(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Quote deserialie(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Quote.class);
    }
}
