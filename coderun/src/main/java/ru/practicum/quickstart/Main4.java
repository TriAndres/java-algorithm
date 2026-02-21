package ru.practicum.quickstart;

import java.io.*;

public class Main4 {
    public static void main(String[] args) {
        new Main4().game();
    }

    public void game() {
        System.out.println("Пример 1\n" +
                "Ввод\n" +
                "32\n" +
                "Вывод\n" +
                "5702886\n" +
                "Пример 2\n" +
                "Ввод\n" +
                "21\n" +
                "Вывод\n" +
                "28656\n" +
                "Пример 3\n" +
                "Ввод\n" +
                "33\n" +
                "Вывод\n" +
                "9227464");
        System.out.println("\nВвод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n;
            while (true) {
                String line = reader.readLine();
                if (!isNumeric(line)) {
                    n = Integer.parseInt(line);
                    if (n > 0) break;
                }
            }
            int[] t = new int[n + 1];
            t[1] = 1;
            if (n >= 2) {
                t[2] = 1;
            }
            for (int i = 3; i <= n; i++) {
                t[i] = t[i - 1] + t[i - 2];
            }
            int totalTags = 0;
            for (int i = 1; i <= n; i++) {
                totalTags += t[i];
            }
            System.out.println("Вывод:");
            writer.write(String.valueOf(totalTags));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
