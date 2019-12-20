/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    /**
     * Math中的sqrt函数 1017 / 1017, 1ms(100%), 33.7MB(75.07%)
     */
    // public int mySqrt(int x) {
    // return (int) Math.sqrt(x);
    // }

    /**
     * 一个神奇的求平方根的方法，但是x较大时，精度不够
     */
    // public float sqrt(float x) {
    // float xhalf = 0.5f * x;
    // int i = Float.floatToIntBits(x);
    // i = 0x5f375a86 - (i >> 1);
    // x = Float.intBitsToFloat(i);
    // return 1 / (x * (1.5f - xhalf * x * x));
    // }

    /**
     * 二分法 1017 / 1017, 2ms(99.5%), 33.5MB(75.72%)
     */
    // public int mySqrt(int x) {
    // if (x < 1) {
    // return 0;
    // } else if (x < 4) {
    // return 1;
    // }
    // long l = 2;
    // long r = x / 2;
    // long m, temp;
    // while (l <= r) {
    // // 使用m = (l + r + 1) / 2也可以
    // m = (l + r) / 2;
    // temp = m * m;
    // if (temp < x) {
    // l = m + 1;
    // } else if (temp > x) {
    // r = m - 1;
    // } else {
    // return (int)m;
    // }
    // }
    // return (int)(l - 1);
    // }

    /**
     * 二分法（他人所写）
     */
    // public int mySqrt(int x) {
    //     // 注意：针对特殊测试用例，例如 2147395599
    //     // 要把搜索的范围设置成长整型
    //     // 为了照顾到 0 把左边界设置为 0
    //     long left = 0;
    //     // # 为了照顾到 1 把右边界设置为 x // 2 + 1
    //     long right = x / 2 + 1;
    //     while (left < right) {
    //         // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
    //         // long mid = left + (right - left + 1) / 2;
    //         long mid = (left + right + 1) >>> 1;
    //         long square = mid * mid;
    //         if (square > x) {
    //             right = mid - 1;
    //         } else {
    //             left = mid;
    //         }
    //     }
    //     // 因为一定存在，因此无需后处理
    //     return (int) left;
    // }

    /**
     * 牛顿迭代法
     * 1017 / 1017, 2ms(99.5%), 33.7MB(75.11%)
     */
    public int mySqrt(int x) {
        long result = x;
        while (result * result > x) {
            result = (result + x / result) / 2;
        }
        return (int) result;
    }
}
