/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    /**
     * 315 / 315, 3ms(94.07%), 35.8MB(88.28%)
     */
    // public String addStrings(String num1, String num2) {
    //     if (num1.length() < num2.length()) {
    //         String temp = num1;
    //         num1 = num2;
    //         num2 = temp;
    //     }
    //     int extra = 0;
    //     int index = num2.length();
    //     int offset = num1.length() - index;
    //     StringBuilder sb = new StringBuilder();
    //     while (--index >= 0) {
    //         extra += (num1.charAt(index + offset) + num2.charAt(index) - 96);
    //         if (extra > 9) {
    //             sb.append(extra - 10);
    //             extra = 1;
    //         } else {
    //             sb.append(extra);
    //             extra = 0;
    //         }
    //     }
    //     while (--offset >= 0) {
    //         extra += (num1.charAt(offset) - 48);
    //         if (extra > 9) {
    //             sb.append(extra - 10);
    //             extra = 1;
    //         } else {
    //             sb.append(extra);
    //             extra = 0;
    //         }
    //     }
    //     if (extra == 1) {
    //         sb.append(1);
    //     }
    //     return sb.reverse().toString();
    // }

    /**
     * 双指针
     * 315 / 315, 2ms(99.75%), 36.3MB(85.98%)
     * 时间复杂度O(max(M, N))，空间复杂度O(1)
     * https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, extra = 0;
        while (i >= 0 || j >= 0) {
            int temp = (i >= 0 ? num1.charAt(i) - '0' : 0) + (j >= 0 ? num2.charAt(j) - '0' : 0) + extra;
            extra = temp / 10;
            sb.append(temp % 10);
            --i;
            --j;
        }
        if (extra == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

