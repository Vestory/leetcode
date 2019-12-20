import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    /**
     * 132 / 132, 3ms(84.51%), 41.7MB(95.21%)
     */
    // public int[] sortedSquares(int[] A) {
    //     int len = A.length;
    //     for (int i = 0; i < len; ++i) {
    //         A[i] *= A[i];
    //     }
    //     Arrays.sort(A);
    //     return A;
    // }

    /**
     * 132 / 132, 2ms(99.78%), 39.9MB(96.72%)
     */
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        if (A[len - 1] <= 0) {
            --len;
            for (int i = len; i >= 0; --i) {
                res[len - i] = A[i] * A[i];
            }
        } else if (A[0] >= 0) {
            for (int i = 0; i < len; ++i) {
                res[i] = A[i] * A[i];
            }
        } else {
            int l, r = -1, idx = -1;
            while (++r < len) {
                if (A[r] >= 0) {
                    break;
                }
            }
            l = r - 1;
            while (l >= 0 && r < len) {
                if (Math.abs(A[l]) <= Math.abs(A[r])) {
                    res[++idx] = A[l] * A[l];
                    --l;
                } else {
                    res[++idx] = A[r] * A[r];
                    ++r;
                }
            }
            while (l >= 0) {
                res[++idx] = A[l] * A[l];
                --l;
            }
            while (r < len) {
                res[++idx] = A[r] * A[r];
                ++r;
            }
        }
        return res;
    }
}
// @lc code=end

