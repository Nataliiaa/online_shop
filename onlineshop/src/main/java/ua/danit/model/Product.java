package ua.danit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Product {

    private static Long nextId = 0L;
    private  Long id;
    private  String title;
    private  String description;
    private  String imageUrl;
    private  int price;
    private  List<Comment> comments;
    private  Category category;

    public Product(){
    }


    public Product(Long id, String title, Category category, String description, String imageUrl, int price) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public Product(String title, Category category, String description, String imageUrl, int price) {
        this.id = nextId++;
        this.category = category;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.comments = new ArrayList<>();
    }


    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
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
        return price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imageUrl, product.imageUrl) &&
                Objects.equals(comments, product.comments) &&
                category == product.category;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, imageUrl, price, comments, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", comments=" + comments +
                ", category=" + category +
                '}';
    }
}
