import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start
class Solution {
    /**
     * 83 / 83, 3ms(96.29%), 37.6MB(92.4%)
     */
    public List<String> commonChars(String[] A) {
        int len = A.length;
        if (len == 0) {
            return new ArrayList<String>();
        }
        int[] com = new int[26];
        int[] cur = new int[26];
        for (char c :  A[0].toCharArray()) {
            ++com[c - 'a'];
        }
        for (int i = 1; i < len; ++i) {
            cur = new int[26];
            for (char c : A[i].toCharArray()) {
                ++cur[c - 'a'];
            }
            for (int j = 0; j < 26; ++j) {
                com[j] = Math.min(com[j], cur[j]);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < com[i]; ++j) {
                res.add((char)('a' + i) + "");
            }
        }
        return res;
    }
}
// @lc code=end

