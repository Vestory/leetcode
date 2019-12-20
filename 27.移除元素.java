/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */
class Solution {
    /**
     * 113 / 113, 0ms(100%), 35.9MB(84.18%)
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                while (nums[r] == val) {
                    --r;
                    if (l >= r) {
                        return l;
                    }
                }
                nums[l] = nums[r];
                --r;
            }
            ++l;
        }
        return l;
    }

    /**
     * 双指针法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 113 / 113, 1ms(97.16%), 35.8MB(84.18%)
     */
    // public int removeElement(int[] nums, int val) {
    //     int i = 0;
    //     for (int j = 0; j < nums.length; ++j) {
    //         if (nums[j] != val) {
    //             nums[i] = nums[j];
    //             ++i;
    //         }
    //     }
    //     return i;
    // }
}

