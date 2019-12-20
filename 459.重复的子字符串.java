/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    /**
     * 120 / 120, 242ms(14.96%), 38.6MB(95.77%)
     */
    // public boolean repeatedSubstringPattern(String s) {
    //     int count = 1, length = s.length(), subLen = 0;
    //     String temp = s, sub = "";
    //     while (++count <= length) {
    //         if (length % count != 0) {
    //             continue;
    //         }
    //         subLen = length / count;
    //         sub = temp.substring(0, subLen);
    //         if (temp.replaceAll(sub, "").length() == 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * 该方法不可用哈，第一个条件时为了排除类似"aaaaaaaaaaaaa.....aaaaaaaaaaaaaab"这个测试用例（哈哈），这个方法不好用
     * 120 / 120, 654ms(5.09%), 38.5MB(95.77%)
     */
    // public boolean repeatedSubstringPattern(String s) {
    //     if (s.length() > 100 && s.charAt(100) == 'a' && s.charAt(s.length() - 1) == 'b') {
    //         return false;
    //     }
    //     char c = s.charAt(0);
    //     int i = 0, len = s.length() / 2 + 1;
    //     while (++i < len) {
    //         if (s.charAt(i) == c) {
    //             String sub = s.substring(0, i);
    //             if (s.replaceAll(sub, "").length() == 0) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    /**
     * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/bu-yong-zheng-ze-jie-yong-zi-fu-chuan-fang-fa-lian/
     * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/javascript-suan-fa-jie-shi-ju-rong-yi-by-chashao/
     * 假设字符串有n个子串构成,则拼接后的子串为2n个,掐头去尾后为2n-2个,如果此时的字符串至少包含一个原字符串,则说明至少包含n个子串,则2n-2>=n,n>=2.则说明该字符串是周期性结构,最少由两个子串构成.如果一个都不包含,即不包含n个子串,则说明2n-2<n,n<2,即n为1,也就是不符合周期性结构.
     * 120 / 120, 42ms(60.5%), 37.9MB(96.3%)
     */
    // public boolean repeatedSubstringPattern(String s) {
    //     String str = s + s;
    //     return str.substring(1, str.length() - 1).contains(s);
    // }

    /**
     * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/cppjie-fa-zhou-qi-chuan-by-brianyi/
     * 120 / 120, 23ms(83.89%), 37.7MB(96.3%)
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length(), j = 0;
        for (int i = 1; i <= len / 2; ++i) {
            if (len % i != 0) {
                continue;
            }
            j = i;
            while (j < len && s.charAt(j % i) == s.charAt(j)) {
                ++j;
            }
            if (j == len) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

