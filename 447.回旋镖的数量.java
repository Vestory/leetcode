import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
class Solution {
    /**
     * 31 / 31, 98ms(73.15%), 41MB(99.1%)
     */
    // public int numberOfBoomerangs(int[][] points) {
    // int len = points.length, dx, dy, count = 0;
    // HashMap<Integer, Integer> map = new HashMap<>();
    // Iterator<Integer> iterator = null;
    // for (int i = 0; i < len; ++i) {
    // map.clear();
    // for (int j = 0; j < len; ++j) {
    // if (i == j) {
    // continue;
    // }
    // dx = points[i][0] - points[j][0];
    // dy = points[i][1] - points[j][1];
    // dx = dx * dx + dy * dy;
    // map.put(dx, map.getOrDefault(dx, 0) + 1);
    // }
    // iterator = map.values().iterator();
    // while (iterator.hasNext()) {
    // dx = iterator.next();
    // count += dx * (dx - 1);
    // }
    // }
    // return count;
    // }

    /**
     * 31 / 31, 126ms(65.76%), 41MB(99.1%) 更慢了
     */
    // public int numberOfBoomerangs(int[][] points) {
    // int len = points.length, dx, dy, count = -1;
    // int[] dis = new int[len * (len - 1) / 2];
    // for (int i = 0; i < len; ++i) {
    // for (int j = i + 1; j < len; ++j) {
    // dx = points[i][0] - points[j][0];
    // dy = points[i][1] - points[j][1];
    // dis[++count] = dx * dx + dy * dy;
    // }
    // }
    // count = 0;
    // HashMap<Integer, Integer> map = new HashMap<>();
    // Iterator<Integer> iterator = null;
    // for (int i = 0; i < len; ++i) {
    // map.clear();
    // for (int j = 0; j < len; ++j) {
    // if (i == j) {
    // continue;
    // }
    // if (i < j) {
    // dx = i;
    // dy = j;
    // } else {
    // dx = j;
    // dy = i;
    // }
    // dx = dis[(2 * len - 1 - dx) * dx / 2 + dy - dx - 1];
    // map.put(dx, map.getOrDefault(dx, 0) + 1);
    // }
    // iterator = map.values().iterator();
    // while (iterator.hasNext()) {
    // dx = iterator.next();
    // count += dx * (dx - 1);
    // }
    // }
    // return count;
    // }

    // https://leetcode-cn.com/problems/number-of-boomerangs/solution/447-hui-xuan-biao-de-shu-liang-by-en-zhao/
}
// @lc code=end
