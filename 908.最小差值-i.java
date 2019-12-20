/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    /**
     * 68 / 68, 1ms(100%), 38MB(93.66%)
     */
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = min, len = A.length;
        for (int i = 0; i < len; ++i) {
            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            }
        }
        max -= (min + 2 * K);
        return max < 0 ? 0 : max;
    }
}
// @lc code=end

