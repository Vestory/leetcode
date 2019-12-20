import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution {
    /**
     * 数学方法，可以参考
     * https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
     * 122 / 122, 1ms(99.01%), 38.2MB(99%)
     */
    // public int missingNumber(int[] nums) {
    //     int sum = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         sum += nums[i];
    //     }
    //     return nums.length * (nums.length + 1) / 2 - sum;
    // }

    // #region [0] 其他方法
    // https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
    /**
     * 排序
     * 时间复杂度O(nlogn)，空间复杂度O(1)或O(n)
     * 122 / 122, 11ms(24.65%), 39.1MB(97.34%)
     */
    // public int missingNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     // 判断n是否出现在末位
    //     if (nums[nums.length - 1] != nums.length) {
    //         return nums.length;
    //     }
    //     // 判断n是否出现在首位
    //     if (nums[0] != 0) {
    //         return 0;
    //     }
    //     // 此时缺少的数字就在0和n之间
    //     for (int i = 1; i < nums.length; ++i) {
    //         int temp = nums[i - 1] + 1;
    //         if (nums[i] != temp) {
    //             return temp;
    //         }
    //     }
    //     // 保证函数有返回值（未找到）
    //     return -1;
    // }

    /**
     * 哈希表
     * 时间复杂度O(n), 空间复杂度O(n)
     * 122 / 122, 12ms(23.69%), 40MB(95.01%)
     */
    // public int missingNumber(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         set.add(num);
    //     }
    //     int count = nums.length + 1;
    //     for (int i = 0; i < count; ++i) {
    //         if (!set.contains(i)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    /**
     * 位运算
     * 时间复杂度O(n)，空间复杂度O(1)
     * 122 / 122, 1ms(99.01%), 38.7MB(98.17%)
     */
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    // #endregion
}
// @lc code=end

