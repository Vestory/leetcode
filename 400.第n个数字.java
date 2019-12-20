/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/nth-digit/solution/shou-xian-zhao-dao-shu-zi-de-wei-zhi-ran-hou-zhao-/
     * 70 / 70, 1ms(78.66%), 33.1MB(80%)
     */
    // public int findNthDigit(int n) {
    //     int i = 1;
    //     while (n > i * (Math.pow(10, i - 1)) * 9) {
    //         n -= i * (Math.pow(10, i - 1)) * 9;
    //         ++i;
    //     }
    //     int temp = (int)((n - 1) / i + Math.pow(10, i - 1));
    //     String str = temp + "";
    //     if (n % i == 0) {
    //         return str.charAt(i - 1) - '0';
    //     }
    //     return str.charAt(n % i - 1) - '0';
    // }

    /**
     * https://leetcode-cn.com/problems/nth-digit/solution/di-tui-jie-ti-zhi-xing-0msji-bai-100-by-tommy-23/
     * 70 / 70, 0ms(100%), 33MB(80%)
     */
    public int findNthDigit(int n) {
        int maxi = 0;
        int i = 1;
        while (n > maxi + i * (Math.pow(10, i) - Math.pow(10, i - 1))) {
            maxi += i * (Math.pow(10, i) - Math.pow(10, i - 1));
            i++;
        }
        n -= maxi;
        n--;
        int remain = n % i;
        int counter = n / i;
        int inwhich = (int) Math.pow(10, i - 1) + counter;

        int rtn = 0;

        for (int j = 0; j < i - remain; j++) {
            rtn = inwhich % 10;
            inwhich /= 10;
        }
        return rtn;
    }
}
// @lc code=end

