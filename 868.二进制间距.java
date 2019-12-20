/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    /**
     * 260 / 260, 1ms(100%), 33MB(71.2%)
     */
    public int binaryGap(int N) {
        int max = 0, curr = -1;
        while (N > 0) {
            if (N % 2 == 1) {
                if (curr == -1) {
                    curr = 1;
                } else {
                    if (curr > max) {
                        max = curr;
                    }
                    curr = 1;
                }
            } else {
                if (curr != -1) {
                    ++curr;
                }
            }
            N /= 2;
        }
        return max;
    }
}
// @lc code=end

