/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
class Solution {

    /**
     * 字符串，首尾比较是否相等
     * 11509 / 11509, 19ms(72.08%), 38.8MB(84.64%)
     */
    // public boolean isPalindrome(int x) {
    //     if (x < 0 || (x % 10 == 0 && x != 0)) {
    //         return false;
    //     }
    //     String str = Integer.toString(x);
    //     for (int i = 0; i < str.length(); ++i) {
    //         if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /**
     * 反转一半数字
     * 时间复杂度O(log10(n))，空间复杂度O(1)
     * 11509 / 11509, 12ms(97.36%), 37.9MB(85.97%)
     */
    public boolean isPalindrome(int x) {
        // 负数不满足条件
        // 若x可以被10整除，那么x必须为0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rec = 0;
        // 当x大于rec，则将x末尾数取出作为rec的末尾数
        while (x > rec) {
            rec = rec * 10 + x % 10;
            x /= 10;
        }
        // 偶位数：x == rec
        // 奇位数：x == rec / 10
        return x == rec || x == rec / 10;
    }
}

