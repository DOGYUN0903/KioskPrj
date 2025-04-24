package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;
    private Scanner sc = new Scanner(System.in);

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            showMainMenu();
            int inputNum = sc.nextInt();
            sc.nextLine();

            if (inputNum == 1) {
                showFoodMenu();
            } else if (inputNum == 0) {
                System.out.println("키오스크 프로그램을 종료합니다. 안녕히가세요.");
                break;
            } else {
                System.out.println("잘못된 주문번호입니다. 다시 입력해주세요.");
            }

        }
    }

    private void showMainMenu() {
        System.out.println("=====================================================================");
        System.out.println("[               SHAKESHACK burger에 오신 것을 환영합니다.               ]");
        System.out.println("1. 주문 상세보기");
        System.out.println("0. 종료");
        System.out.print("입력: ");
        System.out.println();
        System.out.println("=====================================================================");
        System.out.println();
    }

    private void showFoodMenu() {
        while (true) {
            showMenu();
            System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
            int orderNum = sc.nextInt();
            sc.nextLine();

            if (orderNum == 0) {
                break;
            }

            if (orderNum >= 1 && orderNum <= menuItems.size()) {
                MenuItem menu = menuItems.get(orderNum - 1); // 인덱스는 0부터 시작이니까 -1을 사용하여 인덱스에 맞춰줍니다.
                System.out.println(menu.getFoodName() + "를 주문하였습니다. 가격은 " + menu.getPrice() + "원 입니다.");
                System.out.println("메뉴 설명: " + menu.getDescription());
            }
            else {
                System.out.println("잘못된 주문번호입니다.");
            }

        }
    }

    private void showMenu() {
        System.out.println("=====================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        // 메뉴판을 하드코딩하지 않기 위해 반복문을 사용합니다.
        // 메뉴는 menuItems 리스트에 저장되어 있으며, 리스트의 각 요소는 MenuItem 객체입니다.
        // 인덱스는 0부터 시작하지만, 메뉴 번호는 1부터 출력해야 하므로 i + 1을 사용합니다.
        // 각 항목은 getter를 통해 이름, 가격, 설명을 가져와 출력합니다.
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get((i)).getFoodName() + "   | " + menuItems.get((i)).getPrice() + " | " + menuItems.get((i)).getDescription());
        }
        System.out.println("0. 뒤로가기");
        System.out.println("=====================================================================");
        System.out.println();
    }

}
