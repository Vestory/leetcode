import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=893 lang=java
 *
 * [893] 特殊等价字符串组
 */

// @lc code=start
class Solution {
    /**
     * 官方解题
     * https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/solution/te-shu-deng-jie-zi-fu-chuan-zu-by-leetcode/
     * 36 / 36, 14ms(63.22%), 37.6MB(79.35%)
     */
    // public int numSpecialEquivGroups(String[] A) {
    //     Set<String> seen = new HashSet();
    //     for (String S : A) {
    //         int[] count = new int[52];
    //         for (int i = 0; i < S.length(); ++i)
    //             count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
    //         seen.add(Arrays.toString(count));
    //     }
    //     return seen.size();
    // }

    /**
     * https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/solution/java-by-zxy0917-18/
     * 36 / 36, 11ms(75.21%), 37.6MB(79.35%)
     */
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            char[] chars = str.toCharArray();
            String odd = "", even = "";
            for (int i = 0; i < chars.length; i++) {
                // 如果是奇数位
                if ((i & 1) == 1) {
                    odd += str.charAt(i);
                } else {
                    // 如果为偶数位
                    even += str.charAt(i);
                }
            }
            // 排序后拼接
            char[] oddArr = odd.toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }
        return set.size();
    }
}
// @lc code=end

