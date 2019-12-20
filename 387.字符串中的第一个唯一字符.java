import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    /**
     * 哈希表
     * 104 / 104, 19ms(77.22%), 37.7MB(94.07%)
     */
    // public int firstUniqChar(String s) {
    //     HashSet<Character> set = new HashSet<>();
    //     char c;
    //     int j;
    //     for (int i = 0; i < s.length(); ++i) {
    //         c = s.charAt(i);
    //         if (!set.contains(c)) {
    //             j = i + 1;
    //             while (j < s.length()) {
    //                 if (s.charAt(j) == c) {
    //                     j = -1;
    //                     break;
    //                 }
    //                 ++j;
    //             }
    //             if (j != -1) {
    //                 return i;
    //             }
    //             set.add(c);
    //         }
    //     }
    //     return -1;
    // }

    /**
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
     * 时间复杂度和空间复杂度均为O(n)
     * 104 / 104, 52ms(50.95%), 37.8MB(93.96%)
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; ++i) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
// @lc code=end

