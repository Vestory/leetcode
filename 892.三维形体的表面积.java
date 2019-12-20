/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    /**
     * 90 / 90, 3ms(98.11%), 41.4MB(51.85%)
     */
    public int surfaceArea(int[][] grid) {
        int res = 0, near = 0, len0 = grid.length, len1 = grid[0].length, temp;
        for (int i = 0; i < len0; ++i) {
            for (int j = 0; j < len1; ++j) {
                temp = grid[i][j];
                if (temp > 0) {
                    near += temp - 1;
                    res += temp;
                    if (i + 1 < len0 && grid[i + 1][j] != 0) {
                        near += Math.min(temp, grid[i + 1][j]);
                    }
                    if (j + 1 < len1 && grid[i][j + 1] != 0) {
                        near += Math.min(temp, grid[i][j + 1]);
                    }
                }
            }
        }
        return res * 6 - near * 2;
    }
}
// @lc code=end

