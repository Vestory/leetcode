/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    /**
     * 26 / 26, 1ms(100%), 38.3MB(64.37%)
     */
    // public int thirdMax(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     } else if (nums.length == 1) {
    //         return nums[0];
    //     } else if (nums.length == 2) {
    //         return Math.max(nums[0], nums[1]);
    //     }
    //     int[] res = new int[3];
    //     if (nums[0] > nums[1]) {
    //         res[0] = nums[0];
    //         res[1] = nums[1];
    //     } else {
    //         res[0] = nums[1];
    //         res[1] = nums[0];
    //     }
    //     if (nums[2] > res[0]) {
    //         res[2] = res[1];
    //         res[1] = res[0];
    //         res[0] = nums[2];
    //     } else if (nums[2] > res[1]) {
    //         res[2] = res[1];
    //         res[1] = nums[2];
    //     } else {
    //         res[2] = nums[2];
    //     }
    //     for (int i = 3; i < nums.length; ++i) {
    //         if (nums[i] != res[0] && nums[i] != res[1] && nums[i] != res[2]) {
    //             if (nums[i] >= res[0]) {
    //                 res[2] = res[1];
    //                 res[1] = res[0];
    //                 res[0] = nums[i];
    //             } else if (nums[i] > res[1]) {
    //                 res[2] = res[1];
    //                 res[1] = nums[i];
    //             } else if (nums[i] > res[2]) {
    //                 if (res[0] == res[1]) {
    //                     res[1] = nums[i];
    //                 } else {
    //                     res[2] = nums[i];
    //                 }
    //             } else if (res[1] == res[2]) {
    //                 res[2] = nums[i];
    //             }
    //         }
    //     }
    //     if (res[0] == res[1] || res[1] == res[2]) {
    //         return res[0];
    //     } else {
    //         return res[2];
    //     }
    // }

    /**
     * https://leetcode-cn.com/problems/third-maximum-number/solution/414di-san-da-de-shu-by-mikeoperfect/
     */
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int) first : (int) third;
    }
}
// @lc code=end
