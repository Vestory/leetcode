/*
 * @lc app=leetcode.cn id=1108 lang=java
 *
 * [1108] IP 地址无效化
 */

// @lc code=start
class Solution {
    /**
     * 62 / 62, 3ms(51.83%), 34.2MB(100%)
     */
    // public String defangIPaddr(String address) {
    //     return address.replaceAll("\\.", "[.]");
    // }

    /**
     * 62 / 62, 0ms(100%), 34.4MB(100%)
     */
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

