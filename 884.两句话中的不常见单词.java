import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
class Solution {
    /**
     * 53 / 53, 3ms(99.78%), 36.2MB(89.24%)
     */
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] as = A.split(" ");
        String[] bs = B.split(" ");
        int la = as.length, lb = bs.length;
        for (int i = 0; i < la; ++i) {
            if (disContains(as[i], bs)) {
                if (map.containsKey(as[i])) {
                    map.put(as[i], -1);
                } else {
                    map.put(as[i], 0);
                }
            }
        }
        for (int i = 0; i < lb; ++i) {
            if (disContains(bs[i], as)) {
                if (map.containsKey(bs[i])) {
                    map.put(bs[i], -1);
                } else {
                    map.put(bs[i], 0);
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        String temp;
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (map.get(temp) == 0) {
                res.add(temp);
            }
        }
        return res.toArray(new String[0]);
    }
    private boolean disContains(String str, String[] arr) {
        for (String s : arr) {
            if (s.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

