/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    // https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc/
    // 1101 / 1101, 2ms(90.14%), 33.5MB(13.88%)
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
// @lc code=end

