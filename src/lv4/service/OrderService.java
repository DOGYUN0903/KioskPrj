package lv4.service;

import lv4.Menu;
import lv4.MenuItem;

public class OrderService {

    public void processOrder(Menu menu, int orderNum) {
        MenuItem item = menu.getMenuItems().get(orderNum - 1);
        System.out.println(item.getFoodName() + "를 주문하였습니다. 가격은 " + item.getPrice() + "원 입니다.");
        System.out.println("메뉴 설명: " + item.getDescription());
    }
}
