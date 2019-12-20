import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    // #region [0] 官方解答
    // https://leetcode-cn.com/problems/implement-queue-using-stacks/
    /**
     * 方法1，两个栈，入队O(n)，出队O(1)
     */
    // private Stack<Integer> s1 = new Stack<>();
    // private Stack<Integer> s2 = new Stack<>();
    // private int front;
    // /** Initialize your data structure here. */
    // public MyQueue() {

    // }

    // /** Push element x to the back of queue. */
    // public void push(int x) {
    //     if (s1.empty()) {
    //         front = x;
    //     }
    //     while (!s1.isEmpty()) {
    //         s2.push(s1.pop());
    //     }
    //     s2.push(x);
    //     while (!s2.isEmpty()) {
    //         s1.push(s2.pop());
    //     }
    // }

    // /** Removes the element from in front of queue and returns that element. */
    // public int pop() {
    //     s1.pop();
    //     if (!s1.isEmpty()) {
    //         front = s1.peek();
    //     }
    // }

    // /** Get the front element. */
    // public int peek() {
    //     return front;
    // }

    // /** Returns whether the queue is empty. */
    // public boolean empty() {
    //     return s1.isEmpty();
    // }

    /**
     * 方法2，两个栈，入队和出队均为O(1)
     * 17 / 17, 51ms(99.45%), 33.8MB(69.98%)
     */
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    // #endregion
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

