import java.util.HashMap;
/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    /**
     * 哈希表 23 / 23, 12ms(95.92%), 44.3MB(67.20%)
     */
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
    //             return true;
    //         }
    //         map.put(nums[i], i);
    //     }
    //     return false;
    // }

    /**
     * 另一种思路
     * 维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
     * 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字 时间复杂度：O(n)，n为数组长度
     * https://leetcode-cn.com/problems/contains-duplicate-ii/solution/hua-jie-suan-fa-219-cun-zai-zhong-fu-yuan-su-ii-by/
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // 其他解法
    // https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
}
// @lc code=end

