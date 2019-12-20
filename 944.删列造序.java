/*
 * @lc app=leetcode.cn id=944 lang=java
 *
 * [944] 删列造序
 */

// @lc code=start
class Solution {
    /**
     * 84 / 84, 8ms(96.29%), 37.6MB(94.98%)
     */
    public int minDeletionSize(String[] A) {
        int len0 = A.length, len1 = A[0].length();
        char[][] matrix = new char[len0][];
        for (int i = 0; i < len0; ++i) {
            matrix[i] = A[i].toCharArray();
        }
        int res = 0;
        for (int i = 0; i < len1; ++i) {
            for (int j = 1; j < len0; ++j) {
                if (matrix[j][i] < matrix[j - 1][i]) {
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

