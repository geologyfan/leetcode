package sort;


import org.jetbrains.annotations.NotNull;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9, -2, 0, 7, -36, 3};
        new BubbleSort().bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void bubbleSort(@NotNull int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public void bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    nums[j] = nums[j] + nums[j - 1];
                    nums[j - 1] = nums[j] - nums[j - 1];
                    nums[j] = nums[j] - nums[j - 1];
                }
            }
        }
    }
}
