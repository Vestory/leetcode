/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {
    /**
     * 99 / 99, 2ms(97.47%), 35MB(95.95%)
     */
    public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");
        char c;
        S = "aeiouAEIOU";
        for (int i = 0; i < len; ++i) {
            c = strs[i].charAt(0);
            if (S.indexOf(c) != -1) {
                res.append(strs[i]);
            } else {
                res.append(strs[i].substring(1));
                res.append(c);
            }
            res.append("ma");
            res.append(suffix);
            res.append(' ');
            suffix.append('a');
        }
        return res.substring(0, res.length() - 1).toString();
    }
}
// @lc code=end

