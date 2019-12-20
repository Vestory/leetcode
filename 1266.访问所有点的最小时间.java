/*
 * @lc app=leetcode.cn id=1266 lang=java
 *
 * [1266] 访问所有点的最小时间
 */

// @lc code=start
class Solution {
    /**
     * 122 / 122, 1ms(100%), 40.3MB(100%)
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int sec = 0, len = points.length;
        for (int i = 1; i < len; ++i) {
            sec += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return sec;
    }
}
// @lc code=end

