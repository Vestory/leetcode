import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    /**
     * 转换为字符数组，排序，然后比较
     * 时间复杂度O(logn), 空间复杂度O(1)
     * 34 / 34, 4ms(96.61%), 38.2MB(95.19%)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    /**
     * 34 / 34, 44ms(21.48%), 37.2MB(95.9%)
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char sc, tc;
    //     for (int i = 0; i < s.length(); ++i) {
    //         sc = s.charAt(i);
    //         tc = t.charAt(i);
    //         if (sc != tc) {
    //             if (map.containsKey(sc)) {
    //                 if (map.get(sc) == -1) {
    //                     map.remove(sc);
    //                 } else {
    //                     map.put(sc, map.get(sc) + 1);
    //                 }
    //             } else {
    //                 map.put(sc, 1);
    //             }
    //             if (map.containsKey(tc)) {
    //                 if (map.get(tc) == 1) {
    //                     map.remove(tc);
    //                 } else {
    //                     map.put(tc, map.get(tc) - 1);
    //                 }
    //             } else {
    //                 map.put(tc, -1);
    //             }
    //         }
    //     }
    //     return map.isEmpty();
    // }

    /**
     * 34 / 34, 33ms(23.68%), 38.2MB(94.93%)
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char c;
    //     for (int i = 0; i < s.length(); ++i) {
    //         c = s.charAt(i);
    //         if (map.containsKey(c)) {
    //             map.put(c, map.get(c) + 1);
    //         } else {
    //             map.put(c, 1);
    //         }
    //     }
    //     for (int i = 0; i < t.length(); ++i) {
    //         c = t.charAt(i);
    //         if (map.containsKey(c)) {
    //             if (map.get(c) == 1) {
    //                 map.remove(c);
    //             } else {
    //                 map.put(c, map.get(c) - 1);
    //             }
    //         } else {
    //             return false;
    //         }
    //     }
    //     return map.isEmpty();
    // }

    // 官方题解
    // https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
    // 如果没有unicode字符，那么可以使用26大小的数组来对字母进行计数，从而不用哈希表
    // 但是，哈希表则是更加通用的做法
}
// @lc code=end

