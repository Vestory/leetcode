/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */
class Solution {
    /**
     * 扫描字符串
     * 1000 / 1000, 2ms(98.63%), 35.8MB(37.56%)
     */
    // public int titleToNumber(String s) {
    //     int count = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         count += (Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 64));
    //     }
    //     return count;
    // }

    /**
     * 都是扫描字符串，但是下面这种方法更好，不需要每次都求n次方
     * https://leetcode-cn.com/problems/excel-sheet-column-number/solution/hua-jie-suan-fa-171-excelbiao-lie-xu-hao-by-guanpe/
     * 1000 / 1000, 1ms(100%), 35.9MB(37.32%)
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int num = s.charAt(i) - 64;
            ans = ans * 26 + num;
        }
        return ans;
    }
}

