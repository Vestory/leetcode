import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    /**
     * 哈希表
     * 33 / 33, 1ms(100%), 34.2MB(36.73%)
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        char c;
        for (int i = 0; i < pattern.length(); ++i) {
            c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}
// @lc code=end

