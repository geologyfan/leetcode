package newcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/7
 */

public class Trip {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();


        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp.val);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        return stack2;
    }

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Trip trip = new Trip();
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        ListNode node1 = trip.reverse(node);

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        List<Integer> list = postorderTraversal(root);
//        System.out.println(list);
        int[] arr = new int[]{3,4,3,2,4};
        System.out.println(compute(arr));
    }

    private static int compute(int[] heights){
        double res = 0;
        int len = heights.length;
        for(int i=len-1;i>=0;i--){
            res = Math.ceil((res+heights[i])/2);
        }
        return (int)res;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;
        ListNode p = head;
        while (count < k && p != null) {
            p = p.next;
            count++;
        }
        if (p == null) {
            return head;
        }
        ListNode next = p.next;
        p.next = null;
        ListNode t = reverse(head);
        head.next = reverseKGroup(next, k);
        return t;
    }


    private ListNode reverse(ListNode node) {
        ListNode nodePre = new ListNode(0);
        while (node != null) {
            ListNode next = node.next;
            node.next = nodePre.next;
            nodePre.next = node;
            node = next;
        }
        return nodePre.next;
    }


    private static void find(int[][] matrix) {
        int n = matrix.length;
        boolean[] used = new boolean[n];
        used[0] = true;
        dfs(n - 1, 0, 0, matrix, used);

    }

    private static void dfs(int n, int money, int last, int[][] matrix, boolean[] used) {
        if (n == 0) {
            min = Math.min(min, money + matrix[last][0]);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(n - 1, money + matrix[last][i], i, matrix, used);
                used[i] = false;
            }
        }
    }

}
