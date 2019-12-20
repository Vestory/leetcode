/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    /**
     * 550 / 550, 1ms(100%), 34.6MB(93.44%)
     */
    // public boolean detectCapitalUse(String word) {
    // if (word.length() < 2) {
    // return true;
    // }
    // boolean curr = Character.isUpperCase(word.charAt(0)), flag =
    // Character.isUpperCase(word.charAt(1));
    // if (flag != curr) {
    // if (flag) {
    // return false;
    // }
    // }
    // for (int i = 2; i < word.length(); ++i) {
    // curr = Character.isUpperCase(word.charAt(i));
    // if (curr != flag) {
    // return false;
    // }
    // }
    // return true;
    // }

    /**
     * 另一种思路
     * https://leetcode-cn.com/problems/detect-capital/solution/c-ji-jian-jie-fa-by-makeex/
     * 550 / 550, 2ms(72.49%), 34.8MB(93.17%)
     */
    // public boolean detectCapitalUse(String word) {
    // int count = 0;
    // for (int i = 0; i < word.length(); ++i) {
    // if (Character.isUpperCase(word.charAt(i)) && count++ < i) {
    // return false;
    // }
    // }
    // return count == word.length() || count <= 1;
    // }

    /**
     * 其他思路
     * https://leetcode-cn.com/problems/detect-capital/solution/javajian-ji-jie-fa-by-wang-zi-de-xin-yi/
     * 550 / 550, 1ms(100%), 34.7MB(93.17%)
     */
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int upper = 0;// 大写字母个数
        int lower = 0;// 小写字母个数
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' < 0) {
                upper++;
            } else {
                lower++;
            }
        }
        if (upper == chars.length || lower == chars.length || (upper == 1 && chars[0] < 'a')) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end
