/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    /**
     * 43 / 43, 0ms(100%), 34.1MB(88.54%)
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[0] < rec1[2] && rec2[1] < rec1[3] && rec2[2] > rec1[0] && rec2[3] > rec1[1]) {
            return true;
        }
        return false;
    }
}
// @lc code=end

