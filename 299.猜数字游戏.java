/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    /**
     * 152 / 152, 1ms(100%), 37.5MB(40.35%)
     */
    public String getHint(String secret, String guess) {
        int count = 0, len = secret.length();
        int[] nums = new int[10];
        int sc, gc;
        for (int i = 0; i < len; ++i) {
            sc = secret.charAt(i) - '0';
            gc = guess.charAt(i) - '0';
            if (sc == gc) {
                ++count;
            } else {
                ++nums[sc];
                --nums[gc];
            }
        }
        sc = 0;
        for (int i = 0; i < 10; ++i) {
            if (nums[i] > 0) {
                sc += nums[i];
            }
        }
        return count + "A" + (len - sc - count) + "B";
    }
}
// @lc code=end

