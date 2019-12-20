import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    /**
     * 89 / 89, 2ms(100%), 58.2MB(95.73%)
     */
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return trust.length == 0 ? 1 : -1;
        }
        int[] cnts = new int[N + 1];
        --N;
        int target = -1;
        for (int[] arr : trust) {
            if (++cnts[arr[1]] == N) {
                target = arr[1];
                break;
            }
        }
        for (int[] arr : trust) {
            if (arr[0] == target) {
                return -1;
            }
        }
        return target;
    }
}
// @lc code=end

