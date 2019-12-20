import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
/**
 * 28 / 28, 31ms(83.36%), 57MB(91.13%)
 */
// class MyHashSet {

//     private int[] arr;

//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         arr = new int[1000000];
//     }

//     public void add(int key) {
//         arr[key] = 1;
//     }

//     public void remove(int key) {
//         arr[key] = 0;
//     }

//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//         return arr[key] == 1;
//     }
// }

/**
 * 28 / 28, 23ms(97.4%), 53.6MB(95.39%)
 */
// class MyHashSet {

//     private byte[] arr;

//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         arr = new byte[1000000];
//     }

//     public void add(int key) {
//         arr[key] = 1;
//     }

//     public void remove(int key) {
//         arr[key] = 0;
//     }

//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//         return arr[key] == 1;
//     }
// }

/**
 * 28 / 28, 27ms(90.84%), 55.8MB(93.97%)
 */
// class MyHashSet {

//     private HashSet<Integer> set;

//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         set = new HashSet<>();
//     }

//     public void add(int key) {
//         set.add(key);
//     }

//     public void remove(int key) {
//         set.remove(key);
//     }

//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//         return set.contains(key);
//     }
// }

/**
 * 再散列法
 * https://leetcode-cn.com/problems/design-hashset/solution/zai-san-lie-fa-by-lokayaga/
 * 28 / 28, 34ms(77.56%), 57.3MB(90.43%)
 */
class MyHashSet {

    int[] values;
    int lenght;

    public MyHashSet() {
        values = new int[1000000];
        lenght = 1000000;
        for (int i = 0; i < lenght; i++) {
            values[i] = -1;
        }
    }

    public void add(int key) {
        int index = Hash(key);
        values[index] = 1;
    }

    public void remove(int key) {
        int index = Hash(key);
        values[index] = -1;
    }

    /**
     * Returns true if this set contains the specified element
     */

    public boolean contains(int key) {
        return isExisted(Hash(key));
    }

    int Hash(int key) {
        int index = key % lenght;
        if (isExisted(index)) {
            Hash(index + 1);
        }
        return index;
    }

    boolean isExisted(int index) {
        if (values[index] == -1) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

