import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    /**
     * 133 / 133, 54ms(23.55%), 38.9MB(97.85%)
     */
    // public String[] findRestaurant(String[] list1, String[] list2) {
    //     int len1 = list1.length, len2 = list2.length, min = len1 + len2 - 1;
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < len1; ++i) {
    //         for (int j = 0; j < len2; ++j) {
    //             if (i + j > min) {
    //                 continue;
    //             }
    //             if (list1[i].equals(list2[j])) {
    //                 if (min > i + j) {
    //                     min = i + j;
    //                     sb = new StringBuilder(list1[i]);
    //                 } else if (min == i + j) {
    //                     sb.append("@");
    //                     sb.append(list1[i]);
    //                 }
    //             }
    //         }
    //     }
    //     return sb.toString().split("@");
    // }

    /**
     * 133 / 133, 52ms(23.73%), 38.4MB(97.85%)
     */
    // public String[] findRestaurant(String[] list1, String[] list2) {
    //     int len1 = list1.length, len2 = list2.length, min = len1 + len2 - 1;
    //     ArrayList<String> res = new ArrayList<>();
    //     for (int i = 0; i < len1; ++i) {
    //         for (int j = 0; j < len2; ++j) {
    //             if (i + j > min) {
    //                 continue;
    //             }
    //             if (list1[i].equals(list2[j])) {
    //                 if (min > i + j) {
    //                     min = i + j;
    //                     res.clear();
    //                     res.add(list1[i]);
    //                 } else if (min == i + j) {
    //                     res.add(list1[i]);
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     return res.toArray(new String[0]);
    // }

    /**
     * 使用哈希表
     * 133 / 133, 11ms(91.39%), 38MB(97.85%)
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length, len2 = list2.length, min = len1 + len2;
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; ++i) {
            map.put(list1[i], i);
        }
        int temp;
        for (int i = 0; i < len2; ++i) {
            temp = map.getOrDefault(list2[i], -1);
            if (temp != -1) {
                temp += i;
                if (temp == min) {
                    res.add(list2[i]);
                } else if (temp < min) {
                    min = temp;
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
// @lc code=end

