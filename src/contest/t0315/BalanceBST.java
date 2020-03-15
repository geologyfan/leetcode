package contest.t0315;

import Tree.TreeNode;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class BalanceBST {
//    public TreeNode balanceBST(TreeNode root) {
//        TreeNode temp = root;
//        TreeNode papa;
//        if (height(temp.left) - height(temp.right) > 1) {
//            papa = temp;
//            temp = temp.left;
//        }
//    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}
