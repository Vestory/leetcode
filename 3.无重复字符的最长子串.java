import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    /**
     * 逐渐扫描
     * 987 / 987, 11ms(84.53%), 38.4MB(88.3%)
     */
    // public int lengthOfLongestSubstring(String s) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char c;
    //     int l = 0, r = 0;
    //     int max = 0, temp;
    //     while (r < s.length()) {
    //         c = s.charAt(r);
    //         if (!map.containsKey(c)) {
    //             map.put(c, r);
    //         } else {
    //             temp = r - l;
    //             if (temp > max) {
    //                 max = temp;
    //             }
    //             temp = map.get(c);
    //             while (l < temp) {
    //                 map.remove(s.charAt(l));
    //                 ++l;
    //             }
    //             ++l;
    //             map.put(c, r);
    //         }
    //         ++r;
    //     }
    //     temp = r - l;
    //     return temp > max ? temp : max;
    // }

    // region [0] 官方解法
    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
    /**
     * 暴力法，会超时
     * 时间复杂度O(n * n)，空间复杂度O(min(n, m))
     */
    // public int lengthOfLongestSubstring(String s) {
    //     int n = s.length();
    //     int ans = 0;
    //     for (int i = 0; i < n; ++i) {
    //         for (int j = i + 1; j <=n; ++j) {
    //             if (allUnique(s, i, j)) {
    //                 ans = Math.max(ans, j - i);
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // public boolean allUnique(String s, int start, int end) {
    //     Set<Character> set = new HashSet<>();
    //     for (int i = start; i < end; ++i) {
    //         Character ch = s.charAt(i);
    //         if (set.contains(ch)) {
    //             return false;
    //         }
    //         set.add(ch);
    //     }
    //     return true;
    // }

    /**
     * 滑动窗口
     * 时间复杂度O(2 * n)， 即O(n)，空间复杂度O(min(m, n))
     * 987 / 987, 16ms(76.38%), 37.2MB(93.72%)
     */
    // public int lengthOfLongestSubstring(String s) {
    //     int n = s.length();
    //     Set<Character> set = new HashSet<>();
    //     int ans = 0, i = 0, j = 0;
    //     while (i < n && j < n) {
    //         if (!set.contains(s.charAt(j))) {
    //             set.add(s.charAt(j++));
    //             ans = Math.max(ans, j - i);
    //         } else {
    //             set.remove(s.charAt(i++));
    //         }
    //     }
    //     return ans;
    // }

    /**
     * 优化的滑动窗口
     * 时间复杂度O(n), 空间复杂度O(min(m, n))
     * 987 / 987, 10ms(87.51%), 37.6MB(91.8%)
     */
    // public int lengthOfLongestSubstring(String s) {
    //     int n = s.length(), ans = 0;
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (int j = 0, i = 0; j < n; ++j) {
    //         if (map.containsKey(s.charAt(j))) {
    //             i = Math.max(map.get(s.charAt(j)), i);
    //         }
    //         ans = Math.max(ans, j - i + 1);
    //         map.put(s.charAt(j), j + 1);
    //     }
    //     return ans;
    // }
    // #endregion

    /**
     * 参考上一种和第一种方法
     * 987 / 987, 10ms(87.51%), 37.3MB(93.07%)
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), ans = 0;
        char c;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < length; ) {
            c = s.charAt(j++);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            ans = Math.max(ans, j - i);
            map.put(c, j);
        }
        return ans;
    }
}
// @lc code=end