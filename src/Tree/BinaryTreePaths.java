package Tree;

import java.lang.reflect.Array;
import java.util.Stack;

public class BinaryTreePaths {
    public static void main(String[] args){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(new TreeNode(1));
//        System.out.println(stack.toString());
        Object[] arr = stack.toArray();
        System.out.println(arr);
    }

//    class newStack<TreeNode> extends Stack<Tree.TreeNode> {
//        public String toString(){
//
//        }
//    }
}
