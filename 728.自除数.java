import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * 31 / 31, 2ms(99.81%), 33.8MB(78.04%)
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while (left <= right) {
            if (sdn(left)) {
                res.add(left);
            }
            ++left;
        }
        return res;
    }
    private boolean sdn(int val) {
        int i = val, j = 0;
        while (i > 0) {
            j = i % 10;
            if (j == 0 || val % j != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
// @lc code=end

