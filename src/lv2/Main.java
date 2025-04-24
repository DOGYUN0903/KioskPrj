package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu(menuItems);
        }

    }

    private static void showMenu(List<MenuItem> menuItems) {
        System.out.println("=====================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get((i)).getFoodName() + "   | " + menuItems.get((i)).getPrice() + " | " + menuItems.get((i)).getDescription());
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("=====================================================================");
        System.out.println();
    }
}
