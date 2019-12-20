/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    /**
     * 113 / 113, 0ms(100%), 34.1MB(95.56%)
     */
    // public boolean checkRecord(String s) {
    //     int a = 0, l = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         switch (s.charAt(i)) {
    //         case 'A':
    //         if (++a > 1) {
    //             return false;
    //         }
    //             l = 0;
    //             break;
    //         case 'L':
    //             if (++l > 2) {
    //                 return false;
    //             }
    //             break;
    //         case 'P':
    //             l = 0;
    //             break;
    //         }
    //     }
    //     return true;
    // }

    // #region [0] 官方解题
    // https://leetcode-cn.com/problems/student-attendance-record-i/solution/xue-sheng-chu-qin-ji-lu-i-by-leetcode/
    /**
     * 正则表达式
     * 时间复杂度O(n)，空间复杂度O(1)
     * 113 / 113, 6ms(5.39%), 34.9MB(86.67%)
     */
    // public boolean checkRecord(String s) {
    //     return !s.matches(".*(A.*A|LLL).*");
    // }

    /**
     * 不使用indexOf的一次迭代方法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 113 / 113, 1ms(88.14%), 34.2MB(95.24%)
     */
    // public boolean checkRecord(String s) {
    //     int countA = 0;
    //     for (int i = 0; i < s.length() && countA < 2; i++) {
    //         if (s.charAt(i) == 'A')
    //             countA++;
    //         if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
    //             return false;
    //     }
    //     return countA < 2;
    // }

    /**
     * 简单的解法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 113 / 113, 1ms(88.14%), 34.5MB(92.7%)
     */
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == 'A')
                count++;
        return count < 2 && s.indexOf("LLL") < 0;
    }

    /**
     * 上一方法的优化版
     * 时间复杂度O(n)，空间复杂度O(1)
     * 113 / 113, 0ms(100%), 34.3MB(94.6%)
     */
    // public boolean checkRecord(String s) {
    //     int count = 0;
    //     for (int i = 0; i < s.length() && count < 2; i++)
    //         if (s.charAt(i) == 'A')
    //             count++;
    //     return count < 2 && s.indexOf("LLL") < 0;
    // }
    // #endregion
}
// @lc code=end
