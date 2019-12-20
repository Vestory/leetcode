import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    /**
     * 307 / 307, 1ms(100%), 40.3MB(95.13%)
     */
    public int findUnsortedSubarray(int[] nums) {
        int l = -1, r = -1, len = nums.length, temp = 0, min = 0;
        int i = 0;
        while (++i < len) {
            if (nums[i] < nums[i - 1]) {
                // 暂存起始的l
                if (l == -1) {
                    l = i - 1;
                }
                // 更新r
                temp = i - 1;
                min = i;
                while (++i < len) {
                    if (nums[i] >= nums[temp]) {
                        break;
                    }
                    if (nums[i] < nums[min]) {
                        min = i;
                    }
                }
                r = i - 1;
                // 更新l
                if (l > 0 && nums[min] < nums[l - 1]) {
                    while (--l >= 0) {
                        if (nums[min] >= nums[l]) {
                            break;
                        }
                    }
                    ++l;
                }
            }
        }
        return r == l ? 0 : r - l + 1;
    }

    /**
     * 排序
     * 307 / 307, 11ms(56.22%), 40.6MB(95.13%)
     */
    // public int findUnsortedSubarray(int[] nums) {
    //     int len = nums.length, l = 0, r = len - 1;
    //     int[] arr = Arrays.copyOf(nums, len);
    //     Arrays.sort(arr);
    //     while (l < len) {
    //         if (arr[l] != nums[l]) {
    //             break;
    //         }
    //         ++l;
    //     }
    //     while (r >= l) {
    //         if (arr[r] != nums[r]) {
    //             break;
    //         }
    //         --r;
    //     }
    //     return l > r ? 0 : r - l + 1;
    // }
}
// @lc code=end

