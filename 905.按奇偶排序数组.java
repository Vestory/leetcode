/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    /**
     * 285 / 285, 1ms(100%), 38.7MB(97.18%)
     */
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1, temp;
        while (l < r) {
            while (l < r) {
                if (A[l] % 2 == 1) {
                    break;
                }
                ++l;
            }
            while (l < r) {
                if (A[r] % 2 == 0) {
                    break;
                }
                --r;
            }
            temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            ++l;
            --r;
        }
        return A;
    }
}
// @lc code=end

