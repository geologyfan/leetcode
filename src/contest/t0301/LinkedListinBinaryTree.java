package contest.t0301;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/1
 */

public class LinkedListinBinaryTree {
    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(judge(temp,head))
                return true;
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return false;
    }

    public boolean judge(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null)
            return false;
        if (head.val == root.val)
            return judge(root.left, head.next) || judge(root.right, head.next);
        else
            return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
