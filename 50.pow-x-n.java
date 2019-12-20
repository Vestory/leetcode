import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /**
     * 我的垃圾实现，一大堆分支
     * 304 / 304, 2ms(51.42%), 33.5MB(73.69%)
     */
    // public double myPow(double x, int n) {
    //     int extraIndex = 0;
    //     if (n < 0) {
    //         x = 1 / x;
    //         if (n == Integer.MIN_VALUE) {
    //             n = Integer.MAX_VALUE;
    //             extraIndex = 1;
    //         } else {
    //             n = -n;
    //         }
    //     }
    //     if (Math.abs(x - 1) < 0.000001 || n == 0) {
    //         return 1;
    //     } else if (Math.abs(x + 1) < 0.0000001) {
    //         if ((n % 2 + extraIndex) % 2 == 0) {
    //             return 1;
    //         }
    //         return -1;
    //     } else if (n == 1) {
    //         return x;
    //     } else if (Math.abs(x) < 1 && n > 100000000) {
    //         return 0;
    //     }
    //     HashMap<Integer, Double> map = new HashMap<>();
    //     int index = 2;
    //     int target = n / 2 + extraIndex;
    //     map.put(1, x);
    //     while (index <= target) {
    //         x *= x;
    //         map.put(index, x);
    //         index *= 2;
    //     }
    //     index /= 2;
    //     target = n - index;
    //     while (target > 0) {
    //         while (index > target) {
    //             index /= 2;
    //         }
    //         target -= index;
    //         x *= map.get(index);
    //     }
    //     return x;
    // }

    /**
     * 暴力法
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
     * 时间复杂度O(n), 空间复杂度O(1)
     * 超时
     */
    // public double myPow(double x, int n) {
    //     long index = n;
    //     if (index < 0) {
    //         x = 1 / x;
    //         index = -index;
    //     }
    //     double ans = 1;
    //     for (long i = 0; i < index; ++i) {
    //         ans *= x;
    //     }
    //     return ans;
    // }

    /**
     * 快速幂算法（递归）
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
     * 时间复杂度和空间复杂度均为O(lonn) 304 / 304, 1ms(99.82%), 33.7MB(73.39%)
     */
    // public double myPow(double x, int n) {
    //     long index = n;
    //     if (index < 0) {
    //         x = 1 / x;
    //         index = -index;
    //     }
    //     return fastPow(x, index);
    // }
    // private double fastPow(double x, long n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     double half = fastPow(x, n / 2);
    //     if (n % 2 == 0) {
    //         return half * half;
    //     } else {
    //         return half * half * x;
    //     }
    // }

    /**
     * 快速幂算法（迭代）
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
     * 时间复杂度O(logn)，空间复杂度O(1)
     * 304 / 304, 1ms(99.82%), 33.6MB(73.49%)
     */
    // public double myPow(double x, int n) {
    //     long index = n;
    //     if (index < 0) {
    //         x = 1 / x;
    //         index = -index;
    //     }
    //     double ans = 1;
    //     for (long i = index; i > 0; i /= 2) {
    //         if ((i % 2) == 1) {
    //             ans *= x;
    //         }
    //         x *= x;
    //     }
    //     return ans;
    // }

    /**
     * 没有使用long来处理溢出
     * https://leetcode-cn.com/problems/powx-n/solution/qing-xi-jian-dan-de-dan-han-shu-di-gui-wu-lei-xing/
     * 时间复杂度O(logn)
     * 304 / 304, 1ms(99.82%), 33.6MB(73.49%)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
}
// @lc code=end

