import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
// #region [0] 前后指针
/**
 * 18 / 18, 107ms(55.27%), 47.7MB(22.38%)
 */
// class MinStack {

//     private List<Item> list;
//     private Item min;

//     /** initialize your data structure here. */
//     public MinStack() {
//         list = new ArrayList<Item>();
//         min = null;
//     }

//     public void push(int x) {
//         Item item = null;
//         if (min == null) {
//             item = new Item(x, null, null);
//             min = item;
//         } else if (x <= min.val) {
//             item = new Item(x, null, min);
//             min.pre = item;
//             min = item;
//         } else {
//             Item curr = min;
//             while (curr.next != null) {
//                 curr = curr.next;
//                 if (curr.val >= x) {
//                     item = new Item(x, curr.pre, curr);
//                     curr.pre.next = item;
//                     curr.pre = item;
//                     list.add(item);
//                     return;
//                 }
//             }
//             item = new Item(x, curr, null);
//             curr.next = item;
//         }
//         list.add(item);
//     }

//     public void pop() {
//         if (list.size() < 1) {
//             return;
//         }
//         Item item = list.get(list.size() - 1);
//         if (item.pre == null) {
//             min = item.next;
//             if (min != null) {
//                 min.pre = null;
//             }
//         } else if (item.next == null) {
//             item.pre.next = null;
//         } else {
//             item.pre.next = item.next;
//             item.next.pre = item.pre;
//         }
//         list.remove(list.size() - 1);
//     }

//     public int top() {
//         return list.size() > 0 ? list.get(list.size() - 1).val : 0;
//     }

//     public int getMin() {
//         return min == null ? 0 : min.val;
//     }
// }

// class Item {
//     public int val = 0;
//     public Item pre = null;
//     public Item next = null;

//     public Item(int val, Item pre, Item next) {
//         this.val = val;
//         this.pre = pre;
//         this.next = next;
//     }
// }
// #endregion

// #region [0] 辅助栈和数据栈同步
// https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
/**
 * 时间复杂度O(1)，空间复杂度O(n)
 * 18 / 18, 59ms(99.73%), 40.1MB(95.63%)
 */
// class MinStack {

//     private Stack<Integer> data;
//     private Stack<Integer> helper;

//     /** initialize your data structure here. */
//     public MinStack() {
//         data = new Stack<>();
//         helper = new Stack<>();
//     }

//     public void push(int x) {
//         data.add(x);
//         if (helper.isEmpty() || helper.peek() >= x) {
//             helper.add(x);
//         } else {
//             helper.add(helper.peek());
//         }
//     }

//     public void pop() {
//         if (!data.isEmpty()) {
//             helper.pop();
//             data.pop();
//         }
//     }

//     public int top() {
//         if (!data.isEmpty()) {
//             return data.peek();
//         }
//         throw new RuntimeException();
//     }

//     public int getMin() {
//         if (!helper.isEmpty()) {
//             return helper.peek();
//         }
//         throw new RuntimeException();
//     }
// }
// #endregion

// #region [0] 辅助栈和数据栈不同步
// https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
/**
 * 18 / 18, 77ms(94.23%), 40.3MB(95.44%)
 */
class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
    }

    public void pop() {
        // 关键3：data一定要使用pop()
        if (!data.isEmpty()) {
            // 注意：声明成 int 类型，这里完成了自动拆箱，从 Integer 转成了 int，因此下面的比较可以使用 "==" 运算符
            // 参考资料：https://www.cnblogs.com/GuoYaxiang/p/6931264.html
            // 如果把 top 变量声明成 Integer 类型，下面的比较就得使用 equals 方法
            int top = data.pop();
            if (top == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException();
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException();
    }
}
// #endregion
