import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    /**
     * 277 / 277, 2ms(41.46%), 37.7MB(100%)
     */
    // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //     int len0 = image.length, len1 = image[0].length;
    //     boolean[][] visited = new boolean[len0][len1];
    //     --len0;
    //     --len1;
    //     Queue<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(sr, sc));
    //     Pair cur;
    //     sr = image[sr][sc];
    //     while (!queue.isEmpty()) {
    //         cur = queue.poll();
    //         if (image[cur.x][cur.y] == sr) {
    //             if (!visited[cur.x][cur.y]) {
    //                 visited[cur.x][cur.y] = true;
    //                 image[cur.x][cur.y] = newColor;
    //                 if (cur.x > 0) {
    //                     queue.add(new Pair(cur.x - 1, cur.y));
    //                 }
    //                 if (cur.x < len0) {
    //                     queue.add(new Pair(cur.x + 1, cur.y));
    //                 }
    //                 if (cur.y > 0) {
    //                     queue.add(new Pair(cur.x, cur.y - 1));
    //                 }
    //                 if (cur.y < len1) {
    //                     queue.add(new Pair(cur.x, cur.y + 1));
    //                 }
    //             }
    //         }
    //     }
    //     return image;
    // }
    // class Pair {
    //     int x = 0, y = 0;
    //     public Pair(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }
    // }

    /**
     * 277 / 277, 1ms(100%), 39.4MB(99.03%)
     */
    // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //     int len0 = image.length, len1 = image[0].length;
    //     boolean[][] added = new boolean[len0][len1];
    //     int[] xs = new int[len0 * len1];
    //     int[] ys = new int[len0 * len1];
    //     --len0;
    //     --len1;
    //     xs[0] = sr;
    //     ys[0] = sc;
    //     added[sr][sc] = true;
    //     int l = 0, r = 1, color = image[sr][sc], x, y;
    //     while (l < r) {
    //         sr = xs[l];
    //         sc = ys[l];
    //         image[sr][sc] = newColor;
    //         x = sr - 1;
    //         y = sc;
    //         if (sr > 0 && image[x][y] == color && !added[x][y]) {
    //             xs[r] = x;
    //             ys[r] = y;
    //             added[x][y] = true;
    //             ++r;
    //         }
    //         x += 2;
    //         if (sr < len0 && image[x][y] == color && !added[x][y]) {
    //             xs[r] = x;
    //             ys[r] = y;
    //             added[x][y] = true;
    //             ++r;
    //         }
    //         --x;
    //         --y;
    //         if (sc > 0 && image[x][y] == color && !added[x][y]) {
    //             xs[r] = x;
    //             ys[r] = y;
    //             added[x][y] = true;
    //             ++r;
    //         }
    //         y += 2;
    //         if (sc < len1 && image[x][y] == color && !added[x][y]) {
    //             xs[r] = x;
    //             ys[r] = y;
    //             added[x][y] = true;
    //             ++r;
    //         }
    //         ++l;
    //     }
    //     return image;
    // }

    /**
     * 官方解题
     * 深度优先搜索
     * https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode/
     * 277 / 277, 1ms(100%), 37.1MB(100%)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)
            dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1)
                dfs(image, r - 1, c, color, newColor);
            if (c >= 1)
                dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length)
                dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length)
                dfs(image, r, c + 1, color, newColor);
        }
    }
}
// @lc code=end

