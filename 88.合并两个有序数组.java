import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */
class Solution {
    /**
     * 双指针，从尾部到头部
     * 59 / 59, 0ms(100%), 36.3MB(79.68%)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        int i = m + n + 1;
        while (m >= 0 && n >= 0) {
            nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

    /**
     * 合并后排序
     * 时间复杂度O((n + m)log(n + m))，空间复杂度O(1)
     * 59 / 59, 1ms(95.57%), 36.2MB(82%)
     */
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     System.arraycopy(nums2, 0, nums1, m, n);
    //     Arrays.sort(nums1);
    // }

    /**
     * 双指针，从前往后
     * 时间复杂度O(n + m),空间复杂度O(m)
     * 59 / 59, 0ms(100%), 36.1MB(85.44%)
     */
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int[] nums1_copy = new int[m];
    //     System.arraycopy(nums1, 0, nums1_copy, 0, m);
    //     int p1 = 0;
    //     int p2 = 0;
    //     int p = 0;
    //     while (p1 < m && p2 < n) {
    //         nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
    //     }
    //     if (p1 < m) {
    //         System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    //     }
    //     if (p2 < n) {
    //         System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    //     }
    // }
}

