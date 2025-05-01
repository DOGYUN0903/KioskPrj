package challengeLv2.exception;

/**
 * ExceptionHandler는 사용자 입력을 정수로 안전하게 받기 위한 클래스입니다.
 */
public class InputException extends RuntimeException {

    /**
     * 사용자의 입력을 안전하게 int로 변환하여 반환
     * 숫자가 아닌 값을 입력하면 InputException을 던진다.
     */
    public InputException(String message) {
        super(message);
    }
}
