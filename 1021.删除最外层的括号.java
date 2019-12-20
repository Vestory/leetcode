/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    /**
     * 59 / 59, 2ms(100%), 37.3MB(78.65%)
     */
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (++count != 1) {
                    sb.append(c);
                }
            } else {
                if (--count != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

