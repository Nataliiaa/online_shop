package ua.danit.model;

public class Product {

    private final Long id;
    private final String title;
    private final String description;
    private final String imageUrl;
    private final int price;

    public Product(Long id, String title, String description, String imageUrl, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;

        this.price = price;
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
}
