/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    /**
     * 51 / 51, 2ms(77.21%), 38.9MB(92.2%)
     */
    // public boolean validMountainArray(int[] A) {
    //     int len = A.length, i = 1;
    //     if (len < 3) {
    //         return false;
    //     }
    //     while (i < len) {
    //         if (A[i] < A[i - 1]) {
    //             break;
    //         } else if (A[i] == A[i - 1]) {
    //             return false;
    //         }
    //         ++i;
    //     }
    //     if (i == 1 || i == len) {
    //         return false;
    //     }
    //     while (i < len) {
    //         if (A[i] >= A[i - 1]) {
    //             return false;
    //         }
    //         ++i;
    //     }
    //     return i == len;
    // }

    /**
     * https://leetcode-cn.com/problems/valid-mountain-array/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-11/
     * 51 / 51, 2ms(77.21%), 38.9MB(92.2%)
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;

        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1])//注意循环完毕后,left指针只能到数组倒数第二个数位置
            left++;
        while (right > 1 && A[right] < A[right - 1])//和left指针条件一样
            right--;

        return left == right;
    }
}
// @lc code=end

