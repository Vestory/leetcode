/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    /**
     * 位运算
     * https://leetcode-cn.com/problems/sum-of-two-integers/solution/wei-yun-suan-xiang-jie-yi-ji-zai-python-zhong-xu-y/
     * 13 / 13, 0ms(100%), 33.2MB(20.65%)
     */
    // public int getSum(int a, int b) {
    //     int res;
    //     while (b != 0) {
    //         res = (a & b) << 1;
    //         a = a ^ b;
    //         b = res;
    //     }
    //     return a;
    // }

    /**
     * 13 / 13, 0ms(100%), 33MB(20.81%)
     */
    public int getSum(int a, int b) {
        return a + b;
    }
}
// @lc code=end

