/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    /**
     * 37 / 37, 0ms(100%), 38.5MB(100%)
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int len;
        if (start == destination) {
            return 0;
        } else if (start > destination) {
            len = start;
            start = destination;
            destination = len;
        }
        len = distance.length;
        int sum0 = 0, sum1 = 0, i = 0;
        while (i < start) {
            sum0 += distance[i];
            ++i;
        }
        while (i < destination) {
            sum1 += distance[i];
            ++i;
        }
        while (i < len) {
            sum0 += distance[i];
            ++i;
        }
        return sum0 < sum1 ? sum0 : sum1;
    }
}
// @lc code=end

