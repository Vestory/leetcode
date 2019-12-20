import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
class Solution {
    /**
     * 184 / 184, 8ms(99.82%), 38.1MB(97.5%)
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int len;
        char[] chs;
        char c;
        StringBuilder sb;
        for (String s : emails) {
            len = s.length();
            chs = s.toCharArray();
            sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                c = chs[i];
                if (c == '+') {
                    sb.append(s.substring(s.indexOf('@')));
                    break;
                } else if (c == '@') {
                    sb.append(s.substring(i));
                    break;
                } else if (c != '.') {
                    sb.append(c);
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
// @lc code=end

