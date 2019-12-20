/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    /**
     * 超时
     */
    // public int tribonacci(int n) {
    //     if (n < 2) {
    //         return n;
    //     } else if (n == 2) {
    //         return 1;
    //     } else {
    //         return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    //     }
    // }

    /**
     * 避免递归的重复计算
     * 39 / 39, 0ms(100%), 33MB(100%)
     */
    public int tribonacci(int n) {
        int[] arr = new int[38];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; ++i) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
    /**
     * 其他解法，如矩阵求解等等
     * https://leetcode-cn.com/problems/n-th-tribonacci-number/solution/1-xian-xing-fa-on-2-ju-zhen-fa-ologn-by-nickmeepo/
     * 有趣的解法
     * https://leetcode-cn.com/problems/n-th-tribonacci-number/solution/o1-huan-yao-sha-zi-xing-che-a-by-ldeng7/
     */
}
// @lc code=end

