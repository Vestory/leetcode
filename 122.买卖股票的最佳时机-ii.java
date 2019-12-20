/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */
class Solution {
    /**
     * 从前往后，根据趋势
     * 201 / 201, 1ms(100%), 37.3MB(71.7%)
     */
    // public int maxProfit(int[] prices) {
    //     if (prices.length < 2) {
    //         return 0;
    //     }
    //     int max = 0;
    //     int start = prices[0];
    //     int i = 1;
    //     while (i < prices.length) {
    //         if (prices[i - 1] > prices[i] && start != -1) {
    //             max += prices[i - 1] - start;
    //             start = -1;
    //         } else if (prices[i - 1] < prices[i] && start == -1) {
    //             start = prices[i - 1];
    //         }
    //         ++i;
    //     }
    //     if (prices[i - 2] <= prices[i - 1] && start != -1) {
    //         max += prices[i - 1] - start;
    //     }
    //     return max;
    // }

    // #region [0] 官方题解
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
    /**
     * 穷举法
     * 时间复杂度O(n * n)，空间复杂度O(n)
     * 超时
     */
    // public int maxProfit(int[] prices) {
    //     return calculate(prices, 0);
    // }

    // public int calculate(int prices[], int s) {
    //     if (s >= prices.length) {
    //         return 0;
    //     }
    //     int max = 0;
    //     for (int start = s; start < prices.length; ++start) {
    //         int maxprofit = 0;
    //         for (int i = start + 1; i < prices.length; ++i) {
    //             if (prices[start] < prices[i]) {
    //                 int profit = calculate(prices, i + 1) + prices[i] - prices[start];
    //                 if (profit > maxprofit) {
    //                     maxprofit = profit;
    //                 }
    //             }
    //         }
    //         if (maxprofit > max) {
    //             max = maxprofit;
    //         }
    //     }
    //     return max;
    // }

    /**
     * 峰谷法
     * 时间复杂度O(n)，空间复杂度O(1)
     * 201 / 201, 1ms(100%), 35.7MB(98.98%)
     */
    // public int maxProfit(int[] prices) {
    //     if (prices.length < 2) {
    //         return 0;
    //     }
    //     int i = 0;
    //     int valley = prices[0];
    //     int peak = prices[0];
    //     int maxprofit = 0;
    //     while (i < prices.length - 1) {
    //         while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
    //             ++i;
    //         }
    //         valley = prices[i];
    //         while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
    //             ++i;
    //         }
    //         peak = prices[i];
    //         maxprofit += peak - valley;
    //     }
    //     return maxprofit;
    // }

    /**
     * 简单一次遍历
     * 时间复杂度O(n), 空间复杂度O(1)
     * 201 / 201, 1ms(100%), 36.3MB(97.1%)
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    // #endregion
}

