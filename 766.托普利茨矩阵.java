/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    /**
     * 482 / 482, 1ms(100%), 39.7MB(97.81%)
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int len0 = matrix.length, len1 = matrix[0].length;
        if (len0 == 1 || len1 == 1) {
            return true;
        }
        for (int i = 1; i < len0; ++i) {
            for (int j = 1; j < len1; ++j) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

