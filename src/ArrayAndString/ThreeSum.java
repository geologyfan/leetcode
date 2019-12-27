package ArrayAndString;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class ThreeSum {
    public static void main(String[] args) {
         int[] nums = {0,0,0,0};
         out.println(new ThreeSum().threeSum(nums,0));
    }

    public List<List<Integer>> threeSum(int[] nums, int sum) {
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>sum) break;
            if(i>=1&&nums[i]==nums[i-1]) continue;
            int tmp = sum - nums[i];
            int low = i, high = nums.length - 1;
            while (low < high) {
                if (low == i) low++;
                if (high == i) high--;
                if (low < high && tmp == nums[low] + nums[high]) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[low]);
                    tempList.add(nums[high]);
                    output.add(tempList);
                    while (low < high && nums[low + 1] == nums[low]) low++;
                    low++;
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    high--;
                } else if (low < high && tmp < nums[low] + nums[high]) high--;
                else if (low < high && tmp > nums[low] + nums[high]) low++;
            }
        }
        return output;
    }
}
