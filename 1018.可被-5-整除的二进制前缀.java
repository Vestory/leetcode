import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
class Solution {
    /**
     * 24 / 24, 4ms(97.05%), 38.2MB(98.21%)
     */
    // public List<Boolean> prefixesDivBy5(int[] A) {
    //     int left = A[0], len = A.length;
    //     List<Boolean> res = new ArrayList<>();
    //     res.add(left == 0);
    //     for (int i = 1; i < len; ++i) {
    //         left *= 2;
    //         if (A[i] == 1) {
    //             ++left;
    //         }
    //         left %= 5;
    //         res.add(left == 0);
    //     }
    //     return res;
    // }

    /**
     * 24 / 24, 4ms(97.05%), 38.8MB(95.54%)
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        int left = A[0], len = A.length;
        List<Boolean> res = new ArrayList<>();
        res.add(left == 0);
        for (int i = 1; i < len; ++i) {
            left *= 2;
            if (A[i] == 1) {
                ++left;
            }
            if (left >= 5) {
                left -= 5;
            }
            res.add(left == 0);
        }
        return res;
    }
}
// @lc code=end

