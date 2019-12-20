/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */

// @lc code=start
class Solution {
    /**
     * 246 / 246, 1ms(100%), 34.2MB(100%)
     * 不要使用split来分割字符串，耗时太长了
     */
    public int dayOfYear(String date) {
        int[] arr = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
        int month = Integer.parseInt(date.substring(5, 7)) - 1;
        int day = Integer.parseInt(date.substring(8, 10));
        if (month > 1) {
            return isLeapYear(Integer.parseInt(date.substring(0, 4))) ? (arr[month] + day + 1) : (arr[month] + day);
        }
        return arr[month] + day;
    }
    private boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
}
// @lc code=end
