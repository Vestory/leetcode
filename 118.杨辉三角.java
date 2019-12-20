import java.util.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */
class Solution {
    /**
     * 动态规划
     * 时间复杂度和空间复杂度都是O(numRows * numRows)
     * 15 / 15, 1ms(99.92%), 34.1MB(25.94%)
     */
    // public List<List<Integer>> generate(int numRows) {
    //     if (numRows < 1) {
    //         return new ArrayList<List<Integer>>();
    //     }
    //     List<List<Integer>> list = new ArrayList<List<Integer>>();
    //     List<Integer> array = new ArrayList<Integer>();
    //     array.add(1);
    //     list.add(array);
    //     if (numRows == 1) {
    //         return list;
    //     }
    //     array = new ArrayList<Integer>();
    //     array.add(1);
    //     array.add(1);
    //     list.add(array);
    //     if (numRows == 2) {
    //         return list;
    //     }
    //     --numRows;
    //     List<Integer> last = list.get(1);
    //     for (int i = 1; i < numRows; ++i) {
    //         array = new ArrayList<Integer>();
    //         array.add(1);
    //         for (int j = 1; j < last.size(); ++j) {
    //             array.add(last.get(j - 1) + last.get(j));
    //         }
    //         array.add(1);
    //         last = array;
    //         list.add(array);
    //     }
    //     return list;
    // }

    /**
     * 和上述思路一致，但是在计算当前层时，只计算前一半，后一半通过复制前一半得到
     * 15 / 15, 1ms(99.92%), 33.7MB(30.41%)
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        list.add(array);
        if (numRows == 1) {
            return list;
        }
        array = new ArrayList<Integer>();
        array.add(1);
        array.add(1);
        list.add(array);
        if (numRows == 2) {
            return list;
        }
        --numRows;
        List<Integer> last = list.get(1);
        int j, k;
        for (int i = 1; i < numRows; ++i) {
            array = new ArrayList<Integer>();
            array.add(1);
            k = last.size() / 2 + 1;
            for (j = 1; j < k; ++j) {
                array.add(last.get(j - 1) + last.get(j));
            }
            if (last.size() % 2 != 0) {
                --k;
            } else {
                k -= 2;
            }
            for (; j <= last.size(); ++j) {
                array.add(array.get(k));
                --k;
            }
            last = array;
            list.add(array);
        }
        return list;
    }
}

