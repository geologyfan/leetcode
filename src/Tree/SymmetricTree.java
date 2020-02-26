package Tree;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/23
 */

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode left, TreeNode right) {
        int flag = isSameNode(left, right);
        switch (flag) {
            case 0:
                return false;
            case 1:
                return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
            case 2:
                return true;
        }
        return false;
    }


    public int isSameNode(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return 2;
        else if ((left == null && right != null) || (left != null && right == null))
            return 0;
        else if (left.val == right.val)
            return 1;
        else
            return 0;
    }

}
