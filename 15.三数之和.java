import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    /**
     * 313 / 313, 135ms(14.6%), 49.1MB(85.76%)
     */
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i : nums) {
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
    //     int len = 0;
    //     int[] keys = new int[map.size()];
    //     for (int i : map.keySet()) {
    //         keys[len++] = i;
    //     }
    //     Set<Integer> visited = new HashSet<>();
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     List<Integer> list;
    //     int a, b, c, temp;
    //     for (int i = 0; i < len; ++i) {
    //         a = keys[i];
    //         for (int j = i; j < len; ++j) {
    //             b = keys[j];
    //             if (visited.contains(b)) {
    //                 continue;
    //             }
    //             c = -a - b;
    //             if (a == b) {
    //                 temp = map.get(a);
    //                 if (temp < 2) {
    //                     continue;
    //                 }
    //                 if (a == c) {
    //                     if (temp < 3) {
    //                         continue;
    //                     }
    //                 } else if (!map.containsKey(c)) {
    //                     continue;
    //                 }
    //             } else {
    //                 temp = map.getOrDefault(c, 0);
    //                 if (temp == 0 || (temp == 1 && (a == c || b == c))) {
    //                     continue;
    //                 }
    //             }
    //             list = new ArrayList<>();
    //             list.add(a);
    //             list.add(b);
    //             list.add(c);
    //             res.add(list);
    //             visited.add(c);
    //         }
    //         visited.clear();
    //         map.remove(a);
    //     }
    //     return res;
    // }

    /**
     * 排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list;
        int l = 0, r = nums.length - 1, need, i;
        while (l < r) {
            need = -nums[l] - nums[r];
            if (need >= 0) {
                i = r - 1;
                while (i > l) {
                    if (nums[i] == need) {
                        list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[r]);
                        list.add(need);
                        res.add(list);
                        break;
                    }
                    --i;
                }
                if (need == 0 && nums[l] % 2 == 0 && r - i > 2) {
                    need = -nums[l] / 2;
                    while (++i < r) {
                        if (nums[i] == need) {
                            break;
                        }
                    }
                    if (i + 1 < r && nums[i + 1] == need) {
                        list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(need);
                        list.add(need);
                        res.add(list);
                    }
                }
                ++l;
                while (l < r) {
                    if (nums[l] != nums[l - 1]) {
                        break;
                    }
                    ++l;
                }
            } else {
                i = l + 1;
                while (i < r) {
                    if (nums[i] == need) {
                        list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[r]);
                        list.add(need);
                        res.add(list);
                        break;
                    }
                    ++i;
                }
                --r;
                while (l < r) {
                    if (nums[r] != nums[r + 1]) {
                        break;
                    }
                    --r;
                }
            }
        }
        return res;
    }
}
// @lc code=end

