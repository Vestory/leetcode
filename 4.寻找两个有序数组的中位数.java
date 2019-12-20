import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {
    /**
     * 2085 / 2085, 3ms(99.7%), 46.9MB(95.01%)
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     // 双指针
    //     int la = 0, lb = 0, ra = nums1.length - 1, rb = nums2.length - 1;
    //     // nums1的最近一次操作是否是移除了较小的值，即
    //     // nums1的最近一次移动的是la指针还是ra指针
    //     // 如果是la，那么num2则是移动了rb，相应的，如果此时两个数组都同时移动完毕（没有多余元素了）
    //     // 那么，中位数就是最近一次两者移除掉的两个数字的平均，而此时，分别指向这两个数字的指针恰好是没有这次没有移动的ra和lb
    //     boolean smaller = false;
    //     while (la <= ra && lb <= rb) {
    //         // 移除一个较小数
    //         if (nums1[la] < nums2[lb]) {
    //             ++la;
    //             smaller = true;
    //         } else {
    //             ++lb;
    //         }
    //         // 判断是否已经有个一个数组为空，并移除一个较大数
    //         if (la > ra) {
    //             --rb;
    //         } else if (lb > rb) {
    //             --ra;
    //             smaller = false;
    //         } else {
    //             if (nums1[ra] > nums2[rb]) {
    //                 --ra;
    //                 smaller = false;
    //             } else {
    //                 --rb;
    //             }
    //         }
    //     }
    //     // 判断是不是numn1为空，并返回中位数
    //     int temp = ra - la;
    //     if (temp >= 0) {
    //         if (temp % 2 == 0) {
    //             return nums1[(la + ra) / 2];
    //         } else {
    //             return (nums1[(la + ra) / 2] + nums1[(la + ra) / 2 + 1]) / 2.0f;
    //         }
    //     }
    //     // 判断是不是nums2为空，并返回中位数
    //     temp = rb - lb;
    //     if (temp >= 0) {
    //         if (temp % 2 == 0) {
    //             return nums2[(lb + rb) / 2];
    //         } else {
    //             return (nums2[(lb + rb) / 2] + nums2[(lb + rb) / 2 + 1]) / 2.0f;
    //         }
    //     }
    //     // 两个数组是同时为空的，根据smaller来计算平均值
    //     if (smaller) {
    //         return (nums1[ra] + nums2[lb]) / 2.0f;
    //     } else {
    //         return (nums1[la] + nums2[rb]) / 2.0f;
    //     }
    // }

    /**
     * 官方的递归法
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
     * 2085 / 2085, 3ms(99.7%), 46.5MB(95.94%)
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     if (m > n) { // to ensure m<=n
    //         int[] temp = nums1;
    //         nums1 = nums2;
    //         nums2 = temp;
    //         int tmp = m;
    //         m = n;
    //         n = tmp;
    //     }
    //     int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    //     while (iMin <= iMax) {
    //         int i = (iMin + iMax) / 2;
    //         int j = halfLen - i;
    //         if (i < iMax && nums2[j - 1] > nums1[i]) {
    //             iMin = i + 1; // i is too small
    //         } else if (i > iMin && nums1[i - 1] > nums2[j]) {
    //             iMax = i - 1; // i is too big
    //         } else { // i is perfect
    //             int maxLeft = 0;
    //             if (i == 0) {
    //                 maxLeft = nums2[j - 1];
    //             } else if (j == 0) {
    //                 maxLeft = nums1[i - 1];
    //             } else {
    //                 maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
    //             }
    //             if ((m + n) % 2 == 1) {
    //                 return maxLeft;
    //             }

    //             int minRight = 0;
    //             if (i == m) {
    //                 minRight = nums2[j];
    //             } else if (j == n) {
    //                 minRight = nums1[i];
    //             } else {
    //                 minRight = Math.min(nums2[j], nums1[i]);
    //             }

    //             return (maxLeft + minRight) / 2.0;
    //         }
    //     }
    //     return 0.0;
    // }

    // #region [0] 其他解法
    // https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
    /**
     * 解法1：直接合并两个数组，然后排序，然后返回中位数
     * 时间复杂度O(m + n), 空间复杂度O(m + n)
     */
    /**
     * 解法2：移动一半到中位数的位置，用变量记录下中位数的位置然后返回
     * 对比写在最后的那种方法，两者思路一致，而这个方法用变量存储了中位数的位置，另一个方法则是通过判断来获取中位数
     * 前者需要额外的存储空间并且每次循环均需要判断，而后者则是在循环后判断，且不需要额外的空间
     * 但是，前者代码看起来会更加清晰，后者乱七八糟，分支一大堆
     * 时间复杂度O(m + n)，空间复杂度O(1)
     * 2085 / 2085, 3ms(99.7%), 46.2MB(96.8%)
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     int len = m + n;
    //     int left = -1, right = -1;
    //     int start1 = 0, start2 = 0;
    //     for (int i = 0; i <= len / 2; ++i) {
    //         left = right;
    //         if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
    //             right = nums1[start1++];
    //         } else {
    //             right = nums2[start2++];
    //         }
    //     }
    //     if ((len & 1) == 0) {
    //         return (left + right) / 2.0f;
    //     }
    //     return right;
    // }

    /**
     * 二分法，求第k小数的方法
     * 时间复杂度O(log(m + n))，空间复杂度O(1)，尾递归，编译器不需要不停地堆栈
     * 2085 / 2085, 3ms(99.7%), 45.9MB(98%)
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     int left = (m + n + 1) / 2;
    //     int right = (m + n + 2) / 2;
    //     // 将奇数和偶数的情况合并，如果是奇数，会求两次同样的k
    //     return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    // }

    // private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
    //     int len1 = end1 - start1 + 1;
    //     int len2 = end2 - start2 + 1;
    //     // 让len1的长度小于len2，这样就能保证如果有数组空了，一定是len1
    //     if (len1 > len2) {
    //         return getKth(nums2, start2, end2, nums1, start1, end1, k);
    //     }
    //     if (len1 == 0) {
    //         return nums2[start2 + k - 1];
    //     }
    //     if (k == 1) {
    //         return Math.min(nums1[start1], nums2[start2]);
    //     }
    //     int i = start1 + Math.min(len1, k / 2) - 1;
    //     int j = start2 + Math.min(len2, k / 2) - 1;
    //     if (nums1[i] > nums2[j]) {
    //         return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
    //     }
    //     return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    // }

    /**
     * 时间复杂度O(log(min(m, n)))，空间复杂度O(1)
     * 2085 / 2085, 3ms(99.7%), 45.1MB(99.47%)
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
    // //#endregion

    /**
     * 另一种思路，一直排除较小的数字，直到到了一半，从而得到中位数
     * 这分支真的多
     * 2085 / 2085, 3ms(99.7%), 46.8MB(95.25%)
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     // 去除两个数组为空或其中一个为空的情况
    //     if (nums1.length == 0 && nums2.length == 0) {
    //         return 0;
    //     } else if (nums1.length == 0) {
    //         if (nums2.length % 2 == 0) {
    //             return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0f;
    //         }
    //         return (nums2[nums2.length / 2]);
    //     } else if (nums2.length == 0) {
    //         if (nums1.length % 2 == 0) {
    //             return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0f;
    //         }
    //         return (nums1[nums1.length / 2]);
    //     }
    //     // 两个数组均不为空
    //     // 移动一半的长度
    //     int length = (nums1.length + nums2.length) / 2;
    //     int pa = 0, pb = 0;
    //     for (int i = 0; i < length; ++i) {
    //         if (pa < nums1.length && pb < nums2.length) {
    //             if (nums1[pa] < nums2[pb]) {
    //                 ++pa;
    //             } else {
    //                 ++pb;
    //             }
    //         } else if (pa < nums1.length) {
    //             ++pa;
    //         } else { // 不需要考虑两个数组同时为空的情况，因为只迭代一半长度是不会两者都为空的
    //             ++pb;
    //         }
    //     }
    //     // 偶数个元素
    //     if ((nums1.length + nums2.length) % 2 == 0) {
    //         // 两个数组均有剩余元素
    //         if (pa < nums1.length && pb < nums2.length) {
    //             length = nums1[pa] < nums2[pb] ? nums1[pa] : nums2[pb];
    //             if (pa == 0 || (pb != 0 && nums1[pa - 1] < nums2[pb - 1])) {
    //                 return (length + nums2[pb - 1]) / 2.0f;
    //             }
    //             return (length + nums1[pa - 1]) / 2.0f;
    //         // 第二个数组没有剩余元素
    //         } else if (pa < nums1.length) {
    //             if (pa == 0 || nums1[pa - 1] < nums2[pb - 1]) {
    //                 return (nums1[pa] + nums2[pb - 1]) / 2.0f;
    //             }
    //             return (nums1[pa - 1] + nums1[pa]) / 2.0f;
    //         // 第一个数组没有剩余元素
    //         } else {
    //             if (pb != 0 && nums1[pa - 1] < nums2[pb - 1]) {
    //                 return (nums2[pb - 1] + nums2[pb]) / 2.0f;
    //             }
    //             return (nums1[pa - 1] + nums2[pb]) / 2.0f;
    //         }
    //     // 奇数个元素
    //     } else {
    //         // 两个数组均有剩余元素
    //         if (pa < nums1.length && pb < nums2.length) {
    //             if (nums1[pa] < nums2[pb]) {
    //                 return nums1[pa];
    //             }
    //             return nums2[pb];
    //         // 第二个数组没有剩余元素
    //         } else if (pa < nums1.length) {
    //             return nums1[pa];
    //         // 第一个数组没有剩余元素
    //         } else {
    //             return nums2[pb];
    //         }
    //     }
    // }
}
// @lc code=end
