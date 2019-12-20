/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    /**
     * 45 / 45, 3ms(53.07%), 39.4MB(93.41%)
     */
    // public boolean lemonadeChange(int[] bills) {
    // int len = bills.length;
    // int[] mr = new int[3];
    // for (int i = 0; i < len; ++i) {
    // switch (bills[i]) {
    // case 5:
    // ++mr[0];
    // break;
    // case 10:
    // if (--mr[0] < 0) {
    // return false;
    // }
    // ++mr[1];
    // break;
    // case 20:
    // if (mr[1] > 0) {
    // --mr[1];
    // if (--mr[0] < 0) {
    // return false;
    // }
    // } else {
    // mr[0] -= 3;
    // if (mr[0] < 0) {
    // return false;
    // }
    // }
    // ++mr[2];
    // break;
    // }
    // }
    // return true;
    // }

    /**
     * 45 / 45, 2ms(99.91%), 39.9MB(92.24%)
     */
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        int m0 = 0, m1 = 0, m2 = 0;
        for (int i = 0; i < len; ++i) {
            switch (bills[i]) {
            case 5:
                ++m0;
                break;
            case 10:
                --m0;
                ++m1;
                break;
            case 20:
                if (m1 > 0) {
                    --m1;
                    --m0;
                } else {
                    m0 -= 3;
                }
                ++m2;
                break;
            }
            if (m0 < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
