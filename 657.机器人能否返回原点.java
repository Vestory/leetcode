import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    /**
     * 63 / 63, 6ms(92.17%), 38.2MB(95.21%)
     */
    // public boolean judgeCircle(String moves) {
    //     int l = 0, r = 0, u = 0, d = 0, len = moves.length();
    //     for (int i = 0; i < len; ++i) {
    //         switch (moves.charAt(i)) {
    //         case 'L':
    //             ++l;
    //             break;
    //         case 'R':
    //             ++r;
    //             break;
    //         case 'U':
    //             ++u;
    //             break;
    //         case 'D':
    //             ++d;
    //             break;
    //         }
    //     }
    //     return (l - r) == 0 && (u - d) == 0;
    // }

    /**
     * 63 / 63, 7ms(79.83%), 37.6MB(95.21%)
     */
    // public boolean judgeCircle(String moves) {
    //     int h = 0, v = 0, len = moves.length();
    //     for (int i = 0; i < len; ++i) {
    //         switch (moves.charAt(i)) {
    //         case 'L':
    //             --h;
    //             break;
    //         case 'R':
    //             ++h;
    //             break;
    //         case 'U':
    //             ++v;
    //             break;
    //         case 'D':
    //             --v;
    //             break;
    //         }
    //     }
    //     return h == 0 && v == 0;
    // }

    /**
     * 63 / 63, 14ms(35.84%), 37.4MB(95.21%)
     */
    // public boolean judgeCircle(String moves) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     map.put('L', 0);
    //     map.put('R', 1);
    //     map.put('U', 2);
    //     map.put('D', 3);
    //     int[] arr = new int[4];
    //     int len = moves.length();
    //     for (int i = 0; i < len; ++i) {
    //         ++arr[map.get(moves.charAt(i))];
    //     }
    //     return arr[0] - arr[1] == 0 && arr[2] - arr[3] == 0;
    // }

    /**
     * 63 / 63, 6ms(92.17%), 38.2MB(95.21%)
     */
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int l = 0, r = 0, u = 0, d = 0, len = arr.length;
        for (int i = 0; i < len; ++i) {
            switch (arr[i]) {
            case 'L':
                ++l;
                break;
            case 'R':
                ++r;
                break;
            case 'U':
                ++u;
                break;
            case 'D':
                ++d;
                break;
            }
        }
        return (l - r) == 0 && (u - d) == 0;
    }
}
// @lc code=end
