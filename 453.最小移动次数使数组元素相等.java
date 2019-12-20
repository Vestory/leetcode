/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */

// @lc code=start
class Solution {
    /**
     * 假设以一个比nums中的元素都大（或等于其最大值）的数z为标准值，有公式
     * y = a * b - c
     * 其中y为结果，a为数组nums的长度，b是z与nums中元素的最大差值，c是nums中每个元素与z之间的差值的总和
     * 如果z比nums中的最大值小，那么上述公式需要进行转换
     * 如果取nums中的最大值为z，那么就可以：
     * 先找出最大值和最小值，然后计算c的值，最后就可以得出结果
     */
    // public int minMoves(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int l = nums[0], r = l, len = nums.length;
    //     for (int i = 0; i < len; ++i) {
    //         if (nums[i] < l) {
    //             l = nums[i];
    //         } else if (nums[i] > r) {
    //             r = nums[i];
    //         }
    //     }
    //     int count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         count += (r - nums[i]);
    //     }
    //     return len * (r - l) - count;
    // }

    /**
     * 使用一个大于nums中的最大值的值作为标准值
     * 84 / 84, 2ms(100%), 39.6MB(92.7%)
     */
    // public int minMoves(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int l = nums[0], len = nums.length;
    //     long count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (nums[i] < l) {
    //             l = nums[i];
    //         }
    //         count += Integer.MAX_VALUE - nums[i];
    //     }
    //     return (int)(len * (Integer.MAX_VALUE - l) - count);
    // }

    /**
     * 取0为标准值，不知z会比最大值小还是大，然后完成校正
     * 84 / 84, 2ms(100%), 40MB(92.13%)
     */
    // public int minMoves(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int l = nums[0], r = l, len = nums.length, count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (nums[i] < l) {
    //             l = nums[i];
    //         } else if (nums[i] > r) {
    //             r = nums[i];
    //         }
    //         // 相当于count = count + (0 - nums[i])
    //         count -= nums[i];
    //     }
    //     // return len * (r - l) - count - len * r;
    //     return -(len * l + count);
    // }

    /**
     * 其他思路
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
     */
}
// @lc code=end

