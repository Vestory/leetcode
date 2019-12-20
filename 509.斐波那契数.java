/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    /**
     * 迭代
     * 31 / 31, 0ms(100%), 33MB(64.46%)
     */
    // public int fib(int N) {
    //     if (N < 2) {
    //         return N;
    //     }
    //     int n0 = 0, n1 = 1, temp = 0;
    //     for (int i = 2; i <= N; ++i) {
    //         temp = n1;
    //         n1 += n0;
    //         n0 = temp;
    //     }
    //     return n1;
    // }

    /**
     * 递归
     * 31 / 31, 13ms(23.21%), 32.8MB(71.07%)
     */
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        return fib(N - 2) + fib(N - 1);
    }

    // 强烈建议看看这个
    // 讲了递归、带记忆的递归、动态规划等
    // https://leetcode-cn.com/problems/fibonacci-number/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-labuladong/
}
// @lc code=end

