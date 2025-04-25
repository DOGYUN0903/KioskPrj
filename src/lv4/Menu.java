package lv4;


import java.util.List;

public class Menu {
    private String menuCategory;
    private List<MenuItem> menuItems;

    public Menu(String menuCategory, List<MenuItem> menuItems) {
        this.menuCategory = menuCategory;
        this.menuItems = menuItems;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
