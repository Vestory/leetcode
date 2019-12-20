/*
 * @lc app=leetcode.cn id=1281 lang=java
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start
class Solution {
    /**
     * 123 / 123, 0ms(100%), 32.9MB(100%)
     */
    public int subtractProductAndSum(int n) {
        int mul = 1, sum = 0, temp;
        while (n > 0) {
            temp = n % 10;
            mul *= temp;
            sum += temp;
            n /= 10;
        }
        return mul - sum;
    }
}
// @lc code=end

