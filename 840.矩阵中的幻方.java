/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
    /**
     * 91 / 91, 1ms(78.5%), 34.7MB(86.84%)
     */
    // private int[][] grid;
    // public int numMagicSquaresInside(int[][] grid) {
    //     this.grid = grid;
    //     int cnt = 0, len0 = grid.length - 2, len1 = grid[0].length - 2;
    //     for (int i = 0; i < len0; ++i) {
    //         for (int j = 0; j < len1; ++j) {
    //             if (isMagic(i, j)) {
    //                 ++cnt;
    //             }
    //         }
    //     }
    //     return cnt;
    // }
    // private boolean isMagic(int x, int y) {
    //     int xe = x + 3, ye = y + 3, val;
    //     int[] arr = new int[10];
    //     for (int i = x; i < xe; ++i) {
    //         for (int j = y; j < ye; ++j) {
    //             val = grid[i][j];
    //             if (val < 1 || val > 9 || ++arr[val] > 1) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return grid[x][y] + grid[x][y + 1] + grid[x][y + 2] == 15 &&
    //     grid[x + 1][y] + grid[x + 1][y + 1] + grid[x + 1][y + 2] == 15 &&
    //     grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2] == 15 &&
    //     grid[x][y] + grid[x + 1][y] + grid[x + 2][y] == 15 &&
    //     grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1] == 15 &&
    //     grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2] == 15 &&
    //     grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] == 15 &&
    //     grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y] == 15;
    // }

    /**
     * 91 / 91, 0ms(100%), 34.3MB(90.79%)
     */
    // private int[][] grid;
    // public int numMagicSquaresInside(int[][] grid) {
    //     this.grid = grid;
    //     int cnt = 0, len0 = grid.length - 2, len1 = grid[0].length - 2;
    //     for (int i = 0; i < len0; ++i) {
    //         for (int j = 0; j < len1; ++j) {
    //             if (isMagic(i, j)) {
    //                 ++cnt;
    //             }
    //         }
    //     }
    //     return cnt;
    // }
    // /**
    //  * 更好的判断方法请看
    //  * https://leetcode-cn.com/problems/magic-squares-in-grid/solution/pan-duan-zhong-jian-wei-54zhou-4zu-he-wei-15ji-ke-/
    //  * 1. 九个数字分别是1-9
    //  * 2. 中间为5
    //  * 3. 一三行和为15，一三列和为15
    //  */
    // private boolean isMagic(int x, int y) {
    //     int xe = x + 3, ye = y + 3, val;
    //     int[] arr = new int[10];
    //     for (int i = x; i < xe; ++i) {
    //         for (int j = y; j < ye; ++j) {
    //             val = grid[i][j];
    //             if (val < 1 || val > 9 || ++arr[val] > 1) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return grid[x + 1][y + 1] == 5 &&
    //     grid[x][y] + grid[x][y + 1] + grid[x][y + 2] == 15 &&
    //     grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2] == 15 &&
    //     grid[x][y] + grid[x + 1][y] + grid[x + 2][y] == 15 &&
    //     grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2] == 15;
    // }

    /**
     * 91 / 91, 0ms(100%), 34.7MB(86.84%)
     */
    private int[][] grid;
    public int numMagicSquaresInside(int[][] grid) {
        this.grid = grid;
        int cnt = 0, len0 = grid.length - 2, len1 = grid[0].length - 2;
        for (int i = 0; i < len0; ++i) {
            for (int j = 0; j < len1; ++j) {
                if (isMagic(i, j)) {
                    ++cnt;
                    ++j;
                }
            }
        }
        return cnt;
    }
    /**
     * 更好的判断方法请看
     * https://leetcode-cn.com/problems/magic-squares-in-grid/solution/pan-duan-zhong-jian-wei-54zhou-4zu-he-wei-15ji-ke-/
     * 1. 九个数字分别是1-9
     * 2. 中间为5
     * 3. 一三行和为15，一三列和为15
     */
    private boolean isMagic(int x, int y) {
        int xe = x + 3, ye = y + 3, val;
        int[] arr = new int[10];
        for (int i = x; i < xe; ++i) {
            for (int j = y; j < ye; ++j) {
                val = grid[i][j];
                if (val < 1 || val > 9 || ++arr[val] > 1) {
                    return false;
                }
            }
        }
        return grid[x + 1][y + 1] == 5 &&
        grid[x][y] + grid[x][y + 1] + grid[x][y + 2] == 15 &&
        grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2] == 15 &&
        grid[x][y] + grid[x + 1][y] + grid[x + 2][y] == 15 &&
        grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2] == 15;
    }
}
// @lc code=end

