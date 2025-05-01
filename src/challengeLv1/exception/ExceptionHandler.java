package challengeLv1.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ExceptionHandler는 사용자 입력을 정수로 안전하게 받기 위한 클래스입니다.
 */
public class ExceptionHandler {

    // 사용자의 입력을 안전하게 int로 변환하여 반환
    // - 숫자가 아닌 값을 입력하면 InputException을 던진다.
    public static int safeReadInt(Scanner sc) {
        try {
            int input = sc.nextInt();
            sc.nextLine();
            return input;
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputException("숫자만 입력 가능합니다."); // 예외 던지기
        }
    }
}
