/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    /**
     * 公式法
     * 27 / 27, 0ms(100%), 33.9MB(100%)
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int round = (int) ((Math.sqrt(1 + 8 * (double)candies) - 1) / 2 / num_people);
        int sum = 0;
        if (round > 0) {
            for (int i = 0; i < num_people; ++i) {
                res[i] = (2 * i + 2 + (round - 1) * num_people) * round / 2;
                sum += res[i];
            }
        }
        candies -= sum;
        sum = round * num_people + 1;
        for (int i = 0; i < num_people; ++i) {
            if (candies > sum) {
                res[i] += sum;
                candies -= sum;
                ++sum;
            } else {
                res[i] += candies;
                break;
            }
        }
        return res;
    }
}
// @lc code=end

