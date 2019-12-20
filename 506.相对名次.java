import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    /**
     * 17 / 17, 10ms(71.89%), 40MB(95.65%)
     */
    // public String[] findRelativeRanks(int[] nums) {
    //     String[] text = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int r = nums.length;
    //     for (int i = 0; i < r; ++i) {
    //         map.put(nums[i], i);
    //     }
    //     Arrays.sort(nums);
    //     String[] res = new String[r];
    //     int l = r - 3;
    //     if (l < 0) {
    //         l = 0;
    //     }
    //     for (int i = 0; i < l; ++i) {
    //         res[map.get(nums[i])] = (r - i) + "";
    //     }
    //     int idx = 0;
    //     while (--r >= l) {
    //         res[map.get(nums[r])] = text[idx];
    //         ++idx;
    //     }
    //     return res;
    // }

    /**
     * https://leetcode-cn.com/problems/relative-ranks/solution/kong-jian-huan-shi-jian-sou-suo-by-joshue/
     * 17 / 17, 3ms(99.75%), 38MB(99.13%)
     */
    public String[] findRelativeRanks(int[] nums) {
        String[] s = new String[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = i + 1;
        }
        for (int i = max, flag = 1; i >= 0; i--) {
            if (dp[i] > 0) {
                switch (flag) {
                case 1:
                    s[dp[i] - 1] = "Gold Medal";
                    break;
                case 2:
                    s[dp[i] - 1] = "Silver Medal";
                    break;
                case 3:
                    s[dp[i] - 1] = "Bronze Medal";
                    break;
                default:
                    s[dp[i] - 1] = Integer.toString(flag);
                }
                flag++;
            }
        }
        return s;
    }
}
// @lc code=end
