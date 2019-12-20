/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {

    /**
     * 161 / 161, 2ms(90.72%), 45MB(70.37%)
     */
    // public int removeDuplicates(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int index = 0;
    //     for (int i = 1; i < nums.length; ++i) {
    //         if (nums[i] != nums[index]) {
    //             ++index;
    //             nums[index] = nums[i];
    //         }
    //     }
    //     return index + 1;
    // }

    /**
     * 双指针法，和上面的方法一样
     * 时间复杂度O(n)，空间复杂度O(1)
     * 161 / 161, 1ms(100%), 40.3MB(94.62%)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

