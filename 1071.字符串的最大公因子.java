import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    /**
     * 103 / 103, 14ms(16.26%), 36.5MB(100%)
     */
    // public String gcdOfStrings(String str1, String str2) {
    //     String s = "";
    //     int[] chs = new int[26];
    //     for (char c : str1.toCharArray()) {
    //         chs[c - 'A'] = 1;
    //     }
    //     int idx;
    //     for (char c : str2.toCharArray()) {
    //         idx = c - 'A';
    //         if (chs[idx] == 0) {
    //             return s;
    //         } else if (chs[idx] == 1) {
    //             ++chs[idx];
    //         }
    //     }
    //     for (int i : chs) {
    //         if (i == 1) {
    //             return s;
    //         }
    //     }
    //     List<Integer> list = getCommon(str1.length(), str2.length());
    //     int len = list.size() - 1;
    //     idx = list.get(len);
    //     for (int i = 0; i < len; ++i) {
    //         // NOTE 这里不该这么写，idx应该更新，而不是一直等于最大公约数
    //         // 103 / 103, 27ms(11.38%), 37.3MB(100%)
    //         // s = str1.substring(0, idx / list.get(i));
    //         // if (str1.replaceAll(s, "").length() == 0 && str2.replaceAll(s, "").length() == 0) {
    //         //     return s;
    //         // }
    //         // 103 / 103, 14ms(16.26%), 36.5MB(100%)
    //         idx /= list.get(i);
    //         s = str1.substring(0, idx);
    //         if (str1.replaceAll(s, "").length() == 0 && str2.replaceAll(s, "").length() == 0) {
    //             return s;
    //         }
    //     }
    //     return s;
    // }
    // /**
    //  * 获取公共的质因数和最大公约数
    //  * @return 为了程序方便，第一个数为1，随后为公因数，最后一个为最大公约数
    //  */
    // private List<Integer> getCommon(int x, int y) {
    //     List<Integer> res = new ArrayList<>();
    //     List<Integer> primes = x == y ? getPrimes(x + 1) : getPrimes(Math.max(x, y) / 2 + 1);
    //     int mul = 1;
    //     res.add(1);
    //     for (int i : primes) {
    //         while (x % i == 0 && y % i == 0) {
    //             res.add(i);
    //             x /= i;
    //             y /= i;
    //             mul *= i;
    //         }
    //     }
    //     res.add(mul);
    //     return res;
    // }
    // /**
    //  * 获取(1, n)之间的质数
    //  */
    // private List<Integer> getPrimes(int n) {
    //     List<Integer> primes = new ArrayList<>();
    //     boolean[] signs = new boolean[n];
    //     for (int i = 2; i < n; ++i) {
    //         if (!signs[i]) {
    //             primes.add(i);
    //             for (int j = i + i; j < n; j += i) {
    //                 signs[j] = true;
    //             }
    //         }
    //     }
    //     return primes;
    // }

    /**
     * 103 / 103, 4ms(30.35%), 37.9MB(100%)
     */
    // public String gcdOfStrings(String str1, String str2) {
    //     String s = "";
    //     char[] cha = str1.toCharArray(), chb = str2.toCharArray();
    //     int la = cha.length, lb = chb.length;
    //     List<Integer> list = getCommon(la, lb);
    //     int size = list.size() - 1, end = list.get(size);
    //     for (int i = 0; i < size; ++i) {
    //         end /= list.get(i);
    //         if (isCycle(cha, cha, end) && isCycle(chb, cha, end)) {
    //             return str1.substring(0, end);
    //         }
    //     }
    //     return s;
    // }
    // /**
    //  * 检测input字符串是否是由sub[0, subLen)字符串重复1至n次组成的
    //  * @param input 需要检测的字符串所在的字符数组
    //  * @param sub 子串所在的字符数组
    //  * @param subLen 子串长度
    //  */
    // private boolean isCycle(char[] input, char[] sub, int subLen) {
    //     int len = input.length / subLen, idx = 0;
    //     for (int i = 0; i < len; ++i) {
    //         for (int j = 0; j < subLen; ++j) {
    //             if (input[idx] != sub[j]) {
    //                 return false;
    //             }
    //             ++idx;
    //         }
    //     }
    //     return true;
    // }
    // /**
    //  * 获取公共的质因数和最大公约数
    //  * @return 为了程序方便，第一个数为1，随后为公因数，最后一个为最大公约数
    //  */
    // private List<Integer> getCommon(int x, int y) {
    //     List<Integer> res = new ArrayList<>();
    //     List<Integer> primes = x == y ? getPrimes(x + 1) : getPrimes(Math.max(x, y) / 2 + 1);
    //     int mul = 1;
    //     res.add(1);
    //     for (int i : primes) {
    //         while (x % i == 0 && y % i == 0) {
    //             res.add(i);
    //             x /= i;
    //             y /= i;
    //             mul *= i;
    //         }
    //     }
    //     res.add(mul);
    //     return res;
    // }
    // /**
    //  * 获取(1, n)之间的质数
    //  */
    // private List<Integer> getPrimes(int n) {
    //     List<Integer> primes = new ArrayList<>();
    //     boolean[] signs = new boolean[n];
    //     for (int i = 2; i < n; ++i) {
    //         if (!signs[i]) {
    //             primes.add(i);
    //             for (int j = i + i; j < n; j += i) {
    //                 signs[j] = true;
    //             }
    //         }
    //     }
    //     return primes;
    // }

    /**
     * 103 / 103, 2ms(42.01%), 37.8MB(100%)
     */
    public String gcdOfStrings(String str1, String str2) {
        int la = str1.length(), lb = str2.length(), tmp = -1;
        char[] cha, chb;
        if (la > lb) {
            tmp = la;
            la = lb;
            lb = tmp;
            cha = str2.toCharArray();
            chb = str1.toCharArray();
        } else {
            cha = str1.toCharArray();
            chb = str2.toCharArray();
        }
        int l, m, r = 1, next, half = la / 2 + 1;
        boolean equal;
        while (r < half) {
            if (cha[r] == cha[0] && la % r == 0 && lb % r == 0) {
                m = r;
                next = -1;
                l = 1;
                ++r;
                equal = true;
                while (l < m) {
                    if (cha[r] == cha[0]) {
                        next = r;
                    }
                    if (cha[l] != cha[r]) {
                        equal = false;
                        break;
                    }
                    ++l;
                    ++r;
                }
                if (equal) {
                    while (r < la) {
                        for (int i = 0; i < m; ++i) {
                            if (cha[r] != cha[i]) {
                                equal = false;
                                break;
                            }
                            ++r;
                        }
                        if (!equal) {
                            break;
                        }
                    }
                    if (equal) {
                        r = 0;
                        while (r < lb) {
                            for (int i = 0; i < m; ++i) {
                                if (chb[r] != cha[i]) {
                                    return "";
                                }
                                ++r;
                            }
                        }
                        return str1.substring(0, gcd(la, lb));
                    } else {
                        ++r;
                    }
                } else {
                    if (next != -1) {
                        r = next;
                    } else {
                        ++r;
                    }
                }
            } else {
                ++r;
            }
        }
        if (lb % la == 0) {
            r = 0;
            while (r < lb) {
                for (int i = 0; i < la; ++i) {
                    if (chb[r] != cha[i]) {
                        return "";
                    }
                    ++r;
                }
            }
            return tmp == -1 ? str1 : str2;
        }
        return "";
    }
    /**
     * 求最大公约数（更相减损术）
     */
    private int gcd(int x, int y) {
        if (x > y) {
            return gcd(x - y, y);
        } else if (x < y) {
            return gcd(x, y - x);
        }
        return x;
    }

    /**
     * 更好的解法
     * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/1071-zi-fu-chuan-de-zui-da-gong-yin-zi-by-wonderfu/
     */
}
// @lc code=end
