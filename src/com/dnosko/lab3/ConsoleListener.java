package com.dnosko.lab3;

import java.util.Map;
import java.util.Scanner;

public class ConsoleListener {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to know your age?");
            while (scanner.next().equals("yes")) {
                System.out.println("Input your birthYear");
                int birthYear = scanner.nextInt();

                System.out.println("Input your birthMonth");
                int birthMonth = scanner.nextInt();

                System.out.println("Input your birthDay");
                int birthDay = scanner.nextInt();

                Map<String, Number> ageData = AgeUtil.countAge(birthYear, birthMonth, birthDay);
                String ageInfo = AgeUtil.getInfo(ageData);
                System.out.println("Your age info: " + ageInfo);

                System.out.println("Do you want to know your age?");
            }
        }
    }
}
