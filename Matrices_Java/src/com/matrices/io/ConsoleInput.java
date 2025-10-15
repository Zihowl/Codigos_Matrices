package com.matrices.io;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner SC = new Scanner(System.in);

    public static int getInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, intente de nuevo.");
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return SC.nextLine();
    }
}