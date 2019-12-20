/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
class Solution {
    /**
     * 55 / 55, 131ms(72.14%), 36.3MB(86.8%)
     */
    // public int repeatedStringMatch(String A, String B) {
    //     int la = A.length(), lb = B.length();
    //     if (la * 2 >= lb) {
    //         if (A.indexOf(B) != -1) {
    //             return 1;
    //         } else if ((A + A).indexOf(B) != -1) {
    //             return 2;
    //         }
    //     }
    //     int idx = B.indexOf(A);
    //     if (idx == -1) {
    //         return -1;
    //     }
    //     B = B.replaceAll(A, "");
    //     int lt = B.length(), res = (lb - lt) / la;
    //     if (lt == 0) {
    //         return res;
    //     }
    //     // only suffix
    //     if (idx == 0) {
    //         return A.indexOf(B) == 0 ? ++res : -1;
    //     }
    //     // prefix
    //     if (A.lastIndexOf(B.substring(0, idx)) != la - idx) {
    //         return -1;
    //     }
    //     ++res;
    //     // suffix
    //     if (idx < lt) {
    //         if (A.indexOf(B.substring(idx)) != 0) {
    //             return -1;
    //         }
    //         ++res;
    //     }
    //     return res;
    // }

    /**
     * 55 / 55, 120ms(77.11%), 36.4MB(82.23%)
     */
    // public int repeatedStringMatch(String A, String B) {
    //     int la = A.length(), lb = B.length();
    //     if (lb <= 2 * la - 2) {
    //         if (A.indexOf(B) != -1) {
    //             return 1;
    //         } else if ((A + A).indexOf(B) != -1) {
    //             return 2;
    //         }
    //     }
    //     int idx = B.indexOf(A);
    //     if (idx != -1 && idx < la) {
    //         B = B.replaceAll(A, "");
    //         int lt = B.length(), res = (lb - lt) / la;
    //         if (lt != 0) {
    //             if (idx == 0) {
    //                 return A.indexOf(B) == 0 ? ++res : -1;
    //             }
    //             if (A.lastIndexOf(B.substring(0, idx)) != la - idx) {
    //                 return -1;
    //             }
    //             ++res;
    //             if (idx < lt) {
    //                 if (A.indexOf(B.substring(idx)) != 0) {
    //                     return -1;
    //                 }
    //                 ++res;
    //             }
    //         }
    //         return res;
    //     }
    //     return -1;
    // }

    /**
     * 55 / 55, 129ms(72.79%), 35.8MB(91.37%)
     */
    public int repeatedStringMatch(String A, String B) {
        int res = B.length() / A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res; ++i) {
            sb.append(A);
        }
        for (int i = 0; i < 3; ++i) {
            if (sb.indexOf(B) == -1) {
                ++res;
                sb.append(A);
            } else {
                return res;
            }
        }
        return -1;
    }
}
// @lc code=end

