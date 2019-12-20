import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    // #region [0] 官方解答
    // https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode/
    /**
     * 方法1，两个队列，压入O(1)，弹出O(n)
     */
    // private Queue<Integer> q1 = new LinkedList<>();
    // private Queue<Integer> q2 = new LinkedList<>();
    // private int top;
    // /** Initialize your data structure here. */
    // public MyStack() {

    // }

    // /** Push element x onto stack. */
    // public void push(int x) {
    //     q1.add(x);
    //     top = x;
    // }

    // /** Removes the element on top of the stack and returns that element. */
    // public int pop() {
    //     while (q1.size() > 1) {
    //         top = q1.remove();
    //         q2.add(top);
    //     }
    //     q1.remove();
    //     Queue<Integer> temp = q1;
    //     q1 = q2;
    //     q2 = temp;
    // }

    // /** Get the top element. */
    // public int top() {
    //     return top;
    // }

    // /** Returns whether the stack is empty. */
    // public boolean empty() {
    //     return q1.isEmpty();
    // }

    /**
     * 方法二，两个队列，压入O(n), 弹出O(1)
     */
    // private Queue<Integer> q1 = new LinkedList<>();
    // private Queue<Integer> q2 = new LinkedList<>();
    // private int top;
    // /** Initialize your data structure here. */
    // public MyStack() {

    // }

    // /** Push element x onto stack. */
    // public void push(int x) {
    //     q2.add(x);
    //     top = x;
    //     while (!q1.isEmpty()) {
    //         q2.add(q1.remove());
    //     }
    //     Queue<Integer> temp = q1;
    //     q1 = q2;
    //     q2 = temp;
    // }

    // /** Removes the element on top of the stack and returns that element. */
    // public int pop() {
    //     q1.remove();
    //     if (!q1.isEmpty()) {
    //         top = q1.peek();
    //     }
    // }

    // /** Get the top element. */
    // public int top() {
    //     return top;
    // }

    // /** Returns whether the stack is empty. */
    // public boolean empty() {
    //     return q1.isEmpty();
    // }

    /**
     * 方法三，一个队列，压入O(n), 弹出O(1)
     * 16 / 16, 55ms(94.33%), 34.1MB(69.61%)
     */
    private LinkedList<Integer> q1 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            --sz;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    // #endregion
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

