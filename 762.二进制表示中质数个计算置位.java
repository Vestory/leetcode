/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/solution/javachao-yue-99de-jian-dan-xie-fa-by-flychenkai/
     * 200 / 200, 2ms(100%), 33.2MB(72.06%)
     */
    public int countPrimeSetBits(int L, int R) {
        // 0-20的质数列表，prime[i]为1，则i为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }
}
// @lc code=end

