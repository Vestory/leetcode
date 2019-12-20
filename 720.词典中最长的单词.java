import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
/**
 * 官方解题
 * 暴力法
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/solution/ci-dian-zhong-zui-chang-de-dan-ci-by-leetcode/
 * 57 / 57, 10ms(96.12%), 37.3MB(97.69%)
 */
// class Solution {
//     public String longestWord(String[] words) {
//         String ans = "";
//         Set<String> wordset = new HashSet<>();
//         for (String word : words) wordset.add(word);
//         for (String word : words) {
//             if (word.length() > ans.length() ||
//                     word.length() == ans.length() && word.compareTo(ans) < 0) {
//                 boolean good = true;
//                 for (int k = 1; k < word.length(); ++k) {
//                     if (!wordset.contains(word.substring(0, k))) {
//                         good = false;
//                         break;
//                     }
//                 }
//                 if (good) ans = word;
//             }
//         }
//         return ans;
//     }
// }

/**
 * 官方解题
 * 前缀树 + 深度优先搜索
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/solution/ci-dian-zhong-zui-chang-de-dan-ci-by-leetcode/
 * 57 / 57, 29ms(34.07%), 37.1MB(97.69%)
 */
// class Solution {
//     public String longestWord(String[] words) {
//         Trie trie = new Trie();
//         int index = 0;
//         for (String word : words) {
//             trie.insert(word, ++index); // indexed by 1
//         }
//         trie.words = words;
//         return trie.dfs();
//     }
// }

// class Node {
//     char c;
//     HashMap<Character, Node> children = new HashMap<>();
//     int end;

//     public Node(char c) {
//         this.c = c;
//     }
// }

// class Trie {
//     Node root;
//     String[] words;

//     public Trie() {
//         root = new Node('0');
//     }

//     public void insert(String word, int index) {
//         Node cur = root;
//         for (char c : word.toCharArray()) {
//             cur.children.putIfAbsent(c, new Node(c));
//             cur = cur.children.get(c);
//         }
//         cur.end = index;
//     }

//     public String dfs() {
//         String ans = "";
//         Stack<Node> stack = new Stack<>();
//         stack.push(root);
//         while (!stack.empty()) {
//             Node node = stack.pop();
//             if (node.end > 0 || node == root) {
//                 if (node != root) {
//                     String word = words[node.end - 1];
//                     if (word.length() > ans.length() ||
//                             word.length() == ans.length() && word.compareTo(ans) < 0) {
//                         ans = word;
//                     }
//                 }
//                 for (Node nei: node.children.values()) {
//                     stack.push(nei);
//                 }
//             }
//         }
//         return ans;
//     }
// }

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/solution/shi-yong-trieshu-by-taolei0108/
 * 57 / 57, 13ms(89.2%), 38.2MB(97.69%)
 */
class Solution {
    String longestword = "";
    int longlen = 0;

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word: words){                                     //依次插入string
            trie.insert(word);
        }
        for(String word: words){
            if(trie.isBuild(word) && word.length() > longlen){         //遍历后发现有更长的string满足条件，进行替换
                longestword = word;
                longlen = word.length();
            }else if(trie.isBuild(word) && word.length() == longlen){     //当出现一样长的字符串时，进行比较
                char[] longestchar = longestword.toCharArray();
                char[] wordchar = word.toCharArray();
                for(int i=0; i<longlen; i++){
                    if(wordchar[i]-longestchar[i] < 0){
                        longestword = word;
                        break;
                    }else if(wordchar[i]-longestchar[i] > 0) break;
                }
            }
        }
        return longestword;
    }
}

class Trie {
    TrieNode root = new TrieNode('/');

    public void insert(String string) { // 用来插入一个string
        char[] ccc = string.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < ccc.length; i++) {
            int index = ccc[i] - 'a';
            if (p.next[index] == null) {
                TrieNode trienode = new TrieNode(ccc[i]);
                p.next[index] = trienode;
            }
            p = p.next[index];
        }
        p.isword = true;
    }

    public boolean isBuild(String string){            //用来判断这个字符串是不是由其他节点依次加一个字符组成
        char[] ccc = string.toCharArray();
        TrieNode p = root;
        for(int i=0; i<ccc.length; i++){
            if(!p.next[ccc[i]-'a'].isword) return false;
            p = p.next[ccc[i]-'a'];
        }
        return true;
    }

}

class TrieNode {
    public char data;
    public boolean isword = false;
    public TrieNode[] next = new TrieNode[26];

    public TrieNode(char c){
        data = c;
    }
}
// @lc code=end

