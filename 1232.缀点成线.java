/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    /**
     * 66 / 66, 0ms(100%), 40.3MB(100%)
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if (coordinates[0][0] == coordinates[1][0]) {
            int x = coordinates[0][0];
            for (int i = 2; i < len; ++i) {
                if (coordinates[i][0] != x) {
                    return false;
                }
            }
        } else {
            double k = (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]);
            double b = coordinates[0][1] - k * coordinates[0][0];
            for (int i = 2; i < len; ++i) {
                if (Math.abs(k * coordinates[i][0] + b - coordinates[i][1]) > 0.000001) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

