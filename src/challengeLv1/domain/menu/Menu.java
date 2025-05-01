package challengeLv1.domain.menu;



import java.util.List;

/**
 * Menu 클래스는 카테고리별 메뉴 묶음입니다.
 */
public class Menu {
    private String menuCategory;  // 메뉴 카테고리명
    private List<MenuItem> menuItems;  // 해당 카테고리에 포함된 메뉴 항목 리스트

    public Menu(String menuCategory, List<MenuItem> menuItems) {
        this.menuCategory = menuCategory;
        this.menuItems = menuItems;
    }

    // 메뉴 카테고리명 반환
    public String getMenuCategory() {
        return menuCategory;
    }

    // 메뉴 항목 리스트 반환
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
