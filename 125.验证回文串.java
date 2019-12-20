/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */
class Solution {
    /**
     * 双指针
     * 476 / 476, 8ms(87.13%), 37.6MB(90.82%)
     */
    // public boolean isPalindrome(String s) {
    //     s = s.toLowerCase();
    //     int l = 0;
    //     int r = s.length() - 1;
    //     char left, right;
    //     while (l <= r) {
    //         left = s.charAt(l);
    //         while (!Character.isDigit(left) && !Character.isAlphabetic(left)) {
    //             if (++l >= r) {
    //                 return true;
    //             }
    //             left = s.charAt(l);
    //         }
    //         right = s.charAt(r);
    //         while (!Character.isDigit(right) && !Character.isAlphabetic(right)) {
    //             if (--r <= l) {
    //                 return true;
    //             }
    //             right = s.charAt(r);
    //         }
    //         if (left != right) {
    //             return false;
    //         }
    //         ++l;
    //         --r;
    //     }
    //     return true;
    // }

    /**
     * 原地算法先过滤出有效字符，判断是否是回文
     * https://leetcode-cn.com/problems/valid-palindrome/solution/java-yuan-di-suan-fa-by-user6268/
     * 476 / 476, 2ms(100%), 36.9MB(96.59%)
     */
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        --cnt;
        while (j < cnt) {
            if (cs[j++] != cs[cnt--]) {
                return false;
            }
        }
        return true;
    }
}
