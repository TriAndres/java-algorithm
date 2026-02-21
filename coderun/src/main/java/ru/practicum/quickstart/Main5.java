package ru.practicum.quickstart;

import java.io.*;

/*
5. 29 задача аналитики
 */
public class Main5 {
    public static void main(String[] args) {
        new Main5().game();
    }

    public void game() {
        System.out.println("Пример 1\n" +
                "Ввод\n" +
                "1 -2 1\n" +
                "Вывод\n" +
                "1\n" +
                "1.000000\n" +
                "Пример 2\n" +
                "Ввод\n" +
                "5 0 3 \n" +
                "Вывод\n" +
                "0\n" +
                "Пример 3\n" +
                "Ввод\n" +
                "6 -5 -8\n" +
                "Вывод\n" +
                "2\n" +
                "-0.810910 1.644243");
        System.out.println("\nВвод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input;
            do {
                input = reader.readLine().split(" ");
            } while (isNumeric(input[0]) || isNumeric(input[1]) || isNumeric(input[2]) || input.length != 3);

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            double D = b * b - 4 * a * c;

            System.out.println("Вывод:");
            if (D > 0) {
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);
                if (x1 > x2) {
                    double temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                writer.write("2\n");
                writer.write(String.format("%.6f %.6f\n", x1, x2));
            } else if (D == 0) {
                double x = -b / (2.0 * a);
                writer.write("1\n");
                writer.write(String.format("%.6f\n", x));
            } else {
                writer.write("0\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}