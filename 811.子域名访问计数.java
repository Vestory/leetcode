import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    /**
     * 52 / 52, 10ms(100%), 37.9MB(98.36%)
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        int count, idx;
        for (String s : cpdomains) {
            idx = s.indexOf(' ');
            count = Integer.parseInt(s.substring(0, idx));
            s = s.substring(idx + 1);
            while (true) {
                map.put(s, map.getOrDefault(s, 0) + count);
                idx = s.indexOf('.');
                if (idx == -1) {
                    break;
                } else {
                    s = s.substring(idx + 1);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
// @lc code=end

