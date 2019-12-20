/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    /**
     * 23 / 23, 2ms(88.79%), 37.8MB(100%)
     */
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
            case 'a':
                ++counts[0];
                break;
            case 'b':
                ++counts[1];
                break;
            case 'l':
                ++counts[2];
                break;
            case 'n':
                ++counts[3];
                break;
            case 'o':
                ++counts[4];
                break;
            }
        }
        counts[2] /= 2;
        counts[4] /= 2;
        for (int i = 1; i < 5; ++i) {
            if (counts[i] < counts[0]) {
                counts[0] = counts[i];
            }
        }
        return counts[0];
    }
}
// @lc code=end
