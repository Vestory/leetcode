/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    /**
     * 241 / 241, 2ms(53.62%), 34.3MB(95.2%)
     */
    // public String convertToBase7(int num) {
    //     if (num == 0) {
    //         return "0";
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     boolean tag = false;
    //     if (num < 0) {
    //         num *= -1;
    //         tag = true;
    //     }
    //     while (num > 0) {
    //         sb.append(num % 7);
    //         num /= 7;
    //     }
    //     if (tag) {
    //         sb.append('-');
    //     }
    //     return sb.reverse().toString();
    // }

    /**
     * https://leetcode-cn.com/problems/base-7/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jiao-10/
     * 241 / 241, 1ms(100%), 34.1MB(95.2%)
     */
    public String convertToBase7(int num) {
        return num >= 0 ? Integer.toUnsignedString(num, 7) : "-" + Integer.toUnsignedString(num * -1, 7);
    }
}
// @lc code=end
