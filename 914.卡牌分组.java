import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    /**
     * 69 / 69, 15ms(41.91%), 38.1MB(92.2%)
     */
    // public boolean hasGroupsSizeX(int[] deck) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int len = deck.length, min = Integer.MAX_VALUE, cur;
    //     for (int i = 0; i < len; ++i) {
    //         map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
    //     }
    //     Iterator<Integer> iterator = map.values().iterator();
    //     while (iterator.hasNext()) {
    //         cur = iterator.next();
    //         if (cur < min) {
    //             min = cur;
    //         }
    //     }
    //     boolean valid;
    //     for (int i = 2; i <= min; ++i) {
    //         iterator = map.values().iterator();
    //         valid = true;
    //         while (iterator.hasNext()) {
    //             cur = iterator.next();
    //             if (cur % i != 0) {
    //                 valid = false;
    //                 break;
    //             }
    //         }
    //         if (valid) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * 69 / 69, 15ms(41.91%), 38.1MB(92.2%)
     */
    // public boolean hasGroupsSizeX(int[] deck) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int len = deck.length, min = Integer.MAX_VALUE;
    //     for (int i = 0; i < len; ++i) {
    //         map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
    //     }
    //     Iterator<Integer> iterator = map.values().iterator();
    //     len = map.size();
    //     int[] arr = new int[len];
    //     int idx = -1;
    //     while (iterator.hasNext()) {
    //         arr[++idx] = iterator.next();
    //         if (arr[idx] < min) {
    //             min = arr[idx];
    //         }
    //     }
    //     for (int i = 2; i <= min; ++i) {
    //         idx = -1;
    //         while (++idx < len) {
    //             if (arr[idx] % i != 0) {
    //                 break;
    //             }
    //         }
    //         if (idx == len) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * 69 / 69, 3ms(84.74%), 38.8MB(91.28%)
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] map = new int[10000];
        int len = deck.length, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            ++map[deck[i]];
        }
        for (int i = 0; i < len; ++i) {
            if (map[deck[i]] < min) {
                min = map[deck[i]];
            }
        }
        int idx;
        for (int i = 2; i <= min; ++i) {
            idx = -1;
            while (++idx < len) {
                if (map[deck[idx]] % i != 0) {
                    break;
                }
            }
            if (idx == len) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

