import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    /**
     * 84 / 84, 15ms(32.91%), 38.2MB(95.54%)
     */
    // public int largestPerimeter(int[] A) {
    //     Arrays.sort(A);
    //     int x = A.length - 1, y = x - 1, z = y - 1, temp;
    //     while (z > -1) {
    //         temp = A[x] - A[y];
    //         while (z > -1) {
    //             if (A[z] > temp) {
    //                 break;
    //             }
    //             --z;
    //         }
    //         if (z != -1) {
    //             return A[x] + A[y] + A[z];
    //         }
    //         x = y;
    //         --y;
    //         z = y - 1;
    //     }
    //     return 0;
    // }

    /**
     * 84 / 84, 12ms(88.57%), 38MB(96.04%)
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i > -1; --i) {
            if (A[i] > A[i + 2] - A[i + 1]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }

    /**
     * 其他解法
     * https://leetcode-cn.com/problems/largest-perimeter-triangle/solution/dui-pai-xu-by-ttang/
     */
}
// @lc code=end

