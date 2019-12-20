/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    /**
     * 116 / 116, 1ms(94.07%), 34.6MB(92.19%)
     */
    public String reverseOnlyLetters(String S) {
        int l = 0, r = S.length() - 1;
        char[] arr = S.toCharArray();
        char c;
        while (l < r) {
            while (l < r) {
                if (Character.isAlphabetic(arr[l])) {
                    break;
                }
                ++l;
            }
            while (l < r) {
                if (Character.isAlphabetic(arr[r])) {
                    break;
                }
                --r;
            }
            if (l < r) {
                c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
                ++l;
                --r;
            }
        }
        return new String(arr);
    }
}
// @lc code=end

