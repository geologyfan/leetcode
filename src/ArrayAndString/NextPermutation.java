package ArrayAndString;

import sort.BubbleSort;
import sort.SelectionSort;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        new NextPermutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        SelectionSort selectionSort = new SelectionSort();
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j;
                for (j = i; j < len; j++) {
                    if (nums[j] <= nums[i - 1]) {
                        break;
                    }
                }
                int temp = nums[j - 1];
                nums[j - 1] = nums[i - 1];
                nums[i - 1] = temp;
                selectionSort.selectionSort(nums, i, len-1);
                return;
            }
        }
        selectionSort.selectionSort(nums, 0, nums.length - 1);
    }

}
