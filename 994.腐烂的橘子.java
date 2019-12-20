import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    /**
     * 303 / 303, 8ms(12.65%), 36.4MB(89.61%)
     */
    // public int orangesRotting(int[][] grid) {
    //     int ones = 0, len = 0, lr = grid.length, lc = grid[0].length;
    //     int[][] twos = new int[lr * lc][2];
    //     for (int i = 0; i < lr; ++i) {
    //         for (int j = 0; j < lc; ++j) {
    //             switch (grid[i][j]) {
    //             case 1:
    //                 ++ones;
    //                 break;
    //             case 2:
    //                 twos[len][0] = i;
    //                 twos[len][1] = j;
    //                 ++len;
    //                 break;
    //             default:
    //                 break;
    //             }
    //             grid[i][j] -= 2;
    //         }
    //     }
    //     if (ones == 0) {
    //         return 0;
    //     } else if (len == 0) {
    //         return -1;
    //     }
    //     Queue<Integer> xq = new LinkedList<>();
    //     Queue<Integer> yq = new LinkedList<>();
    //     Set<Integer> set = new HashSet<>();
    //     int x, y, cnt = 0, val, min = 0;
    //     for (int i = 0; i < len; ++i) {
    //         xq.add(twos[i][0]);
    //         yq.add(twos[i][1]);
    //         while (!xq.isEmpty()) {
    //             x = xq.poll();
    //             y = yq.poll();
    //             set.add(x * lc + y);
    //             val = grid[x][y];
    //             if (val == -1) {
    //                 ++cnt;
    //                 min = Integer.MAX_VALUE;
    //             } else if (val > 0) {
    //                 min = val - 1;
    //             }
    //             if (x > 0) {
    //                 val = grid[x - 1][y];
    //                 if ((val > 0 || val == -1) && !set.contains((x - 1) * lc + y)) {
    //                     xq.add(x - 1);
    //                     yq.add(y);
    //                 }
    //                 if (val >= 0 && min > val) {
    //                     min = val;
    //                 }
    //             }
    //             if (x < lr - 1) {
    //                 val = grid[x + 1][y];
    //                 if ((val > 0 || val == -1) && !set.contains((x + 1) * lc + y)) {
    //                     xq.add(x + 1);
    //                     yq.add(y);
    //                 }
    //                 if (val >= 0 && min > val) {
    //                     min = val;
    //                 }
    //             }
    //             if (y > 0) {
    //                 val = grid[x][y - 1];
    //                 if ((val > 0 || val == -1) && !set.contains(x * lc + y - 1)) {
    //                     xq.add(x);
    //                     yq.add(y - 1);
    //                 }
    //                 if (val >= 0 && min > val) {
    //                     min = val;
    //                 }
    //             }
    //             if (y < lc - 1) {
    //                 val = grid[x][y + 1];
    //                 if ((val > 0 || val == -1) && !set.contains(x * lc + y + 1)) {
    //                     xq.add(x);
    //                     yq.add(y + 1);
    //                 }
    //                 if (val >= 0 && min > val) {
    //                     min = val;
    //                 }
    //             }
    //             if (grid[x][y] == -1 || grid[x][y] > 0) {
    //                 grid[x][y] = min + 1;
    //             }
    //         }
    //         xq.clear();
    //         yq.clear();
    //         set.clear();
    //     }
    //     if (cnt < ones) {
    //         return -1;
    //     }
    //     len = 0;
    //     for (int i = 0; i < lr; ++i) {
    //         for (int j = 0; j < lc; ++j) {
    //             if (grid[i][j] > len) {
    //                 len = grid[i][j];
    //             }
    //         }
    //     }
    //     return len;
    // }

    /**
     * https://leetcode-cn.com/problems/rotting-oranges/solution/java-2ms-100-by-adidas/
     * 303 / 303, 2ms(99.83%), 39.1MB(73.37%)
     */
    int grid[][];
    int r;
    int l;
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0)
            return -1;
        this.r = grid.length;
        this.l = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) { // 烂橘子开始传染病毒
                    dps(i, j, 2);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1; // 有新鲜的橘子
                max = Math.max(grid[i][j], max); // 找到烂的 最久的橘子
            }
        }
        return max == 0 ? max : max - 2;
    }

    public void dps(int i, int j, int val) {
        grid[i][j] = val; // 判断周围是新鲜的橘子或者是烂得更慢的橘子

        if (i > 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] - grid[i][j] > 1)) {
            dps(i - 1, j, 1 + val);
        }
        if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] - grid[i][j] > 1)) {
            dps(i, j - 1, 1 + val);
        }
        if (i < r - 1 && (grid[i + 1][j] == 1 || grid[i + 1][j] - grid[i][j] > 1)) {
            dps(i + 1, j, 1 + val);
        }
        if (j < l - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] - grid[i][j] > 1)) {
            dps(i, j + 1, 1 + val);
        }
    }
}
// @lc code=end
