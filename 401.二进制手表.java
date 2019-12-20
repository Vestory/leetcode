import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    /**
     * 10 / 10, 1ms(100%), 34.8MB(85.22%)
     */
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <= num && i < 4; ++i) {
            if (num - i > 5) {
                continue;
            }
            String[] hours = getHours(i);
            String[] minutes = getMinutes(num - i);
            for (int j = 0; j < hours.length; ++j) {
                for (int k = 0; k < minutes.length; ++k) {
                    res.add(hours[j] + ":" + minutes[k]);
                }
            }
        }
        return res;
    }

    public String[] getMinutes(int num) {
        switch (num) {
        case 1:
            return new String[] { "01", "02", "04", "08", "16", "32" };
        case 2:
            return new String[] { "03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40",
                    "48" };
        case 3:
            return new String[] { "07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41",
                    "42", "44", "49", "50", "52", "56" };
        case 4:
            return new String[] { "15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58" };
        case 5:
            return new String[] { "31", "47", "55", "59" };
        default:
            return new String[] { "00" };
        }
    }

    public String[] getHours(int num) {
        switch (num) {
        case 1:
            return new String[] { "1", "2", "4", "8" };
        case 2:
            return new String[] { "3", "5", "6", "9", "10" };
        case 3:
            return new String[] { "7", "11" };
        default:
            return new String[] { "0" };
        }
    }

    /**
     * 其他解法
     * https://leetcode-cn.com/problems/binary-watch/solution/cjian-jian-dan-dan-de-ji-xing-dai-ma-jie-jue-wen-t/
     */
}
// @lc code=end