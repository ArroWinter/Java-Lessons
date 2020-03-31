package ru.sibsutis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Integer a, b, res = null;
        String op;

        try {
            a = sc.nextInt();
            op = sc.next();
            b = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input Error");
            return;
        }

        switch (op) {
            case ("+"):
                res = a + b;
                break;
            case ("-"):
                res = a - b;
                break;
            case ("*"):
                res = a * b;
                break;
            case ("/"):
                if (b != 0) {
                    res = a / b;
                } else {
                    System.out.println("You can't divide by 0");
                }
                break;
            case ("^"):
                res = 1;
                for (int i = 0; i < b; i++) {
                    res *= a;
                }
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }
        System.out.printf("%d %s %d = %d", a, op, b, res);
    }

}