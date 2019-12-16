package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(new PathSum3().pathSum(root, 8));


//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(1,8);
//        System.out.println(list.get(2));
    }

    public int pathSum(TreeNode root, int sum) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        helper(root, sum, arrayList);
        return arrayList.get(0);

    }

    public void helper(TreeNode root, int sum, List<Integer> list) {
        if (root != null) {
            int val = root.val;

            list.add(val);
            if (val == sum)
                list.set(0, list.get(0) + 1);
            for (int i = 1; i < list.size() - 1; i++) {
                int temp = list.get(i) + root.val;
                if (temp == sum)
                    list.set(0, list.get(0) + 1);
                list.set(i, temp);
            }

            helper(root.left, sum, list);
            helper(root.right, sum, list);

            list.remove(list.size() - 1);
            for (int i = 1; i < list.size(); i++) {
                list.set(i, list.get(i) - val);
            }
        }
    }

    public int pathSum_2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper_2(root, sum) + pathSum_2(root.left, sum) + pathSum_2(root.right, sum);
    }

    public int helper_2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (root.val == sum ? 1 : 0) + helper_2(root.left, sum - root.val) + helper_2(root.right, sum - root.val);
    }
}
