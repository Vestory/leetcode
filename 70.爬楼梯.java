/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */
class Solution {
    /**
     * 递归法，反向操作，从到了终点开始回退，每次回退1和2步，计算有效的路径
     * 时间复杂度O(2 ^ n), 空间复杂度O(n)
     * 耗时太长了，超出时间限制
     */
    // public int climbStairs(int n) {
    //     if (n > 0) {
    //         return climbStairs(n - 2) + climbStairs(n - 1);
    //     } else if (n == 0) {
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }

    // #region [0] 官方解题
    // https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
    /**
     * 暴力法
     * 超时
     * 时间复杂度O(2 ^ n), 空间复杂度O(n)
     */
    // public int climbStairs(int n) {
    //     return climb_Stairs(0, n);
    // }
    // private int climb_Stairs(int i, int n) {
    //     if (i > n) {
    //         return 0;
    //     }
    //     if (i == n) {
    //         return 1;
    //     }
    //     return climb_Stairs(i + 1, ) + climb_Stairs(i + 2, n);
    // }

    /**
     * 记忆化递归
     * 时间复杂度和空间复杂度均为O(n)
     * 45 / 45, 0ms(100%), 32.9MB(73.38%)
     */
    // public int climbStairs(int n) {
    //     int[] memo = new int[n + 1];
    //     return cs(0, n, memo);
    // }
    // private int cs(int i, int n, int[] memo) {
    //     if (i > n) {
    //         return 0;
    //     }
    //     if (i == n) {
    //         return 1;
    //     }
    //     if (memo[i] > 0) {
    //         return memo[i];
    //     }
    //     memo[i] = cs(i + 1, n, memo) + cs(i + 2, n, memo);
    //     return memo[i];
    // }

    /**
     * 动态规划
     * 时间复杂度和空间复杂度均为O(n)
     * 45 / 45, 0ms(100%), 33MB(72.53%)
     */
    // public int climbStairs(int n) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     int[] dp = new int[n + 1];
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for (int i = 3; i <= n; ++i) {
    //         dp[i] = dp[i - 1] + dp[i - 2];
    //     }
    //     return dp[n];
    // }

    /**
     * 动态规划，时间换空间
     * 45 / 45, 0ms(100%), 32.6MB(77.79%)
     */
    // public int climbStairs(int n) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     int[] dp = new int[3];
    //     dp[0] = 1;
    //     dp[1] = 2;
    //     int i = 2;
    //     while (i < n) {
    //         dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
    //         ++i;
    //     }
    //     return dp[(i - 1) % 3];
    // }

    /**
     * 斐波那契数列
     * 时间复杂度O(n)，空间复杂度O(1)
     * 45 / 45, 0ms(100%), 33MB(72.47%)
     */
    // public int climbStairs(int n) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     int first = 1;
    //     int second = 2;
    //     for (int i = 3; i <= n; ++i) {
    //         int third = first + second;
    //         first = second;
    //         second = third;
    //     }
    //     return second;
    // }

    /**
     * Binets方法
     * 时间复杂度O(logn)，空间复杂度O(1)
     * 45 / 45, 0ms(100%), 33MB(72.95%)
     */
    // public int climbStairs(int n) {
    //     int[][] q = {{1,1}, {1, 0}};
    //     int[][] res = pow(q, n);
    //     return res[0][0];
    // }
    // private int[][] pow(int[][] a, int n) {
    //     int[][] res = {{1, 0}, {0, 1}};
    //     while (n > 0) {
    //         if ((n & 1) == 1) {
    //             res = multiply(res, a);
    //         }
    //         n >>= 1;
    //         a = multiply(a, a);
    //     }
    //     return res;
    // }
    // private int[][] multiply(int[][] a, int[][] b) {
    //     int[][] c = new int[2][2];
    //     for (int i = 0; i < 2; ++i) {
    //         for (int j = 0; j < 2; ++j) {
    //             c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
    //         }
    //     }
    //     return c;
    // }

    /**
     * 斐波那契公式
     * 时间复杂度O(logn), 空间复杂度O(1)
     * 45 / 45, 0ms(100%), 33.1MB(72.24%)
     */
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }
    // #endregion
}
