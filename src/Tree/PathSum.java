package Tree;

public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);

    }

    public boolean helper(TreeNode root, int num, int sum) {
        if(root==null)
            return false;
        num += root.val;
        if (root.left != null || root.right != null) {
            return helper(root.left, num , sum) || helper(root.right, num , sum);
        } else{
            if(num==sum)
                return true;
            else
                return false;
        }
    }
}
