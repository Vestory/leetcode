/*
 * @lc app=leetcode.cn id=1275 lang=java
 *
 * [1275] 找出井字棋的获胜者
 */

// @lc code=start
class Solution {
    /**
     * 100 / 100, 0ms(100%), 34.&MB(100%)
     */
    private int[][] moves;
    private int len;
    public String tictactoe(int[][] moves) {
        this.moves = moves;
        len = moves.length;
        if (len > 4) {
            if (isWinner(0)) {
                return "A";
            } else if (len > 5 && isWinner(1)) {
                return "B";
            } else if (len == 9) {
                return "Draw";
            }
        }
        return "Pending";
    }
    private boolean isWinner(int i) {
        int[] xcnts = new int[3];
        int[] ycnts = new int[3];
        boolean[] dia = new boolean[5];
        int x, y;
        while (i < len) {
            x = moves[i][0];
            y = moves[i][1];
            if (++xcnts[x] > 2 || ++ycnts[y] > 2) {
                return true;
            }
            if (x == 0) {
                if (y == 0) {
                    dia[0] = true;
                } else if (y == 2) {
                    dia[1] = true;
                }
            } else if (x == 1) {
                if (y == 1) {
                    dia[2] = true;
                }
            } else {
                if (y == 0) {
                    dia[3] = true;
                } else if (y == 2) {
                    dia[4] = true;
                }
            }
            i += 2;
        }
        return dia[2] && ((dia[0] && dia[4]) || (dia[1] && dia[3]));
    }
}
// @lc code=end

