package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new CombinationSum2().helper(candidates,target,0);
    }
    // TODO
    public List<List<Integer>> helper(int[] candidates,int target,int index){
        List<List<Integer>> output = new ArrayList<>();
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]==target){
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                output.add(temp);
            }else if(candidates[i]<target){
                List<List<Integer>> last = helper(candidates,target-candidates[i],i+1);
                for (List<Integer> integers : last) {
                    integers.add(candidates[i]);
                    output.add(integers);
                }
            }else
                continue;
        }
        return output;
    }
}
