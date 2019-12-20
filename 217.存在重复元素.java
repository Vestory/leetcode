import java.util.Arrays;
import java.util.HashMap;
/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    /**
     * 哈希表
     * 18 / 18, 12ms(73.59%), 42.7MB(91.92%)
     */
    // public boolean containsDuplicate(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (map.containsKey(nums[i])) {
    //             return true;
    //         } else {
    //             map.put(nums[i], i);
    //         }
    //     }
    //     return false;
    // }

    /**
     * 排序，然后检测相邻元素
     * 18 / 18, 4ms(98.06%), 41.8MB(94.20%)
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // 其他解法
    // https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
}
// @lc code=end

