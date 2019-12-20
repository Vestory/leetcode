/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    /**
     * 32 / 32, 0ms(100%), 37.9MB(95.64%)
     */
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length - 1;
        for (int i = 1; i < len; ++i) {
            if (A[i + 1] < A[i]) {
                return i;
            }
        }
        return 1;
    }
}
// @lc code=end

