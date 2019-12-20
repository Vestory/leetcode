/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    /**
     * 38 / 38, 25ms(60.53%), 38MB(99.36%)
     */
    // public String licenseKeyFormatting(String S, int K) {
    //     S = S.toUpperCase();
    //     char c;
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = S.length() - 1, count = 0; i >= 0; --i) {
    //         c = S.charAt(i);
    //         if (c != '-') {
    //             sb.append(c);
    //             if (++count == K) {
    //                 sb.append('-');
    //                 count = 0;
    //             }
    //         }
    //     }
    //     if (sb.length() == 0) {
    //         return "";
    //     }
    //     return sb.charAt(sb.length() - 1) == '-' ? sb.reverse().substring(1, sb.length()) : sb.reverse().toString();
    // }

    /**
     * 38 / 38, 12ms(94.13%), 38MB(99.36%)
     */
    public String licenseKeyFormatting(String S, int K) {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1, count = 0; i >= 0; --i) {
            c = S.charAt(i);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
                if (++count == K) {
                    sb.append('-');
                    count = 0;
                }
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        // StringBuilder的delete比StringBuilder和String的subString快很多
        // 如果下面的写成
        // if (sb.charAt(sb.length() - 1) == '-') {
        //     return sb.reverse().substring(1, sb.length());
        // }
        // 则时间会增加到19ms
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    /**
     * 38 / 38, 27ms(55.47%), 37.6MB(99.36%)
     */
    // public String licenseKeyFormatting(String S, int K) {
    //     S = S.replace("-", "").toUpperCase();
    //     if (S.length() == 0) {
    //         return "";
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = S.length() - 1, count = 0; i >= 0; --i) {
    //         sb.append(S.charAt(i));
    //         if (++count == K) {
    //             sb.append('-');
    //             count = 0;
    //         }
    //     }
    //     if (sb.charAt(sb.length() - 1) == '-') {
    //         sb.deleteCharAt(sb.length() - 1);
    //     }
    //     return sb.reverse().toString();
    // }
}
// @lc code=end

