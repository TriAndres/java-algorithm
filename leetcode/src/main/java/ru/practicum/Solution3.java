package ru.practicum;
/*
1207. Unique Number of Occurrences

https://leetcode.com/problems/unique-number-of-occurrences/description/
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1,1,3};
        System.out.println("Входные данные: arr = [1,2,2,1,1,3]\nВыходные данные: " + uniqueOccurrences(arr1));
        System.out.println("Пояснение: Значение 1 встречается 3 раза, 2 — 2 раза, а 3 — 1 раз. " +
                "Нет двух значений, которые встречались бы одинаковое количество раз.");

        int[] arr2 = {1,2};
        System.out.println("\nВходные данные: arr = [1,2]\nВыходные данные: " + uniqueOccurrences(arr2));

        int[] arr3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println("\nВходные данные: arr = [-3,0,1,-3,1,1,1,-3,10,0]\nВыходные данные:" + uniqueOccurrences(arr3));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : arr) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (hashSet.contains(entry.getValue())) {
                return false;
            } else {
                hashSet.add(entry.getValue());
            }
        }
        return true;
    }
}
