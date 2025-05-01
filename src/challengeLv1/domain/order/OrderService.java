package challengeLv1.domain.order;

import challengeLv1.domain.cart.CartService;
import challengeLv1.domain.menu.Menu;
import challengeLv1.domain.menu.MenuItem;
import challengeLv1.exception.ExceptionHandler;
import challengeLv1.exception.InputException;

import java.util.Scanner;

/**
 * OrderService는 개별 주문 처리 로직을 담당합니다.
 */
public class OrderService {
    private final CartService cartService;  // 장바구니 서비스 (주문 시 장바구니에 담기 위해서)
    private final Scanner sc;

    public OrderService(CartService cartService, Scanner sc) {
        this.cartService = cartService;
        this.sc = sc;
    }

    // 사용자가 메뉴를 선택하면, 해당 항목을 장바구니에 담을지 묻고 처리합니다.
    public void processOrder(Menu menu, int orderNum) {
        MenuItem item = menu.getMenuItems().get(orderNum - 1);
        System.out.println(item.getFoodName() + "를 주문하였습니다. 가격은 " + item.getPrice() + "원 입니다.");
        System.out.println("메뉴 설명: " + item.getDescription());
        System.out.println();

        while (true) {
            try {
                // 장바구니에 추가할지 확인
                System.out.println(item.getFoodName() + "을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                System.out.print("입력: ");
                int confirm = ExceptionHandler.safeReadInt(sc);

                if (confirm == 1) {
                    // 수량 입력
                    while (true) {
                        try {
                            System.out.println(item.getFoodName() + "의 수량을 선택해주세요.");
                            System.out.print("수량 입력: ");
                            int quantity = ExceptionHandler.safeReadInt(sc);

                            cartService.addToCart(item, quantity);  // 장바구니에 추가
                            return; // 정상 주문 완료
                        } catch (InputException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (confirm == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.");
                    return; // 취소했으니까 메서드 종료
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 장바구니 목록을 보여주고 주문 최종 확인 처리
    public void showOrder(){
        cartService.showCart();  // 장바구니 목록 출력
        System.out.println();
        while (true) {
            try {
                System.out.println("아래와 같이 주문하시겠습니까?");
                System.out.println("1. 주문      2. 메뉴판으로 돌아가기");
                System.out.print("입력: ");
                int choice = ExceptionHandler.safeReadInt(sc);

                if (choice == 1) {
                    int totalPrice = cartService.calculateTotalPrice();
                    System.out.println("주문이 완료되었습니다. 결제 금액은 " + totalPrice + "원입니다.");
                    cartService.clearCart();  // 주문 완료 시 장바구니 비우기
                    return;
                } else if (choice == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.");
                    return;
                } else {
                    System.out.println("잘못된 입력입니다. 메뉴판으로 돌아갑니다.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
