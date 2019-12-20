import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */
class Solution {
    /**
     * 从尾部向前扫描，9之外的数字加一并返回，9则改为0并继续
     * 109 / 109, 0ms(100%), 35MB(39.71%)
     */
    // public int[] plusOne(int[] digits) {
    //     boolean finished = false;
    //     for (int i = digits.length - 1; i >= 0; --i) {
    //         if (digits[i] == 9) {
    //             digits[i] = 0;
    //         } else {
    //             ++digits[i];
    //             return digits;
    //         }
    //     }
    //     int[] result = Arrays.copyOf(digits, digits.length + 1);
    //     // int[] result = new int[digits.length + 1];
    //     result[0] = 1;
    //     return result;
    // }
}

