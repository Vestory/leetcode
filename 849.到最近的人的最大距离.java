/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
    /**
     * 79 / 79, 2ms(99.53%), 39.1MB(92.19%)
     */
    public int maxDistToClosest(int[] seats) {
        int l = 0, r, len = seats.length, max = 0, temp;
        while (l < len) {
            if (seats[l] == 1) {
                max = l;
                break;
            }
            ++l;
        }
        r = l + 1;
        while (r < len) {
            if (seats[r] == 1) {
                temp = (r - l) / 2;
                l = r;
                if (max < temp) {
                    max = temp;
                }
            }
            ++r;
        }
        if (l != len - 1) {
            temp = r - l - 1;
            return max < temp ? temp : max;
        }
        return max;
    }
}
// @lc code=end

