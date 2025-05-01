package challengeLv1.app;


import challengeLv1.domain.cart.Cart;
import challengeLv1.domain.cart.CartService;
import challengeLv1.domain.menu.Menu;
import challengeLv1.domain.menu.MenuService;
import challengeLv1.domain.order.OrderService;
import challengeLv1.exception.ExceptionHandler;
import challengeLv1.exception.InputException;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;  // 전체 메뉴 목록
    private final Scanner sc;
    private final MenuService menuService;  // 메뉴 관련 서비스
    private final OrderService orderService; // 주문 서비스
    private final CartService cartService;  // 장바구니 서비스

    public Kiosk(List<Menu> menus, Scanner sc) {
        this.menus = menus;
        this.sc = sc;
        this.menuService = new MenuService();
        this.cartService = new CartService(new Cart());
        this.orderService = new OrderService(cartService, sc);
    }

    public void start() {
        while (true) {
            try {
                menuService.showMainMenu(menus, cartService);  // 메인 메뉴 출력
                System.out.print("입력: ");
                int inputNum = ExceptionHandler.safeReadInt(sc);

                if (inputNum == 0) {
                    exitProgram(); // 프로그램 종료
                    break;
                } else if (inputNum > 0 && inputNum <= menus.size()) {
                    showFoodMenu(inputNum); // 메뉴 카테고리 상세보기
                } else if (inputNum == 4) {
                    processOrderMenu(); // 주문
                } else if (inputNum == 5) {
                    processCancelMenu(); // 주문 취소
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 프로그램 종료
    private void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
    }

    // 장바구니 비어있는지 확인하고 주문 처리하기
    private void processOrderMenu() {
        if (cartService.isCartEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            orderService.showOrder();
        }
    }

    // 주문 취소
    private void processCancelMenu() {
        if (cartService.isCartEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        while (true) {
            try {
                System.out.println("1. 전체 취소");
                System.out.println("2. 특정 상품 수량 줄이기");
                System.out.print("입력: ");
                int cancelOption = ExceptionHandler.safeReadInt(sc);

                if (cancelOption == 1) {
                    cartService.clearCart();
                    break;
                } else if (cancelOption == 2) {
                    handlePartialCancel();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 특정 상품 수량 줄이기
    private void handlePartialCancel() {
        cartService.showCart();

        int itemIndex = 0;
        while (true) {
            try {
                System.out.print("취소할 상품 번호 입력: ");
                itemIndex = ExceptionHandler.safeReadInt(sc) - 1;
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }

        int quantity = 0;
        while (true) {
            try {
                System.out.print("줄일 수량 입력: ");
                quantity = ExceptionHandler.safeReadInt(sc);
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }

        cartService.decreaseItemQuantity(itemIndex, quantity);
    }

    // 카테고리 선택 시 해당 메뉴 항목 보여주기
    private void showFoodMenu(int inputNum) {
        Menu selectedMenu = menus.get(inputNum - 1);

        while (true) {
            try {
                menuService.showMenuItems(selectedMenu);
                System.out.print("원하시는 주문 번호를 입력하여 주십시오: ");
                int orderNum = ExceptionHandler.safeReadInt(sc);

                if (orderNum == 0) {
                    break;
                }

                if (orderNum >= 1 && orderNum <= selectedMenu.getMenuItems().size()) {
                    orderService.processOrder(selectedMenu, orderNum);
                } else {
                    System.out.println("잘못된 주문번호입니다.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
