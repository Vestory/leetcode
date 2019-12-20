/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    /**
     * 循环和位移动
     * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     * 时间复杂度和空间复杂度均为O(1) 601 / 601, 1ms(99.82%), 33.5MB(16.99%)
     */
    // public int hammingWeight(int n) {
    // int bits = 0;
    // int mask = 1;
    // for (int i = 0; i < 32; ++i) {
    // if ((n & mask) != 0) {
    // ++bits;
    // }
    // mask <<= 1;
    // }
    // return bits;
    // }

    /**
     * 位操作的小技巧
     * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     * 时间复杂度和空间复杂度均为O(1) 601 / 601, 1ms(99.82%), 33.3MB(19.12%)
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            n &= (n - 1);
        }
        return sum;
    }
}
// @lc code=end

