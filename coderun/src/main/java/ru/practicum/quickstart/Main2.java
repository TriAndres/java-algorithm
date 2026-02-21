package ru.practicum.quickstart;

import java.io.*;

/*
2. Треугольник
 */
public class Main2 {
    public static void main(String[] args) {
        new Main2().game();
    }

    public void game() {
        System.out.println("Пример 1\n" +
                "Ввод\n" +
                "3 4 5\n" +
                "Вывод\n" +
                "YES\n" +
                "Пример 2\n" +
                "Ввод\n" +
                "3 5 4\n" +
                "Вывод\n" +
                "YES\n" +
                "Пример 3\n" +
                "Ввод\n" +
                "4 5 3\n" +
                "Вывод\n" +
                "YES");
        System.out.println("\nВвод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long a = getNum(reader);
            long b = getNum(reader);
            long c = getNum(reader);
            System.out.println("Вывод:");
            if (action(a,b,c)) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean action(long a, long b, long c) {
        return a + b > c && b + c > a && c + a > b;
    }

    private long getNum(BufferedReader reader) {
        long num;
        while (true) {
            try {
                num = Long.parseLong(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println();
            }
        }
        return num;
    }
}