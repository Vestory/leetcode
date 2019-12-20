import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=949 lang=java
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
class Solution {
    /**
     * 172 / 172, 1ms(100%), 34.8MB(92.65%)
     */
    public String largestTimeFromDigits(int[] A) {
        // 0和1的数量，2的数量，小于4的数量，小于6的数量
        int zeroAndOne = 0, two = 0, lessThanFour = 0, lessThanSix = 0, len = 4, val;
        // 0,1,2中的最大值，0,1中的最大值
        int large = -1, small = -1;
        // 计数，并找出时间第一位的可能取值的位置
        for (int i = 0; i < len; ++i) {
            val = A[i];
            if (val < 6) {
                ++lessThanSix;
                if (val < 4) {
                    ++lessThanFour;
                    if (val == 3) {
                        continue;
                    }
                    if (val == 2) {
                        ++two;
                    } else if (val < 2) {
                        ++zeroAndOne;
                        if (small == -1 || val > A[small]) {
                            small = i;
                        }
                    }
                    if (large == -1 || val > A[large]) {
                        large = i;
                    }
                }
            }
        }
        // 2X:XX的情况
        if (two > 0 && lessThanFour > 1 && lessThanSix > 2) {
            // 第一位设置为2
            if (A[0] != 2) {
                swap(A, 0, large);
            }
            // 寻找第二位，第二位需要小于4的值中的最大值
            val = 1;
            large = 0;
            while (val < len) {
                if (A[val] < 4 && (large == 0 || A[large] < A[val])) {
                    large = val;
                }
                ++val;
            }
        // 1X:XX或0X:XX的情况
        } else if (zeroAndOne > 0 && lessThanSix > 1) {
            // 若large指向了2，那么从small里面取0或者1
            if (A[large] == 2) {
                swap(A, 0, small);
            } else {
                swap(A, 0, large);
            }
            // 寻找第二位，第二位是剩余数字中的最大值
            val = 2;
            large = 1;
            while (val < len) {
                if (A[large] < A[val]) {
                    large = val;
                }
                ++val;
            }
        // 不符合情况，无法组成有效的时间
        } else {
            return "";
        }
        // 设置第二位
        swap(A, 1, large);
        // 设置第三位，同时也就设置了第四位
        if (A[2] > 5 || (A[3] < 6 && A[2] < A[3])) {
            swap(A, 2, 3);
        }
        // 输出结果
        StringBuilder sb = new StringBuilder();
        return sb.append(A[0]).append(A[1]).append(':').append(A[2]).append(A[3]).toString();
    }
    private void swap(int[] A, int i, int j) {
        int val = A[i];
        A[i] = A[j];
        A[j] = val;
    }
}
// @lc code=end