/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */
class Solution {
    /**
     * 双指针法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 17 / 17, 1ms(99.85%), 37.4MB(83.53%)
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, temp;
        while (l < r) {
            temp = numbers[l] + numbers[r];
            if (temp > target) {
                --r;
            } else if (temp < target) {
                ++l;
            } else {
                ++l;
                ++r;
                return new int[] {l, r};
            }
        }
        return new int[] {0, 0};
    }

    // 其他方法，二分法，时间复杂度O(nlogn)
    // https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/python-liang-chong-fang-fa-by-ljt-4/
}

