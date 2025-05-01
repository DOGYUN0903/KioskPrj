package challengeLv2.enums;

/**
 * MenuCategory는 메뉴(Burger, Drink, Dessert 등)를 정의하는 Enum입니다.
 */
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


