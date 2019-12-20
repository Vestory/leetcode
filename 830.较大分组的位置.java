import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
class Solution {
    /**
     * 202 / 202, 2ms(94.51%), 37.9MB(92.7%)
     */
    // public List<List<Integer>> largeGroupPositions(String S) {
    //     char[] arr = S.toCharArray();
    //     int l = 0, r = 1, len = arr.length;
    //     ArrayList<List<Integer>> res = new ArrayList<>();
    //     ArrayList<Integer> list;
    //     while (r < len) {
    //         if (arr[l] != arr[r]) {
    //             if (r - l > 2) {
    //                 list = new ArrayList<Integer>();
    //                 list.add(l);
    //                 list.add(r - 1);
    //                 res.add(list);
    //             }
    //             l = r;
    //         }
    //         ++r;
    //     }
    //     if (r - l > 2) {
    //         list = new ArrayList<Integer>();
    //         list.add(l);
    //         list.add(r - 1);
    //         res.add(list);
    //     }
    //     return res;
    // }

    /**
     * 202 / 202, 2ms(94.51%), 38.2MB(87.08%)
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] arr = S.toCharArray();
        int l = 0, r = 1, len = arr.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list;
        while (r <= len) {
            if (r == len || arr[l] != arr[r]) {
                if (r - l > 2) {
                    list = new ArrayList<Integer>();
                    list.add(l);
                    list.add(r - 1);
                    res.add(list);
                }
                l = r;
            }
            ++r;
        }
        return res;
    }
}
// @lc code=end

