import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    /**
     * 17 / 17, 6ms(67.85%), 37.3MB(70.84%)
     */
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int j, len1 = nums1.length, len2 = nums2.length;
    //     for (int i = 0; i < len1; ++i) {
    //         j = 0;
    //         while (nums1[i] != nums2[j]) {
    //             ++j;
    //         }
    //         while (j < len2) {
    //             if (nums1[i] < nums2[j]) {
    //                 break;
    //             }
    //             ++j;
    //         }
    //         nums1[i] = j == len2 ? -1 : nums2[j];
    //     }
    //     return nums1;
    // }

    /**
     * 17 / 17, 10ms(41.46%), 36.3MB(91.96%)
     */
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int len1 = nums1.length, len2 = nums2.length, j;
    //     for (int i = 1; i < len1; ++i) {
    //         map.put(nums1[i], -1);
    //     }
    //     for (int i = 0; i < len1; ++i) {
    //         j = map.getOrDefault(nums1[i], -1);
    //         map.remove(nums1[i]);
    //         if (j == -1) {
    //             j = 0;
    //             while (nums1[i] != nums2[j]) {
    //                 if (map.containsKey(nums2[j])) {
    //                     map.put(nums2[j], j);
    //                 }
    //                 ++j;
    //             }
    //         }
    //         while (j < len2) {
    //             if (map.containsKey(nums2[j])) {
    //                 map.put(nums2[j], j);
    //             }
    //             if (nums1[i] < nums2[j]) {
    //                 break;
    //             }
    //             ++j;
    //         }
    //         nums1[i] = j == len2 ? -1 : nums2[j];
    //     }
    //     return nums1;
    // }

    /**
     * 17 / 17, 4ms(91.36%), 37.3MB(70.28%)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length, len2 = nums2.length, j;
        for (int i = 0; i < len1; ++i) {
            map.put(nums1[i], -1);
        }
        for (int i = 0; i < len2; ++i) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], i);
            }
        }
        for (int i = 0; i < len1; ++i) {
            j = map.get(nums1[i]) + 1;
            while (j < len2) {
                if (nums1[i] < nums2[j]) {
                    break;
                }
                ++j;
            }
            nums1[i] = j == len2 ? -1 : nums2[j];
        }
        return nums1;
    }

    /**
     * 其他解法
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
     *
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/java-bao-li-suan-fa-3-ms-367-mb-by-onlya/
     */
}
// @lc code=end

