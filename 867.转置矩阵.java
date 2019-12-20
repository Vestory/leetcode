/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    /**
     * 36 / 36, 1ms(95.04%), 38.3MB(95.72%)
     */
    public int[][] transpose(int[][] A) {
        int len0 = A.length, len1 = A[0].length;
        if (len0 == len1) {
            int temp;
            for (int i = 0; i < len0; ++i) {
                for (int j = i + 1; j < len1; ++j) {
                    temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
            }
            return A;
        } else {
            int[][] res = new int[len1][len0];
            for (int i = 0; i < len0; ++i) {
                for (int j = 0; j < len1; ++j) {
                    res[j][i] = A[i][j];
                }
            }
            return res;
        }
    }
}
// @lc code=end

