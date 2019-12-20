import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */
class Solution {
    /**
     * 每次都从后向前计算，在上一层的结果基础上计算下一层结果，每次均计算一半，等需要返回时，才复制另一半出来，并返回
     * 34 / 34, 1ms(99.29%), 33.4MB(34.01%)
     */
    // public List<Integer> getRow(int rowIndex) {
    //     List<Integer> list = new ArrayList<Integer>();
    //     if (rowIndex < 0) {
    //         return list;
    //     }
    //     list.add(1);
    //     if (rowIndex == 0) {
    //         return list;
    //     }
    //     if (rowIndex == 1) {
    //         list.add(1);
    //         return list;
    //     }
    //     int j;
    //     for (int i = 2; i <= rowIndex; ++i) {
    //         j = (i - 1) / 2;
    //         if (i % 2 == 0) {
    //             list.add(2 * list.get(j));
    //         }
    //         while (j > 0) {
    //             list.set(j, list.get(j - 1) + list.get(j));
    //             --j;
    //         }
    //     }
    //     j = rowIndex % 2 == 0 ? (list.size() - 2) : (list.size() - 1);
    //     while (j >= 0) {
    //         list.add(list.get(j));
    //         --j;
    //     }
    //     return list;
    // }

    // #region [0] 其他解法
    // https://leetcode-cn.com/problems/pascals-triangle-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--28/
    /**
     * 从前往后1
     * 34 / 34, 2ms(80.29%), 34MB(22.2%)
     */
    // public List<Integer> getRow(int rowIndex) {
    //     List<Integer> pre = new ArrayList<>();
    //     List<Integer> cur = new ArrayList<>();
    //     for (int i = 0; i <= rowIndex; ++i) {
    //         cur = new ArrayList<>();
    //         for (int j = 0; j <= i; ++j) {
    //             if (j == 0 || j == i) {
    //                 cur.add(1);
    //             } else {
    //                 cur.add(pre.get(j - 1) + pre.get(j));
    //             }
    //         }
    //         pre = cur;
    //     }
    //     return cur;
    // }

    /**
     * 从前往后2
     * 34 / 34, 2ms(80.29%), 33.6MB(23.75%)
     */
    // public List<Integer> getRow(int rowIndex) {
    //     int pre = 1;
    //     List<Integer> cur = new ArrayList<>();
    //     cur.add(1);
    //     for (int i = 1; i <= rowIndex; ++i) {
    //         for (int j = 1; j < i; ++j) {
    //             int temp = cur.get(j);
    //             cur.set(j, pre + cur.get(j));
    //             pre = temp;
    //         }
    //         cur.add(1);
    //     }
    //     return cur;
    // }

    /**
     * 从后往前
     * 34 / 34, 1ms(99.29%), 33.6MB(24.58%)
     */
    // public List<Integer> getRow(int rowIndex) {
    //     int pre = 1;
    //     List<Integer> cur = new ArrayList<>();
    //     cur.add(1);
    //     for (int i = 1; i <= rowIndex; ++i) {
    //         for (int j = i - 1; j > 0; --j) {
    //             cur.set(j, cur.get(j - 1) + cur.get(j));
    //         }
    //         cur.add(1);
    //     }
    //     return cur;
    // }

    /**
     * 公式法
     * 34 / 34, 0ms(100%), 33.6MB(24.58%)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int n = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= n; ++k) {
            long cur = pre * (n - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    // #endregion
}
