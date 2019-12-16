package Tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int leftHeight  = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return  Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) &&isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root != null)
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        else
            return 0;
    }

    public boolean isBalanced_2(TreeNode root) {
        Boolean flag = new Boolean(true);
        getHeight_2(root,flag);
        return flag;

    }

    public int getHeight_2(TreeNode root, Boolean flag) {
        if (root != null) {
            int heightOfLeft = getHeight_2(root.left,flag);
            int heightOfRight = getHeight_2(root.right,flag);

            if (Math.abs(heightOfLeft-heightOfRight)>1)
                flag=false;

            return 1 + Math.max(heightOfLeft,heightOfRight);
        } else
            return 0;
    }

    public int dfsHeight(TreeNode root){
        if(root==null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight==-1) return -1;
        int rightHeight = dfsHeight(root.right);
        if(rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight,rightHeight)+1;
    }

    public boolean isBalanced_3(TreeNode root){
        if(dfsHeight(root)==-1) return false;
        return true;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left=null;
        root.left.right= null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        double begin = System.nanoTime();
        System.out.println(new BalancedBinaryTree().isBalanced_3(root));
        double end = System.nanoTime();
        System.out.println(end-begin);

    }
}
