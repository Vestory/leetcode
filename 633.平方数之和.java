/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    /**
     * 超时
     */
    // public boolean judgeSquareSum(int c) {
    //     int sq = (int)(Math.sqrt(c)) + 1, temp;
    //     for (int i = 0; i < sq; ++i) {
    //         temp = i * i;
    //         for (int j = i; j < sq; ++j) {
    //             if (temp + j * j == c) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    /**
     * https://leetcode-cn.com/problems/sum-of-square-numbers/solution/shuang-zhi-zhen-ologn-shi-jian-fu-za-du-by-cyc2018/
     * 124 / 124, 3ms(80.17%), 32.9MB(82.19%)
     */
    public boolean judgeSquareSum(int target) {
        if (target < 0)
            return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
// @lc code=end

