package challengeLv2.enums;

public enum MenuCategory {
    BURGER("Burgers"),
    DRINK("Drinks"),
    DESSERT("Desserts");

    private final String category;

    MenuCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}


