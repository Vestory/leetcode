import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    /**
     * use to print the map and path
     */
    // private static int xmax = 0;
    // private static int ymax = 0;
    // private static char[][] map;
    // private static char[] symbol = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
    //         'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
    //         'z', '!', '@', '$', '%' };
    // private static int curIdx = 0;

    // private static void drawMap(int[][] obstacles) {
    //     int xcur, ycur;
    //     for (int[] p : obstacles) {
    //         xcur = Math.abs(p[0]);
    //         ycur = Math.abs(p[1]);
    //         if (xcur > xmax) {
    //             xmax = xcur;
    //         }
    //         if (ycur > ymax) {
    //             ymax = ycur;
    //         }
    //     }
    //     map = new char[xmax * 2 + 1][ymax * 2 + 1];
    //     for (int i = 0; i < map.length; ++i) {
    //         for (int j = 0; j < map[0].length; ++j) {
    //             map[i][j] = '.';
    //         }
    //     }
    //     for (int[] p : obstacles) {
    //         map[p[0] + xmax][p[1] + ymax] = '#';
    //     }
    // }

    // private static void drawPath(int fx, int fy, int tx, int ty) {
    //     int temp;
    //     if (fx > tx) {
    //         temp = fx;
    //         fx = tx;
    //         tx = temp;
    //     } else if (fy > ty) {
    //         temp = fy;
    //         fy = ty;
    //         ty = temp;
    //     }
    //     while (fx <= tx) {
    //         while (fy <= ty) {
    //             map[fx + xmax][fy + ymax] = symbol[curIdx];
    //             ++fy;
    //         }
    //         fy = ty;
    //         ++fx;
    //     }
    //     ++curIdx;
    // }

    // private static void printMap() throws IOException {
    //     StringBuilder sb = new StringBuilder();
    //     map[xmax][ymax] = '+';
    //     for (int i = 0; i < map.length; ++i) {
    //         for (int j = 0; j < map[0].length; ++j) {
    //             sb.append(map[i][j]);
    //         }
    //         sb.append('\n');
    //     }
    //     File file = new File("C:\\Users\\WuJiangtao\\Desktop\\map.txt");
    //     Writer out = new FileWriter(file);
    //     out.write(sb.toString());
    //     out.close();
    //     log(sb.toString());
    // }

    /**
     * 47 / 47, 226ms(12.35%), 60.9MB(63.78%)
     */
    // public int robotSim(int[] commands, int[][] obstacles) {
    //     int des = commands.length, size = 0, i = 0, dir = 0, steps, temp, startDir = 0;
    //     // comvert commands to [steps, dir, steps, dir.....], the start direction is
    //     // stored in startDir
    //     while (i < des) {
    //         while (i < des) {
    //             temp = commands[i];
    //             if (temp > 0) {
    //                 break;
    //             } else if (temp == -1) {
    //                 dir = (dir + 1) % 4;
    //             } else if (--dir < 0) {
    //                 dir = 3;
    //             }
    //             ++i;
    //         }
    //         if (i == des) {
    //             break;
    //         }
    //         steps = 0;
    //         while (i < des) {
    //             temp = commands[i];
    //             if (temp < 0) {
    //                 break;
    //             }
    //             steps += temp;
    //             ++i;
    //         }
    //         if (size == 0) {
    //             startDir = dir;
    //             commands[size] = steps;
    //             ++size;
    //         } else {
    //             commands[size] = dir;
    //             ++size;
    //             commands[size] = steps;
    //             ++size;
    //         }
    //     }
    //     int x = 0, y = 0, max = 0;
    //     i = 0;
    //     while (i < size) {
    //         if (i != 0) {
    //             dir = commands[i];
    //             ++i;
    //         } else {
    //             dir = startDir;
    //         }
    //         steps = commands[i];
    //         ++i;
    //         switch (dir) {
    //         case 0:
    //             des = y + steps;
    //             for (int[] p : obstacles) {
    //                 if (p[0] == x && p[1] > y && p[1] <= des) {
    //                     des = p[1] - 1;
    //                 }
    //             }
    //             y = des;
    //             break;
    //         case 1:
    //             des = x + steps;
    //             for (int[] p : obstacles) {
    //                 if (p[1] == y && p[0] > x && p[0] <= des) {
    //                     des = p[0] - 1;
    //                 }
    //             }
    //             x = des;
    //             break;
    //         case 2:
    //             des = y - steps;
    //             for (int[] p : obstacles) {
    //                 if (p[0] == x && p[1] < y && p[1] >= des) {
    //                     des = p[1] + 1;
    //                 }
    //             }
    //             y = des;
    //             break;
    //         case 3:
    //             des = x - steps;
    //             for (int[] p : obstacles) {
    //                 if (p[1] == y && p[0] < x && p[0] >= des) {
    //                     des = p[0] + 1;
    //                 }
    //             }
    //             x = des;
    //             break;
    //         default:
    //             break;
    //         }
    //         temp = x * x + y * y;
    //         if (max < temp) {
    //             max = temp;
    //         }
    //     }
    //     return max;
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-leetcode/
     * 47 / 47, 19ms(95.16%), 57.2MB(70.87%)
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }
        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2) // left
                di = (di + 3) % 4;
            else if (cmd == -1) // right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
