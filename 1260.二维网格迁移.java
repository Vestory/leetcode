import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    /**
     * 107 / 107, 5ms(98.28%), 40.2MB(100%)
     */
    // public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     int n = grid.length, m = grid[0].length, rows, cols, l, idx;
    //     k %= n * m;
    //     rows = k / m;
    //     cols = k % m;
    //     k = n - rows - 1;
    //     l = m - cols;
    //     List<Integer> list;
    //     for (int i = k; i < n; ++i) {
    //         list = new ArrayList<>();
    //         for (int j = l; j < m; ++j) {
    //             list.add(grid[i][j]);
    //         }
    //         res.add(list);
    //     }
    //     for (int i = 0; i < k; ++i) {
    //         list = new ArrayList<>();
    //         for (int j = l; j < m; ++j) {
    //             list.add(grid[i][j]);
    //         }
    //         res.add(list);
    //     }
    //     ++k;
    //     idx = 0;
    //     for (int i = k; i < n; ++i) {
    //         list = res.get(idx);
    //         for (int j = 0; j < l; ++j) {
    //             list.add(grid[i][j]);
    //         }
    //         ++idx;
    //     }
    //     for (int i = 0; i < k; ++i) {
    //         list = res.get(idx);
    //         for (int j = 0; j < l; ++j) {
    //             list.add(grid[i][j]);
    //         }
    //         ++idx;
    //     }
    //     return res;
    // }

    /**
     * 107 / 107, 5ms(98.28%), 40.2MB(100%)
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = grid.length, m = grid[0].length, l, o;
        k %= n * m;
        l = k / m;
        o = k % m;
        k = n - l - 1;
        l = m - o;
        List<Integer> list;
        for (int i = k; i < n; ++i) {
            list = new ArrayList<>();
            for (int j = l; j < m; ++j) {
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        for (int i = 0; i < k; ++i) {
            list = new ArrayList<>();
            for (int j = l; j < m; ++j) {
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        ++k;
        o = 0;
        for (int i = k; i < n; ++i) {
            list = res.get(o);
            for (int j = 0; j < l; ++j) {
                list.add(grid[i][j]);
            }
            ++o;
        }
        for (int i = 0; i < k; ++i) {
            list = res.get(o);
            for (int j = 0; j < l; ++j) {
                list.add(grid[i][j]);
            }
            ++o;
        }
        return res;
    }
}
// @lc code=end

