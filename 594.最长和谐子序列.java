import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    /**
     * 201 / 201, 40ms(66.85%), 39.4MB(96.08%)
     */
    // public int findLHS(int[] nums) {
    //     int len = nums.length;
    //     if (len < 2) {
    //         return 0;
    //     }
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < len; ++i) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }
    //     Iterator<Integer> iterator = map.keySet().iterator();
    //     len = -1;
    //     while (iterator.hasNext()) {
    //         nums[++len] = iterator.next();
    //     }
    //     ++len;
    //     Arrays.sort(nums, 0, len);
    //     int res = 0, temp;
    //     for (int i = 1; i < len; ++i) {
    //         if (Math.abs(nums[i] - nums[i - 1]) < 2) {
    //             temp = map.get(nums[i]) + map.get(nums[i - 1]);
    //             if (temp > res) {
    //                 res = temp;
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 201 / 201, 36ms(86.31%), 39.7MB(96.08%)
     * https://leetcode-cn.com/problems/longest-harmonious-subsequence/solution/java-shi-yong-map-by-zxy0917-6/
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0, sum = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                sum = map.get(key) + map.get(key + 1);
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
// @lc code=end

