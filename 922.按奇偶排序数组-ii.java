/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    /**
     * 61 / 61, 3ms(92.58%), 40.1MB(96.15%)
     */
    public int[] sortArrayByParityII(int[] A) {
        int idx = 1, len = A.length, temp;
        for (int i = 0; i < len; i += 2) {
            if (A[i] % 2 == 1) {
                while (idx < len) {
                    if (A[idx] % 2 == 0) {
                        break;
                    }
                    idx += 2;
                }
                temp = A[i];
                A[i] = A[idx];
                A[idx] = temp;
                idx += 2;
            }
        }
        return A;
    }
}
// @lc code=end

