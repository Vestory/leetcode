import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    /**
     * 156 / 156, 6ms(89.9%), 41.3MB(90.63%)
     */
    // public List<Integer> addToArrayForm(int[] A, int K) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     int i = A.length - 1, cur = 0;
    //     while (K > 0) {
    //         cur += K % 10;
    //         K /= 10;
    //         if (i >= 0) {
    //             cur += A[i];
    //             --i;
    //         }
    //         if (cur > 9) {
    //             res.add(cur - 10);
    //             cur = 1;
    //         } else {
    //             res.add(cur);
    //             cur = 0;
    //         }
    //     }
    //     while (i >= 0) {
    //         cur += A[i];
    //         --i;
    //         if (cur > 9) {
    //             res.add(cur - 10);
    //             cur = 1;
    //         } else {
    //             res.add(cur);
    //             cur = 0;
    //         }
    //     }
    //     if (cur == 1) {
    //         res.add(cur);
    //     }
    //     Collections.reverse(res);
    //     return res;
    // }

    /**
     * 156 / 156, 5ms(96.63%), 40.8MB(90.63%)
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = A.length - 1, cur = 0;
        while (K > 0 && i >= 0) {
            A[i] += K % 10 + cur;
            if (A[i] > 9) {
                A[i] -= 10;
                cur = 1;
            } else {
                cur = 0;
            }
            K /= 10;
            --i;
        }
        if (K > 0) {
            K += cur;
            cur = 1;
            while (K / cur > 9) {
                cur *= 10;
            }
            while (cur > 0) {
                res.add(K / cur);
                K %= cur;
                cur /= 10;
            }
            cur = A.length;
            while (++i < cur) {
                res.add(A[i]);
            }
        } else {
            while (i >= 0 && cur > 0) {
                A[i] += cur;
                if (A[i] > 9) {
                    A[i] -= 10;
                    cur = 1;
                } else {
                    cur = 0;
                }
                --i;
            }
            if (cur == 1) {
                res.add(cur);
            } else {
                i = -1;
            }
            cur = A.length;
            while (++i < cur) {
                res.add(A[i]);
            }
        }
        return res;
    }
}
// @lc code=end

