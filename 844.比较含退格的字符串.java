/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    /**
     * 104 / 104, 1ms(99.59%), 34.2MB(83.74%)
     */
    // public boolean backspaceCompare(String S, String T) {
    //     char[] sr = S.toCharArray(), tr = T.toCharArray();
    //     int s = S.length() - 1, t = T.length() - 1, count = 0;
    //     while (s > -1 && t > -1) {
    //         while (s > -1) {
    //             if (sr[s] != '#') {
    //                 if (count == 0) {
    //                     break;
    //                 } else {
    //                     --count;
    //                 }
    //             } else {
    //                 ++count;
    //             }
    //             --s;
    //         }
    //         count = 0;
    //         while (t > -1) {
    //             if (tr[t] != '#') {
    //                 if (count == 0) {
    //                     break;
    //                 } else {
    //                     --count;
    //                 }
    //             } else {
    //                 ++count;
    //             }
    //             --t;
    //         }
    //         if (s > -1 && t > -1) {
    //             if (sr[s] != tr[t]) {
    //                 break;
    //             }
    //             --s;
    //             --t;
    //         }
    //     }
    //     count = 0;
    //     while (s > -1) {
    //         if (sr[s] != '#') {
    //             if (count == 0) {
    //                 break;
    //             } else {
    //                 --count;
    //             }
    //         } else {
    //             ++count;
    //         }
    //         --s;
    //     }
    //     while (t > -1) {
    //         if (tr[t] != '#') {
    //             if (count == 0) {
    //                 break;
    //             } else {
    //                 --count;
    //             }
    //         } else {
    //             ++count;
    //         }
    //         --t;
    //     }
    //     return s == t;
    // }

    /**
     * 104 / 104, 1ms(99.59%), 34.3MB(82.66%)
     */
    public boolean backspaceCompare(String S, String T) {
        char[] sr = S.toCharArray(), tr = T.toCharArray();
        int s = S.length() - 1, t = T.length() - 1;
        while (s > -1 && t > -1) {
            s = next(sr, s);
            t = next(tr, t);
            if (s > -1 && t > -1) {
                if (sr[s] != tr[t]) {
                    break;
                }
                --s;
                --t;
            }
        }
        s = next(sr, s);
        t = next(tr, t);
        return s == t;
    }
    private int next(char[] arr, int idx) {
        int count = 0;
        while (idx > -1) {
            if (arr[idx] != '#') {
                if (count-- == 0) {
                    return idx;
                }
            } else {
                ++count;
            }
            --idx;
        }
        return idx;
    }
}
// @lc code=end

