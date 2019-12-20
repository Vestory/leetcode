/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */
class Solution {
    /**
     * 尾部开始往前扫描
     * 59 / 59, 0ms(100%), 36.2MB(57.86%)
     */
    // public int lengthOfLastWord(String s) {
    //     int length = s.length() - 1;
    //     // 去除从尾部开始的空格
    //     while (length >= 0) {
    //         if (s.charAt(length) != ' ') {
    //             break;
    //         }
    //         --length;
    //     }
    //     // 如果全是空格（-1），或者只剩下一个字符（0），则直接返回结果
    //     if (length == -1 || length == 0) {
    //         return length + 1;
    //     }
    //     int index = length;
    //     // 从尾部开始的第一个不是空格的字符向前，遇到空格为止
    //     while (index >= 0) {
    //         if (s.charAt(index) == ' ') {
    //             return length - index;
    //         }
    //         --index;
    //     }
    //     return length + 1;
    // }

    /**
     * 类似的想法，运用了trim去除尾部空格，lastIndexOf来获取空格位置
     * 59 / 59, 0ms(100%), 35.8MB(77.38%)
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() < 2) {
            return s.length();
        }
        int index = s.lastIndexOf(" ");
        return index == -1 ? s.length() : (s.length() - index - 1);
    }
}

