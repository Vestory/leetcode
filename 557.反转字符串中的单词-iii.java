import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    /**
     * 30 / 30, 6ms(91.8%), 37.6MB(97.15%)
     */
    // public String reverseWords(String s) {
    //     int len = s.length(), l = 0, r = 1, next;
    //     char[] array = s.toCharArray();
    //     char c;
    //     while (l < len) {
    //         while (r < len) {
    //             if (array[r] == ' ') {
    //                 break;
    //             }
    //             ++r;
    //         }
    //         next = r + 1;
    //         --r;
    //         while (l < r) {
    //             c = array[l];
    //             array[l] = array[r];
    //             array[r] = c;
    //             ++l;
    //             --r;
    //         }
    //         l = next;
    //         r = next + 1;
    //     }
    //     return new String(array);
    // }

    // #region [0] 官方解题
    // https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/solution/fan-zhuan-zi-fu-chuan-zhong-de-dan-ci-iii-by-leetc/
    /**
     * 简单的解法
     * 时间复杂度和空间复杂度均为O(n)
     * 30 / 30, 8ms(78.93%), 38.3MB(97.06%)
     */
    // public String reverseWords(String s) {
    //     String words[] = s.split(" ");
    //     StringBuilder res = new StringBuilder();
    //     for (String word : words)
    //         res.append(new StringBuffer(word).reverse().toString() + " ");
    //     return res.toString().trim();
    // }

    /**
     * 不使用自带的split和reverse
     * 时间复杂度和空间复杂度均为O(n)
     * 30 / 30, 31ms(23.05%), 38.1MB(97.06%)
     */
    // public String reverseWords(String s) {
    //     String words[] = split(s);
    //     StringBuilder res = new StringBuilder();
    //     for (String word : words)
    //         res.append(reverse(word) + " ");
    //     return res.toString().trim();
    // }

    // public String[] split(String s) {
    //     ArrayList<String> words = new ArrayList<>();
    //     StringBuilder word = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == ' ') {
    //             words.add(word.toString());
    //             word = new StringBuilder();
    //         } else
    //             word.append(s.charAt(i));
    //     }
    //     words.add(word.toString());
    //     return words.toArray(new String[words.size()]);
    // }

    // public String reverse(String s) {
    //     StringBuilder res = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++)
    //         res.insert(0, s.charAt(i));
    //     return res.toString();
    // }

    /**
     * 使用StringBuilder和reverse方法
     * 时间复杂度和空间复杂度均为O(n)
     * 30 / 30, 14ms(55.78%), 38.6MB(96.88%)
     */
    public String reverseWords(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
    // #endregion
}
// @lc code=end

