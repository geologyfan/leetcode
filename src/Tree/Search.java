package Tree;


import java.util.*;

public class Search {
    public List<Integer> DFS(TreeNode root) {
        return null;
    }

    private void DFSHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            DFSHelper(root.left, list);
            list.add(root.val);
            DFSHelper(root.right, list);
        }
    }

    public List<TreeNode> BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            arrayList.add(temp);
            if (temp.left != null) arrayList.add(temp.left);
            if (temp.right != null) arrayList.add(temp.right);
        }
        return arrayList;
    }

    public List<List<Integer>> BFSReverse(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> reList = new LinkedList<>();

        int nLastWidth, nCurrentWidth;

        queue.add(root);
        nLastWidth = 1;

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        stack.push(list);

        while (!queue.isEmpty()) {
            nCurrentWidth = 0;
            List<Integer> currentLayer = new ArrayList<>();

            while (nLastWidth > 0) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                    nCurrentWidth++;
                    currentLayer.add(temp.left.val);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nCurrentWidth++;
                    currentLayer.add(temp.right.val);
                }
                nLastWidth--;
            }
            nLastWidth = nCurrentWidth;
            if (!currentLayer.isEmpty())
                stack.push(currentLayer);
        }
        while (!stack.empty()) {
            reList.add(stack.pop());
        }
        return reList;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new LinkedList<>();
        if (root == null) {
            return levelOrderList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int lastWidth, currentWidth;
        queue.add(root);
        currentWidth = 1;
        while (!queue.isEmpty()) {
            lastWidth = currentWidth;
            currentWidth = 0;
            List<Integer> currentLayer = new ArrayList<>();
            while (lastWidth > 0) {
                TreeNode temp = queue.remove();
                lastWidth--;
                currentLayer.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                    currentWidth++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    currentWidth++;

                }
            }
            levelOrderList.add(currentLayer);

        }
        return levelOrderList;
    }
}
