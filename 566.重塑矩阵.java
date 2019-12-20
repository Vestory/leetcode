import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    /**
     * 56 / 56, 1ms(100%), 38.6MB(97.8%)
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int col = nums[0].length;
        if (nums.length * col != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int idx = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = nums[idx / col][idx % col];
                ++idx;
            }
        }
        return res;
    }


    // #region [0] 官方解题
    // https://leetcode-cn.com/problems/reshape-the-matrix/solution/zhong-su-ju-zhen-by-leetcode/
    /**
     * 使用队列
     * 时间复杂度和空间复杂度均为O(m * n)
     * 56 / 56, 5ms(13.03%), 39.4MB(96.86%)
     */
    // public int[][] matrixReshape(int[][] nums, int r, int c) {
    //     int[][] res = new int[r][c];
    //     if (nums.length == 0 || r * c != nums.length * nums[0].length)
    //         return nums;
    //     int count = 0;
    //     Queue<Integer> queue = new LinkedList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums[0].length; j++) {
    //             queue.add(nums[i][j]);
    //         }
    //     }
    //     for (int i = 0; i < r; i++) {
    //         for (int j = 0; j < c; j++) {
    //             res[i][j] = queue.remove();
    //         }
    //     }
    //     return res;
    // }

    /**
     * 不使用额外空间
     * 时间复杂度和空间复杂度均为O(m * n)
     * 56 / 56, 3ms(59.07%), 38.3MB(97.8%)
     */
    // public int[][] matrixReshape(int[][] nums, int r, int c) {
    //     int[][] res = new int[r][c];
    //     if (nums.length == 0 || r * c != nums.length * nums[0].length)
    //         return nums;
    //     int rows = 0, cols = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums[0].length; j++) {
    //             res[rows][cols] = nums[i][j];
    //             cols++;
    //             if (cols == c) {
    //                 rows++;
    //                 cols = 0;
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 除法和取模长
     * 时间复杂度和空间复杂度均为O(m * n)
     * 56 / 56, 1ms(100%), 44.8MB(83.65%)
     */
    // public int[][] matrixReshape(int[][] nums, int r, int c) {
    //     int[][] res = new int[r][c];
    //     if (nums.length == 0 || r * c != nums.length * nums[0].length)
    //         return nums;
    //     int count = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums[0].length; j++) {
    //             res[count / c][count % c] = nums[i][j];
    //             count++;
    //         }
    //     }
    //     return res;
    // }
    // #endregion
}
// @lc code=end

