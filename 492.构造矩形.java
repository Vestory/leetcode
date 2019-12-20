/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    /**
     * 50 / 50, 1ms(86%), 33.7MB(77.91%)
     */
    public int[] constructRectangle(int area) {
        int x = (int)(Math.sqrt(area));
        while (area % x != 0) {
            --x;
        }
        return new int[] {area / x, x};
    }
}
// @lc code=end

