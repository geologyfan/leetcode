package ArrayAndString;

import sort.InsertionSort;
import sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {10,2,7,6,5};
        List<List<Integer>> output = new CombinationSum().combinationSum2(nums, 8);
        for (List<Integer> integers : output) {
            System.out.println(integers);
        }
    }

    // 这个方法非常慢。。。有可能是因为排序
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
                for (int j = last.size() - 1; j >= 0; j--) {
                    List<Integer> temp = last.get(j);
                    if (temp.get(temp.size() - 1) < cur)
                        break;
                    temp.add(cur);
                    output.add(temp);
                }
            }
        }
        return output;
    }

    //这个方法不根据排序而去重，而是根据下标去重,这个快多了！！！
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new CombinationSum().helper(candidates, target, 0);
    }

    public List<List<Integer>> helper(int[] candidates, int target, int index) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                output.add(temp);
            } else if (candidates[i] < target) {
                List<List<Integer>> last = helper(candidates, target - candidates[i], i);
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
