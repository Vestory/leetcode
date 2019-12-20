import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    /**
     * 49 / 49, 37ms(10%), 38.3MB(97.84%)
     */
    // public int[] findErrorNums(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     int n = nums.length, x = 0, y;
    //     for (int i = 1; i <= n; ++i) {
    //         set.add(i);
    //     }
    //     for (int i = 0; i < n; ++i) {
    //         if (!set.remove(nums[i])) {
    //             x = nums[i];
    //         }
    //     }
    //     y = set.iterator().next();
    //     return new int[] { x, y };
    // }

    /**
     * 49 / 49, 2ms(100%), 38.8MB(95.14%)
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, x = -1, y = -1;
        int[] arr = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; ++i) {
            arr[nums[i] - 1] -= n;
        }
        for (int i = 0; i < n; ++i) {
            if (arr[i] <= -n) {
                x = i + 1;
                if (y != -1) {
                    break;
                }
            }
            if (arr[i] > 0) {
                y = i + 1;
                if (x != -1) {
                    break;
                }
            }
        }
        return new int[] { x, y };
    }
}
// @lc code=end

