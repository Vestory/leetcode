/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    /**
     * 8, 0ms(100%), 34.3MB(56.63%)
     */
    // public String toLowerCase(String str) {
    //     char[] array = str.toCharArray();
    //     int len = str.length();
    //     for (int i = 0; i < len; ++i) {
    //         if (array[i] > 64 && array[i] < 91) {
    //             array[i] += 32;
    //         }
    //     }
    //     return new String(array);
    // }

    /**
     * 8, 0ms(100%), 33.9MB(72.84%)
     */
    public String toLowerCase(String str) {
        int len = str.length();
        char c;
        for (int i = 0; i < len; ++i) {
            c = str.charAt(i);
            if (c > 64 && c < 91) {
                str = str.replace(c, (char) (c + 32));
            }
        }
        return str;
    }
}
// @lc code=end

