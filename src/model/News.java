package model;

public class News {

    private String title;
    private String body;

    public News(String title, String body){
        this.body = body;
        this.title = title;
    }

    @Override
    public String toString() {
        return "News: " + title + " description: " + body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
}
