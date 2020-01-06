package ArrayAndString;

import sort.InsertionSort;
import sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> output = new CombinationSum().combinationSum(nums, 7);
        for (List<Integer> integers : output) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        new QuickSort().quickSort(candidates, 0, candidates.length - 1);
        for (int i = 0; i < candidates.length; i++) {
            int cur = candidates[i];
            if (cur > target) {
                break;
            } else if (cur == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                output.add(temp);
                break;
            } else {
                List<List<Integer>> last = combinationSum(candidates, target - candidates[i]);
                for(int j=last.size()-1;j>=0;j--){
                    List<Integer> temp = last.get(j);
                    if(temp.get(temp.size()-1)<cur)
                        break;
                    temp.add(cur);
                    output.add(temp);
                }
            }
        }
        return output;
    }
}
