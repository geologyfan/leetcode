package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinatreeInorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> arrayList = new ArrayList<>();

        while (root != null || !stack.empty()) {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            arrayList.add(root.val);
            root = root.right;

        }
        return arrayList;
    }
}
