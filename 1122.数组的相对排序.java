import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    /**
     * 16 / 16, 4ms(35.04%), 36MB(100%)
     */
    // public int[] relativeSortArray(int[] arr1, int[] arr2) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i : arr2) {
    //         map.put(i, 0);
    //     }
    //     for (int i : arr1) {
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
    //     int idx = 0, count;
    //     for (int i : arr2) {
    //         count = map.get(i);
    //         map.remove(i);
    //         for (int j = 0; j < count; ++j) {
    //             arr1[idx] = i;
    //             ++idx;
    //         }
    //     }
    //     int[] rest = new int[map.size()];
    //     count = 0;
    //     for (int i : map.keySet()) {
    //         rest[count] = i;
    //         ++count;
    //     }
    //     Arrays.sort(rest);
    //     for (int i : rest) {
    //         count = map.get(i);
    //         for (int j = 0; j < count; ++j) {
    //             arr1[idx] = i;
    //             ++idx;
    //         }
    //     }
    //     return arr1;
    // }

    /**
     * https://leetcode-cn.com/problems/relative-sort-array/solution/java-chuang-jian-yi-ge-mapji-lu-arr1zhong-de-zhi-d/
     * 16 / 16, 0ms(100%), 36.1MB(100%)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        int[] ref = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }
        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }
}
// @lc code=end

