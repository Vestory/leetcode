/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    /**
     * 26 / 26, 2ms(33.05%), 33.8MB(86.67%)
     */
    // public int countSegments(String s) {
    //     if (s.length() == 0) {
    //         return 0;
    //     }
    //     s = s.trim();
    //     if (s.length() == 0) {
    //         return 0;
    //     }
    //     return s.replaceAll("\\s\\s+", " ").split(" ").length;
    // }

    /**
     * 26 / 26, 2ms(33.09%), 33.9MB(80%)
     * 时间复杂度和空间复杂度均为O(n)
     * https://leetcode-cn.com/problems/number-of-segments-in-a-string/solution/zi-fu-chuan-zhong-de-dan-ci-shu-by-leetcode/
     */
    // public int countSegments(String s) {
    //     s = s.trim();
    //     if (s.equals("")) {
    //         return 0;
    //     }
    //     return s.split("\\s+").length;
    // }

    /**
     * 26 / 26, 0ms(100%), 33.8MB(86.36%)
     */
    // public int countSegments(String s) {
    //     boolean flag = true;
    //     int count = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         if (flag) {
    //             if (Character.isSpaceChar(s.charAt(i))) {
    //                 continue;
    //             }
    //             flag = false;
    //             ++count;
    //         } else {
    //             if (Character.isSpaceChar(s.charAt(i))) {
    //                 flag = true;
    //             }
    //         }
    //     }
    //     return count;
    // }

    /**
     * 26 / 26, 0ms(100%), 34MB(71.21%)
     */
    // public int countSegments(String s) {
    //     int count = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         if (!Character.isSpaceChar(s.charAt(i))) {
    //             while (++i < s.length() && !Character.isSpaceChar(s.charAt(i))) {
    //             }
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    /**
     * 原地法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 26 / 26, 0ms(100%), 34MB(73.03%)
     * https://leetcode-cn.com/problems/number-of-segments-in-a-string/solution/zi-fu-chuan-zhong-de-dan-ci-shu-by-leetcode/
     */
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                ++count;
            }
        }
        return count;
    }
}
// @lc code=end