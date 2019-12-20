/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */
class Solution {
    /**
     * 迭代
     * 18 / 18, 3ms(94.21%), 33.9MB(95.16%)
     */
    // public String countAndSay(int n) {
    //     if (n == 1) {
    //         return "1";
    //     }
    //     StringBuffer sb = new StringBuffer();
    //     sb.append(1);       // 起始n = 1
    //     int j;
    //     char c;             // 当前字符
    //     int start;          // 当前字符的起始索引
    //     int len;            // 当前迭代的长度
    //     for (int i = 1; i < n; ++i) {
    //         // 初始化为第一个字符
    //         c = sb.charAt(0);
    //         start = 0;
    //         len = sb.length();
    //         // 扫描当前迭代len长度的字符串，生成新的迭代结果
    //         for (j = 1; j < len; ++j) {
    //             if (sb.charAt(j) != c) {
    //                 sb.append(j - start).append(c);
    //                 c = sb.charAt(j);
    //                 start = j;
    //             }
    //         }
    //         // 加入最后一部分计数内容
    //         sb.append(j - start).append(c);
    //         // 删除上一次迭代的结果
    //         sb.delete(0, j);
    //     }
    //     return sb.toString();
    // }

    /**
     * 递归
     * 18 / 18, 3ms(94.21%), 33.9MB(95.56%)
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return iterate(new StringBuffer().append(1), --n).toString();
    }

    /** 递归，count为剩余次数 */
    public StringBuffer iterate(StringBuffer sb, int count) {
        if (count > 0) {
            char c = sb.charAt(0);
            int start = 0;
            int len = sb.length();
            int j = 1;
            for (; j < len; ++j) {
                if (sb.charAt(j) != c) {
                    sb.append(j - start).append(c);
                    c = sb.charAt(j);
                    start = j;
                }
            }
            sb.append(j - start).append(c);
            iterate(sb.delete(0, j), --count);
        }
        return sb;
    }
}

