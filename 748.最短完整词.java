import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短完整词
 */

// @lc code=start
class Solution {
    /**
     * 102 / 102, 5ms(75%), 38.3MB(100%)
     */
    // public String shortestCompletingWord(String licensePlate, String[] words) {
    //     int[] license = new int[26];
    //     int sum = 0, idx;
    //     for (char c : licensePlate.toCharArray()) {
    //         idx = Character.toLowerCase(c) - 'a';
    //         if (idx >= 0 && idx < 26) {
    //             ++license[idx];
    //             ++sum;
    //         }
    //     }
    //     int[] arr;
    //     String res = null;
    //     for (String word : words) {
    //         arr = Arrays.copyOf(license, 26);
    //         idx = sum;
    //         for (char c : word.toCharArray()) {
    //             if (--arr[c - 'a'] >= 0) {
    //                 --idx;
    //             }
    //         }
    //         if (idx == 0) {
    //             if (res == null) {
    //                 res = word;
    //             } else if (word.length() < res.length()) {
    //                 res = word;
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/shortest-completing-word/solution/zui-duan-wan-zheng-ci-by-leetcode/
     * 102 / 102, 5ms(75%), 37.1MB(100%)
     */
    // public String shortestCompletingWord(String licensePlate, String[] words) {
    //     int[] target = count(licensePlate);
    //     String ans = "";
    //     for (String word : words)
    //         if ((word.length() < ans.length() || ans.length() == 0) && dominates(count(word.toLowerCase()), target))
    //             ans = word;
    //     return ans;
    // }

    // public boolean dominates(int[] count1, int[] count2) {
    //     for (int i = 0; i < 26; ++i)
    //         if (count1[i] < count2[i])
    //             return false;
    //     return true;
    // }

    // public int[] count(String word) {
    //     int[] ans = new int[26];
    //     for (char letter : word.toCharArray()) {
    //         int index = Character.toLowerCase(letter) - 'a';
    //         if (0 <= index && index < 26)
    //             ans[index]++;
    //     }
    //     return ans;
    // }
}
// @lc code=end

