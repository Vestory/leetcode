/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    /**
     * 快慢指针
     * https://leetcode-cn.com/problems/happy-number/solution/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/
     * 401 / 401, 2ms(97.81%), 33.4MB(30.23%)
     */
    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        return slow == 1;
    }

    public int squareSum(int n) {
        int sum = 0, bit;
        while (n > 0) {
            bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

