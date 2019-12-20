import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    /**
     * 排序找出最大的三个数和最小的两个数
     * 83 / 83, 17ms(68.11%), 38.7MB(97.52%)
     */
    // public int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);
    //     int len = nums.length;
    //     int v0 = nums[len - 1] * nums[len - 2] * nums[len - 3];
    //     int v1 = nums[0] * nums[1] * nums[len - 1];
    //     return v0 > v1 ? v0 : v1;
    // }

    /**
     * 找最大的三个数和最小的两个数
     * 83 / 83, 4ms(89.41%), 39.6MB(97.27%)
     */
    // public int maximumProduct(int[] nums) {
    //     int len = nums.length;
    //     if (len == 3) {
    //         return nums[0] * nums[1] * nums[2];
    //     }
    //     int[] arr = new int[5];
    //     arr[2] = -1001;
    //     if (nums[0] > nums[1]) {
    //         arr[0] = nums[0];
    //         arr[1] = nums[1];
    //         arr[3] = nums[1];
    //         arr[4] = nums[0];
    //     } else {
    //         arr[0] = nums[1];
    //         arr[1] = nums[0];
    //         arr[3] = nums[0];
    //         arr[4] = nums[1];
    //     }
    //     for (int i = 2; i < len; ++i) {
    //         if (nums[i] > arr[0]) {
    //             arr[2] = arr[1];
    //             arr[1] = arr[0];
    //             arr[0] = nums[i];
    //         } else if (nums[i] > arr[1]) {
    //             arr[2] = arr[1];
    //             arr[1] = nums[i];
    //         } else if (nums[i] > arr[2]) {
    //             arr[2] = nums[i];
    //         } else if (nums[i] < arr[3]) {
    //             arr[4] = arr[3];
    //             arr[3] = nums[i];
    //         } else if (nums[i] < arr[4]) {
    //             arr[4] = nums[i];
    //         }
    //     }
    //     len = arr[0] * arr[1] * arr[2];
    //     int temp = arr[0] * arr[3] * arr[4];
    //     return len > temp ? len : temp;
    // }

    /**
     * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcode/
     * 83 / 83, 3ms(98.59%), 38.3MB(98.02%)
     */
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
// @lc code=end

