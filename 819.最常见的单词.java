import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    /**
     * 47 / 47, 6ms(98.77%), 35.8MB(98.4%)
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        int l = 0, r = 0, len = paragraph.length();
        char[] arr = paragraph.toCharArray();
        String temp = "";
        while (r < len) {
            while (r < len) {
                if (Character.isAlphabetic(arr[r])) {
                    break;
                }
                ++r;
            }
            if (r == len) {
                break;
            }
            l = r;
            ++r;
            while (r < len) {
                if (!Character.isAlphabetic(arr[r])) {
                    break;
                }
                ++r;
            }
            temp = paragraph.substring(l, r).toLowerCase();
            if (!set.contains(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            ++r;
        }
        r = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            l = entry.getValue();
            if (l > r) {
                r = l;
                temp = entry.getKey();
            }
        }
        return temp;
    }
}
// @lc code=end

