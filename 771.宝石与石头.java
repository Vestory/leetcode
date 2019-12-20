import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    /**
     * 254 / 254, 2ms(65.46%), 34.9MB(90.76%)
     */
    // public int numJewelsInStones(String J, String S) {
    //     if (J.length() == 0 || S.length() == 0) {
    //         return 0;
    //     }
    //     HashSet<Character> set = new HashSet<>();
    //     int len = J.length();
    //     for (int i = 0; i < len; ++i) {
    //         set.add(J.charAt(i));
    //     }
    //     len = S.length();
    //     int count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (set.contains(S.charAt(i))) {
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    /**
     * 254 / 254, 2ms(65.46%), 34.9MB(90.76%)
     */
    // public int numJewelsInStones(String J, String S) {
    //     if (J.length() == 0 || S.length() == 0) {
    //         return 0;
    //     }
    //     HashSet<Character> set = new HashSet<>();
    //     char[] arr = J.toCharArray();
    //     int len = arr.length;
    //     for (int i = 0; i < len; ++i) {
    //         set.add(arr[i]);
    //     }
    //     arr = S.toCharArray();
    //     len = arr.length;
    //     int count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (set.contains(arr[i])) {
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    /**
     * 254 / 254, 10ms(6.52%), 36.3MB(81.1%)
     */
    // public int numJewelsInStones(String J, String S) {
    //     int lj = J.length(), ls = S.length();
    //     if (lj == 0 || ls == 0) {
    //         return 0;
    //     }
    //     for (int i = 0; i < lj; ++i) {
    //         S = S.replaceAll(J.charAt(i) + "", "");
    //     }
    //     return ls - S.length();
    // }

    /**
     * 254 / 254, 1ms(99.98%), 34.7MB(90.87%)
     */
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        char[] arr = S.toCharArray();
        int len = arr.length, count = 0;
        for (int i = 0; i < len; ++i) {
            if (J.indexOf(arr[i]) != -1) {
                ++count;
            }
        }
        return count;
    }
}
// @lc code=end

