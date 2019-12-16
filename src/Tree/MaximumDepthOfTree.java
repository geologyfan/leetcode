package Tree;

public class MaximumDepthOfTree {
    public int maxDepth(TreeNode root){
        if(root!=null){
            return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
        }else
            return 0;

    }


}
