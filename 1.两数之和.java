import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    /**
     * 穷举法 时间复杂度O(n^2)，空间复杂度O(1) 29 / 29, 60ms(24.36%), 37.8MB(82.06%)
     */
    // public int[] twoSum(int[] nums, int target) {
    // for (int i = 0; i < nums.length - 1; ++i) {
    // for (int j = i + 1; j < nums.length; ++j) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] {i, j};
    // }
    // }
    // }
    // return null;
    // }

    /**
     * 两遍哈希表 时间复杂度O(n)，空间复杂度O(n) 29 / 29, 9ms(69.19%), 39.2MB(46.03%)
     */
    // public int[] twoSum(int[] nums, int target) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < nums.length; ++i) {
    // map.put(nums[i], i);
    // }
    // int value = 0;
    // for (int i = 0; i < nums.length; ++i) {
    // value = target - nums[i];
    // if (map.containsKey(value) && map.get(value) != i) {
    // return new int[] { i, map.get(value) };
    // }
    // }
    // return null;
    // }

    /**
     * 一遍哈希表 时间复杂度O(n)，空间复杂度O(n) 29 / 29, 8ms(79.17%), 40.3MB(32.02%)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int value = 0;
        for (int i = 0; i < nums.length; ++i) {
            value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != i) {
                return new int[] { i, map.get(value) };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
