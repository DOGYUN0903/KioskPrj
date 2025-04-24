package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>(); // MenuItem을 담을 리스트 객체 생성
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")); // list 안에 햄버거 객체 생성 후 추가
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu(menuItems); // 메뉴판을 보여주는 메서드
            System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
            int orderNum = sc.nextInt(); // 어떤 기능을 수행할 것인지 선택
            sc.nextLine(); // 개행 제거

            if (order(orderNum, menuItems)) break; // 주문번호에 따른 메뉴 가져오기
        }

    }

    /**
     * 사용자로부터 입력받은 주문 번호에 따라 메뉴 정보를 출력하거나 프로그램을 종료합니다.
     *
     * @param orderNum 사용자가 입력한 주문 번호
     * @param menuItems 메뉴 항목 리스트
     * @return 주문 번호가 0인 경우 true(프로그램 종료), 그 외에는 false
     */
    private static boolean order(int orderNum, List<MenuItem> menuItems) {
        // 주문 번호가 1~4 사이일 경우, 해당 인덱스의 메뉴 정보를 출력
        if (orderNum >= 1 && orderNum <= menuItems.size()) {
            MenuItem menu = menuItems.get(orderNum - 1); // 인덱스는 0부터 시작이니까 -1을 사용하여 인덱스에 맞춰줍니다.
            System.out.println(menu.getFoodName() + "를 주문하였습니다. 가격은 " + menu.getPrice() + "원 입니다.");
            System.out.println("메뉴 설명: " + menu.getDescription());
        }
        // 주문 번호가 0이면 프로그램 종료
        else if (orderNum == 0) {
            System.out.println("키오스크 프로그램을 종료합니다. 안녕히가세요.");
            return true;
        }
        // orderNum >= 1 && orderNum <= menuItems.size() 이외의 번호는 잘못된 입력으로 다시 처음부터 메뉴 선택
        else {
            System.out.println("잘못된 주문번호입니다.");
        }
        return false;
    }

    private static void showMenu(List<MenuItem> menuItems) {
        System.out.println("=====================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        // 메뉴판을 하드코딩하지 않기 위해 반복문을 사용합니다.
        // 메뉴는 menuItems 리스트에 저장되어 있으며, 리스트의 각 요소는 MenuItem 객체입니다.
        // 인덱스는 0부터 시작하지만, 메뉴 번호는 1부터 출력해야 하므로 i + 1을 사용합니다.
        // 각 항목은 getter를 통해 이름, 가격, 설명을 가져와 출력합니다.
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get((i)).getFoodName() + "   | " + menuItems.get((i)).getPrice() + " | " + menuItems.get((i)).getDescription());
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("=====================================================================");
        System.out.println();
    }
}
