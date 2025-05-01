package challengeLv2.domain.menu;

import challengeLv2.enums.MenuCategory;

import java.util.List;

/**
 * Menu 클래스는 카테고리별 메뉴 묶음입니다.
 */
public class Menu {
    private MenuCategory menuCategory;  // 메뉴 카테고리(enum): BURGER, DRINK 등
    private List<MenuItem> menuItems;   // 해당 카테고리에 포함된 메뉴 항목 리스트

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
