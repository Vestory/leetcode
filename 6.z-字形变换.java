import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    /**
     * 找规律，然后计算
     * 1158 / 1158, 7ms(95.72%), 38.5MB(95.87%)
     */
    // public String convert(String s, int numRows) {
    //     if (numRows == 1) {
    //         return s;
    //     }
    //     StringBuffer sb = new StringBuffer();
    //     int j, l, r, length = s.length();
    //     for (int i = 0; i < numRows; ++i) {
    //         j = 0;
    //         while (true) {
    //             if (i == 0 || i == numRows - 1) {
    //                 l = 2 * j * (numRows - 1) + i;
    //                 if (l >= length) {
    //                     break;
    //                 }
    //                 sb.append(s.charAt(l));
    //             } else {
    //                 l = 2 * j * (numRows - 1) - i;
    //                 r = 2 * j * (numRows - 1) + i;
    //                 if (l >= length) {
    //                     break;
    //                 }
    //                 if (l >= 0) {
    //                     sb.append(s.charAt(l));
    //                 }
    //                 if (r >= length) {
    //                     break;
    //                 }
    //                 sb.append(s.charAt(r));
    //             }
    //             ++j;
    //         }
    //     }
    //     return sb.toString();
    // }

    /**
     * 按行排序
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     * 时间复杂度和空间复杂度均为O(N)
     * 1158 / 1158, 9ms(91.75%), 38.5MB(96.21%)
     */
    // public String convert(String s, int numRows) {
    //     if (numRows == 1) {
    //         return s;
    //     }
    //     List<StringBuilder> rows = new ArrayList<>();
    //     for (int i = 0; i < Math.min(numRows, s.length()); ++i) {
    //         rows.add(new StringBuilder());
    //     }
    //     int curRow = 0;
    //     boolean goingDown = false;
    //     for (char c : s.toCharArray()) {
    //         rows.get(curRow).append(c);
    //         if (curRow == 0 || curRow == numRows - 1) {
    //             goingDown = !goingDown;
    //         }
    //         curRow += goingDown ? 1 : -1;
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (StringBuilder row : rows) {
    //         res.append(row);
    //     }
    //     return res.toString();
    // }

    /**
     * 按行访问，和自己的想法一致，但是却写得更好
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     * 时间复杂度和空间复杂度均为O(n)
     * 1158 / 1158, 5ms(98.03%), 38.4MB(96.55%)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j + i < n; j += cycleLen) {
                res.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return res.toString();
    }
}
// @lc code=end

