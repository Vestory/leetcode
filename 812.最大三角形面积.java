/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
    /**
     * 57 / 57, 3ms(100%), 34.4MB(91.75%)
     */
    private int[][] mps;
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        mps = points;
        if (len < 3) {
            return 0;
        } else if (len == 3) {
            return getArea(0, 1, 2);
        }
        double max = 0, temp;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j + 1; k < len; ++k) {
                    temp = getArea(i, j, k);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }
    private double getArea(int i, int j, int k) {
        return Math.abs((mps[i][0] * mps[j][1] + mps[j][0] * mps[k][1] + mps[k][0] * mps[i][1] - mps[i][0] * mps[k][1]
                - mps[j][0] * mps[i][1] - mps[k][0] * mps[j][1]) * 0.5);
    }
}
// @lc code=end

