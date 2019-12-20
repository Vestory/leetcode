/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    /**
     * 官方解答
     * https://leetcode-cn.com/problems/nim-game/solution/nimyou-xi-by-leetcode/
     * 更容易懂得解释
     * https://leetcode-cn.com/problems/nim-game/solution/nimyou-xi-by-lydia_0701/
     * 时间复杂度和空间复杂度均为O(1) 60 / 60, 0ms(100%), 32.9MB(11.88%)
     */
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
// @lc code=end

