/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    /**
     * 5833 / 5833, 8ms(99.72%), 58.6MB(94.78%)
     */
    public int islandPerimeter(int[][] grid) {
        int land = 0, share = 0, len0 = grid.length, len1 = grid[0].length;
        for (int i = 0; i < len0; ++i) {
            for (int j = 0; j < len1; ++j) {
                if (grid[i][j] == 1) {
                    ++land;
                    if ((i > 0 && grid[i - 1][j] == 1)) {
                        ++share;
                    }
                    if ((j > 0 && grid[i][j - 1] == 1)) {
                        ++share;
                    }
                }
            }
        }
        return 4 * land - 2 * share;
    }

    /**
     * 其他解法
     * https://leetcode-cn.com/problems/island-perimeter/solution/chang-gui-jie-fa-javashi-xian-by-lyl0724-2/
     * https://leetcode-cn.com/problems/island-perimeter/solution/qiu-yi-ban-ji-ke-by-danvychan/
     */
}
// @lc code=end

