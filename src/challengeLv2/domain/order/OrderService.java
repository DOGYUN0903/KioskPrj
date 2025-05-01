package challengeLv2.domain.order;

import challengeLv2.domain.cart.CartService;
import challengeLv2.domain.menu.Menu;
import challengeLv2.domain.menu.MenuItem;
import challengeLv2.enums.UserType;
import challengeLv2.exception.ExceptionHandler;
import challengeLv2.exception.InputException;

import java.util.Scanner;

/**
 * OrderService 클래스는 주문 처리 전반(메뉴 선택, 수량, 할인 선택, 결제)을 담당합니다.
 */
public class OrderService {
    private final CartService cartService; // 장바구니 서비스
    private final Scanner sc;

    public OrderService(CartService cartService, Scanner sc) {
        this.cartService = cartService;
        this.sc = sc;
    }

    // 사용자가 메뉴 항목을 선택한 후 장바구니에 추가할지 확인하고 수량을 받아 처리
    public void processOrder(Menu menu, int orderNum) {
        MenuItem item = menu.getMenuItems().get(orderNum - 1);

        showItemDetail(item);

        if (addToCart(item)) {
            chooseQuantity(item);
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

    // 선택된 메뉴 상세 정보 출력
    private void showItemDetail(MenuItem item) {
        System.out.println(item.getFoodName() + "를 주문하였습니다. 가격은 " + item.getPrice() + "원 입니다.");
        System.out.println("메뉴 설명: " + item.getDescription());
        System.out.println();
    }

    // 장바구니 추가 여부를 물어봄
    private boolean addToCart(MenuItem item) {
        while (true) {
            try {
                System.out.println(item.getFoodName() + "을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                System.out.print("입력: ");
                int confirm = ExceptionHandler.safeReadInt(sc);

                if (confirm == 1) {
                    return true;
                } else if (confirm == 2) {
                    return false;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 수량을 입력받아 장바구니에 추가
    private void chooseQuantity(MenuItem item) {
        while (true) {
            try {
                System.out.println(item.getFoodName() + "의 수량을 선택해주세요.");
                System.out.print("수량 입력: ");
                int quantity = ExceptionHandler.safeReadInt(sc);

                cartService.addToCart(item, quantity);
                return;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 장바구니를 출력하고 결제 여부와 할인 정보를 받아 최종 결제 처리
    public void showOrder() {
        cartService.showCart();
        System.out.println();

        int choice = askOrder();

        if (choice == 1) {
            UserType userType = selectDiscount();
            completeOrder(userType);
        } else if (choice == 2) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            System.out.println("잘못된 입력입니다. 메뉴판으로 돌아갑니다.");
        }
    }

    // 주문 여부 선택
    private int askOrder() {
        while (true) {
            try {
                System.out.println("아래와 같이 주문하시겠습니까?");
                System.out.println("1. 주문      2. 메뉴판으로 돌아가기");
                System.out.print("입력: ");
                int choice = ExceptionHandler.safeReadInt(sc);
                return choice;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 할인 정보 선택: UserType Enum을 통해 사용자 유형 선택
    private UserType selectDiscount() {
        while (true) {
            try {
                System.out.println("할인 정보를 입력해주세요:");
                for (int i = 0; i < UserType.values().length; i++) {
                    UserType type = UserType.values()[i];
                    System.out.println((i + 1) + ". " + type.getDiscountType() + " : " + type.getDiscountPercent() + "%");
                }
                System.out.print("입력: ");
                int inputDiscountInfo = ExceptionHandler.safeReadInt(sc);

                if (inputDiscountInfo >= 1 && inputDiscountInfo <= UserType.values().length) {
                    return UserType.values()[inputDiscountInfo - 1];
                } else {
                    System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 최종 결제 및 할인 적용
    private void completeOrder(UserType userType) {
        int totalPrice = cartService.calculateTotalPrice();
        int discountAmount = totalPrice * userType.getDiscountPercent() / 100;
        int finalPrice = totalPrice - discountAmount;

        System.out.println("할인 적용 완료 (" + userType.getDiscountType() + ")");
        System.out.println("최종 결제 금액: " + finalPrice + "원");
        System.out.println("주문이 완료되었습니다. 감사합니다!");

        cartService.clearCart();
    }
}
