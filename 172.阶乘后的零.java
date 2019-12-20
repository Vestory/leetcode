/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */
class Solution {
    /**
     * 求5的个数
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/tong-guo-guan-cha-chan-sheng-ling-de-tiao-jian-er-/
     * 502 / 502, 1ms(99.77%), 33.2MB(80.14%)
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += (n / 5);
            n /= 5;
        }
        return count;
    }
}

