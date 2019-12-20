import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 */

// @lc code=start
class Solution {
    /**
     * 72 / 72, 15ms(83.79%), 39.1MB(94.22%)
     */
    // public int findPairs(int[] nums, int k) {
    //     if (k < 0) {
    //         return 0;
    //     }
    //     HashSet<Integer> set = new HashSet<>();
    //     HashSet<Integer> ignore = new HashSet<>();
    //     int count = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (set.contains(nums[i])) {
    //             if (k == 0 && !ignore.contains(nums[i])) {
    //                 ignore.add(nums[i]);
    //                 ++count;
    //             }
    //             continue;
    //         }
    //         if (set.contains(nums[i] - k)) {
    //             ++count;
    //         }
    //         if (set.contains(nums[i] + k)) {
    //             ++count;
    //         }
    //         set.add(nums[i]);
    //     }
    //     return count;
    // }

    /**
     * 72 / 72, 27ms(50.45%), 39.8MB(92.42%)
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (map.getOrDefault(nums[i], false)) {
                if (k == 0) {
                    map.put(nums[i], false);
                    ++count;
                }
            } else {
                if (map.getOrDefault(nums[i] - k, false)) {
                    ++count;
                }
                if (map.getOrDefault(nums[i] + k, false)) {
                    ++count;
                }
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], true);
                }
            }
        }
        return count;
    }

    /**
     * 其他思路
     * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/solution/532-shu-zu-zhong-de-k-diffshu-dui-by-en-zhao/
     * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/solution/cpai-xu-er-fen-cha-zhao-by-shao-rui-chen-v7vbj73f1/
     * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/solution/532-shu-zu-zhong-de-k-diffshu-dui-c16-lineonlogn-b/
     */
}
// @lc code=end

