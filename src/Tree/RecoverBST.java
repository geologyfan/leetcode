package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        new RecoverBST().recoverTree_2(root);
        List<TreeNode> list = new Search().BFS(root);
        for(TreeNode node:list)
            System.out.println(node.val);

    }

    public void recoverTree(TreeNode root) {

    }

    public void DFSearch(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            DFSearch(root.left, queue);
            queue.add(root.val);
            DFSearch(root.right, queue);
        }

    }

    public void DFSRecorver(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            DFSRecorver(root.left, queue);
            root.val = queue.remove();
            DFSRecorver(root.right, queue);
        }
    }

    public void recoverTree_2(TreeNode root) {
        while (DFSearch(root) != 0) ;
        while (DFSearch(root) != 0) ;
        if (root != null && root.left != null) DFRecover(root.left, root);
        else if (root != null && root.right != null) DFRecover(root, root.right);
    }

    public int DFSearch(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left != null && root.val < root.left.val) {
            int temp = root.val;
            root.val = root.left.val;
            root.left.val = temp;
            return 1 + DFSearch(root.left);
        } else if (root.right != null && root.val > root.right.val) {
            int temp = root.val;
            root.val = root.right.val;
            root.right.val = temp;
            return 1 + DFSearch(root.right);
        } else
            return DFSearch(root.left) + DFSearch(root.right);
    }

    public void DFRecover(TreeNode pre, TreeNode post) {
        if (pre != null && post != null) {
            DFRecover(pre.left, post.left);
            if (pre.val > post.val) {
                int temp = pre.val;
                pre.val = post.val;
                post.val = temp;
            }
            DFRecover(pre.right, post.right);
        }
    }
}
