package challengeLv2.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {

    public static int safeReadInt(Scanner sc) {
        try {
            int input = sc.nextInt();
            sc.nextLine();
            return input;
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputException("숫자만 입력 가능합니다.");
        }
    }
}
