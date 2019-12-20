/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    /**
     * 115 / 115, 0ms(100%), 37.9MB(60.21%)
     */
    public boolean isAlienSorted(String[] words, String order) {
        char[] chs0 = order.toCharArray();
        int[] morder = new int[26];
        int len = chs0.length;
        for (int i = 0; i < len; ++i) {
            morder[chs0[i] - 'a'] = i;
        }
        len = words.length;
        int len0, len1 = words[0].length(), l, r, lo, ro;
        char[] chs1 = words[0].toCharArray();
        for (int i = 1; i < len; ++i) {
            len0 = len1;
            chs0 = chs1;
            len1 = words[i].length();
            chs1 = words[i].toCharArray();
            l = 0;
            r = 0;
            while (l < len0 && r < len1) {
                lo = morder[chs0[l] - 'a'];
                ro = morder[chs1[r] - 'a'];
                if (lo > ro) {
                    return false;
                } else if (lo < ro) {
                    break;
                }
                ++l;
                ++r;
            }
            if (r == len1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

