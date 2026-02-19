package ru.practicum.general;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1. Средний элемент
 */
public class Main1 {

    public static void main(String[] args) {

        System.out.println("Пример 1\nВвод\n1 2 3\nВывод\n2");
        System.out.println("\nПример 2\nВвод\n1000 -1000 0\nВывод\n0");
        System.out.println("\nПример 3\nВвод\n3 1 3\nВывод\n3");

        System.out.println("Ввод:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){

            String[] nums = reader.readLine().split(" +");
            List<Integer> list = new ArrayList<>();
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (n >= -1000 && n <= 1000) {
                    list.add(n);
                }
            }
            Collections.sort(list);
            System.out.println("\nВывод:");
            writer.write(String.valueOf(list.get(1)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}