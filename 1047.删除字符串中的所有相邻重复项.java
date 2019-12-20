import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    /**
     * 98 / 98, 45ms(67.34%), 37.1MB(100%)
     */
    // public String removeDuplicates(String S) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char c : S.toCharArray()) {
    //         if (!stack.isEmpty() && stack.peek() == c) {
    //             stack.pop();
    //         } else {
    //             stack.push(c);
    //         }
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : stack) {
    //         sb.append(c);
    //     }
    //     return sb.toString();
    // }

    /**
     * 98 / 98, 4ms(100%), 38.2MB(100%)
     */
    public String removeDuplicates(String S) {
        char[] chs = S.toCharArray();
        int len = chs.length, l = 0, r = -1;
        for (int i = 1; i < len; ++i) {
            if (r < l) {
                if (chs[i] != chs[i - 1]) {
                    r = i;
                    l = r - 1;
                } else {
                    if (++i == len - 1) {
                        return chs[i] + "";
                    }
                }
            } else {
                if (chs[i] == chs[r]) {
                    if (--r < l) {
                        if (++i == len - 1) {
                            return chs[i] + "";
                        }
                    }
                } else {
                    chs[++r] = chs[i];
                }
            }
        }
        return new String(chs, l, r - l + 1);
    }
}
// @lc code=end