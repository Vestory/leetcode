import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */

// @lc code=start
class Solution {
    /**
     * 29 / 29, 1ms(98.62%), 34.4MB(100%)
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int len = words.length;
        ArrayList<String> res = new ArrayList<>();
        boolean isDifferent = !first.equals(second);
        for (int i = 2; i < len; ++i) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                res.add(words[i]);
                if (isDifferent) {
                    ++i;
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
// @lc code=end

