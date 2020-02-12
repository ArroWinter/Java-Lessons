package ru.sibsutis;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Simple Calculator");
        Scanner sc = new Scanner(System.in);
        double var = 0;
        System.out.println("Put x");
        double X = sc.nextDouble();
        System.out.println("Put operation");
        sc.nextLine();
        String O = sc.nextLine();
        System.out.println("Put y");
        double Y = sc.nextDouble();
        switch (O) {
            case "+":
                var = X + Y;
                break;
            case "-":
                var = X - Y;
                break;
            case "*":
                var = X * Y;
                break;
            case "/":
                if (Y == 0) {
                    System.out.println("Error /0");
                    break;
                } else {
                    var = X / Y;
                    break;
                }
            case "^":
                var = 1;
                for (int i = 0; i < Y; i++) {
                    var *= X;
                }
            default:
                System.out.println("Input Error");
        }
        System.out.println("Var = " + var);
    }

}