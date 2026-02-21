package ru.practicum.quickstart;

import java.io.*;
/*
1. Юля, Никита и задачи
 */
public class Main1 {

    public static void main(String[] args) {
        new Main1().game();
    }

    private void game() {
        System.out.println("\nПример 1\nВвод\n1 1\nВывод\n2");
        System.out.println("\nПример 2\nВвод\n4 1\nВывод\n5");
        System.out.println("\nПример 3\nВвод\n1 3\nВывод\n4");
        System.out.println("\nВвод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long sum = 0;
            String[] parts;
            do {
                parts = reader.readLine().split("\\s+");
            } while (isNumberic(parts[0]) || isNumberic(parts[1]) || parts.length != 2);
            for (String part : parts) {
                long num = Long.parseLong(part);
                sum += num;
            }
            System.out.println("Вывод:");
            writer.write(String.valueOf(sum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNumberic(String str) {
        try {
            boolean d = Long.parseLong(str) > 0;
        } catch (NumberFormatException ee) {
            return true;
        }
        return false;
    }
}
