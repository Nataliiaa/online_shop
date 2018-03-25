package ua.danit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private final Long id;
    private final String title;
    private final String description;
    private final String imageUrl;
    private final int price;

    private static Long nextId = 0L;

    private List<Comment> comments;

    public Product(String title, String description, String imageUrl, int price) {
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void addComment(String text, String author, int rating) {
        comments.add(new Comment(text, author, rating));
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
