import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
class Solution {
    /**
     * 58 / 58, 18ms(26.57%), 59.4MB(85.9%)
     */
    // public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    // HashSet<Integer> set = new HashSet<>();
    // int sum = 0, len = A.length;
    // for (int i = 0; i < len; ++i) {
    // if (A[i] % 2 == 0) {
    // sum += A[i];
    // set.add(i);
    // }
    // }
    // len = queries.length;
    // int[] res = new int[len];
    // for (int i = 0; i < len; ++i) {
    // if (set.contains(queries[i][1])) {
    // if (queries[i][0] % 2 == 0) {
    // sum += queries[i][0];
    // } else {
    // sum -= A[queries[i][1]];
    // set.remove(queries[i][1]);
    // }
    // A[queries[i][1]] += queries[i][0];
    // } else {
    // A[queries[i][1]] += queries[i][0];
    // if (queries[i][0] % 2 != 0) {
    // set.add(queries[i][1]);
    // sum += A[queries[i][1]];
    // }
    // }
    // res[i] = sum;
    // }
    // return res;
    // }

    /**
     * 58 / 58, 5ms(96.98%), 58.8MB(88.63%)
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0, len = A.length;
        for (int i = 0; i < len; ++i) {
            if (A[i] % 2 == 0) {
                sum += A[i];
            }
        }
        len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            if (A[queries[i][1]] % 2 == 0) {
                if (queries[i][0] % 2 == 0) {
                    sum += queries[i][0];
                } else {
                    sum -= A[queries[i][1]];
                }
                A[queries[i][1]] += queries[i][0];
            } else {
                A[queries[i][1]] += queries[i][0];
                if (queries[i][0] % 2 != 0) {
                    sum += A[queries[i][1]];
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
// @lc code=end
