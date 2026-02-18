package ru.practicum;
/*
1004. Max Consecutive Ones |||

https://leetcode.com/problems/max-consecutive-ones-iii/
 */
class Solution2 {
    public static void main(String[] args) {
        System.out.println("\nExample 1:\n" +
                "Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2\n" +
                "Output: 6\n" +
                "Explanation: [1,1,1,0,0,1,1,1,1,1,1]\n" +
                "Числа, выделенные жирным шрифтом, были изменены с 0 на 1.\n" +
                " Самый длинный подмассив подчеркнут.");
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println("-> " + longestOnes(nums1, k1));


        System.out.println("\nExample 2:\n" +
                "Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3\n" +
                "Output: 10\n" +
                "Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]\n" +
                "Числа, выделенные жирным шрифтом, были изменены с 0 на 1.\n" +
                " Самый длинный подмассив подчеркнут.");
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println("-> " + longestOnes(nums2, k2));
    }

    public static int longestOnes(int[] nums, int k) {
        int num1;
        int num0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            num1 = 0;
            num0 = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) num1++;
                if (nums[j] == 0) {
                    num0++;
                    if (num0 > k) {
                        --num0;
                        break;
                    }
                }
            }
            num1 += num0;

            if (max < num1) {
                max = num1;
            }
        }
        return max;
    }
}