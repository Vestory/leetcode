/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    /**
     * 看注释吧，分支到底 1079 / 1079, 4ms(90.78%), 35.6MB(89.70%)
     */
    // public int myAtoi(String str) {
    // // 排除空的字符串
    // if (str == null || str.length() == 0) {
    // return 0;
    // }
    // // 获取第一个遇到的数字子串
    // int l = 0, r = str.length() - 1;
    // boolean positive = true;
    // char c = str.charAt(l);
    // while (l < r) {
    // if (c == ' ') { // 跳过空格
    // c = str.charAt(++l);
    // } else if (Character.isDigit(c)) { // 遇到第一个数字，跳出循环
    // break;
    // } else if (c == '+' && Character.isDigit(str.charAt(l + 1))) { //
    // 遇到正号且下一个字符是数字
    // ++l;
    // break;
    // } else if (c == '-' && Character.isDigit(str.charAt(l + 1))) { //
    // 遇到负号且下一个字符是数字
    // ++l;
    // positive = false;
    // break;
    // } else { // 遇到了不是空格的其他符号，返回0
    // return 0;
    // }
    // }
    // if (!Character.isDigit(str.charAt(l))) { // 判断l处是不是数字，如果不是，则不是从合法分支跳出的，返回0
    // return 0;
    // }
    // while (l < str.length() && str.charAt(l) == '0') { // 跳过数字开头的所有0
    // ++l;
    // }
    // if (l == str.length() || !Character.isDigit(str.charAt(l))) { // 判断是不是跳过头了
    // return 0;
    // }
    // r = l + 1;
    // while (r < str.length() && Character.isDigit(str.charAt(r))) { // 寻找数字子串的结束位置
    // ++r;
    // }
    // --r; // r减一之后才是数字子串的最后一个字符
    // if (r - l > 9) { // 32位整数只有10位数字，超过10位数字直接返回最大或最小值即可
    // return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    // }
    // long res = 0; // 字符串转换成数字
    // while (l <= r) {
    // res *= 10;
    // res += (str.charAt(l++) - 48);
    // }
    // // 判断是否溢出
    // if (positive) {
    // if (res > Integer.MAX_VALUE) {
    // res = Integer.MAX_VALUE;
    // }
    // } else {
    // res = -res;
    // if (res < Integer.MIN_VALUE) {
    // res = Integer.MIN_VALUE;
    // }
    // }
    // return (int) res;
    // }

    /**
     * 这道题用了long（64位环境变量）
     * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-27/
     * 1079 / 1079, 3ms(96.81%), 36.1MB(84.89%)
     */
    // public int myAtoi(String str) {
    // if (str == null) {
    // return 0;
    // }
    // str = str.trim();
    // if (str.length() == 0) {
    // return 0;
    // }
    // char c = str.charAt(0);
    // int sign = 1;
    // int start = 0;
    // long res = 0;
    // if (c == '+') {
    // ++start;
    // } else if (c == '-') {
    // sign = -1;
    // ++start;
    // }
    // for (int i = start; i < str.length(); ++i) {
    // c = str.charAt(i);
    // if (!Character.isDigit(c)) {
    // return (int) res * sign;
    // }
    // res = res * 10 + c - 48;
    // if (sign == 1 && res > Integer.MAX_VALUE) {
    // return Integer.MAX_VALUE;
    // }
    // if (sign == -1 && res > Integer.MAX_VALUE) {
    // return Integer.MIN_VALUE;
    // }
    // }
    // return (int) res *sign;
    // }

    /**
     * 没有使用long（64位环境变量） 1079 / 1079, 2ms(99.94%), 36.3MB(83.89%)
     */
    public int myAtoi(String str) {
        if (str == null) { // 排除空串
            return 0;
        }
        str = str.trim(); // 去除开头的空格
        if (str.length() == 0) {
            return 0;
        }
        char c = str.charAt(0);
        int sign = 1;
        int i = 0;
        int res = 0;
        if (c == '+') { // 正
            ++i;
        } else if (c == '-') { // 负
            sign = -1;
            ++i;
        }
        int max = Integer.MAX_VALUE / 10;
        while (i < str.length()) {
            c = str.charAt(i);
            if (!Character.isDigit(c)) { // 不是数字
                return res * sign;
            }
            c -= 48; // 字符0对应着48，减去48就是0到9之间的值
            // 如果res大于max，再加一位就一定会超过Integer的界限
            // 如果res等于max，那么是正数时，下一位（c）大于7则越界，是负数时，下一位大于8则越界
            // 越界直接返回边界值
            if (res > max || (res == max && ((sign == 1 && c > 7) || (sign == -1 && c > 8)))) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            res = res * 10 + c;
            ++i;
        }
        return res * sign;
    }
}
// @lc code=end

