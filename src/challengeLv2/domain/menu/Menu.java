package challengeLv2.domain.menu;

import challengeLv2.enums.MenuCategory;

import java.util.List;

public class Menu {
    private MenuCategory menuCategory;
    private List<MenuItem> menuItems;

    public Menu(MenuCategory menuCategory, List<MenuItem> menuItems) {
        this.menuCategory = menuCategory;
        this.menuItems = menuItems;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
