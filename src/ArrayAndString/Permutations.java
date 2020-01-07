package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums){
        return permuteHelper(nums,0);
    }

    public List<List<Integer>> permuteHelper(int[] nums,int cur){
        List<List<Integer>> res = new ArrayList<>();
        if(cur>=nums.length){
            return res;
        }else if (cur ==nums.length-1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[cur]);
            res.add(temp);
        }else{
            List<List<Integer>> last = permuteHelper(nums,cur+1);
            for (List<Integer> integers : last) {
                for(int i=0;i<=integers.size();i++){
                    res.add(insert(integers,i,nums[cur]));
                }
            }
        }
        return res;
    }

    public List<Integer> insert(List<Integer> integers,int pos,int cur){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<pos;i++){
            res.add(integers.get(i));
        }
        res.add(cur);
        for(int i=pos+1;i<=integers.size();i++){
            res.add(integers.get(i-1));
        }
        return res;
    }
}
