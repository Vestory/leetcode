import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
    /**
     * 50 / 50, 5ms(74.91%), 33.6MB(94.38%)
     */
    // private int[] total = { 1, 2, 3, 3, 3, 4, 5, 5, 6, 7 };
    // private int[] mdiff = { 0, 0, 1, 1, 1, 2, 3, 3, 3, 4 };
    // private int[] msame = { 1, 2, 2, 2, 2, 2, 2, 2, 3, 3 };
    // private int[] input;
    // private int len;
    // public int rotatedDigits(int N) {
    //     if (N < 10) {
    //         return mdiff[N];
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     while (N > 0) {
    //         list.add(N % 10);
    //         N /= 10;
    //     }
    //     len = list.size();
    //     input = list.stream().mapToInt(Integer::valueOf).toArray();
    //     return itera(len - 1, false);
    // }

    // private int itera(int idx, boolean diff) {
    //     if (idx == -1) {
    //         return diff ? 1 : 0;
    //     }
    //     int max = input[idx];
    //     if (diff) {
    //         if (max > 0) {
    //             if (total[max] == total[max - 1]) {
    //                 return (int) Math.pow(7, idx) * total[max];
    //             } else {
    //                 return (int) Math.pow(7, idx) * total[max - 1] + itera(idx - 1, diff);
    //             }
    //         } else {
    //             return itera(idx - 1, diff);
    //         }
    //     } else {
    //         if (max > 1) {
    //             int count = 0;
    //             if (mdiff[max] == mdiff[max - 1]) {
    //                 count += (int) Math.pow(7, idx) * mdiff[max];
    //             } else {
    //                 count += itera(idx - 1, true) + (int) Math.pow(7, idx) * (mdiff[max] - 1);
    //             }
    //             if (msame[max] == msame[max - 1]) {
    //                 count += (int) (Math.pow(7, idx) - Math.pow(3, idx)) * msame[max];
    //             } else {
    //                 count += itera(idx - 1, diff) + (int) (Math.pow(7, idx) - Math.pow(3, idx)) * (msame[max] - 1);
    //             }
    //             return count;
    //         } else if (max == 1) {
    //             return itera(idx - 1, diff) + (int) (Math.pow(7, idx) - Math.pow(3, idx)) * (msame[max] - 1);
    //         } else {
    //             return itera(idx - 1, diff);
    //         }
    //     }
    // }

    /**
     * 官方解题
     * 暴力法
     * https://leetcode-cn.com/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode/
     * 50 / 50, 4ms(85.96%), 32.9MB(95.98%)
     */
    // public int rotatedDigits(int N) {
    //     // Count how many n in [1, N] are good.
    //     int ans = 0;
    //     for (int n = 1; n <= N; ++n)
    //         if (good(n, false))
    //             ans++;
    //     return ans;
    // }

    // // Return true if n is good.
    // // The flag is true iff we have an occurrence of 2, 5, 6, 9.
    // public boolean good(int n, boolean flag) {
    //     if (n == 0)
    //         return flag;

    //     int d = n % 10;
    //     if (d == 3 || d == 4 || d == 7)
    //         return false;
    //     if (d == 0 || d == 1 || d == 8)
    //         return good(n / 10, flag);
    //     return good(n / 10, true);
    // }

    /**
     * 官方解题
     * 动态规划
     * https://leetcode-cn.com/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode/
     * 50 / 50, 1ms(99.81%), 33MB(95.58%)
     */
    public int rotatedDigits(int N) {
        char[] A = String.valueOf(N).toCharArray();
        int K = A.length;
        int[][][] memo = new int[K + 1][2][2];
        memo[K][0][1] = memo[K][1][1] = 1;
        for (int i = K - 1; i >= 0; --i) {
            for (int eqf = 0; eqf <= 1; ++eqf) {
                for (int invf = 0; invf <= 1; ++invf) {
                    // We will compute ans = memo[i][eqf][invf],
                    // the number of good numbers with respect to N = A[i:].
                    // If eqf is true, we must stay below N, otherwise
                    // we can use any digits.
                    // Invf becomes true when we write a 2569, and it
                    // must be true by the end of our writing as all
                    // good numbers have a digit in 2569.
                    int ans = 0;
                    for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
                        if (d == '3' || d == '4' || d == '7')
                            continue;
                        boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                        ans += memo[i + 1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                    }
                    memo[i][eqf][invf] = ans;
                }
            }
        }
        return memo[0][1][0];
    }
}
// @lc code=end

