import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start
class Solution {
    /**
     * 79 / 79, 1ms(98.82%), 34.7MB(100%)
     */
    // public int heightChecker(int[] heights) {
    //     int len = heights.length;
    //     int[] after = Arrays.copyOf(heights, len);
    //     Arrays.sort(after);
    //     int count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (after[i] != heights[i]) {
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    /**
     * https://leetcode-cn.com/problems/height-checker/solution/onjie-fa-yong-shi-yu-nei-cun-ji-bai-100-javayong-h/
     * 79 / 79, 1ms(98.82%), 34.3MB(100%)
     */
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
// @lc code=end

