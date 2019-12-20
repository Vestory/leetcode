/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    /**
     * 70 / 70, 2ms(76.75%), 37.9MB(77.14%)
     */
    // public int compress(char[] chars) {
    //     int i = -1, j = 0, k = 0;
    //     String temp = "";
    //     while (++k < chars.length) {
    //         if (chars[j] != chars[k]) {
    //             if (k - j > 1) {
    //                 if (i == -1) {
    //                     i = j;
    //                 } else {
    //                     chars[i] = chars[j];
    //                 }
    //                 temp = (k - j) + "";
    //                 for (int l = 0; l < temp.length(); ++l) {
    //                     chars[++i] = temp.charAt(l);
    //                 }
    //                 ++i;
    //             } else {
    //                 if (i != -1) {
    //                     chars[i++] = chars[j];
    //                 }
    //             }
    //             j = k;
    //         }
    //     }
    //     if (j < chars.length - 1) {
    //         if (i == -1) {
    //             i = j;
    //         } else {
    //             chars[i] = chars[j];
    //         }
    //         temp = (k - j) + "";
    //         for (int l = 0; l < temp.length(); ++l) {
    //             chars[++i] = temp.charAt(l);
    //         }
    //         ++i;
    //     } else {
    //         if (i == -1) {
    //             i = chars.length;
    //         } else {
    //             chars[i++] = chars[j];
    //         }
    //     }
    //     return i;
    // }

    /**
     * 双指针
     * https://leetcode-cn.com/problems/string-compression/solution/ya-suo-zi-fu-chuan-by-leetcode/
     * https://leetcode-cn.com/problems/string-compression/solution/hua-dong-chuang-kou-fa-ya-suo-zi-fu-chuan-java-by-/
     * 时间复杂度O(n), 空间复杂度O(1)
     * 70 / 70, 2ms(76.75%), 37.8MB(77.55%)
     */
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
// @lc code=end
