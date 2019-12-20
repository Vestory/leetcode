/*
 * @lc app=leetcode.cn id=1042 lang=java
 *
 * [1042] 不邻接植花
 */

// @lc code=start
class Solution {
    /**
     * 51 / 51, 6ms(100%), 45.2MB(100%)
     */
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[][] rela = new int[N][4];
        int x, y;
        for (int[] arr : paths) {
            x = arr[0] - 1;
            y = arr[1] - 1;
            ++rela[x][0];
            rela[x][rela[x][0]] = y;
            ++rela[y][0];
            rela[y][rela[y][0]] = x;
        }
        int[] res = new int[N];
        boolean[] deny = new boolean[5];
        for (int i = 0; i < N; ++i) {
            for (int j = 1; j <= rela[i][0]; ++j) {
                deny[res[rela[i][j]]] = true;
            }
            for (int j = 1; j < 5; ++j) {
                if (deny[j]) {
                    deny[j] = false;
                } else {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
// @lc code=end

