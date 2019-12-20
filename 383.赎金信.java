import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    /**
     * 哈希表
     * 126 / 126, 15ms(43.21%), 37.5MB(96.33%)
     */
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char c;
    //     int temp;
    //     for (int i = 0; i < ransomNote.length(); ++i) {
    //         c = ransomNote.charAt(i);
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for (int i = 0; i < magazine.length(); ++i) {
    //         c = magazine.charAt(i);
    //         if (map.containsKey(c)) {
    //             temp = map.get(c);
    //             if (temp == 1) {
    //                 map.remove(c);
    //             } else {
    //                 map.put(c, --temp);
    //             }
    //         }
    //     }
    //     return map.isEmpty();
    // }

    /**
     * 数组
     * https://leetcode-cn.com/problems/ransom-note/solution/shi-yong-tong-lai-fu-zhu-jie-jue-javashi-xian-by-l/
     * 126 / 126, 5ms(95.08%), 36.8MB(98.59%)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] buckets = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            buckets[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            if(--buckets[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end