/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] 总持续时间可被 60 整除的歌曲
 */

// @lc code=start
class Solution {
    /**
     * 超时
     */
    // public int numPairsDivisibleBy60(int[] time) {
    //     int len = time.length;
    //     for (int i = 0; i < len; ++i) {
    //         while (time[i] >= 60) {
    //             time[i] -= 60;
    //         }
    //     }
    //     int cnt = 0;
    //     for (int i = 0; i < len; ++i) {
    //         for (int j = i + 1; j < len; ++j) {
    //             if ((time[i] + time[j]) % 60 == 0) {
    //                 ++cnt;
    //             }
    //         }
    //     }
    //     return cnt;
    // }

    /**
     * 超时
     */
    // public int numPairsDivisibleBy60(int[] time) {
    //     int len = time.length;
    //     int cnt = 0;
    //     for (int i = 0; i < len; ++i) {
    //         for (int j = i + 1; j < len; ++j) {
    //             if ((time[i] + time[j]) % 60 == 0) {
    //                 ++cnt;
    //             }
    //         }
    //     }
    //     return cnt;
    // }

    /**
     * 34 / 34, 2ms(100%), 41.2MB(95.76%)
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnts = new int[60];
        for (int i : time) {
            ++cnts[i % 60];
        }
        int cnt = 0;
        if (cnts[0] > 1) {
            cnt += (cnts[0] * (cnts[0] - 1)) / 2;
        }
        if (cnts[30] > 1) {
            cnt += (cnts[30] * (cnts[30] - 1)) / 2;
        }
        for (int i = 1; i < 30; ++i) {
            cnt += (cnts[i] * cnts[60 - i]);
        }
        return cnt;
    }
}
// @lc code=end

