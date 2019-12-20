import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 重复 N 次的元素
 */

// @lc code=start
class Solution {
    /**
     * 102 / 102, 4ms(45.15%), 38.7MB(94.5%)
     */
    // public int repeatedNTimes(int[] A) {
    //     int len = A.length / 2 + 2;
    //     int max = 10000;
    //     int[] arr = new int[max];
    //     for (int i = 0; i < len; ++i) {
    //         arr[i] += A[i];
    //         arr[A[i]] += max;
    //     }
    //     len = max;
    //     max *= 2;
    //     for (int i = 0; i < len; ++i) {
    //         if (arr[i] >= max) {
    //             return i;
    //         }
    //     }
    //     return 0;
    // }

    /**
     * 102 / 102, 1ms(92.95%), 38.1MB(95.78%)
     */
    public int repeatedNTimes(int[] A) {
        int len = A.length / 2 + 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            if (set.contains(A[i])) {
                return A[i];
            }
            set.add(A[i]);
        }
        return 0;
    }
}
// @lc code=end

