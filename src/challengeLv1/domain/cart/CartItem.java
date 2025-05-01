package challengeLv1.domain.cart;

import challengeLv1.domain.menu.MenuItem;

/**
 * CartItem은 장바구니에 담긴 개별 상품과 수량을 나타냅니다.
 */
public class CartItem {
    private final MenuItem menuItem;  // 담긴 메뉴 항목
    private int quantity;             // 수량

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // 음식 이름 반환
    public String getFoodName() {
        return menuItem.getFoodName();
    }

    // 개당 가격 반환
    public int getPrice() {
        return menuItem.getPrice();
    }

    // 수량 반환
    public int getQuantity() {
        return quantity;
    }

    // 수량 증가
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    // 장바구니 수량 감소
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
