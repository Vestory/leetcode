import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    /**
     * 89 / 89, 6ms(97.58%), 42.2MB(88.33%)
     */
    // public int findShortestSubArray(int[] nums) {
    //     int[] counts = new int[50000];
    //     int[] idx = new int[50000];
    //     int len = nums.length;
    //     int val = nums[0], count = 1, length = 0, temp;
    //     counts[val] = 1;
    //     idx[val] = 1;
    //     for (int i = 1; i < len; ++i) {
    //         if (nums[i] == val) {
    //             ++counts[val];
    //             ++count;
    //             length = i - idx[val] + 1;
    //         } else {
    //             if (idx[nums[i]] == 0) {
    //                 idx[nums[i]] = i + 1;
    //                 ++counts[nums[i]];
    //                 continue;
    //             }
    //             if (++counts[nums[i]] > count) {
    //                 val = nums[i];
    //                 ++count;
    //                 length = i - idx[val] + 1;
    //             } else if (counts[nums[i]] == count) {
    //                 temp = i - idx[nums[i]] + 1;
    //                 if (temp < length) {
    //                     val = nums[i];
    //                     length = temp;
    //                 }
    //             }
    //         }
    //     }
    //     return length + 1;
    // }

    /**
     * 89 / 89, 11ms(95.16%), 40.7MB(93.33%)
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int val = nums[0], count = 1, length = 0, temp, len = nums.length;
        map.put(nums[0], new Pair(1, 0));
        Pair cur;
        for (int i = 1; i < len; ++i) {
            if (nums[i] == val) {
                cur = map.get(val);
                ++cur.count;
                ++count;
                length = i - cur.idx;
            } else {
                cur = map.getOrDefault(nums[i], null);
                if (cur == null) {
                    map.put(nums[i], new Pair(1, i));
                    continue;
                }
                if (++cur.count > count) {
                    val = nums[i];
                    ++count;
                    length = i - cur.idx;
                } else if (cur.count == count) {
                    temp = i - cur.idx;
                    if (temp < length) {
                        val = nums[i];
                        length = temp;
                    }
                }
            }
        }
        return length + 1;
    }
    class Pair {
        public int count = 0;
        public int idx = 0;
        public Pair(int count, int idx) {
            this.count = count;
            this.idx = idx;
        }
    }
}
// @lc code=end

