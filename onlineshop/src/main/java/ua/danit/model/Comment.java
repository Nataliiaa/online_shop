package ua.danit.model;

public class Comment {
    private final String text;
    private final String author;
    private final int rating;

    public Comment(String text, String author, int rating) {
        this.text = text;
        this.author = author;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }
}
