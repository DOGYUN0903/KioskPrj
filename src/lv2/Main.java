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

    private static boolean order(int orderNum, List<MenuItem> menuItems) {
        if (orderNum == 1) {
            System.out.println(menuItems.get(0).getFoodName() + "를 주문하였습니다. 가격은 " + menuItems.get(0).getPrice() + "원 입니다.");
            System.out.println("메뉴 설명: " + menuItems.get(0).getDescription());
        } else if (orderNum == 2) {
            System.out.println(menuItems.get(1).getFoodName() + "를 주문하였습니다. 가격은 " + menuItems.get(1).getPrice() + "원 입니다.");
            System.out.println("메뉴 설명: " + menuItems.get(1).getDescription());
        } else if (orderNum == 3) {
            System.out.println(menuItems.get(2).getFoodName() + "를 주문하였습니다. 가격은 " + menuItems.get(2).getPrice() + "원 입니다.");
            System.out.println("메뉴 설명: " + menuItems.get(2).getDescription());
        } else if (orderNum == 4) {
            System.out.println(menuItems.get(3).getFoodName() + "를 주문하였습니다. 가격은 " + menuItems.get(3).getPrice() + "원 입니다.");
            System.out.println("메뉴 설명: " + menuItems.get(3).getDescription());
        } else if (orderNum == 0) {
            System.out.println("키오스크 프로그램을 종료합니다. 안녕히가세요.");
            return true;
        } else {
            System.out.println("잘못된 주문번호입니다.");
        }
        return false;
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
