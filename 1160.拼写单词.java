import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    /**
     * 36 / 36, 5ms(96.46%), 38.2MB(100%)
     */
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (char c : chars.toCharArray()) {
            ++counts[c - 'a'];
        }
        int len = words.length, res = 0;
        int[] cur;
        boolean flag;
        for (int i = 0; i < len; ++i) {
            cur = Arrays.copyOf(counts, 26);
            flag = true;
            for (char c : words[i].toCharArray()) {
                if (--cur[c - 'a'] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += words[i].length();
            }
        }
        return res;
    }
}
// @lc code=end

