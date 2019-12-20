/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */
class Solution {
    /**
     * 穷举法
     * 200 / 200, 326ms(17.65%), 49.3MB(5.08%)
     */
    // public int maxProfit(int[] prices) {
    //     int max = 0;
    //     for (int i = 0; i < prices.length - 1; ++i) {
    //         for (int j = i + 1; j < prices.length; ++j) {
    //             if (prices[j] - prices[i] > max) {
    //                 max = prices[j] - prices[i];
    //             }
    //         }
    //     }
    //     return max;
    // }

    /**
     * 一次遍历
     * 200 / 200, 1ms(99.97%), 37MB(87.29%)
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int low = prices[0];
        int max = 0;
        int profix = 0;
        for (int i = 1; i < prices.length; ++i) {
            profix = prices[i] - low;
            if (profix < 0) {
                low = prices[i];
            } else if (profix > max) {
                max = profix;
            }
        }
        return max;
    }
}

