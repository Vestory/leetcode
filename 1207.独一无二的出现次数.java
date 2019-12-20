import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    /**
     * 63 / 63, 4ms(30.3%), 34.6MB(100%)
     */
    // public boolean uniqueOccurrences(int[] arr) {
    //     int len = arr.length, i = 0;
    //     ArrayList<Integer> list = new ArrayList<>();
    //     while (i < len) {
    //         list.add(i);
    //         ++i;
    //     }
    //     len = 0;
    //     int count, cur;
    //     while (!list.isEmpty()) {
    //         count = 1;
    //         cur = arr[list.get(0)];
    //         list.remove(0);
    //         i = 0;
    //         while (i < list.size()) {
    //             if (arr[list.get(i)] == cur) {
    //                 list.remove(i);
    //                 ++count;
    //             } else {
    //                 ++i;
    //             }
    //         }
    //         for (int j = 0; j < len; ++j) {
    //             if (arr[j] == count) {
    //                 return false;
    //             }
    //         }
    //         arr[len] = count;
    //         ++len;
    //     }
    //     return true;
    // }

    /**
     * https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/li-yong-java-8te-xing-qiu-jie-by-recruit/
     * 63 / 63, 11ms(5.97%), 36.5MB(100%)
     */
    // public boolean uniqueOccurrences(int[] arr) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i : arr)
    //         map.merge(i, 1, Integer::sum);

    //     int i1 = map.values().stream().distinct().mapToInt(i -> i).sum();
    //     int i2 = map.values().stream().mapToInt(i -> i).sum();
    //     return i1 == i2;
    // }

    /**
     * https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/java-shi-jian-kong-jian-100hashmaphashset-by-magic/
     * 63 / 63, 2ms(93.73%), 35.8MB(100%)
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        // 记录出现次数
        for (int data : arr) {
            if (map.get(data) == null)
                map.put(data, 1);
            else
                map.put(data, map.get(data) + 1);
        }

        // 验证重复值
        for (Integer i : map.values()) {
            if (!set.add(i))
                return false;
        }
        return true;
    }
}
// @lc code=end

