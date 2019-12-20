/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
    /**
     * 53 / 53, 2ms(98.8%), 48.3MB(99.3%)
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0, len = A.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            sum += A[i];
            arr[i] = sum;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int i = 0;
        while (i < len) {
            if (arr[i] == sum) {
                break;
            }
            ++i;
        }
        if (i + 2 >= len) {
            return false;
        }
        sum *= 2;
        while (i < len) {
            if (arr[i] == sum) {
                break;
            }
            ++i;
        }
        return i + 1 < len;
    }
}
// @lc code=end

