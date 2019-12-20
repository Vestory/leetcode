/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */
class Solution {
    /**
     * 环装替换
     * 时间复杂度O(n)，空间复杂度O(1)
     * 34 /34, 1ms(98.46%), 37.5MB(95.41%)
     */
    // public void rotate(int[] nums, int k) {
    //     k %= nums.length;
    //     int start = 0;
    //     int curr = k;
    //     int count = 0;
    //     int swap = 0;
    //     while (count < nums.length && start < k) {
    //         while (curr != start) {
    //             swap = nums[start];
    //             nums[start] = nums[curr];
    //             nums[curr] = swap;
    //             curr = (curr + k) % nums.length;
    //             ++count;
    //         }
    //         ++start;
    //         ++count;
    //         curr = (start + k) % nums.length;
    //     }
    // }

    /**
     * 穷举法
     * 时间复杂度O(n * k)，空间复杂度O(1)
     * 34 / 34, 106ms(32.01%), 36.7MB(95.45%)
     */
    // public void rotate(int[] nums, int k) {
    //     int temp, pre;
    //     for (int i = 0; i < k; ++i) {
    //         pre = nums[nums.length - 1];
    //         for (int j = 0; j < nums.length; ++j) {
    //             temp = nums[j];
    //             nums[j] = pre;
    //             pre = temp;
    //         }
    //     }
    // }

    /**
     * 使用额外的数组
     * 时间复杂度和空间复杂度均为O(n)
     * 34 / 34, 1ms(98.46%), 36.7MB(95.45%)
     */
    // public void rotate(int[] nums, int k) {
    //     int[] a = new int[nums.length];
    //     for (int i = 0; i < nums.length; ++i) {
    //         a[(i + k) % nums.length] = nums[i];
    //     }
    //     for (int i = 0; i < nums.length; ++i) {
    //         nums[i] = a[i];
    //     }
    // }

    /**
     * 使用反转
     * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 时间复杂度O(n), 空间复杂度O(1)
     * 34 / 34, 0ms(100%), 37.8MB(92.13%)
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}