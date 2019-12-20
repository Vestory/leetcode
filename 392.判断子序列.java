/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    /**
     * 递归
     * 14 / 14, 19ms(62.57%), 48.7MB(95.23%)
     */
    // public boolean isSubsequence(String s, String t) {
    //     if (s.length() == 0) {
    //         return true;
    //     }
    //     if (t.length() == 0) {
    //         return false;
    //     }
    //     return isSub(s, 0, t, 0);
    // }
    // private boolean isSub(String s, int i, String t, int j) {
    //     char c = s.charAt(i);
    //     while (j < t.length() && t.charAt(j) != c) {
    //         ++j;
    //     }
    //     if (j == t.length()) {
    //         return false;
    //     }
    //     if (i == s.length() - 1) {
    //         return true;
    //     }
    //     return isSub(s, i + 1, t, j + 1);
    // }

    /**
     * 迭代
     * https://leetcode-cn.com/problems/is-subsequence/solution/cpan-duan-zi-xu-lie-hou-xu-tiao-zhan-by-zzzzzz-5/
     * 14 / 14, 35ms(30.49%), 49.5MB(95.23%)
     */
    // public boolean isSubsequence(String s, String t) {
    //     if (s.length() == 0) {
    //         return true;
    //     }
    //     int i = 0, length = s.length();
    //     for (int j = 0; j < t.length(); ++j) {
    //         if (s.charAt(i) == t.charAt(j)) {
    //             ++i;
    //         }
    //         if (i == length) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // 其他解法：
    // https://leetcode-cn.com/problems/is-subsequence/solution/cpan-duan-zi-xu-lie-hou-xu-tiao-zhan-by-zzzzzz-5/
    // https://leetcode-cn.com/problems/is-subsequence/solution/java-dp-by-zxy0917-5/
}
// @lc code=end

