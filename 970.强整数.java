import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
class Solution {
    /**
     * 93 / 93, 2ms(90.73%), 34MB(79.33%)
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        if (x == 1 && y == 1) {
            if (bound >= 2) {
                res.add(2);
            }
        } else if (x != 1 && y != 1) {
            if (x != y) {
                Set<Integer> set = new HashSet<>();
                int len = 21, lx = -1, ly = -1;
                int[] xarr = new int[len];
                int[] yarr = new int[len];
                xarr[0] = 1;
                yarr[0] = 1;
                for (int i = 1; i < len; ++i) {
                    if (lx == -1) {
                        xarr[i] = xarr[i - 1] * x;
                        if (xarr[i] >= bound) {
                            lx = i;
                        }
                    }
                    if (ly == -1) {
                        yarr[i] = yarr[i - 1] * y;
                        if (yarr[i] >= bound) {
                            ly = i;
                        }
                    }
                    if (lx != -1 && ly != -1) {
                        break;
                    }
                }
                for (int i = 0; i < lx; ++i) {
                    for (int j = 0; j < ly; ++j) {
                        len = xarr[i] + yarr[j];
                        if (len > bound) {
                            break;
                        }
                        set.add(len);
                    }
                }
                for (int val : set) {
                    res.add(val);
                }
            } else {
                int len = 21, temp;
                int[] arr = new int[len];
                arr[0] = 1;
                for (int i = 1; i < len; ++i) {
                    arr[i] = arr[i - 1] * x;
                    if (arr[i] >= bound) {
                        len = i;
                        break;
                    }
                }
                for (int i = 0; i < len; ++i) {
                    for (int j = i; j < len; ++j) {
                        temp = arr[i] + arr[j];
                        if (temp > bound) {
                            break;
                        }
                        res.add(temp);
                    }
                }
            }
        } else {
            if (x == 1) {
                x = y;
            }
            int len = 21;
            int[] arr = new int[len];
            arr[0] = 1;
            for (int i = 1; i < len; ++i) {
                arr[i] = arr[i - 1];
                if (arr[i] >= bound) {
                    break;
                }
                res.add(arr[i] + 1);
                arr[i] *= x;
            }
        }
        return res;
    }

    /**
     * 官方解题
     * 暴力法
     * https://leetcode-cn.com/problems/powerful-integers/solution/qiang-zheng-shu-by-leetcode/
     * Wrong Answer in case 92 / 93
     */
    // public List<Integer> powerfulIntegers(int x, int y, int bound) {
    //     Set<Integer> seen = new HashSet<>();
    //     for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
    //         for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
    //             int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
    //             if (v <= bound)
    //                 seen.add(v);
    //         }
    //     return new ArrayList<>(seen);
    // }
}
// @lc code=end

