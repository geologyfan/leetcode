package ArrayAndString;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, -3, 3, 3, 5};
        System.out.println(new FourSum().fourSum(nums, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        int length = nums.length;
        if (length < 4) return output;
        new QuickSort().quickSort(nums, 0, length - 1);
        for (int i = 0; i < length - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) continue;
                int preTwo = nums[i] + nums[j];
//                if (preTwo > target) continue;
                int low = j + 1, high = length - 1;
                while (low < high) {
                    int lastTwo = nums[low] + nums[high];
                    if (preTwo + lastTwo == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        output.add(temp);
                        while (low < high && nums[low + 1] == nums[low]) low++;
                        low++;
                        while (low < high && nums[high - 1] == nums[high]) high--;
                        high--;
                    }
                    while (low < high && preTwo + nums[low] + nums[high] < target) low++;
                    while (low < high && preTwo + nums[low] + nums[high] > target) high--;
                }
            }
        }
        return output;
    }
}
