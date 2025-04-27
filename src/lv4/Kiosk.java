package lv4;


import lv4.service.MenuService;
import lv4.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private final Scanner sc;
    private final MenuService menuService;
    private final OrderService orderService;

    public Kiosk(List<Menu> menus, Scanner sc) {
        this.menus = menus;
        this.sc = sc;
        this.menuService = new MenuService();
        this.orderService = new OrderService();
    }

    public void start() {
        while (true) {
            menuService.showMainMenu(menus);
            int inputNum = inputMainMenuNumber();

            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (inputNum > 0 && inputNum <= menus.size()) {
                showFoodMenu(inputNum);
            }
        }
    }

    private int inputMainMenuNumber() {
        int inputNumber = sc.nextInt();
        System.out.println();
        return inputNumber;
    }

    private void showFoodMenu(int inputNum) {
        Menu selectedMenu = menus.get(inputNum - 1);

        while (true) {
            menuService.showMenuItems(selectedMenu);
            System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
            int orderNum = sc.nextInt();
            sc.nextLine();

            if (orderNum == 0) {
                break;
            }

            if (orderNum >= 1 && orderNum <= selectedMenu.getMenuItems().size()) {
                orderService.processOrder(selectedMenu, orderNum);
            }
            else {
                System.out.println("잘못된 주문번호입니다.");
            }

        }
    }

}
