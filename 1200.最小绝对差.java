import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    /**
     * 36 / 36, 33ms(20.65%), 52MB(100%)
     */
    // public List<List<Integer>> minimumAbsDifference(int[] arr) {
    //     Arrays.sort(arr);
    //     int minDif = Integer.MAX_VALUE, len = arr.length, cur;
    //     for (int i = 1; i < len; ++i) {
    //         cur = arr[i] - arr[i - 1];
    //         if (minDif > cur) {
    //             minDif = cur;
    //         }
    //     }
    //     List<List<Integer>> res = new ArrayList<>();
    //     ArrayList<Integer> pair;
    //     for (int i = 1; i < len; ++i) {
    //         cur = arr[i] - arr[i - 1];
    //         if (cur == minDif) {
    //             pair = new ArrayList<>();
    //             pair.add(arr[i - 1]);
    //             pair.add(arr[i]);
    //             res.add(pair);
    //         }
    //     }
    //     return res;
    // }

    /**
     * 36 / 36, 25ms(92.82%), 51.1MB(100%)
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDif = Integer.MAX_VALUE, len = arr.length, cur;
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> pair;
        for (int i = 1; i < len; ++i) {
            cur = arr[i] - arr[i - 1];
            if (cur < minDif) {
                res.clear();
                minDif = cur;
            }
            if (cur == minDif) {
                pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }
        return res;
    }
}
// @lc code=end

