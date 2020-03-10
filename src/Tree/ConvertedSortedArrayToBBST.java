package Tree;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/27
 */

public class ConvertedSortedArrayToBBST {
    public static void main(String[] args) {
        new ConvertedSortedArrayToBBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return null;
        TreeNode root = new TreeNode(nums[(length - 1) / 2]);
        traversal(root, nums, 0, (length - 1) / 2 - 1, 0);//左子树
        traversal(root, nums, (length - 1) / 2 + 1, length-1, 1);//右子树
        return root;

    }

    public void traversal(TreeNode father, int[] nums, int low, int high, int left_of_right) {
        if (low <= high) {

            TreeNode temp = new TreeNode(nums[(low + high) / 2]);
            if (left_of_right == 0)
                father.left = temp;
            else
                father.right = temp;

            traversal(temp, nums, low, (low + high) / 2 - 1, 0);
            traversal(temp, nums, (low + high) / 2 + 1, high, 1);
        }
    }

}
