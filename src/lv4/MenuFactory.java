package lv4;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    public static List<Menu> createMenus() {
        List<Menu> menus = new ArrayList<>();

        List<MenuItem> burgers = List.of(
                new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")
        );

        List<MenuItem> drinks = List.of(
                new MenuItem("cider", 2000, "탄산이 많이 들어간 사이다"),
                new MenuItem("coke", 2000, "탄산이 2배로 들어간 콜라"),
                new MenuItem("dietCoke", 2000, "0칼로리 코카콜라!"),
                new MenuItem("dietCider", 2000, "0칼로리 사이다!")
        );

        List<MenuItem> desserts = List.of(
                new MenuItem("icecream", 1500, "아이스크림!"),
                new MenuItem("corn", 1000, "옥수수콘!")
        );

        menus.add(new Menu("Burgers", burgers));
        menus.add(new Menu("Drinks", drinks));
        menus.add(new Menu("Desserts", desserts));

        return menus;
    }
}
