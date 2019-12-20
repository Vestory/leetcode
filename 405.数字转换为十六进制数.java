/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    /**
     * 100 / 100, 1ms(76.22%), 33.7MB(95.56%)
     * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/405-shu-zi-zhuan-huan-wei-shi-liu-jin-zhi-shu-by-e/
     */
    public String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        String s = new String();
        while (num != 0) {
            int end = num & 15;
            s = hex[end] + s;
            num >>>= 4;
        }
        if (s.length() == 0) {
            s = "0";
        }
        return s;
    }
}
// @lc code=end
