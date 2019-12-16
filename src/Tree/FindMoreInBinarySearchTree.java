package Tree;

import java.util.ArrayList;
import java.util.List;

public class FindMoreInBinarySearchTree {
    public static void main(String[] args){

    }

    public int[] findMode(TreeNode root){
        int maxCount = 0;
        int[] count = new int[getMax(root)];
        int numOfMax = 0;

        inorderSearch(root,count);


        for(int i = 0;i<count.length;i++){
            if(count[i]>maxCount){
                maxCount = count[i];
                numOfMax = 1;
            }else if(count[i]==maxCount){
                numOfMax++;
            }
        }

        int[] maxNums = new int[numOfMax];

        for(int i = 0,j=0;i<count.length;i++){
            if(count[i]==maxCount){
                maxNums[j]=i;
            }
        }

        return maxNums;
    }

    public void inorderSearch(TreeNode root, int[] count){
        if(root!=null){
            inorderSearch(root.left,count);
            count[root.val]++;
            inorderSearch(root.right,count);
        }
    }

    public int getMax(TreeNode root){
        while (root.right!=null){
            root = root.right;
        }
        return root.val;
    }
}
