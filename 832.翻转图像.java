/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    /**
     * 82 / 82, 0ms(100%), 39.9MB(59.37%)
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int len0 = A.length;
        if (len0 != 0) {
            int l, r;
            for (int i = 0; i < len0; ++i) {
                l = 0;
                r = A[0].length - 1;
                while (l < r) {
                    if (A[i][l] == A[i][r]) {
                        if (A[i][l] == 0) {
                            A[i][l] = 1;
                            A[i][r] = 1;
                        } else {
                            A[i][l] = 0;
                            A[i][r] = 0;
                        }
                    }
                    ++l;
                    --r;
                }
                if (l == r) {
                    A[i][l] = A[i][l] == 0 ? 1 : 0;
                }
            }
        }
        return A;
    }
}
// @lc code=end

