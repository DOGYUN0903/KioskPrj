package lv4;


import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private final Scanner sc;

    public Kiosk(List<Menu> menus, Scanner sc) {
        this.menus = menus;
        this.sc = sc;
    }

    public void start() {
        while (true) {
            showMainMenu();
            int inputNum = inputMainMenuNumber();

            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (inputNum > 0 && inputNum <= menus.size()) {
                showFoodMenu(inputNum);
            }
        }
    }


    private void showMainMenu() {
        System.out.println("=====================================================================");
        System.out.println("[                             MAIN MENU                             ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getMenuCategory());
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("=====================================================================");
        System.out.print("입력: ");
    }

    private int inputMainMenuNumber() {
        int inputNumber = sc.nextInt();
        System.out.println();
        return inputNumber;
    }

    private void showFoodMenu(int inputNum) {
        Menu selectedMenu = menus.get(inputNum - 1);

        while (true) {
            showMenuItems(selectedMenu);
            System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
            int orderNum = sc.nextInt();
            sc.nextLine();

            if (orderNum == 0) {
                break;
            }

            if (orderNum >= 1 && orderNum <= selectedMenu.getMenuItems().size()) {
                handleOrder(selectedMenu, orderNum);
            }
            else {
                System.out.println("잘못된 주문번호입니다.");
            }

        }
    }

    private void showMenuItems(Menu menu) {
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

    private void handleOrder(Menu selectedMenu, int orderNum) {
        MenuItem menu = selectedMenu.getMenuItems().get(orderNum - 1);
        System.out.println(menu.getFoodName() + "를 주문하였습니다. 가격은 " + menu.getPrice() + "원 입니다.");
        System.out.println("메뉴 설명: " + menu.getDescription());
    }

}
