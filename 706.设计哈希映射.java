import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
/**
 * 33 / 33, 41ms(81.79%), 57.6MB(85.48%)
 */
// class MyHashMap {

//     private int[] arr;

//     /** Initialize your data structure here. */
//     public MyHashMap() {
//         arr = new int[1000001];
//     }

//     /** value will always be non-negative. */
//     public void put(int key, int value) {
//         arr[key] = value + 1;
//     }

//     /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//     public int get(int key) {
//         return arr[key] - 1;
//     }

//     /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//     public void remove(int key) {
//         arr[key] = 0;
//     }
// }

/**
 * 33 / 33, 33ms(91.04%), 54.2MB(90.87%)
 */
// class MyHashMap {

//     private HashMap<Integer, Integer> map;

//     /** Initialize your data structure here. */
//     public MyHashMap() {
//         map = new HashMap<>();
//     }

//     /** value will always be non-negative. */
//     public void put(int key, int value) {
//         map.put(key, value);
//     }

//     /**
//      * Returns the value to which the specified key is mapped, or -1 if this map
//      * contains no mapping for the key
//      */
//     public int get(int key) {
//         return map.getOrDefault(key, -1);
//     }

//     /**
//      * Removes the mapping of the specified value key if this map contains a mapping
//      * for the key
//      */
//     public void remove(int key) {
//         map.remove(key);
//     }
// }

/**
 * https://leetcode-cn.com/problems/design-hashmap/solution/java-shu-zu-shuang-xiang-lian-biao-jian-yi-mo-ni-2/
 * 33 / 33, 31ms(95.1%), 55.3MB(88.38%)
 */
class MyHashMap {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int length = 100;
    private Node[] data = new Node[length];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % length;
        Node curr = data[index];
        if (curr == null) {
            Node node = new Node(key, value);
            data[index] = node;
            return;
        }
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) {
                Node node = new Node(key, value);
                node.prev = curr;
                curr.next = node;
                return;
            } else {
                curr = curr.next;
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int index = key % length;
        Node curr = data[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % length;
        Node curr = data[index];
        if (curr != null && curr.key == key) {
            Node next = curr.next;
            if (next != null) {
                next.prev = null;
            }
            data[index] = next;
            return;
        }
        while(curr != null) {
            if (curr.key == key) {
                Node next = curr.next;
                Node prev = curr.prev;
                if (next != null) {
                    next.prev = prev;
                }
                if (prev != null) {
                    prev.next = next;
                }
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

