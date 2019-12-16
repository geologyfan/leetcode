package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
//      list.remove(list.size() - 1);
        listOfList.add(list);

        System.out.println(list);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, 0, sum, list, listOfList);
        return listOfList;
    }

    public void helper(TreeNode root, int num, int sum, List<Integer> list, List<List<Integer>> listOfList) {
        if (root != null) {
            num += root.val;
            list.add(root.val);
            if (root.left == null && root.right == null) {
                if (num == sum) {
                    listOfList.add(list);
                }
            }

            helper(root.left, num, sum, list, listOfList);
            helper(root.right, num, sum, list, listOfList);
            list.remove(list.size() - 1);
        }
    }

}
