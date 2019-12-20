import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1237 lang=java
 *
 * [1237] 找出给定方程的正整数解
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    /**
     * 45 / 45, 1ms(100%), 34.2MB(100%)
     */
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int x = 1, y = 1, temp;
        while (customfunction.f(x, y) < z) {
            ++y;
        }
        ArrayList<Integer> list;
        while (x <= y) {
            temp = customfunction.f(x, y);
            if (temp == z) {
                list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
                ++x;
                --y;
            } else if (temp > z) {
                --y;
            } else {
                ++x;
            }
        }
        x = 1;
        y = 1;
        while (customfunction.f(x, y) < z) {
            ++x;
        }
        while (x >= y) {
            temp = customfunction.f(x, y);
            if (temp == z && x != y) {
                list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
                --x;
                ++y;
            } else if (temp > z) {
                --x;
            } else {
                ++y;
            }
        }
        return res;
    }
}
// @lc code=end

