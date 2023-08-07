package util;

import java.util.Scanner;

public class InputUtil {
    public static int requiredIntInput(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }
    public static double requiredDoubleInput(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextDouble();
    }
    public static String requiredStringInput(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }
}
