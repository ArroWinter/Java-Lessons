package ru.sibsutis;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] names = {"Anton", "Ivan", "Kirill", "Pavel", "Igor", "Fedor", "Dmitriy", "Maksim"};
        String[] departments = {"dev", "mod", "prod", "jun", "mid", "sen", "tst", "vis"};
        String[] numbers = {"03", "12", "26", "38", "49", "55", "77", "63"};

        Dev[] devs = new Dev[1000];
        for (int i = 0; i < devs.length; i++) {
            Dev tmp = new Dev(names[(int) (Math.random() * 7)], names[(int) (Math.random() * 7)] + "@gmail.com", departments[(int) (Math.random() * 7)]);
            devs[i] = tmp;
        }

        FileWriter fw = new FileWriter("developer.csv");
        fw.write("ID;Names;@mail;department\n");
        for (int i = 0; i < devs.length; i++) {
            fw.write(String.valueOf(i + 1) + ";" + devs[i].toCSV() + "\n");
        }
        fw.close();

        Manager[] managers = new Manager[1001];

        FileWriter fww = new FileWriter("manager.csv");
        fww.write("ID;Names;@mail;phone\n");
        for (int i = 0; i < managers.length; i++) {
            fww.write(String.valueOf(i+1) + ";" + names[(int) (Math.random() * 7)] + ";" + names[(int) (Math.random() * 7)] + "@gmail.com" + ";" + "+7" + numbers[(int) (Math.random() * 7)] + numbers[(int) (Math.random() * 7)] + numbers[(int) (Math.random() * 7)] + "\n");
        }
        fww.close();


        FileReader fr = new FileReader("manager.csv");
        Scanner in = new Scanner(fr);
        String str;
        for (int i = 0; i < managers.length; i++) {
            str = in.nextLine();
            Manager tmpp = new Manager(" ", " ", " ");
            managers[i] = tmpp;
            managers[i].fromCSV(str);
            System.out.println(str);
        }
    }
}