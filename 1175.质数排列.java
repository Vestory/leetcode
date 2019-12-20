/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    /**
     * 步骤：
     * 1、求出质数数量和非质数数量
     * 2、全排列
     * 3、问题是大数，会越界
     * https://leetcode-cn.com/problems/prime-arrangements/solution/javajian-ji-ban-ji-you-hua-by-dreshadow/
     * 100 / 100, 1ms(96.09%), 33.1MB(100%)
     */
    public int numPrimeArrangements(int n) {
        if (n < 3)
            return 1;
        int count = 0;
        boolean[] nums = new boolean[n + 1];
        for (int i = 2; i * i < nums.length; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < nums.length; j += i) {
                    if (nums[j])
                        continue;
                    nums[j] = true;
                    count++;
                }
            }
        }
        // 非质数的数量(加1：元素1不包含在内)
        count++;

        // 8以内的质数个数多于非质数
        if (n < 8)
            count = n - count;

        // 结果
        long res = 1;
        for (int i = 2; i <= count; i++) {
            res = (res * i) % 1000000007;
            // 这里判断会减少一轮遍历
            if (i == n - count) {
                res = (res * res) % 1000000007;
            }
        }
        return (int) res;
    }
}
// @lc code=end

