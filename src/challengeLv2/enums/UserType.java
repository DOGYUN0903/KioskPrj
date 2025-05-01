package challengeLv2.enums;

/**
 * UserType은 할인 대상 사용자 유형과 해당 할인율을 정의합니다.
 */
public enum UserType {
    NATIONAL_MERIT("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    NORMAL("일반", 0);

    private final String discountType;  // 사용자 유형 이름
    private final int discountPercent;  // 할인율

    UserType(String discountType, int discountPercent) {
        this.discountType = discountType;
        this.discountPercent = discountPercent;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
