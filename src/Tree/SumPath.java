package Tree;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/11
 */

public class SumPath {
    public static void main(String[] args) {
//        Deque<Integer> que = new LinkedList<>();
//        que.add(1);
//        que.add(2);
//        System.out.println(que);
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(1);
//        stack.push(2);
//
//        System.out.println(stack);
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        System.out.println(hashMap.get(2));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, new LinkedList<>(), res, 0, sum);
        return res;


    }

    public void traversal(TreeNode root, Deque<Integer> stack, List<List<Integer>> res, int curSum, int sum) {
        if (root == null) {
            return;
        }

        int val = root.val;
        curSum += val;
        stack.push(val);
        if ((root.left == null && root.right == null) && curSum == sum) {

                List<Integer> temp = new ArrayList<>(stack.size());
                Iterator<Integer> iterator = stack.descendingIterator();
                while (iterator.hasNext()) {
                    temp.add(iterator.next());
                }

                res.add(temp);

        }
        traversal(root.left, stack, res, curSum, sum);
        traversal(root.right, stack, res, curSum, sum);
        stack.pop();
    }


}
