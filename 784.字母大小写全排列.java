import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    /**
     * 63 / 63, 3ms(75.36%), 36.8MB(98.49%)
     */
    // private List<String> res = null;
    // private int len = 0;

    // public List<String> letterCasePermutation(String S) {
    //     res = new ArrayList<>();
    //     len = S.length();
    //     char[] arr = S.toCharArray();
    //     res.add(S);
    //     itera(arr, 0);
    //     return res;
    // }

    // private void itera(char[] arr, int idx) {
    //     boolean flag = idx + 1 < len;
    //     if (Character.isAlphabetic(arr[idx])) {
    //         if (flag) {
    //             itera(Arrays.copyOf(arr, len), idx + 1);
    //         }
    //         if (Character.isUpperCase(arr[idx])) {
    //             arr[idx] += 32;
    //         } else {
    //             arr[idx] -= 32;
    //         }
    //         res.add(new String(arr));
    //         if (flag) {
    //             itera(arr, idx + 1);
    //         }
    //     } else if (flag) {
    //         itera(arr, idx + 1);
    //     }
    // }

    /**
     * 63 / 63, 2ms(90.43%), 37MB(98.11%)
     */
    // private List<String> res = null;
    // private int len = 0;
    // private byte[] next;
    // private boolean[] isUpper;

    // public List<String> letterCasePermutation(String S) {
    //     res = new ArrayList<>();
    //     len = S.length();
    //     char[] arr = S.toCharArray();
    //     res.add(S);
    //     next = new byte[len];
    //     isUpper = new boolean[len];
    //     int temp = -1, idx = -1;
    //     for (byte i = 0; i < len; ++i) {
    //         if (Character.isAlphabetic(arr[i])) {
    //             isUpper[i] = Character.isUpperCase(arr[i]);
    //             if (temp == -1) {
    //                 temp = i;
    //                 idx = i;
    //             } else {
    //                 next[temp] = i;
    //                 temp = i;
    //             }
    //         }
    //     }
    //     if (temp != -1) {
    //         next[temp] = -1;
    //     } else {
    //         return res;
    //     }
    //     itera(arr, idx);
    //     return res;
    // }
    // private void itera(char[] arr, int idx) {
    //     if (idx == -1) {
    //         return;
    //     }
    //     itera(Arrays.copyOf(arr, len), next[idx]);
    //     if (isUpper[idx]) {
    //         arr[idx] += 32;
    //     } else {
    //         arr[idx] -= 32;
    //     }
    //     res.add(new String(arr));
    //     itera(arr, next[idx]);
    // }

    /**
     * 63 / 63, 2ms(90.43%), 37MB(98.11%)
     */
    // private List<String> res = null;
    // private int len = 0;
    // private byte[] next;
    // private char[] opp;

    // public List<String> letterCasePermutation(String S) {
    //     res = new ArrayList<>();
    //     len = S.length();
    //     char[] arr = S.toCharArray();
    //     res.add(S);
    //     next = new byte[len];
    //     opp = Arrays.copyOf(arr, len);
    //     int temp = -1, idx = -1;
    //     for (byte i = 0; i < len; ++i) {
    //         if (Character.isAlphabetic(arr[i])) {
    //             opp[i] += Character.isUpperCase(arr[i]) ? 32 : -32;
    //             if (temp == -1) {
    //                 temp = i;
    //                 idx = i;
    //             } else {
    //                 next[temp] = i;
    //                 temp = i;
    //             }
    //         }
    //     }
    //     if (temp != -1) {
    //         next[temp] = -1;
    //     } else {
    //         return res;
    //     }
    //     itera(arr, idx);
    //     return res;
    // }

    // private void itera(char[] arr, int idx) {
    //     if (idx == -1) {
    //         return;
    //     }
    //     itera(Arrays.copyOf(arr, len), next[idx]);
    //     arr[idx] = opp[idx];
    //     res.add(new String(arr));
    //     itera(arr, next[idx]);
    // }

    /**
     * 官方解题
     * 二分掩码
     * https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
     * 63 / 63, 19ms(11.5%), 37.4MB(97.74%)
     */
    // public List<String> letterCasePermutation(String S) {
    //     int B = 0;
    //     for (char c : S.toCharArray())
    //         if (Character.isLetter(c))
    //             B++;
    //     List<String> ans = new ArrayList<>();
    //     for (int bits = 0; bits < 1 << B; bits++) {
    //         int b = 0;
    //         StringBuilder word = new StringBuilder();
    //         for (char letter : S.toCharArray()) {
    //             if (Character.isLetter(letter)) {
    //                 if (((bits >> b++) & 1) == 1)
    //                     word.append(Character.toLowerCase(letter));
    //                 else
    //                     word.append(Character.toUpperCase(letter));
    //             } else {
    //                 word.append(letter);
    //             }
    //         }
    //         ans.add(word.toString());
    //     }
    //     return ans;
    // }

    /**
     * 官方解题
     * 迭代
     * https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
     * 63 / 63, 9ms(31.11%), 37.4MB(97.74%)
     */
    // public List<String> letterCasePermutation(String S) {
    //     List<StringBuilder> ans = new ArrayList();
    //     ans.add(new StringBuilder());
    //     for (char c : S.toCharArray()) {
    //         int n = ans.size();
    //         if (Character.isLetter(c)) {
    //             for (int i = 0; i < n; ++i) {
    //                 ans.add(new StringBuilder(ans.get(i)));
    //                 ans.get(i).append(Character.toLowerCase(c));
    //                 ans.get(n + i).append(Character.toUpperCase(c));
    //             }
    //         } else {
    //             for (int i = 0; i < n; ++i)
    //                 ans.get(i).append(c);
    //         }
    //     }
    //     List<String> finalans = new ArrayList();
    //     for (StringBuilder sb : ans)
    //         finalans.add(sb.toString());
    //     return finalans;
    // }

    /**
     * https://leetcode-cn.com/problems/letter-case-permutation/solution/784-zi-mu-da-xiao-xie-quan-pai-lie-2ms-gao-xiao-ti/
     * 63 / 63, 1ms(100%), 37.3MB(97.74%)
     */
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        dg(S.toCharArray(), 0, ans);
        return ans;
    }
    public void dg(char[] s, int i, List<String> ans) {
        if (i == s.length) {
            ans.add(String.valueOf(s));
            return;
        }
        dg(s, i + 1, ans);
        if (s[i] < '0' || s[i] > '9') {
            s[i] ^= (1 << 5);
            dg(s, i + 1, ans);
        }
    }
}
// @lc code=end

