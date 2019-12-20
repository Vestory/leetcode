import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    /**
     * 76 / 76, 6ms(69.01%), 34.8MB(82.49%)
     */
    // public boolean isValid(String s) {
    // if (s == null || s.length() % 2 != 0) {
    // return false;
    // } else if (s.length() == 0) {
    // return true;
    // }
    // HashMap<Character, Character> map = new HashMap<>();
    // map.put(')', '(');
    // map.put(']', '[');
    // map.put('}', '{');
    // Stack<Character> stack = new Stack<>();
    // char c;
    // for (int i = 0; i < s.length(); ++i) {
    // c = s.charAt(i);
    // if (map.containsKey(c)) {
    // if (stack.isEmpty() || stack.pop() != map.get(c)) {
    // return false;
    // }
    // } else {
    // stack.push(c);
    // }
    // }
    // return stack.isEmpty();
    // }

    /**
     * 76 / 76, 5ms(81.42%), 34.3MB(84.54%)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
            case ')':
            if (stack.isEmpty() || stack.pop() != '(') {
                return false;
            }
                break;
            case ']':
            if (stack.isEmpty() || stack.pop() != '[') {
                return false;
            }
                break;
            case '}':
            if (stack.isEmpty() || stack.pop() != '{') {
                return false;
            }
                break;
            default:
            stack.push(s.charAt(i));
                break;
            }
        }
        return stack.isEmpty();
    }
}
