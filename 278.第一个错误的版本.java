/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /**
     * 二分法，使用了long
     * 22 / 22, 12ms(99.83%), 32.9MB(68.2%)
     */
    // public int firstBadVersion(int n) {
    //     long l = 1, r = n, m;
    //     while (l < r) {
    //         m = (l + r) / 2;
    //         if (isBadVersion((int)m)) {
    //             r = m;
    //         } else {
    //             l = m + 1;
    //         }
    //     }
    //     return (int)l;
    // }

    /**
     * 二分法，没有使用long
     * https://leetcode-cn.com/problems/first-bad-version/solution/di-yi-ge-cuo-wu-de-ban-ben-by-leetcode/
     * 时间复杂度O(logn), 空间复杂度O(1) 22 / 22, 12ms(99.83%), 32.7MB(72.31%)
     */
    public int firstBadVersion(int n) {
        int l = 1, r = n, m;
        while (l < r) {
            m = l + (r - l) / 2;        // 防止溢出
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
// @lc code=end

