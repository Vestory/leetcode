/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    /**
     * 从头到尾扫描不是0的元素，然后移动到开头即可
     * 21 / 21, 0ms(100%), 37.7MB(95.42%)
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                ++j;
            }
        }
    }

    // 官方题解：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/
    // 其他解法：https://leetcode-cn.com/problems/move-zeroes/solution/javashi-yong-2ge-xia-biao-zhi-zhen-fu-zhi-zui-shao/
    // https://leetcode-cn.com/problems/move-zeroes/solution/shi-jian-fu-za-du-wei-onde-javajie-fa-by-lyl0724-2/
}
// @lc code=end

