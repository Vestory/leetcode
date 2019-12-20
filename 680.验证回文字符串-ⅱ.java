/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    /**
     * 460 / 460, 12ms(54.63%), 39.1MB(92.1%)
     */
    // public boolean validPalindrome(String s) {
    //     int l = 0, r = s.length() - 1, count = 0, sl = -1, sr = -1;
    //     char lc, rc;
    //     while (l < r) {
    //         lc = s.charAt(l);
    //         rc = s.charAt(r);
    //         if (lc != rc) {
    //             if (sl != -1) {
    //                 l = sl;
    //                 r = sr;
    //                 sl = -1;
    //                 sr = -1;
    //                 continue;
    //             }
    //             if (++count > 1) {
    //                 return false;
    //             }
    //             if (r - l > 1) {
    //                 if (s.charAt(l + 1) == rc) {
    //                     ++l;
    //                     if (s.charAt(r - 1) == lc) {
    //                         sl = l - 1;
    //                         sr = r - 1;
    //                     }
    //                 } else if (s.charAt(r - 1) == lc) {
    //                     --r;
    //                     if (s.charAt(l + 1) == rc) {
    //                         sl = l + 1;
    //                         sr = r + 1;
    //                     }
    //                 } else {
    //                     return false;
    //                 }
    //             }
    //         }
    //         ++l;
    //         --r;
    //     }
    //     return true;
    // }

    /**
     * 460 / 460, 6ms(96.09%), 38.6MB(92.37%)
     */
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1, count = 0, sl = -1, sr = -1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                if (sl != -1) {
                    l = sl;
                    r = sr;
                    sl = -1;
                    sr = -1;
                    continue;
                }
                if (++count > 1) {
                    return false;
                }
                if (r - l > 1) {
                    if (arr[l + 1] == arr[r]) {
                        if (arr[r - 1] == arr[l]) {
                            sl = l;
                            sr = r - 1;
                        }
                        ++l;
                    } else if (arr[r - 1] == arr[l]) {
                        if (arr[l + 1] == arr[r]) {
                            sl = l + 1;
                            sr = r;
                        }
                        --r;
                    } else {
                        return false;
                    }
                }
            }
            ++l;
            --r;
        }
        return true;
    }
}
// @lc code=end

