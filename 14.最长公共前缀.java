/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {

    /**
     * 水平扫描
     * 时间复杂度O(S)，S是字符串中所有字符数量的总和
     * 空间复杂度O(1)
     * 118 / 118, 3ms(63.18%), 36.1MB(87.52%)
     */
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs.length == 0) {
    //         return "";
    //     }
    //     char c;
    //     for (int i = 0; i < strs[0].length(); ++i) {
    //         c = strs[0].charAt(i);
    //         for (int j = 1; j < strs.length; ++j) {
    //             if (i >= strs[j].length() || strs[j].charAt(i) != c) {
    //                 return strs[0].substring(0, i);
    //             }
    //         }
    //     }
    //     return strs[0];
    // }

    /**
     * 水平扫描法
     * 时间复杂度O(S)，S是所有字符串中字符数量的总和
     * 空间复杂度O(1)
     * 118 / 188, 1ms(99.91%), 35.6MB(89.32%)
     */
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs.length == 0) {
    //         return "";
    //     }
    //     String result = strs[0];
    //     for (int i = 1; i < strs.length; ++i) {
    //         while (strs[i].indexOf(result) != 0) {
    //             result = result.substring(0, result.length() - 1);
    //             if (result.isEmpty()) {
    //                 return "";
    //             }
    //         }
    //     }
    //     return result;
    // }

    // // #region [0] 分治（递归）的方法
    // /**
    //  * 时间复杂度O(S)，S是所有字符串中字符数量的总和
    //  * 空间复杂度O(m*log(n))
    //  * 118 / 188, 3ms(63.19%), 37.4MB(78.08%)
    //  */
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs == null || strs.length == 0) {
    //         return "";
    //     }
    //     return lcp(strs, 0, strs.length - 1);
    // }

    // /** LCP */
    // private String lcp(String[] strs, int l, int r) {
    //     if (l == r) {
    //         return strs[l];
    //     } else {
    //         int mid = (l + r) / 2;
    //         String left = lcp(strs, l, mid);
    //         String right = lcp(strs, mid + 1, r);
    //         return commonPrefix(left, right);
    //     }
    // }

    // /** 获得两个字符串的公共前缀 */
    // private String commonPrefix(String left, String right) {
    //     int length = Math.min(left.length(), right.length());
    //     for (int i = 0; i < length; ++i) {
    //         if (left.charAt(i) != right.charAt(i)) {
    //             return left.substring(0, i);
    //         }
    //     }
    //     return left.substring(0, length);
    // }
    // // #endregion

    // // #region [0] 二分查找法
    // /**
    //  * 118 / 118, 1ms(99.92%), 36.1MB(87.52%)
    //  * 时间复杂度O(S*log(n))，其中S是所有字符串中字符数量的总和
    //  * 空间复杂度O(1)
    //  */
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs == null || strs.length == 0) {
    //         return "";
    //     }
    //     int minLen = Integer.MAX_VALUE;
    //     for (String str: strs) {
    //         minLen = Math.min(minLen, str.length());
    //     }
    //     int low = 1;
    //     int high = minLen;
    //     while (low <= high) {
    //         int middle = (low + high) / 2;
    //         if (isCommonPrefix(strs, middle)) {
    //             low = middle + 1;
    //         } else {
    //             high = middle - 1;
    //         }
    //     }
    //     return strs[0].substring(0, (low + high) / 2);
    // }

    // private boolean isCommonPrefix(String[] strs, int len) {
    //     String str1 = strs[0].substring(0, len);
    //     for (int i = 1; i < strs.length; ++i) {
    //         if (!strs[i].startsWith(str1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // // #endregion

    // #region [0] 二分查找法
    /**
     * 速度反而没有上一种二分查找快
     * 118 / 118, (3ms)63.19%,36.1MB(87.52%)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int low = 0;
        int high = Integer.MAX_VALUE;
        for (String str : strs) {
            high = Math.min(high, str.length());
        }
        while (low < high) {
            int mid = (low + high) / 2;
            low = commonPrefix(strs, low, mid);
            if (low <= mid) {
                return strs[0].substring(0, low);
            }
        }
        return strs[0].substring(0, low);
    }

    private int commonPrefix(String[] strs, int l, int r) {
        char c;
        for (int i = l; i <= r; ++i) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != c) {
                    return i;
                }
            }
        }
        return r + 1;
    }
    // #endregion
}

