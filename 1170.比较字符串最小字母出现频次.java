/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start
class Solution {
    /**
     * 37 / 37, 3ms(93.54%), 37.4MB(100%)
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len = 11, count;
        int[] map = new int[len];
        for (String s : words) {
            count = getCount(s);
            for (int i = count; i < len; ++i) {
                ++map[i];
            }
        }
        count = words.length;
        len = queries.length;
        int[] res = new int[queries.length];
        for (int i = 0; i < len; ++i) {
            res[i] = count - map[getCount(queries[i])];
        }
        return res;
    }
    private int getCount(String s) {
        char c = 'z';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch < c) {
                c = ch;
                count = 1;
            } else if (ch == c) {
                ++count;
            }
        }
        return count;
    }
}
// @lc code=end

