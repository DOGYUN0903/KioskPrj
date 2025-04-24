package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu(); // 메뉴판 출력
            System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
            int inputNum = sc.nextInt(); // 어떤 기능을 수행할 것인지 선택
            sc.nextLine(); // 개행 제거

            if (order(inputNum)) break;

        }
    }

    private static boolean order(int inputNum) {
        if (inputNum == 1) {
            System.out.println("shackBurger를 주문하였습니다. 가격은 6900원 입니다.");
//                purchase(sc);
        } else if (inputNum == 2) {
            System.out.println("SmokeShack을 주문하였습니다. 가격은 8900원 입니다.");
//                purchase(sc);
        } else if (inputNum == 3) {
            System.out.println("Cheeseburger를 주문하였습니다. 가격은 6900원 입니다.");
//                purchase(sc);
        } else if (inputNum == 4) {
            System.out.println("Hamburger를 주문하였습니다. 가격은 5400원 입니다.");
//                purchase(sc);
        } else if (inputNum == 0) {
            System.out.println("키오스크 프로그램을 종료합니다. 안녕히가세요.");
            return true;
        } else {
            System.out.println("잘못된 주문번호입니다.");
        }
        return false;
    }

//    private static void purchase(Scanner sc) {
//        System.out.print("구매하시겠습니까? (네 | 아니요) : ");
//        String answer = sc.nextLine();
//        if (answer.equals("네")) {
//            System.out.println("shackBurger를 주문하였습니다. 6900원을 결제하겠습니다.");
//        } else if (answer.equals("아니요")) {
//            System.out.println("주문을 초기화합니다.");
//        } else {
//            System.out.println("올바른 대답을 입력해주세요. (네 | 아니요)");
//        }
//    }

    private static void showMenu() {
        System.out.println("=====================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료      | 종료");
        System.out.println("=====================================================================");
        System.out.println();
    }


}


