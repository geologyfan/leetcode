package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/28
 */

public class ComputeWidthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new ComputeWidthOfTree().compute(root));
    }

    public int compute(TreeNode root) {
        if (root == null)
            return 0;

        int width = 0;
        int depth = 0;
        int curDepth = 0;
        int nextLen = 1, curLen = 0;
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (nextLen != 0) {
            curLen = nextLen;
            nextLen = 0;
            curDepth++;
            if (curLen > width) {
                width = curLen;
                depth = curDepth;
            }
            while (curLen > 0) {
                temp = queue.remove();
                curLen--;
                if (temp.left != null) {
                    queue.add(temp.left);
                    nextLen++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextLen++;
                }
            }
        }
        return width;
    }
}
