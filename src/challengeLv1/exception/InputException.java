package challengeLv1.exception;

/**
 * InputException은 잘못된 사용자 입력이 발생했을 때 사용하는 커스텀 런타임 예외입니다.
 */
public class InputException extends RuntimeException {
    public InputException(String message) {
        super(message);
    }
}
