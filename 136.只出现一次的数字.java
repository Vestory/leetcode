import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */
class Solution {
    /**
     * 遍历nums中的所有元素，如果某个元素在列表中不存在，则加入，反之则删除
     * 时间复杂度O(n * n)，空间复杂度O(n)
     * 16 / 16, 116ms(7.31%), 40.1MB(82.36%)
     */
    // public int singleNumber(int[] nums) {
    //     List<Integer> list = new ArrayList<Integer>();
    //     list.add(nums[0]);
    //     for (int i = 1; i < nums.length; ++i) {
    //         if (list.contains(nums[i])) {
    //             list.remove(list.indexOf(nums[i]));
    //         } else {
    //             list.add(nums[i]);
    //         }
    //     }
    //     return list.get(0);
    // }

    /**
     * 哈希表
     * 利用哈希表来减少查找时间
     * 时间复杂度O(n)，空间复杂度O(n)
     * 16 / 16, 10ms(31.58%), 40.2MB(79.38%)
     */
    // public int singleNumber(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     map.put(nums[0], 0);
    //     for (int i = 1; i < nums.length; ++i) {
    //         if (map.containsKey(nums[i])) {
    //             map.remove(nums[i]);
    //         } else {
    //             map.put(nums[i], 0);
    //         }
    //     }
    //     return map.keySet().iterator().next();
    // }

    /**
     * 数学
     * 2 * (a + b + c) - (a + a + b + b + c) = c
     * 时间复杂度和空间复杂度均为O(2n)，即O(n)
     * 16 / 16, 10ms(31.58%), 40MB(85.74%)
     */
    // public int singleNumber(int[] nums) {
    //     int half = 0;
    //     int sum = 0;
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         set.add(nums[i]);
    //         sum += nums[i];
    //     }
    //     Iterator<Integer> iterator = set.iterator();
    //     while (iterator.hasNext()) {
    //         half += iterator.next();
    //     }
    //     return 2 * half - sum;
    // }

    /**
     * 位操作
     * 如果我们对0和二进制位进行XOR操作，得到的仍是这个二进制位
     * a XOR 0 = a
     * 如果我们对相同的二进制位进行XOR操作，得到的是0
     * a XOR a = 0
     * XOR满足交换律
     * a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
     * 因此只需要对nums中所有的元素进行XOR操作即可得到唯一的数字
     * 时间复杂度O(n)，空间复杂度O(1)
     * 16 / 16, 1ms(99.87%), 38.9MB(95.17%)
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}

