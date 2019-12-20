import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    /**
     * 使用hashset
     * 205 / 205, 53ms(77.02%), 43.1MB(92.56%)
     */
    // public int distributeCandies(int[] candies) {
    //     HashSet<Integer> set = new HashSet<>();
    //     int len = candies.length;
    //     for (int i = 0; i < candies.length; ++i) {
    //         set.add(candies[i]);
    //     }
    //     len /= 2;
    //     return len > set.size() ? set.size() : len;
    // }

    /**
     * 使用hashset，可以和上一种方法对比一下
     * 205 / 205, 44ms(91.9%), 41.3MB(95.79%)
     * 205 / 205, 34ms(94.86%), 40.4MB(97.41%)
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        int len = candies.length, half = len / 2;
        for (int i = 0; i < candies.length; ++i) {
            set.add(candies[i]);
            if (set.size() > half) {
                return half;
            }
        }
        return set.size();
    }

    /**
     * 使用hashset，可以和上一种方法对比一下
     * 205 / 205, 53ms(77.02%), 45.2MB(86.73%)
     */
    // public int distributeCandies(int[] candies) {
    //     HashSet<Integer> set = new HashSet<>();
    //     int len = candies.length, half = len / 2, count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (!set.contains(candies[i])) {
    //             set.add(candies[i]);
    //             if (++count > half) {
    //                 return half;
    //             }
    //         }
    //     }
    //     return count;
    // }

    /**
     * 使用ArrayList，可以和上一种方法对比一下，list查找元素真的比HashSet慢很多
     * 205 / 205, 892ms(5.03%), 46MB(86.09%)
     */
    // public int distributeCandies(int[] candies) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int len = candies.length, half = len / 2, count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (!list.contains(candies[i])) {
    //             list.add(candies[i]);
    //             if (++count > half) {
    //                 return half;
    //             }
    //         }
    //     }
    //     return count;
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/distribute-candies/solution/fen-tang-guo-by-leetcode/
     */
}
// @lc code=end

