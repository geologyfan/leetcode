package sort;


//import org.jetbrains.annotations.NotNull;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9, -2, 0, 7, -36, 3};
        new BubbleSort().bubbleSort(nums,2,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void bubbleSort( int[] nums,int low,int high) {
        for (int i = high; i >= low; i--) {
            for (int j = low+1; j <= i; j++) {
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
