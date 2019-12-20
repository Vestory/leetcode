import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    /**
     * 8 / 8, 2ms(89.7%), 37MB(100%)
     */
    // public List<String> fizzBuzz(int n) {
    //     ArrayList<String> res = new ArrayList<>();
    //     boolean b0 = false, b1 = false;
    //     for (int i = 1; i <= n; ++i) {
    //         b0 = i % 3 != 0;
    //         b1 = i % 5 != 0;
    //         if (b0 && b1) {
    //             res.add(i + "");
    //         } else if (b0) {
    //             res.add("Buzz");
    //         } else {
    //             if (b1) {
    //                 res.add("Fizz");
    //             } else {
    //                 res.add("FizzBuzz");
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 8 / 8, 2ms(89.7%), 37.2MB(100%)
     */
    // public List<String> fizzBuzz(int n) {
    //     ArrayList<String> res = new ArrayList<>();
    //     for (int i = 1; i <= n; ++i) {
    //         if (i % 3 != 0 && i % 5 != 0) {
    //             res.add(i + "");
    //         } else if (i % 3 == 0) {
    //             if (i % 5 != 0) {
    //                 res.add("Fizz");
    //             } else {
    //                 res.add("FizzBuzz");
    //             }
    //         } else {
    //             res.add("Buzz");
    //         }
    //     }
    //     return res;
    // }

    /**
     * 8 / 8, 3ms(64.18%), 37.5MB(100%)
     */
    // public List<String> fizzBuzz(int n) {
    //     ArrayList<String> res = new ArrayList<>();
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 1; i <= n; ++i) {
    //         if (i % 3 == 0) {
    //             sb.append("Fizz");
    //         }
    //         if (i % 5 == 0) {
    //             sb.append("Buzz");
    //         }
    //         if (sb.length() == 0) {
    //             sb.append(i);
    //         }
    //         res.add(sb.toString());
    //         sb = new StringBuilder();
    //     }
    //     return res;
    // }

    /**
     * 8 / 8, 4ms(42.63%), 37.1MB(100%)
     */
    // public List<String> fizzBuzz(int n) {
    //     ArrayList<String> res = new ArrayList<>();
    //     int i = 0;
    //     while (++i <= n) {
    //         res.add(i + "");
    //     }
    //     i = 2;
    //     while (i < n) {
    //         res.set(i, "Fizz");
    //         i += 3;
    //     }
    //     i = 4;
    //     while (i < n) {
    //         res.set(i, "Buzz");
    //         i += 5;
    //     }
    //     i = 14;
    //     while (i < n) {
    //         res.set(i, "FizzBuzz");
    //         i += 15;
    //     }
    //     return res;
    // }

    /**
     * 哈希表
     * https://leetcode-cn.com/problems/fizz-buzz/solution/fizz-buzz-by-leetcode/
     */
    public List<String> fizzBuzz(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();
        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key : fizzBizzDict.keySet()) {
                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBizzDict.get(key);
                }
            }
            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }
            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }
        return ans;
    }
}
// @lc code=end

