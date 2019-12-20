import java.util.HashMap;
/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    /**
     * 哈希表映射 时间复杂度和空间复杂的均为O(n) 30 / 30, 13ms(73.01%), 37.7MB(55.14%)
     */
    // public boolean isIsomorphic(String s, String t) {
    // HashMap<Character, Character> map = new HashMap<>();
    // char cs, ct;
    // for (int i = 0; i < s.length(); i++) {
    // cs = s.charAt(i);
    // ct = t.charAt(i);
    // if (map.containsKey(cs)) {
    // if (map.get(cs) != ct) {
    // return false;
    // }
    // } else {
    // if (map.containsValue(ct)) {
    // return false;
    // }
    // map.put(cs, ct);
    // }
    // }
    // return true;
    // }

    /**
     * 对比两个字符串对应位置的字符在字符串中第一次出现的位置 30 / 30, 8ms(87.31%), 36.9MB(88.75%)
     */
    public boolean isIsomorphic(String s, String r) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != r.indexOf(r.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

