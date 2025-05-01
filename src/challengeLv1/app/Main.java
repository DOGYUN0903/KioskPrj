package challengeLv1.app;


import challengeLv1.domain.menu.MenuFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(MenuFactory.createMenus(), new Scanner(System.in));

        // 키오스크 작동 시작
        kiosk.start();

    }
}
