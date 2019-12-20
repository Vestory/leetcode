/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution {
    /**
     * 190 / 190. 0ms(100%), 34.6MB(100%)
     */
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0] - points[1][0];
        int x2 = points[1][0] - points[2][0];
        if (x1 != 0) {
            if (x2 != 0) {
                return Math.abs((points[0][1] - points[1][1]) / (float)x1 - (points[1][1] - points[2][1]) / (float)x2) > 0.00001;
            } else {
                return points[1][1] != points[2][1];
            }
        }
        return points[0][1] != points[1][1] && x2 != 0;
    }

    /**
     * 向量是否共线
     * https://leetcode-cn.com/problems/valid-boomerang/solution/pan-duan-san-ge-dian-shi-fou-gong-xian-ke-yi-qu-li/
     */
}
// @lc code=end

