import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {

    /**
     * 哈希表
     * 61 / 61, 4ms(93.96%), 37MB(37.73%)
     */
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int i = 0, temp;
    //     while (i < nums1.length) {
    //         map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
    //         ++i;
    //     }
    //     i = 0;
    //     ArrayList<Integer> list = new ArrayList<>();
    //     while (i < nums2.length) {
    //         temp = map.getOrDefault(nums2[i], 0);
    //         if (temp > 0) {
    //             map.put(nums2[i], temp - 1);
    //             list.add(nums2[i]);
    //         }
    //         ++i;
    //     }
    //     i = 0;
    //     int[] res = new int[list.size()];
    //     while (i < list.size()) {
    //         res[i] = list.get(i);
    //         ++i;
    //     }
    //     return res;
    // }

    /**
     * 排序
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/map-huo-pai-xu-liang-chong-jie-fa-kuai-su-chu-li-w/
     * 61 / 61, 3ms(96.55%), 36.3MB(66.19%)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>(nums1.length);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        // 对象转数组
        Object[] a = list.toArray();
        int n = 0;
        int[] ans = new int[a.length];
        for (Object e: a) {
            ans[n++] = (int) e;
        }
        return ans;
    }
}
// @lc code=end

