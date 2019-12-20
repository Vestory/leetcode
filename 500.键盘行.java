import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    /**
     * 22 / 22, 1ms(83.53%), 34.3MB(92.26%)
     */
    // public String[] findWords(String[] words) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     map.put('q', 0);
    //     map.put('w', 0);
    //     map.put('e', 0);
    //     map.put('r', 0);
    //     map.put('t', 0);
    //     map.put('y', 0);
    //     map.put('u', 0);
    //     map.put('i', 0);
    //     map.put('o', 0);
    //     map.put('p', 0);
    //     map.put('a', 1);
    //     map.put('s', 1);
    //     map.put('d', 1);
    //     map.put('f', 1);
    //     map.put('g', 1);
    //     map.put('h', 1);
    //     map.put('j', 1);
    //     map.put('k', 1);
    //     map.put('l', 1);
    //     map.put('z', 2);
    //     map.put('x', 2);
    //     map.put('c', 2);
    //     map.put('v', 2);
    //     map.put('b', 2);
    //     map.put('n', 2);
    //     map.put('m', 2);
    //     ArrayList<String> list = new ArrayList<>();
    //     int line = 0;
    //     for (int i = 0; i < words.length; ++i) {
    //         line = map.get(Character.toLowerCase(words[i].charAt(0)));
    //         for (int j = 1; j < words[i].length(); ++j) {
    //             if (map.get(Character.toLowerCase(words[i].charAt(j))) != line) {
    //                 line = -1;
    //                 break;
    //             }
    //         }
    //         if (line != -1) {
    //             list.add(words[i]);
    //         }
    //     }
    //     return list.toArray(new String[list.size()]);
    // }

    /**
     * 22 / 22, 1ms(83.53%), 34.6MB(84.18%)
     */
    // public String[] findWords(String[] words) {
    // HashMap<Character, Integer> map = new HashMap<>();
    // map.put('q', 0);
    // map.put('w', 0);
    // map.put('e', 0);
    // map.put('r', 0);
    // map.put('t', 0);
    // map.put('y', 0);
    // map.put('u', 0);
    // map.put('i', 0);
    // map.put('o', 0);
    // map.put('p', 0);
    // map.put('a', 1);
    // map.put('s', 1);
    // map.put('d', 1);
    // map.put('f', 1);
    // map.put('g', 1);
    // map.put('h', 1);
    // map.put('j', 1);
    // map.put('k', 1);
    // map.put('l', 1);
    // map.put('z', 2);
    // map.put('x', 2);
    // map.put('c', 2);
    // map.put('v', 2);
    // map.put('b', 2);
    // map.put('n', 2);
    // map.put('m', 2);

    // map.put('Q', 0);
    // map.put('W', 0);
    // map.put('E', 0);
    // map.put('R', 0);
    // map.put('T', 0);
    // map.put('Y', 0);
    // map.put('U', 0);
    // map.put('I', 0);
    // map.put('O', 0);
    // map.put('P', 0);
    // map.put('A', 1);
    // map.put('S', 1);
    // map.put('D', 1);
    // map.put('F', 1);
    // map.put('G', 1);
    // map.put('H', 1);
    // map.put('J', 1);
    // map.put('K', 1);
    // map.put('L', 1);
    // map.put('Z', 2);
    // map.put('X', 2);
    // map.put('C', 2);
    // map.put('V', 2);
    // map.put('B', 2);
    // map.put('N', 2);
    // map.put('M', 2);
    // ArrayList<String> list = new ArrayList<>();
    // int line = 0;
    // for (int i = 0; i < words.length; ++i) {
    // line = map.get(words[i].charAt(0));
    // for (int j = 1; j < words[i].length(); ++j) {
    // if (map.get(words[i].charAt(j)) != line) {
    // line = -1;
    // break;
    // }
    // }
    // if (line != -1) {
    // list.add(words[i]);
    // }
    // }
    // return list.toArray(new String[list.size()]);
    // }

    /**
     * 22 / 22, 0ms(100%), 34.2MB(92.26%)
     */
    public String[] findWords(String[] words) {
        String s0 = "qwertyuiop";
        String s1 = "asdfghjkl";
        String s2 = "zxcvbnm";
        ArrayList<String> list = new ArrayList<>();
        int line = 0, temp;
        char c;
        for (int i = 0; i < words.length; ++i) {
            c = Character.toLowerCase(words[i].charAt(0));
            if (s0.indexOf(c) != -1) {
                line = 0;
            } else {
                line = s1.indexOf(c) != -1 ? 1 : 2;
            }
            for (int j = 1; j < words[i].length(); ++j) {
                if (line == 0) {
                    if (s0.indexOf(Character.toLowerCase(words[i].charAt(j))) != -1) {
                        continue;
                    }
                } else if (line == 1) {
                    if (s1.indexOf(Character.toLowerCase(words[i].charAt(j))) != -1) {
                        continue;
                    }
                } else {
                    if (s2.indexOf(Character.toLowerCase(words[i].charAt(j))) != -1) {
                        continue;
                    }
                }
                line = -1;
                break;
            }
            if (line != -1) {
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
// @lc code=end
