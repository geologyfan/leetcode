package swordToOffer;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class SwapOddEven {
    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 5, 4, 9, 8, 7, 65, 4, 5, 32, 8};
        new SwapOddEven().scan(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void scan(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] % 2 == 1) low++;
            while (low < high && nums[high] % 2 == 0) high--;
            if (low < high)
                swap(nums, low, high);

        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
