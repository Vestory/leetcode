/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    /**
     * 双指针
     * 证明：https://leetcode-cn.com/problems/container-with-most-water/solution/shuang-zhi-zhen-fa-zheng-que-xing-zheng-ming-by-r3/
     * 时间复杂度O(n), 空间复杂度O(1) 50 / 50, 3ms(98.64%), 39.6MB(93.04%)
     */
    // public int maxArea(int[] height) {
    //     int l = 0, r = height.length - 1, temp, res = 0;
    //     while (l < r) {
    //         temp = Math.min(height[l], height[r]) * (r - l);
    //         if (temp > res) {
    //             res = temp;
    //         }
    //         if (height[l] < height[r]) {
    //             ++l;
    //         } else {
    //             --r;
    //         }
    //     }
    //     return res;
    // }

    /**
     * 暴力法
     * 时间复杂度O(n * n), 空间复杂度O(1)
     * 50 / 50, 290ms(33.92%), 39.8MB(92.56$)
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
}
// @lc code=end

