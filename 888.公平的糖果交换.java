import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 */

// @lc code=start
class Solution {
    /**
     * 75 / 75, 18ms(81.3%), 39.7MB(94.35%)
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int la = A.length, lb = B.length, diff = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < la; ++i) {
            set.add(A[i]);
            diff += A[i];
        }
        for (int i = 0; i < lb; ++i) {
            diff -= B[i];
        }
        diff /= 2;
        for (int i = 0; i < lb; ++i) {
            if (set.contains(B[i] + diff)) {
                return new int[] { B[i] + diff, B[i] };
            }
        }
        return new int[0];
    }
}
// @lc code=end
