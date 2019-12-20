import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    /**
     * 排序
     * 34 / 34, 35ms(11.22%), 47.4MB(94.31%)
     */
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     Arrays.sort(nums);
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     int i = 0, j = 1;
    //     while (i < nums.length) {
    //         if (j < nums[i]) {
    //             res.add(j++);
    //         } else if (j == nums[i]) {
    //             ++i;
    //             ++j;
    //         } else {
    //             ++i;
    //         }
    //     }
    //     while (j <= nums.length) {
    //         res.add(j++);
    //     }
    //     return res;
    // }

    /**
     * 超时
     */
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     List<Integer> list = new ArrayList<Integer>();
    //     for (int i = 1; i <= nums.length; ++i) {
    //         list.add(i);
    //     }
    //     for (int i = 0; i < nums.length; ++i) {
    //         list.remove((Object)(nums[i]));
    //     }
    //     return list;
    // }

    /**
     * 34 / 34, 30ms(12.92%), 51.7MB(81.57%)
     */
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         set.add(nums[i]);
    //     }
    //     List<Integer> list = new ArrayList<Integer>();
    //     for (int i = 1; i <= nums.length; ++i) {
    //         if (!set.contains(i)) {
    //             list.add(i);
    //         }
    //     }
    //     return list;
    // }

    /**
     * 原数组操作
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/cyuan-shu-zu-cao-zuo-by-haydenmiao/
     * 34 / 34, 6ms(96.61%), 46.8MB(97.29%)
     */
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     ArrayList<Integer> list = new ArrayList<Integer>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         int index = (nums[i] - 1) % nums.length;
    //         nums[index] += nums.length;
    //     }
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (nums[i] <= nums.length) {
    //             list.add(i + 1);
    //         }
    //     }
    //     return list;
    // }

    /**
     * 34 / 34, 8ms(85.63%), 46.3MB(98.37%)
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/tong-pai-xu-ji-yu-yi-huo-yun-suan-jiao-huan-liang-/
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }
}
// @lc code=end

