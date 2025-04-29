package challengeLv2.domain.cart;

import challengeLv2.domain.menu.MenuItem;

public class CartItem {
    private final MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return menuItem.getFoodName();
    }

    public int getPrice() {
        return menuItem.getPrice();
    }

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
