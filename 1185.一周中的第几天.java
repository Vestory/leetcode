/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
class Solution {
    /**
     * Zeller公式
     * https://leetcode-cn.com/problems/day-of-the-week/solution/cai-le-gong-shi-by-13579809070/
     * 39 / 39, 0ms(100%), 33.6MB(100%)
     */
    public String dayOfTheWeek(int day, int month, int year) {
        if (month == 1) {
            month = 13;
            --year;
        }
        if (month == 2) {
            month = 14;
            --year;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;

        switch (week) {
        case 0:
            return "Monday";
        case 1:
            return "Tuesday";
        case 2:
            return "Wednesday";
        case 3:
            return "Thursday";
        case 4:
            return "Friday";
        case 5:
            return "Saturday";
        case 6:
            return "Sunday";
        }
        return null;
    }
}
// @lc code=end

