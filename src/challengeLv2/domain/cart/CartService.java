package challengeLv2.domain.cart;

import challengeLv2.domain.menu.MenuItem;

import java.util.List;
import java.util.stream.IntStream;

public class CartService {
    private final Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    // 메뉴를 장바구니에 추가
    public void addToCart(MenuItem menuItem, int quantity) {
        // 기존에 있는 메뉴라면 수량만 증가
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getFoodName().equals(menuItem.getFoodName())) {
                cartItem.addQuantity(quantity); // 기존 수량 증가
                System.out.println(menuItem.getFoodName() + "의 수량이 " + cartItem.getQuantity() + "개로 변경되었습니다.");
                return;
            }
        }

        // 기존에 없는 메뉴 추가
        CartItem newItem = new CartItem(menuItem, quantity);
        cart.addItem(newItem);
        System.out.println(menuItem.getFoodName() + "가 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 출력
    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        System.out.println("[ 장바구니 목록 ]");
        List<CartItem> cartItems = cart.getCartItems();
        IntStream.range(0, cartItems.size())
                .forEach(i -> {
                    CartItem item = cartItems.get(i);
                    System.out.println((i + 1) + ". " + item.getFoodName() + " | " + item.getPrice() + "원 | 수량: " + item.getQuantity());
                });
        System.out.println("[ 총합계 ] " + cart.calculateTotalPrice() + "원");
    }

    // 장바구니 전체 비우기
    public void clearCart() {
        cart.clear();
        System.out.println("장바구니가 비워졌습니다.");
    }

    // 장바구니가 비어있는지 여부 반환
    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    // 장바구니에 있는 총 금액
    public int calculateTotalPrice() {
        return cart.calculateTotalPrice();
    }

    // 특정 상품 수량 감소
    public void decreaseItemQuantity(int index, int quantity) {
        List<CartItem> cartItems = cart.getCartItems();

        if (index < 0 || index >= cartItems.size()) {
            System.out.println("잘못된 상품 번호입니다.");
            return;
        }

        CartItem selectedItem = cartItems.get(index);
        if (selectedItem.getQuantity() <= quantity) {
            cartItems.remove(index);
            System.out.println(selectedItem.getFoodName() + "가 장바구니에서 삭제되었습니다.");
        } else {
            selectedItem.decreaseQuantity(quantity);
            System.out.println(selectedItem.getFoodName() + "의 수량이 " + selectedItem.getQuantity() + "개로 감소되었습니다.");
        }
    }

}
