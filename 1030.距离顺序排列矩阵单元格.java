/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
class Solution {
    /**
     * 66 / 66, 5ms(97.87%), 39MB(100%)
     */
    private int[][] res;
    private int i = 0;
    private int r;
    private int c;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        res = new int[R * C][2];
        r = r0;
        c = c0;
        add();
        int max = Math.max(Math.max(Math.max(r0 + c0, R - r0 - 1 + c0), r0 + C - c0 - 1), R - r0 + C - c0 - 2) + 1,
                x = 1, y = 0;
        while (x < max) {
            r = r0 + x;
            c = c0;
            if (r < R) {
                add();
            }
            r = r0 - x;
            if (r > -1) {
                add();
            }
            r = r0;
            c = c0 + x;
            if (c < C) {
                add();
            }
            c = c0 - x;
            if (c > -1) {
                add();
            }
            --x;
            ++y;
            while (x > 0) {
                c = c0 + y;
                if (c < C) {
                    r = r0 + x;
                    if (r < R) {
                        add();
                    }
                    r = r0 - x;
                    if (r > -1) {
                        add();
                    }
                }
                c = c0 - y;
                if (c > -1) {
                    r = r0 - x;
                    if (r > -1) {
                        add();
                    }
                    r = r0 + x;
                    if (r < R) {
                        add();
                    }
                }
                --x;
                ++y;
            }
            x = y + 1;
            y = 0;
        }
        return res;
    }
    private void add() {
        res[i][0] = r;
        res[i][1] = c;
        ++i;
    }
}
// @lc code=end

