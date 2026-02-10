package ru.practicum;
//933. Number of Recent Calls
//У вас есть RecentCounter класс, который подсчитывает количество недавних запросов за определенный период времени.
//
//Реализуйте RecentCounter класс:
//
//RecentCounter()Инициализирует счетчик нулевым количеством последних запросов.
//int ping(int t) Добавляет новый запрос в момент времени t, где t — время в миллисекундах, и возвращает количество
// запросов, поступивших за последние 3000 миллисекунд (включая новый запрос). В частности, возвращает количество
// запросов, поступивших в диапазоне [t - 3000, t].
//Гарантируется, что при каждом вызове ping используется строго большее значениеt, чем при предыдущем вызове.
//
//
//
//Пример 1:
//
//Input
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//Output
//[null, 1, 2, 3, 3]
//
//Explanation
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1); // запросы = [1], диапазон равен [-2999,1], возвращает 1
//recentCounter.ping(100); // запросы = [1, 100], диапазон равен [-2900,100], возврат 2
//recentCounter.ping(3001); // запросы = [1, 100, 3001], диапазон равен [1,3001], возврат 3
//recentCounter.ping(3002); // запросы = [1, 100, 3001, 3002], диапазон равен [23002], возврат 3
//
//
//Ограничения:
//
//1 <= t <= 10^9
//В каждом тестовом примере будет вызываться ping с строго возрастающими значениями t.
//Будет сделано не более 104 вызовов ping.

import java.util.ArrayDeque;

class RecentCounter {
    private final int INTERVAL;
    private int sum;
    private final ArrayDeque<Integer> self;

    public RecentCounter() {
        sum = 0;
        self = new ArrayDeque<>();
        INTERVAL = 3000;
    }

    public int ping(int t) {
        if (t < INTERVAL) {
            self.addLast(t);
            sum += self.getLast();
            while (sum > INTERVAL) {
                sum -= self.getFirst();
                self.removeFirst();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println("\nsum=" + r.ping(1000));
        for (Integer i : r.self) {
            System.out.print("pin=" + i + " ");
        }
        System.out.println("\nsum=" + r.ping(500));
        for (Integer i : r.self) {
            System.out.print("pin=" + i + " ");
        }
        System.out.println("\nsum=" + r.ping(700));
        for (Integer i : r.self) {
            System.out.print("pin=" + i + " ");
        }
        System.out.println("\nsum=" + r.ping(1000));
        for (Integer i : r.self) {
            System.out.print("pin=" + i + " ");
        }
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */