package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(MenuFactory.createMenus(), new Scanner(System.in));
        kiosk.start();

    }
}
