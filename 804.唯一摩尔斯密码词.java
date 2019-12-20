import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    /**
     * 83 / 83, 4ms(63.29%), 35.3MB(84.76%)
     */
    // public int uniqueMorseRepresentations(String[] words) {
    //     int len = words.length;
    //     if (len < 2) {
    //         return len;
    //     }
    //     HashMap<Character, String> map = new HashMap<>();
    //     map.put('a', ".-");
    //     map.put('b', "-...");
    //     map.put('c', "-.-.");
    //     map.put('d', "-..");
    //     map.put('e', ".");
    //     map.put('f', "..-.");
    //     map.put('g', "--.");
    //     map.put('h', "....");
    //     map.put('i', "..");
    //     map.put('j', ".---");
    //     map.put('k', "-.-");
    //     map.put('l', ".-..");
    //     map.put('m', "--");
    //     map.put('n', "-.");
    //     map.put('o', "---");
    //     map.put('p', ".--.");
    //     map.put('q', "--.-");
    //     map.put('r', ".-.");
    //     map.put('s', "...");
    //     map.put('t', "-");
    //     map.put('u', "..-");
    //     map.put('v', "...-");
    //     map.put('w', ".--");
    //     map.put('x', "-..-");
    //     map.put('y', "-.--");
    //     map.put('z', "--..");
    //     HashSet<String> set = new HashSet<>();
    //     StringBuilder sb;
    //     for (int i = 0; i < len; ++i) {
    //         sb = new StringBuilder();
    //         for (int j = 0; j < words[i].length(); ++j) {
    //             sb.append(map.get(words[i].charAt(j)));
    //         }
    //         set.add(sb.toString());
    //     }
    //     return set.size();
    // }

    /**
     * 83 / 83, 7ms(16.62%), 35.5MB(83.71%)
     */
    // public int uniqueMorseRepresentations(String[] words) {
    //     int len = words.length;
    //     if (len < 2) {
    //         return len;
    //     }
    //     HashMap<Character, String> map = new HashMap<>();
    //     map.put('a', ".-");
    //     map.put('b', "-...");
    //     map.put('c', "-.-.");
    //     map.put('d', "-..");
    //     map.put('e', ".");
    //     map.put('f', "..-.");
    //     map.put('g', "--.");
    //     map.put('h', "....");
    //     map.put('i', "..");
    //     map.put('j', ".---");
    //     map.put('k', "-.-");
    //     map.put('l', ".-..");
    //     map.put('m', "--");
    //     map.put('n', "-.");
    //     map.put('o', "---");
    //     map.put('p', ".--.");
    //     map.put('q', "--.-");
    //     map.put('r', ".-.");
    //     map.put('s', "...");
    //     map.put('t', "-");
    //     map.put('u', "..-");
    //     map.put('v', "...-");
    //     map.put('w', ".--");
    //     map.put('x', "-..-");
    //     map.put('y', "-.--");
    //     map.put('z', "--..");
    //     StringBuilder set = new StringBuilder();
    //     StringBuilder sb;
    //     String s;
    //     int count = 0;
    //     for (int i = 0; i < len; ++i) {
    //         sb = new StringBuilder();
    //         sb.append(0);
    //         for (int j = 0; j < words[i].length(); ++j) {
    //             sb.append(map.get(words[i].charAt(j)));
    //         }
    //         sb.append(0);
    //         s = sb.toString();
    //         if (set.indexOf(s) == -1) {
    //             set.append(s);
    //             ++count;
    //         }
    //     }
    //     return count;
    // }

    /**
     * 83 / 83, 3ms(79.14%), 35.8MB(82.66%)
     */
    // public int uniqueMorseRepresentations(String[] words) {
    //     if (words.length < 2) {
    //         return words.length;
    //     }
    //     HashSet<String> wset = new HashSet<>();
    //     for (int i = 0; i < words.length; ++i) {
    //         wset.add(words[i]);
    //     }
    //     HashMap<Character, String> map = new HashMap<>();
    //     map.put('a', ".-");
    //     map.put('b', "-...");
    //     map.put('c', "-.-.");
    //     map.put('d', "-..");
    //     map.put('e', ".");
    //     map.put('f', "..-.");
    //     map.put('g', "--.");
    //     map.put('h', "....");
    //     map.put('i', "..");
    //     map.put('j', ".---");
    //     map.put('k', "-.-");
    //     map.put('l', ".-..");
    //     map.put('m', "--");
    //     map.put('n', "-.");
    //     map.put('o', "---");
    //     map.put('p', ".--.");
    //     map.put('q', "--.-");
    //     map.put('r', ".-.");
    //     map.put('s', "...");
    //     map.put('t', "-");
    //     map.put('u', "..-");
    //     map.put('v', "...-");
    //     map.put('w', ".--");
    //     map.put('x', "-..-");
    //     map.put('y', "-.--");
    //     map.put('z', "--..");
    //     HashSet<String> set = new HashSet<>();
    //     StringBuilder sb;
    //     Iterator<String> iterator = wset.iterator();
    //     String s;
    //     while (iterator.hasNext()) {
    //         s = iterator.next();
    //         sb = new StringBuilder();
    //         for (int i = 0; i < s.length(); ++i) {
    //             sb.append(map.get(s.charAt(i)));
    //         }
    //         set.add(sb.toString());
    //     }
    //     return set.size();
    // }

    /**
     * https://leetcode-cn.com/problems/unique-morse-code-words/solution/wei-yi-mo-er-si-mi-ma-ci-by-leetcode/
     * 83 / 83, 2ms(99.94%), 35.4MB(83.97%)
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        HashSet<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }
        return seen.size();
    }

    /**
     * 83 / 83, 3ms(79.14%), 35.7MB(83.05%)
     */
    // public int uniqueMorseRepresentations(String[] words) {
    //     String[] map = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
    //             ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
    //             "--.." };
    //     HashSet<String> wset = new HashSet<>();
    //     for (int i = 0; i < words.length; ++i) {
    //         wset.add(words[i]);
    //     }
    //     Iterator<String> iterator = wset.iterator();
    //     String s;
    //     StringBuilder sb;
    //     HashSet<String> set = new HashSet<>();
    //     while (iterator.hasNext()) {
    //         s = iterator.next();
    //         sb = new StringBuilder();
    //         for (char c : s.toCharArray()) {
    //             sb.append(map[c - 'a']);
    //         }
    //         set.add(sb.toString());
    //     }
    //     return set.size();
    // }
}
// @lc code=end

