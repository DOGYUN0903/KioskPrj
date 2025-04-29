package challengeLv2.app;

import challengeLv2.domain.menu.MenuFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(MenuFactory.createMenus(), new Scanner(System.in));
        kiosk.start();

    }
}
