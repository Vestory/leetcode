import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    /**
     * 78 / 78, 2ms(79.07%), 36.5MB(54.2%)
     */
    // public int largestSumAfterKNegations(int[] A, int K) {
    //     Arrays.sort(A);
    //     int x = 0, y = 0, len = A.length, i = 0, sum = 0;
    //     while (i < len) {
    //         if (A[i] >= 0) {
    //             break;
    //         }
    //         ++i;
    //     }
    //     x = i;
    //     while (i < len) {
    //         if (A[i] > 0) {
    //             break;
    //         }
    //         ++i;
    //     }
    //     y = i - x;
    //     if (K <= x) {
    //         i = 0;
    //         while (i < K) {
    //             sum -= A[i];
    //             ++i;
    //         }
    //         while (i < len) {
    //             sum += A[i];
    //             ++i;
    //         }
    //     } else {
    //         i = 0;
    //         while (i < x) {
    //             sum -= A[i];
    //             ++i;
    //         }
    //         while (i < len) {
    //             sum += A[i];
    //             ++i;
    //         }
    //         if (y == 0 && (K - x) % 2 == 1) {
    //             if (x == len || (x != 0 && -A[x - 1] < A[x])) {
    //                 sum += (A[x - 1] * 2);
    //             } else {
    //                 sum -= (A[x] * 2);
    //             }
    //             // 等同于
    //             // if (x == len) {
    //             //     sum += (A[x - 1] * 2);
    //             // } else if (x == 0) {
    //             //     sum -= (A[x] * 2);
    //             // } else {
    //             //     if (-A[x - 1] > A[x]) {
    //             //         sum -= (A[x] * 2);
    //             //     } else {
    //             //         sum += (A[x - 1] * 2);
    //             //     }
    //             // }
    //         }
    //     }
    //     return sum;
    // }

    /**
     * 78 / 78, 10ms(20%), 37.7MB(28.18%)
     */
    // public int largestSumAfterKNegations(int[] A, int K) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int len = A.length, sum = 0, minAbs = Integer.MAX_VALUE, cur, idx, min;
    //     boolean noZero = true;
    //     for (int i = 0; i < len; ++i) {
    //         cur = A[i];
    //         if (cur > 0) {
    //             sum += cur;
    //         } else if (cur == 0) {
    //             noZero = false;
    //         } else {
    //             cur = -cur;
    //             if (list.size() < K) {
    //                 sum += cur;
    //                 list.add(cur);
    //             } else {
    //                 idx = 1;
    //                 min = 0;
    //                 while (idx < K) {
    //                     if (list.get(idx) < list.get(min)) {
    //                         min = idx;
    //                     }
    //                     ++idx;
    //                 }
    //                 idx = list.get(min);
    //                 if (cur > idx) {
    //                     list.remove(min);
    //                     list.add(cur);
    //                     sum -= idx * 2;
    //                     sum += cur;
    //                 } else {
    //                     sum -= cur;
    //                 }
    //             }
    //         }
    //         if (minAbs > cur) {
    //             minAbs = cur;
    //         }
    //     }
    //     K -= list.size();
    //     if (K > 0 && noZero && K % 2 == 1) {
    //         sum -= minAbs * 2;
    //     }
    //     return sum;
    // }

    public int largestSumAfterKNegations(int[] A, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = A.length, sum = 0, minAbs = Integer.MAX_VALUE, cur, idx, min;
        boolean noZero = true;
        for (int i = 0; i < len; ++i) {
            cur = A[i];
            if (cur > 0) {
                sum += cur;
            } else if (cur == 0) {
                noZero = false;
            } else {
                cur = -cur;
                if (list.size() < K) {
                    sum += cur;
                    list.add(cur);
                } else {
                    idx = 1;
                    min = 0;
                    while (idx < K) {
                        if (list.get(idx) < list.get(min)) {
                            min = idx;
                        }
                        ++idx;
                    }
                    idx = list.get(min);
                    if (cur > idx) {
                        list.remove(min);
                        list.add(cur);
                        sum -= idx * 2;
                        sum += cur;
                    } else {
                        sum -= cur;
                    }
                }
            }
            if (minAbs > cur) {
                minAbs = cur;
            }
        }
        K -= list.size();
        if (K > 0 && noZero && K % 2 == 1) {
            sum -= minAbs * 2;
        }
        return sum;
    }

    /**
     * 更好的解法
     * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/solution/java-chao-yue-9966xiang-xi-jie-xi-by-flychenkai/
     */
}
// @lc code=end
