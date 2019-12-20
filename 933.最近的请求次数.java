/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {
    /**
     * 68 / 68, 184ms(14.76%), 65.9MB(70.42%)
     */
    // private int[] times;
    // private int idx;
    // public RecentCounter() {
    //     times = new int[10000];
    //     idx = 0;
    // }
    // public int ping(int t) {
    //     times[idx] = t;
    //     int cnt = 1;
    //     for (int i = idx - 1; i > -1; --i) {
    //         if (times[idx] - times[i] > 3000) {
    //             break;
    //         }
    //         ++cnt;
    //     }
    //     ++idx;
    //     return cnt;
    // }

    /**
     * 68 / 68, 34ms(99.56%), 62.5MB(81.69%)
     */
    private int[] times;
    private int l, r;
    public RecentCounter() {
        times = new int[3002];
        l = 0;
        r = 0;
    }
    public int ping(int t) {
        times[r] = t;
        while (times[r] - times[l] > 3000) {
            if (++l == 3002) {
                l %= 3002;
            }
        }
        if (++r == 3002) {
            r %= 3002;
        }
        int cnt = r - l;
        return cnt > 0 ? cnt : cnt + 3002;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

