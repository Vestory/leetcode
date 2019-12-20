/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    /**
     * 202 / 202, 11ms(74.13%), 39.8MB(98.06%)
     */
    // public int[][] imageSmoother(int[][] M) {
    //     int len0 = M.length;
    //     if (len0 == 0) {
    //         return new int[0][0];
    //     }
    //     int len1 = M[0].length, count;
    //     int[][] res = new int[len0][len1];
    //     boolean f0, f1;
    //     for (int i = 0; i < len0; ++i) {
    //         for (int j = 0; j < len1; ++j) {
    //             f0 = j > 0;
    //             f1 = j + 1 < len1;
    //             count = 1;
    //             res[i][j] = M[i][j];
    //             if (i > 0) {
    //                 if (f0) {
    //                     res[i][j] += M[i - 1][j - 1];
    //                     ++count;
    //                 }
    //                 if (f1) {
    //                     res[i][j] += M[i - 1][j + 1];
    //                     ++count;
    //                 }
    //                 res[i][j] += M[i - 1][j];
    //                 ++count;
    //             }
    //             if (i + 1 < len0) {
    //                 if (f0) {
    //                     res[i][j] += M[i + 1][j - 1];
    //                     ++count;
    //                 }
    //                 if (f1) {
    //                     res[i][j] += M[i + 1][j + 1];
    //                     ++count;
    //                 }
    //                 res[i][j] += M[i + 1][j];
    //                 ++count;
    //             }
    //             if (f0) {
    //                 res[i][j] += M[i][j - 1];
    //                 ++count;
    //             }
    //             if (f1) {
    //                 res[i][j] += M[i][j + 1];
    //                 ++count;
    //             }
    //             res[i][j] /= count;
    //         }
    //     }
    //     return res;
    // }

    /**
     * https://leetcode-cn.com/problems/image-smoother/solution/tu-pian-ping-hua-qi-by-leetcode/
     * 202 / 202, 16ms(43.6%), 43.4MB(96.12%)
     */
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
}
// @lc code=end
