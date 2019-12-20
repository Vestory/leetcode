/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
    /**
     * 穷举法 202 / 202, 104ms(6.06%), 39MB(79.32%)
     */
    // public int maxSubArray(int[] nums) {
    // int max = nums[0];
    // int sum = 0;
    // for (int i = 0; i < nums.length; ++i) {
    // sum = 0;
    // for (int j = i; j < nums.length; ++j) {
    // sum += nums[j];
    // if (sum > max) {
    // max = sum;
    // }
    // }
    // }
    // return max;
    // }

    /**
     * 动态规划 时间复杂度O(n) 202 / 202, 1ms(99.95%), 39.2MB(76.08%)
     */
    // public int maxSubArray(int[] nums) {
    // int max = nums[0];
    // int sum = 0;
    // for (int i = 0; i < nums.length; ++i) {
    // if (sum > 0) {
    // sum += nums[i];
    // } else {
    // sum = nums[i];
    // }
    // max = Math.max(max, sum);
    // }
    // return max;
    // }

    /**
     * 动态规划，这种方法和上一种方法是一样的 202 / 202, 1ms(99.95%), 38.2MB(86.42%)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    /** python的分治实现 */
    // def maxSubArray(self, nums: List[int]) -> int:
    // n = len(nums)
    // #递归终止条件
    // if n == 1:
    // return nums[0]
    // else:
    // #递归计算左半边最大子序和
    // max_left = self.maxSubArray(nums[0:len(nums) // 2])
    // #递归计算右半边最大子序和
    // max_right = self.maxSubArray(nums[len(nums) // 2:len(nums)])
    // #计算中间的最大子序和，从右到左计算左边的最大子序和，从左到右计算右边的最大子序和，再相加
    // max_l = nums[len(nums) // 2 - 1]
    // tmp = 0
    // for i in range(len(nums) // 2 - 1, -1, -1):
    // tmp += nums[i]
    // max_l = max(tmp, max_l)
    // max_r = nums[len(nums) // 2]
    // tmp = 0
    // for i in range(len(nums) // 2, len(nums)):
    // tmp += nums[i]
    // max_r = max(tmp, max_r)
    // #返回三个中的最大值
    // return max(max_right,max_left,max_l+max_r)

    // 作者：pandawakaka
    // 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/bao-li-qiu-jie-by-pandawakaka/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
