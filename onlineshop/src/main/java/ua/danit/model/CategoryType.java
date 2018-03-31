package ua.danit.model;

public class CategoryType {

    private final Long id;
    private final String title;

    public CategoryType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
