/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    /**
     * 90 / 90, 1ms(100%), 41.1MB(51.52%)
     */
    public int projectionArea(int[][] grid) {
        int res = 0, len0 = grid.length, len1 = grid[0].length, yz, temp;
        int[] xz = grid[0];
        for (int i = 0; i < len0; ++i) {
            yz = grid[i][0];
            for (int j = 0; j < len1; ++j) {
                temp = grid[i][j];
                if (temp != 0) {
                    ++res;
                    if (temp > yz) {
                        yz = temp;
                    }
                    if (temp > xz[j]) {
                        xz[j] = temp;
                    }
                }
            }
            res += yz;
        }
        for (int i = 0; i < len1; ++i) {
            res += xz[i];
        }
        return res;
    }
}
// @lc code=end

