package Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args){

    }

    public boolean isValidBST(TreeNode root){
        List<Integer> arrayList = new ArrayList<>();
        inorderSearch(root,arrayList);
        for(int i = 0;i<arrayList.size()-1;i++){
            if(arrayList.get(i)>=arrayList.get(i+1))
                return false;
        }
        return true;
    }

    public void inorderSearch(TreeNode root,List<Integer> list){
        if(root!=null){
            inorderSearch(root.left,list);
            list.add(root.val);
            inorderSearch(root.right,list);
        }
    }
}
