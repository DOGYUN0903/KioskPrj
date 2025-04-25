package lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Menu bugerMenu = new Menu("Burgers", burgers);

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("cider", 2000, "탄산이 많이 들어간 사이다"));
        drinks.add(new MenuItem("coke", 2000, "탄산이 2배로 들어간 콜라"));
        drinks.add(new MenuItem("dietCoke", 2000, "0칼로리 코카콜라!"));
        drinks.add(new MenuItem("dietCider", 2000, "0칼로리 사이다!"));
        Menu drinkMenu = new Menu("Drinks", drinks);

        List<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("icecream", 1500, "아이스크림!"));
        desserts.add(new MenuItem("corn", 1000, "옥수수콘!"));
        Menu dessertMenu = new Menu("Desserts", desserts);

        List<Menu> menus = new ArrayList<>();
        menus.add(bugerMenu);
        menus.add(drinkMenu);
        menus.add(dessertMenu);

        Kiosk kiosk = new Kiosk(menus);

        kiosk.start();

    }
}
