/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */
class Solution {
    /**
     * 进制转换，10进制转26进制，但又有些不同，因为A-Z中没有一个表示0
     * 18 / 18, 0ms(100%), 34MB(83.37%)
     */
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int temp = 0;
        while (n > 26) {
            // 64对应着字符'@'，65则是'A'
            temp = 64 + n % 26;
            /**
             * 当余数为0时，由于A-Z中没有一个表示0，所以需要转换
             * 比如n = 52，n / 26 = 2，余数为0，此时，就需要使得n - 26
             * 然后让余数变成26（也就是Z），即n = 52时，应该视为 26 + 26 => AZ
             * （AZ表示A * 26 + Z * 1 = 1 * 26 + 26 * 1 = 52）
             * 如果是n = 260，那么不能认为是10个26，而应该是9 + 1个，即IZ（I * 26 + Z * 1）
             */
            if (temp == 64) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append((char) temp);
                n /= 26;
            }
        }
        sb.append((char) (64 + n));
        return sb.reverse().toString();
    }
}

