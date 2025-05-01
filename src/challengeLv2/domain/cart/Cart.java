package challengeLv2.domain.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart 클래스는 장바구니 항목들을 관리합니다.
 */
public class Cart {

    private List<CartItem> cartItems; // 장바구니 항목 리스트

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // 장바구니에 항목 추가
    public void addItem(CartItem item) {
        cartItems.add(item);
    }

    // 장바구니 항목 리스트 반환
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // 장바구니 비우기
    public void clear() {
        cartItems.clear();
    }

    // 장바구니 비어있는지 확인
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // 장바구니 총합 금액 계산
    public int calculateTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
