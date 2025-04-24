package lv2;

public class MenuItem {
    private String foodName; // 음식 이름
    private int price; // 음식 가격
    private String description; // 음식 설명

    // 처음에 객체를 초기화 할 때 값을 가져오려고 생성자 생성
    public MenuItem(String foodName, int price, String description) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
    }

    // 음식 이름 가져오기
    public String getFoodName() {
        return foodName;
    }

    // 음식 가격 가져오기
    public int getPrice() {
        return price;
    }

    // 음식 설명 가져오기
    public String getDescription() {
        return description;
    }
}
