/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    /**
     * 先转换为字符数组，然后首尾互相交换
     * 1032 / 1032, 7ms(32.02%), 34.5MB(77.9%)
     */
    // public int reverse(int x) {
    //     // 如果超过下限，那么反转之后会超出int范围
    //     if (x <= Integer.MIN_VALUE) {
    //         return 0;
    //     }
    //     // 转换为字符数组
    //     char[] array = null;
    //     boolean negative = false;
    //     if (x < 0) {
    //         array = Integer.toString(-x).toCharArray();
    //         negative = true;
    //     } else {
    //         array = Integer.toString(x).toCharArray();
    //     }
    //     char c;
    //     // 交换位置
    //     for (int i = 0; i < array.length / 2; ++i) {
    //         c = array[i];
    //         array[i] = array[array.length - 1 - i];
    //         array[array.length - 1 - i] = c;
    //     }
    //     // 判断是否超过上限并返回
    //     long temp = Long.parseLong(new String(array));
    //     if (temp > Integer.MAX_VALUE) {
    //         return 0;
    //     } else {
    //         return negative ? -(int)temp : (int)temp;
    //     }
    // }

    /**
     * 弹出和推入数字 & 溢出前进行检查
     * 时间复杂度O(log(x))，空间复杂度O(1)
     * 1032 / 1032, 3ms(92.53%), 34.6MB(77.83%)
     */
    public int reverse(int x) {
        int rec = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rec > Integer.MAX_VALUE / 10 || (rec == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rec < Integer.MIN_VALUE / 10 || (rec == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rec = rec * 10 + pop;
        }
        return rec;
    }
}

