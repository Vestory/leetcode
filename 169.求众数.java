import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */
class Solution {

    /**
     * 穷举法
     * 可以优化一下，存储已经不合格的元素，然后跳过它们
     * 时间复杂度O(n * n)，空间复杂度O(1)
     * 44 / 44, 1680ms(5.4%), 41.8MB(83.66%)
     */
    // public int majorityElement(int[] nums) {
    //     int limit = nums.length / 2;
    //     for (int num : nums) {
    //         int count = 0;
    //         for (int elem : nums) {
    //             if (elem == num) {
    //                 count += 1;
    //             }
    //         }
    //         if (count > limit) {
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    /**
     * 哈希表统计
     * 时间复杂度和空间复杂度均为O(n)
     * 44 / 44, 16ms(33.72%), 41.4MB(84.25%)
     */
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int count = 0, length = nums.length / 2;
    //     for (int i = 0; i < nums.length; ++i) {
    //         count = map.getOrDefault(nums[i], 0) + 1;
    //         if (count >  length) {
    //             return nums[i];
    //         }
    //         map.put(nums[i], count);
    //     }
    //     return -1;
    // }

    /**
     * 排序
     * 如果所有数字被单调递增或者单调递减的顺序排了序，那么众数的下标为n / 2（n为奇数），n / 2 + 1（n为偶数）
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     * 时间复杂度O(nlgn)，空间复杂度O(1)或者是O(n)：我们将 nums 就地排序，如果不能就低排序，我们必须使用线性空间将 nums 数组拷贝，然后再排序
     * 44 / 44, 2ms(99.53%), 41.8MB(83.7%)
     */
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // #region [0] 随机法
    /**
     * 随机法
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     * 随机选一个下标，然后判断是不是众数，是则返回，不是继续
     * 时间复杂度理论上为O(无穷)，但实际上通常是线性的，空间复杂度O(1)
     * 44 / 44, 3ms(94.41%), 41.8MB(83.7%)
     */
    // private int randRange(Random rand, int min, int max) {
    //     return rand.nextInt(max - min) + min;
    // }

    // private int countOccurences(int[] nums, int num) {
    //     int count = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (nums[i] == num) {
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    // public int majorityElement(int[] nums) {
    //     Random rand = new Random();
    //     int majorityCount = nums.length / 2;
    //     while (true) {
    //         int candidate = nums[randRange(rand, 0, nums.length)];
    //         if (countOccurences(nums, candidate) > majorityCount) {
    //             return candidate;
    //         }
    //     }
    // }
    // #endregion

    // #region [0] 分治
    /**
     * 分治策略 如果我们知道数组左边一半和右边一半的众数，我们就可以用线性时间知道全局的众数是哪个
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     * 时间复杂度O(nlgn)，空间复杂度O(lgn)
     * 44 / 44, 2ms(99.53%), 39.7MB(93.53%)
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; ++i) {
            if (nums[i] == num) {
                ++count;
            }
        }
        return count;
    }

    private int majorityElemeec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElemeec(nums, lo, mid);
        int right = majorityElemeec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElemeec(nums, 0, nums.length - 1);
    }
    // #endregion

    /**
     * Boyer-Moore投票算法
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     * 时间复杂度O(n)，空间复杂度O(1)
     * 44 / 44, 3ms(94.41%), 42MB(83.51%)
     */
    // public int majorityElement(int[] nums) {
    //     int count = 0;
    //     Integer candidate = null;
    //     for (int num : nums) {
    //         if (count == 0) {
    //             candidate = num;
    //         }
    //         count += (num == candidate) ? 1 : -1;
    //     }
    //     return candidate;
    // }
}

