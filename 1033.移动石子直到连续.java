/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] 移动石子直到连续
 */

// @lc code=start
class Solution {
    /**
     * 187 / 187, 1ms(99.66%), 34.2MB(100%)
     */
    public int[] numMovesStones(int a, int b, int c) {
        int temp;
        if (c < b) {
            temp = c;
            c = b;
            b = temp;
        }
        if (c < a) {
            temp = c;
            c = a;
            a = temp;
        }
        if (b < a) {
            temp = b;
            b = a;
            a = temp;
        }
        temp = b - a - 1;
        b = c - b - 1;
        if (temp == 0 && b == 0) {
            temp = 0;
        } else {
            if (temp > b) {
                temp = b < 2 ? 1 : 2;
            } else {
                temp = temp < 2 ? 1 : 2;
            }
        }
        return new int[] { temp, c - a - 2 };
    }
}
// @lc code=end
