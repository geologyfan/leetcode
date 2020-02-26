package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/23
 */

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new ZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null)
            return output;
        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftStack = new Stack<>();

        leftToRightStack.push(root);

        while (!leftToRightStack.empty() || !rightToLeftStack.empty()) {
            List<Integer> curLevel = new ArrayList<Integer>();
            TreeNode temp;
            if (!leftToRightStack.empty()) {
                while (!leftToRightStack.empty()) {
                    temp = leftToRightStack.pop();
                    if (temp.left != null)
                        rightToLeftStack.push(temp.left);
                    if (temp.right != null)
                        rightToLeftStack.push(temp.right);
                    curLevel.add(temp.val);
                }
            } else if (!rightToLeftStack.empty()) {
                while (!rightToLeftStack.empty()) {
                    temp = rightToLeftStack.pop();
                    if (temp.right != null)
                        leftToRightStack.push(temp.right);
                    if (temp.left != null)
                        leftToRightStack.push(temp.left);
                    curLevel.add(temp.val);
                }
            }

            output.add(curLevel);
        }
        return output;
    }

}
