import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    /**
     * 19 / 19, 22ms(42.59%), 56.1MB(100%)
     */
    // public int numEquivDominoPairs(int[][] dominoes) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     list.add(0);
    //     int len = dominoes.length;
    //     int[] counts = new int[len];
    //     int idx = 0;
    //     for (int i = 1; i < len; ++i) {
    //         for (int j = 0; j < list.size(); ++j) {
    //             idx = list.get(j);
    //             if ((dominoes[i][0] == dominoes[idx][0] && dominoes[i][1] == dominoes[idx][1]) || (dominoes[i][0] == dominoes[idx][1] && dominoes[i][1] == dominoes[idx][0])) {
    //                 ++counts[j];
    //                 idx = -1;
    //                 break;
    //             }
    //         }
    //         if (idx != -1) {
    //             list.add(i);
    //         }
    //     }
    //     len = list.size();
    //     idx = 0;
    //     for (int i = 0; i < len; ++i) {
    //         idx += (counts[i] * (counts[i] + 1)) / 2;
    //     }
    //     return idx;
    // }

    /**
     * 19 / 19, 11ms(53.63%), 55.3MB(100%)
     */
    // public int numEquivDominoPairs(int[][] dominoes) {
    //     int len = dominoes.length;
    //     int size = 1;
    //     int[] idxs = new int[len];
    //     int[] counts = new int[len];
    //     int idx = 0;
    //     for (int i = 1; i < len; ++i) {
    //         for (int j = 0; j < size; ++j) {
    //             idx = idxs[j];
    //             if ((dominoes[i][0] == dominoes[idx][0] && dominoes[i][1] == dominoes[idx][1])
    //                     || (dominoes[i][0] == dominoes[idx][1] && dominoes[i][1] == dominoes[idx][0])) {
    //                 ++counts[j];
    //                 idx = -1;
    //                 break;
    //             }
    //         }
    //         if (idx != -1) {
    //             idxs[size] = i;
    //             ++size;
    //         }
    //     }
    //     idx = 0;
    //     for (int i = 0; i < size; ++i) {
    //         idx += (counts[i] * (counts[i] + 1)) / 2;
    //     }
    //     return idx;
    // }

    /**
     * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/zui-jian-javashi-xian-pai-xu-tong-ji-by-cysionliu/
     * 19 / 19, 4ms(77.6%), 50.3MB(100%)
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
            ans += cp[arr[0] * 10 + arr[1]]++;
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/shi-yong-shuang-zhong-hashmapjin-xing-jie-da-by-ch/
     * 19 / 19, 24ms(39.12%), 55.9MB(100%)
     */
    // public int numEquivDominoPairs(int[][] dominoes) {
    //     // 初始化Map集合
    //     HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    //     // 定义总数sum，并初始化为0
    //     int sum = 0;
    //     // 循环遍历二维数组dominoes
    //     for (int i = 0; i < dominoes.length; i++) {
    //         // 获取当前「数字对」的值，并将较小的值设置为a,较大的值设置为b
    //         Integer a = dominoes[i][0];
    //         Integer b = dominoes[i][1];
    //         if (a > b) {
    //             a = dominoes[i][1];
    //             b = dominoes[i][0];
    //         }
    //         // 将a 作为Map1的key1
    //         // 而b 作为Map1的value1 （即map2) 的key2

    //         // 判断Map1中是否有key1 为 a 的值
    //         if (map.containsKey(a)) {
    //             HashMap<Integer, Integer> list = map.get(a);
    //             // 判断Map2中是否有key2 为 b 的值
    //             if (list.containsKey(b)) {
    //                 // 获取value2的值并加入到sum中
    //                 int count = list.get(b);
    //                 sum = sum + count;
    //                 // 对应的value的值+1
    //                 list.put(b, count + 1);
    //                 map.put(a, list);

    //             } else {
    //                 // 初始化数值为1
    //                 list.put(b, 1);
    //                 map.put(a, list);
    //             }
    //         } else {
    //             // 初始化数值为1
    //             HashMap<Integer, Integer> list = new HashMap<>();
    //             list.put(b, 1);
    //             map.put(a, list);
    //         }
    //     }
    //     return sum;
    // }
}
// @lc code=end

