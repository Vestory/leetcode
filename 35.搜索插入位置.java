/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */
class Solution {
    /**
     * 二分查找法
     * 62 / 62, 1ms(77.64%), 39.1MB(50.91%)
     * 62 / 62, 0ms(100%), 39.4MB(42.57%)
     */
    // public int searchInsert(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int l = 0;
    //     int r = nums.length;
    //     int m = 0;
    //     while (l < r) {
    //         m = (l + r) / 2;
    //         if (nums[m] > target) {
    //             r = m;
    //         } else if (nums[m] < target) {
    //             l = m + 1;
    //         } else {
    //             return m;
    //         }
    //     }
    //     return nums[m] > target ? m : (m + 1);
    // }

    // 还有别的解法，百度搜索：有序表查找
    // 插值查找、斐波那契查找
}

