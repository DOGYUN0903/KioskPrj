package lv2;

public class MenuItem {
    private String foodName;
    private int price;
    private String description;

    public MenuItem(String foodName, int price, String description) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
