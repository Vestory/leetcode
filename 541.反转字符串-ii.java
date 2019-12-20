/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    /**
     * 60 / 60, 5ms(25.4%), 36.8MB(98.49%)
     */
    // public String reverseStr(String s, int k) {
    //     StringBuilder sb = new StringBuilder();
    //     int len = s.length(), i = 0, j = -k;
    //     while (i < len) {
    //         j += 2 * k;
    //         if (j > len) {
    //             j = len;
    //         }
    //         while (i < j) {
    //             sb.append(s.charAt(--j));
    //         }
    //         j = i + k;
    //         if (j >= len) {
    //             break;
    //         }
    //         i = j + k > len ? len : (j + k);
    //         sb.append(s.substring(j, i));
    //     }
    //     return sb.toString();
    // }

    /**
     * 60 / 60, 1ms(96.52%), 37.3MB(97.74%)
     */
    // public String reverseStr(String s, int k) {
    //     char[] array = s.toCharArray();
    //     int len = s.length(), l = 0, r = (k > len ? len : k) - 1;
    //     char c;
    //     while (true) {
    //         while (l < r) {
    //             c = array[l];
    //             array[l] = array[r];
    //             array[r] = c;
    //             ++l;
    //             --r;
    //         }
    //         l += (k * 3 + 1) / 2;
    //         if (l >= len) {
    //             break;
    //         }
    //         r = (l + k > len ? len : (l + k)) - 1;
    //     }
    //     return new String(array);
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/reverse-string-ii/solution/fan-zhuan-zi-fu-chuan-ii-by-leetcode/
     * 60 / 60, 1ms(96.52%), 37.3MB(97.74%)
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
// @lc code=end
