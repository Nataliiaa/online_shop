package ua.danit.model;

public enum Category {

    computer("Computers"),
    mobile("Mobile Phones"),
    book("Books");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
