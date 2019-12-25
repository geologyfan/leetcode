package ArrayAndString;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> twoSum1(int[] nums, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (sum == nums[i] + nums[j]) {
                List<Integer> tempList = new ArrayList<>(2);
                tempList.add(nums[i]);
                while (nums[i + 1] == nums[i]) i++;
                tempList.add(nums[j]);
                while (nums[j - 1] == nums[j]) j--;
                output.add(tempList);
            } else if (sum < nums[i] + nums[j]) i++;
            else j--;
        }
        return output;
    }

    public List<List<Integer>> twoSum2(int[] nums, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(hashMap.containsKey(nums[i])) continue;
            hashMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length-1;i++){
            int temp = sum-nums[i];
            if(hashMap.containsKey(temp)&&i!=hashMap.get(temp)){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[i],temp);
                hashMap.remove(temp);
                output.add(tempList);
            }
        }
        return output;
    }
}
