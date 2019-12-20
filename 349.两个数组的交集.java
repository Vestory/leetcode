import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    /**
     * 60 / 60, 3ms(97.32%), 36.2MB(80.1%)
     */
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     HashSet<Integer> set = new HashSet<>();
    //     int i = 0, j = 0;
    //     while (i < nums1.length) {
    //         set.add(nums1[i]);
    //         ++i;
    //     }
    //     i = 0;
    //     while (i < nums2.length) {
    //         if (set.contains(nums2[i])) {
    //             set.remove(nums2[i]);
    //             nums2[j] = nums2[i];
    //             ++j;
    //         }
    //         ++i;
    //     }
    //     i = 0;
    //     int[] res = new int[j];
    //     while (i < j) {
    //         res[i] = nums2[i];
    //         ++i;
    //     }
    //     return res;
    // }

    // #region [0] 官方解答
    // https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode/

    /**
     * 两个set
     * 60 / 60, 4ms(92.61%), 36.3MB(73.27%)
     */
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s))
                output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1)
            set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2)
            set2.add(n);

        if (set1.size() < set2.size())
            return set_intersection(set1, set2);
        else
            return set_intersection(set2, set1);
    }

    /**
     * 内置函数
     * 60 / 60, 4ms(92.61%), 36.3MB(69.93%)
     */
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     HashSet<Integer> set1 = new HashSet<Integer>();
    //     for (Integer n : nums1)
    //         set1.add(n);
    //     HashSet<Integer> set2 = new HashSet<Integer>();
    //     for (Integer n : nums2)
    //         set2.add(n);

    //     set1.retainAll(set2);

    //     int[] output = new int[set1.size()];
    //     int idx = 0;
    //     for (int s : set1)
    //         output[idx++] = s;
    //     return output;
    // }

    // #endregion
}
// @lc code=end

