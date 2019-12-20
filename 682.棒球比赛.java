import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    /**
     * 39 / 39, 2ms(100%), 36.2MB(44.62%)
     */
    public int calPoints(String[] ops) {
        int len = ops.length, res = 0, temp;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            switch (ops[i]) {
            case "+":
                temp = list.size();
                temp = list.get(temp - 1) + list.get(temp - 2);
                res += temp;
                list.add(temp);
                break;
            case "D":
                temp = list.get(list.size() - 1);
                temp *= 2;
                res += temp;
                list.add(temp);
                break;
            case "C":
                res -= list.remove(list.size() - 1);
                break;
            default:
                temp = Integer.parseInt(ops[i]);
                res += temp;
                list.add(temp);
                break;
            }
        }
        return res;
    }
}
// @lc code=end
