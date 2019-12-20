import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 车的可用捕获量
 */

// @lc code=start
class Solution {
    // private char[][] board;
    // private int size;
    // public int numRookCaptures(char[][] board) {
    //     int x = -1, y = -1;
    //     size = 8;
    //     this.board = board;
    //     for (int i = 0; i < size; ++i) {
    //         for (int j = 0; j < size; ++j) {
    //             if (board[i][j] == 'R') {
    //                 x = i;
    //                 y = j;
    //                 break;
    //             }
    //         }
    //         if (x != -1) {
    //             break;
    //         }
    //     }
    //     int curx = 0, maxx = 0, cury = 0, maxy = 0, cur;
    //     for (int i = x; i > -1; --i) {
    //         if ((board[i][y] == '.' || i == x) && maxx < 2) {
    //             cur = getCount(false, i, y);
    //             if (cur > maxx) {
    //                 maxx = cur;
    //             }
    //         } else {
    //             if (board[i][y] == 'p') {
    //                 ++curx;
    //             }
    //             break;
    //         }
    //     }
    //     for (int i = x + 1; i < size; ++i) {
    //         if (board[i][y] == '.' && maxx < 2) {
    //             cur = getCount(false, i, y);
    //             if (cur > maxx) {
    //                 maxx = cur;
    //             }
    //         } else {
    //             if (board[i][y] == 'p') {
    //                 ++curx;
    //             }
    //             break;
    //         }
    //     }
    //     curx += maxx;
    //     if (curx > 3) {
    //         return curx;
    //     }
    //     for (int i = y; i > -1; --i) {
    //         if ((board[x][i] == '.' || i == y) && maxy < 2) {
    //             cur = getCount(true, x, i);
    //             if (cur > maxy) {
    //                 maxy = cur;
    //             }
    //         } else {
    //             if (board[x][i] == 'p') {
    //                 ++cury;
    //             }
    //             break;
    //         }
    //     }
    //     for (int i = y + 1; i < size; ++i) {
    //         if (board[x][i] == '.' && maxy < 2) {
    //             cur = getCount(true, x, i);
    //             if (cur > maxy) {
    //                 maxy = cur;
    //             }
    //         } else {
    //             if (board[x][i] == 'p') {
    //                 ++cury;
    //             }
    //             break;
    //         }
    //     }
    //     cury += maxy;
    //     return curx > cury ? curx : cury;
    // }
    // private int getCount(boolean atx, int x, int y) {
    //     int count = 0;
    //     if (atx) {
    //         for (int i = x - 1; i > -1; --i) {
    //             if (board[i][y] == 'p') {
    //                 ++count;
    //                 break;
    //             } else if (board[i][y] == 'B') {
    //                 break;
    //             }
    //         }
    //         for (int i = x + 1; i < size; ++i) {
    //             if (board[i][y] == 'p') {
    //                 ++count;
    //                 break;
    //             } else if (board[i][y] == 'B') {
    //                 break;
    //             }
    //         }
    //     } else {
    //         for (int i = y - 1; i > -1; --i) {
    //             if (board[x][i] == 'p') {
    //                 ++count;
    //                 break;
    //             } else if (board[x][i] == 'B') {
    //                 break;
    //             }
    //         }
    //         for (int i = y + 1; i < size; ++i) {
    //             if (board[x][i] == 'p') {
    //                 ++count;
    //                 break;
    //             } else if (board[x][i] == 'B') {
    //                 break;
    //             }
    //         }
    //     }
    //     return count;
    // }

    /**
     * https://leetcode-cn.com/problems/available-captures-for-rook/solution/java-0msjie-fa-by-littlefogcat/
     * 22 / 22, 0ms(100%), 34.2MB(53.74%)
     */
    public int numRookCaptures(char[][] board) {
        int r = 0;
        int rx = 0, ry = 0; // 车的位置
        out: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('R' == board[i][j]) {
                    rx = i;
                    ry = j;
                    break out;
                }
            }
        }
        char[] directions = { 'u', 'd', 'l', 'r' };
        for (int x = rx, y = ry, i = 0; i < 4;) {
            char d = directions[i];
            switch (d) {
            case 'u':
                x--; // 往上移动
                break;
            case 'd':
                x++; // 往下移动
                break;
            case 'l':
                y--; // 往左移动
                break;
            case 'r':
                y++; // 往右移动
                break;
            }
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                String chess = "" + board[x][y];
                // System.out.println("遇见了(" + x + "," + y + ") " + chess);
                if (!".".equals(chess)) {
                    if ("p".equals(chess))
                        r++;
                    i++;
                    x = rx;
                    y = ry;
                }
            } else {
                i++;
                x = rx;
                y = ry;
            }
        }
        return r;
    }
}
// @lc code=end