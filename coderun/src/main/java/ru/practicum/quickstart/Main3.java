package ru.practicum.quickstart;

import java.io.*;

public class Main3 {
    public static void main(String[] args) {
        new Main3().game();
    }

    public void game() {
        System.out.println("Пример 1\n" +
                "Ввод\n" +
                "1 2 3 4 5\n" +
                "Вывод\n" +
                "0\n" +
                "Пример 2\n" +
                "Ввод\n" +
                "5 4 3 2 1\n" +
                "Вывод\n" +
                "0\n" +
                "Пример 3\n" +
                "Ввод\n" +
                "1 5 1 5 1\n" +
                "Вывод\n" +
                "2");
        System.out.println("\nВвод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = reader.readLine();
            String[] numbers = input.split(" ");
            int count = 0;
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    count++;
                }
            }
            System.out.println("Вывод:");
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
