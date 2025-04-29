package challengeLv2.enums;

public enum UserType {
    NATIONAL_MERIT("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    NORMAL("일반", 0);

    private final String discountType;
    private final int discountPercent;

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
