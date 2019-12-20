/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    /**
     * 366 / 366, 2ms(99.04%), 51.6MB(89.03%)
     */
    public boolean isMonotonic(int[] A) {
        int len = A.length, last = 0, curr;
        for (int i = 1; i < len; ++i) {
            curr = A[i] - A[i - 1];
            if (last * curr < 0) {
                return false;
            } else {
                if (curr != 0) {
                    last = curr;
                }
            }
        }
        return true;
    }
}
// @lc code=end

