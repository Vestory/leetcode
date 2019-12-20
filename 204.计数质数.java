/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    // #region [0] 三种方法
    // https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-bao-li-fa-ji-you-hua-shai-fa-ji-you/
    /**
     * 暴力法（计算超时） 验证某个数是否为质数时，将其对每一个比其小的数进行取余运算，并对取余为零的情况进行计数。由于质数是指在大于 1 的自然数中，除了 1
     * 和它本身以外不再有其他因数的自然数。所以，当计数结果为 1 时，该数为质数。
     */
    // public int countPrimes(int n) {
    // int count = 0;
    // for (int i = 2; i < n; ++i) {
    // boolean sign = true;
    // for (int j = 2; j < i; ++j) {
    // if (i % j == 0) {
    // sign = false;
    // break;
    // }
    // }
    // if (sign) {
    // ++count;
    // }
    // }
    // return count;
    // }

    /**
     * 优化后的暴力算法 排除除2之外的偶数，此外，对于正整数n，如果用2到n的平方根之间的所有整数去测试均无法被整除，那么n时质数 20 / 20,
     * 378ms(6.99%), 33.1MB(83.87%)
     */
    // public int countPrimes(int n) {
    // if (n < 3) {
    // return 0;
    // }
    // // 从3开始算起，所以初始值为1（2为质数）
    // int count = 1;
    // for (int i = 3; i < n; ++i) {
    // // 当某个数为2的n次方时（n为自然数），其&（n - 1）所得值将等价于取余运算所得值
    // // 如果x = 2 ^ n，则x & (n - 1) == x % n
    // // if (i % 2) == 0)
    // if ((i & 1) == 0) {
    // continue;
    // }
    // boolean sign = true;
    // // 用j * j <= i代替j <= i的平方根会更好
    // // 因为我们已经排除了所有偶数，所以每次循环加2
    // for (int j = 3; j * j <= i; j += 2) {
    // if (i % j == 0) {
    // sign = false;
    // break;
    // }
    // }
    // if (sign) {
    // ++count;
    // }
    // }
    // return count;
    // }

    /**
     * 厄拉多塞筛法 在顺序遍历的时候，对于一个数（排除0和1），可以将它的所有倍数排除（除了0、1还有它本身） 20 / 20, 15ms(95.70%),
     * 34.6MB(79.70%)
     */
    // public int countPrimes(int n) {
    // int count = 0;
    // boolean[] signs = new boolean[n];
    // for (int i = 2; i < n; ++i) {
    // if (!signs[i]) {
    // ++count;
    // for (int j = i + i; j < n; j += i) {
    // // 排除不是质数的数
    // signs[j] = true;
    // }
    // }
    // }
    // return count;
    // }

    /**
     * 使用比特表（Bitmap）算法对上一种方法的内存进行优化 20 / 20, 25ms(88.71%), 33.3MB(80.99%)
     */
    public int countPrimes(int n) {
        int count = 0;
        // int占用32字节
        // 在C#中，提供了点阵列（BitArray）数组，这里用的是java
        int[] signs = new int[n / 32 + 1];
        for (int i = 2; i < n; ++i) {
            // 将元素和需确定得数字经行按位或运算，如果值改变，说明不存在该数字（未登记该数字），则其为质数。
            // (当某个数为 2 的 n 次方时（n为自然数），其 & (n - 1) 所得值将等价于取余运算所得值)
            // *如果 x = 2^n ，则 x & (n - 1) == x % n
            // 下面判断可以写成
            // if ((signs[i / size] & (1 << (i % 32))) == 0)
            if ((signs[i / 32] & (1 << (i & 31))) == 0) {
                ++count;
                for (int j = i + i; j < n; j += i) {
                    // 登记这个数字
                    signs[j / 32] |= 1 << (j & 31);
                }
            }
        }
        return count;
    }
    // #endregion
}
// @lc code=end

