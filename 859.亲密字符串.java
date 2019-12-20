import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    /**
     * 23 / 23, 0ms(100%), 37.5MB(78.4%)
     */
    public boolean buddyStrings(String A, String B) {
        int len = A.length();
        if (len != B.length()) {
            return false;
        }
        char[] ar = A.toCharArray();
        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < len; ++i) {
                if (set.contains(ar[i])) {
                    return true;
                }
                set.add(ar[i]);
            }
            return false;
        } else {
            char[] br = B.toCharArray();
            int idx = 0, diff = 0;
            for (int i = 0; i < len; ++i) {
                if (ar[i] != br[i]) {
                    if (++diff > 2) {
                        return false;
                    }
                    if (diff == 1) {
                        idx = i;
                    } else {
                        if (ar[idx] != br[i] || ar[i] != br[idx]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

