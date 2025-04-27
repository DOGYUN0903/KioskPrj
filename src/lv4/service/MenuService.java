package lv4.service;

import lv4.Menu;

import java.util.List;

public class MenuService {

    public void showMainMenu(List<Menu> menus) {
        System.out.println("=====================================================================");
        System.out.println("[                             MAIN MENU                             ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getMenuCategory());
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("=====================================================================");
        System.out.print("입력: ");
    }

    public void showMenuItems(Menu menu) {
        System.out.println("=====================================================================");
        System.out.println("[ " + menu.getMenuCategory() + " MENU ]");
        // 메뉴판을 하드코딩하지 않기 위해 반복문을 사용합니다.
        // menu 리스트에 있는 각각의 MenuItem을 꺼내기 위해서
        // 메뉴는 menuItems 리스트에 저장되어 있으며, 리스트의 각 요소는 MenuItem 객체입니다.
        // 인덱스는 0부터 시작하지만, 메뉴 번호는 1부터 출력해야 하므로 i + 1을 사용합니다.
        // 각 항목은 getter를 통해 이름, 가격, 설명을 가져와 출력합니다.
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            System.out.println((i + 1) + ". " + menu.getMenuItems().get(i).getFoodName() + "   | " + menu.getMenuItems().get(i).getPrice() + " | " + menu.getMenuItems().get(i).getDescription());
        }
        System.out.println("0. 뒤로가기");
        System.out.println("=====================================================================");
        System.out.println();
    }
}
