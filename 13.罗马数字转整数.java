import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
class Solution {

    /**
     * 简单的分支方法
     * 3999 / 3999, 20ms(72.1%), 38.5MB(87.65%)
     */
    // public int romanToInt(String s) {
    //     int i = 0;
    //     int result = 0;
    //     while (i < s.length()) {
    //         switch (s.charAt(i)) {
    //         case 'I':
    //             if (i < s.length() - 1) {
    //                 if (s.charAt(i + 1) == 'V') {
    //                     result += 4;
    //                     ++i;
    //                     break;
    //                 } else if (s.charAt(i + 1) == 'X') {
    //                     result += 9;
    //                     ++i;
    //                     break;
    //                 }
    //             }
    //             result += 1;
    //             break;
    //         case 'V':
    //             result += 5;
    //             break;
    //         case 'X':
    //             if (i < s.length() - 1) {
    //                 if (s.charAt(i + 1) == 'L') {
    //                     result += 40;
    //                     ++i;
    //                     break;
    //                 } else if (s.charAt(i + 1) == 'C') {
    //                     result += 90;
    //                     ++i;
    //                     break;
    //                 }
    //             }
    //             result += 10;
    //             break;
    //         case 'L':
    //             result += 50;
    //             break;
    //         case 'C':
    //             if (i < s.length() - 1) {
    //                 if (s.charAt(i + 1) == 'D') {
    //                     result += 400;
    //                     ++i;
    //                     break;
    //                 } else if (s.charAt(i + 1) == 'M') {
    //                     result += 900;
    //                     ++i;
    //                     break;
    //                 }
    //             }
    //             result += 100;
    //             break;
    //         case 'D':
    //             result += 500;
    //             break;
    //         case 'M':
    //             result += 1000;
    //             break;
    //         }
    //         ++i;
    //     }
    //     return result;
    // }

    /**
     * 使用hashmap存储各种情况，每次判断接下来2位是否存在
     * 3999 / 3999, 23ms(56.23%), 44.3MB(65.98%)
     */
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                ++i;
            } else {
                result += map.get(s.substring(i, i + 1));
            }
        }
        return result;
    }

}
