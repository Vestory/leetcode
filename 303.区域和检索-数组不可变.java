import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    // #region [0] 官方解答
    // https://leetcode-cn.com/problems/range-sum-query-immutable/solution/qu-yu-he-jian-suo-shu-zu-bu-ke-bian-by-leetcode/
    /**
     * 暴力法
     * 时间复杂度O(n), 空间复杂度O(1)
     * 16 / 16, 276ms(16.07%), 61.1MB(16.63%)
     */
    // private int[] data;
    // public NumArray(int[] nums) {
    //     data = nums;
    // }

    // public int sumRange(int i, int j) {
    //     int sum = 0;
    //     while (i <= j) {
    //         sum += data[i];
    //         ++i;
    //     }
    //     return sum;
    // }

    /**
     * 缓存
     * 时间复杂度O(1), 空间复杂度O(n * n)
     */
    // private HashMap<Integer, Integer> map = new HashMap<>();
    // public NumArray(int[] nums) {
    //     for (int i = 0; i < nums.length; ++i) {
    //         int sum = 0;
    //         for (int j = i; j < nums.length; ++j) {
    //             sum += nums[j];
    //             map.put(Pair.create(i ,j), sum);
    //         }
    //     }
    // }

    // public int sumRange(int i, int j) {
    //     return map.get(Pair.create(i, j));
    // }

    /**
     * 缓存
     * 时间复杂度O(1)，空间复杂度O(n)
     * 16 / 16, 66ms(97.81%), 42MB(94.92%)
     */
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    // #endregion
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

