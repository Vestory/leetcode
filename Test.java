import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
    }

    // #region [0] logs
    public static void log(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void log(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void log(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void log(int[] input) {
        for (int i = 0; i < input.length; ++i) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    public static void log(double input) {
        System.out.println(input);
    }

    public static void log(float input) {
        System.out.println(input);
    }

    public static void log(boolean input) {
        System.out.println(input);
    }

    public static void log(String input) {
        System.out.println(input);
    }

    /*  */
    public static void log(int input) {
        System.out.println(input);
    }

    public static void log(long input) {
        System.out.println(input);
    }
    // #endregion
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}