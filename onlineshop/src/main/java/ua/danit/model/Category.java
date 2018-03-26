package ua.danit.model;

import java.util.HashMap;
import java.util.Map;

public enum Category {

    COMPUTER("Computers"),
    MOBILE("Mobile Phones"),
    BOOK("Books");

    private String title;

    private static final Map<String, Category> categoryMap = new HashMap<>();

    static {
        for (Category category : Category.values()) {
            categoryMap.put(category.getTitle(), category);
        }
    }

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Category getCategoryByTitle(String title) {
        Category category = categoryMap.get(title);

        if (category == null) {
            throw new IllegalArgumentException("Unknown code: " + title + " for " + Category.class.toString());
        }

        return category;
    }
}
