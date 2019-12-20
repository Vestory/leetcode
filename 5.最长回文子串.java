import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /**
     * 103 / 103, 116ms(33.67%), 35.9MB(91.62%)
     */
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() == 0) {
    //         return "";
    //     }
    //     int l = 0, r = s.length() - 1, max = 1;
    //     int tl, tr;
    //     String res = s.substring(0, 1);
    //     char c = s.charAt(l);
    //     while (l < s.length() - max) {
    //         while (r - l >= max) {
    //             if (s.charAt(r) == c) {
    //                 tl = l + 1;
    //                 tr = r - 1;
    //                 while (tl < tr && s.charAt(tl) == s.charAt(tr)) {
    //                     ++tl;
    //                     --tr;
    //                 }
    //                 if (tl >= tr) {
    //                     max = r - l + 1;
    //                     res = s.substring(l, r + 1);
    //                 }
    //             }
    //             --r;
    //         }
    //         c = s.charAt(++l);
    //         r = s.length() - 1;
    //     }
    //     return res;
    // }

    // #region [0] 其他更好的方法
    // https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
    /**
     * 暴力破解，超时
     * 时间复杂度O(n * n), 空间复杂度O(1)
     */
    // public String longestPalindrome(String s) {
    //     String ans = "";
    //     int max = 0;
    //     int len = s.length();
    //     for (int i = 0; i < len; ++i) {
    //         for (int j = i + 1; j <= len; ++j) {
    //             String test = s.substring(i, j);
    //             if (isPalindromic(test) && test.length() > max) {
    //                 ans = s.substring(i, j);
    //                 max = Math.max(max, ans.length());
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // private boolean isPalindromic(String s) {
    //     int len = s.length();
    //     for (int i = 0; i < len / 2; ++i) {
    //         if (s.charAt(i) != s.charAt(len - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /**
     * 最长公共子串
     * 时间复杂度O(n * n), 空间复杂度O(n * n)
     * 103 / 103, 98ms(41.39%), 49.3MB(28.64%)
     */
    // public String longestPalindrome(String s) {
    //     if (s.equals("")) {
    //         return "";
    //     }
    //     String origin = s;
    //     String reverse = new StringBuffer(s).reverse().toString();
    //     int length = s.length();
    //     int[][] arr = new int[length][length];
    //     int maxLen = 0;
    //     int maxEnd = 0;
    //     for (int i = 0; i < length; ++i) {
    //         for (int j = 0; j < length; ++j) {
    //             if (origin.charAt(i) == reverse.charAt(j)) {
    //                 if (i == 0 || j == 0) {
    //                     arr[i][j] = 1;
    //                 } else {
    //                     arr[i][j] = arr[i - 1][j - 1] + 1;
    //                 }
    //             }
    //             if (arr[i][j] > maxLen) {
    //                 int beforeRev = length - 1 - j;
    //                 if (beforeRev + arr[i][j] - 1 == i) {
    //                     maxLen = arr[i][j];
    //                     maxEnd = i;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    // }

    /**
     * 优化了空间复杂度的最长公共子串方法
     * 时间复杂度O(n * n), 空间复杂度O(n)
     * 103 / 103, 59ms(55.29%), 36.3MB(91.08%)
     */
    // public String longestPalindrome(String s) {
    //     if (s.equals("")) {
    //         return "";
    //     }
    //     String origin = s;
    //     String reverse = new StringBuffer(s).reverse().toString();
    //     int length = s.length();
    //     int[] arr = new int[length];
    //     int maxLen = 0;
    //     int maxEnd = 0;
    //     for (int i = 0; i < length; ++i) {
    //         for (int j = length - 1; j >= 0; --j) {
    //             if (origin.charAt(i) == reverse.charAt(j)) {
    //                 if (i == 0 || j == 0) {
    //                     arr[j] = 1;
    //                 } else {
    //                     arr[j] = arr[j - 1] + 1;
    //                 }
    //             } else {
    //                 arr[j] = 0;
    //             }
    //             if (arr[j] > maxLen) {
    //                 int beforeRev = length - 1 - j;
    //                 if (beforeRev + arr[j] - 1 == i) {
    //                     maxLen = arr[j];
    //                     maxEnd = i;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    // }

    /**
     * 暴力破解优化
     * 时间复杂度O(n * n), 空间复杂度O(n * n)
     * 103 / 103, 284ms(13.44%), 51.9MB(19.41%)
     */
    // public String longestPalindrome(String s) {
    //     int length = s.length();
    //     boolean[][] p = new boolean[length][length];
    //     int maxLen = 0;
    //     String maxPal = "";
    //     for (int len = 1; len <= length; ++len) {
    //         for (int start = 0; start < length; ++start) {
    //             int end = start + len - 1;
    //             if (end >= length) {
    //                 break;
    //             }
    //             p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
    //             if (p[start][end] && len > maxLen) {
    //                 maxPal = s.substring(start, end + 1);
    //             }
    //         }
    //     }
    //     return maxPal;
    // }

    /**
     * 暴力破解优化后再优化存储空间
     * 时间复杂度O(n * n)，空间复杂度O(n)
     * 103 / 103, 48ms(58.13%), 36.6MB(90.52%)
     */
    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //     String res = "";
    //     boolean[] p = new boolean[n];
    //     for (int i = n - 1; i >= 0; --i) {
    //         for (int j = n - 1; j >= i; --j) {
    //             p[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || p[j - 1]);
    //             if (p[j] && j - i + 1 > res.length()) {
    //                 res = s.substring(i, j + 1);
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 扩展中心法
     * 时间复杂度O(n * n), 空间复杂度O(n)
     * 103 / 103, 8ms(97.34%), 36.1MB(91.3%)
     */
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() < 1) {
    //         return "";
    //     }
    //     int start = 0, end = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         int len1 = expandAroundCenter(s, i, i);
    //         int len2 = expandAroundCenter(s, i, i + 1);
    //         int len = Math.max(len1, len2);
    //         if (len > end - start) {
    //             start = i - (len - 1) / 2;
    //             end = i + len / 2;
    //         }
    //     }
    //     return s.substring(start, end + 1);
    // }
    // private int expandAroundCenter(String s, int left, int right) {
    //     int l = left, r = right;
    //     while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    //         --l;
    //         ++r;
    //     }
    //     return r - l - 1;
    // }

    /**
     * Manacher's Algorithm 马拉车算法
     * 时间复杂度和空间复杂度均为O(n)
     * 103 / 103, 36ms(62.66%), 36.9MB(88.85%)
     */
    public String longestPalindrome(String s) {
        String t = preProcess(s);
        int n = t.length();
        int[] p = new int[n];
        int c = 0, r = 0;
        for (int i = 1; i < n - 1; ++i) {
            int mirror = 2 * c - i;
            if (r > i) {
                // 防止超出r
                p[i] = Math.min(r - i, p[mirror]);
            } else {
                // 等于r的情况
                p[i] = 0;
            }
            // 碰到之前讲的三种情况，需要使用中心扩展法
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                ++p[i];
            }
            // 判断是否需要更新r
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        // 找出p的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        // 求原字符串下标
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
    private String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String res = "^";
        for (int i = 0; i < n; ++i) {
            res += "#" + s.charAt(i);
        }
        res += "#$";
        return res;
    }
    // #endregion
}
// @lc code=end

