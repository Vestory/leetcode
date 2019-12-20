import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    /**
     * 95 / 95, 8ms(40.16%), 35.2MB(80.84%)
     */
    // public int longestPalindrome(String s) {
    //     HashSet<Character> set = new HashSet<>();
    //     char c;
    //     int count = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         c = s.charAt(i);
    //         if (set.contains(c)) {
    //             count += 2;
    //             set.remove(c);
    //         } else {
    //             set.add(c);
    //         }
    //     }
    //     return set.isEmpty() ? count : ++count;
    // }

    /**
     * 95 / 95, 2ms(86.7%), 35.1MB(81.69%)
     */
    public int longestPalindrome(String s) {
        int[] times = new int[58];
        for (int i = 0; i < s.length(); ++i) {
            ++times[s.charAt(i) - 65];
        }
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < times.length; ++i) {
            if (times[i] % 2 != 0) {
                flag = true;
                count += times[i] - 1;
            } else {
                count += times[i];
            }
        }
        return flag ? ++count : count;
    }
}
// @lc code=end

