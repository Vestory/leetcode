/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    /**
     * 44 / 44, 1ms(89.57%), 37.8MB(100%)
     */
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        int len = indices.length;
        for (int i = 0; i < len; ++i) {
            row[indices[i][0]] = !row[indices[i][0]];
            col[indices[i][1]] = !col[indices[i][1]];
        }
        len = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if ((!row[i] && col[j]) || (row[i] && !col[j])) {
                    ++len;
                }
            }
        }
        return len;
    }
}
// @lc code=end

