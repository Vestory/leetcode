import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    /**
     * 481 / 481, 1130ms(5.01%), 51.7MB(5.03%)
     */
    // public String reverseVowels(String s) {
    //     HashSet<Character> set = new HashSet<>();
    //     set.add('a');
    //     set.add('e');
    //     set.add('i');
    //     set.add('o');
    //     set.add('u');
    //     set.add('A');
    //     set.add('E');
    //     set.add('I');
    //     set.add('O');
    //     set.add('U');
    //     int l = 0, r = s.length() - 1;
    //     while (l < r) {
    //         while (!set.contains(s.charAt(l))) {
    //             ++l;
    //             if (l >= r) {
    //                 return s;
    //             }
    //         }
    //         while (!set.contains(s.charAt(r))) {
    //             --r;
    //             if (l >= r) {
    //                 return s;
    //             }
    //         }
    //         s = s.substring(0, l) + s.substring(r, r + 1) + s.substring(l + 1, r) + s.substring(l, l + 1) + s.substring(r + 1);
    //         ++l;
    //         --r;
    //     }
    //     return s;
    // }

    /**
     * 481 / 481, 6ms(93.11%), 38.7MB(94.97%)
     */
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int l = 0, r = s.length() - 1;
        char c;
        while (l < r) {
            while (!set.contains(array[l])) {
                ++l;
                if (l >= r) {
                    return new String(array);
                }
            }
            while (!set.contains(array[r])) {
                --r;
                if (l >= r) {
                    return new String(array);
                }
            }
            if (array[l] != array[r]) {
                c = array[l];
                array[l] = array[r];
                array[r] = c;
            }
            ++l;
            --r;
        }
        return new String(array);
    }
}
// @lc code=end

